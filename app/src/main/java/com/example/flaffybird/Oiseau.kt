package com.example.flaffybird

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

class Oiseau(context: Context){
    //var bitmap : BitmapFactory.decodeResource(getResources(),R.drawable._my_image)
    private var bitmap : Bitmap? = null
    init{
        val resources: Resources = context.resources
        val drawable: Drawable? = ContextCompat.getDrawable(context, R.drawable.my_image)
        if (drawable is BitmapDrawable){
            bitmap = drawable.bitmap
        } else{
            bitmap = BitmapFactory.decodeResource(resources, R.drawable.my_image)
        }
    }
    fun getBitmap() : Bitmap?{
        return bitmap
    }
}
