package com.example.flappybird

class Etoiles {
    fun seFaireManger(){

    }
    fun draw(){}
    fun modeSpecial(tuyaux: ArrayList<Tuyaux>){
        for (tuyau in tuyaux){
            tuyau.change_couleur()

        }
    }
}
