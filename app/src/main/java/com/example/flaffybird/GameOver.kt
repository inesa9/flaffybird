package com.example.flappybird

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class GameOver(var messageId: Int): DialogFragment() {
    lateinit var gameView: GameView
    override fun onCreateDialog(bundle: Bundle?): Dialog {
        val builder = AlertDialog.Builder(getActivity())
        builder.setTitle(resources.getString(messageId))
        builder.setMessage(
            "Temps écoulé : ${gameView.totalElapsedTime}"
        )
        builder.setPositiveButton(R.string.reset_game,
            DialogInterface.OnClickListener { _, _->gameView.newGame()}
        )
        return builder.create()
    }
}
