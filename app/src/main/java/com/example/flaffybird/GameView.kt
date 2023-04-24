package com.example.flappybird

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.fragment.app.FragmentActivity

class GameView @JvmOverloads
constructor(context: Context,
            attributes: AttributeSet? = null,
            defStyleAttr: Int = 0):
    SurfaceView(context, attributes,defStyleAttr),
    SurfaceHolder.Callback,
    Runnable{
    lateinit var canvas: Canvas
    val textPaint = Paint()
    var screenWidth = 0f
    var screenHeight = 0f
    var drawing = true
    val lesTuyaux = ArrayList<Tuyaux>()
    private val LesOiseaux = arrayListOf(Oiseau(100, context), Oiseau(60, context), Oiseau(20, context))
    var timeLeft = 0.0
    var totalElapsedTime = 0.0
    var score = 0
    var gameOver = true
    lateinit var thread: Thread
    private var isRunning = true
    private val FPS = (1000.0/60.0).toInt() //pour avoir 60 FPS
    val nom = "GameView"
    var NombreEchec = 0
    val activity = context as FragmentActivity

    init{
        textPaint.textSize = screenWidth/20
        textPaint.color = Color.BLACK
        timeLeft = 10.0
    }

    fun pause(){
        drawing = false
        thread.join()
    }

    fun resume(){
        drawing = true
        thread = Thread(this)
        thread.start()
    }

    override fun run() {
        var previousFrameTime = System.currentTimeMillis()
        while(drawing){
            draw()
            val currentTime = System.currentTimeMillis()
            val elapsedTimeMS = (currentTime-previousFrameTime).toDouble()
            totalElapsedTime += elapsedTimeMS / 1000.0
            updatePositions(elapsedTimeMS)
            LesOiseaux[NombreEchec].draw(canvas)
        }
    }

    fun updatePositions(elapsedTimeMS: Double) {
        val interval = elapsedTimeMS / 1000.0
        timeLeft -= interval //diminution de temps restant à chaque exécution de la fun updateposition
        if (timeLeft <= 0.0){
            timeLeft = 0.0
            gameOver = true
            drawing = false //arrêter de dessiner la balle quand le temps est écoulé
            showGameOverDialog(R.string.lose)
        }
    }

    private fun showGameOverDialog(messageId: Int) {
        activity.runOnUiThread(
            Runnable {
                val ft = activity.supportFragmentManager.beginTransaction()
                val prev =
                    activity.supportFragmentManager.findFragmentByTag("dialog")
                if (prev != null) {
                    ft.remove(prev)
                }
                ft.addToBackStack(null)
                val gameResult = GameOver(messageId)
                gameResult.setCancelable(false)
                gameResult.show(ft,"dialog")
            }
        )
    }

    fun draw(){
        if (holder.surface.isValid) {
            canvas = holder.lockCanvas()
            val formatted = String.format("%.2f", timeLeft)
            canvas.drawText("il reste $formatted secondes", 30f, 50f, textPaint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }

    fun newGame(){}

    override fun surfaceCreated(holder: SurfaceHolder) {}

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}

    override fun surfaceDestroyed(holder: SurfaceHolder) {}

}
