package com.example.challenge4

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var batuPemain : ImageView
    lateinit var guntingPemain : ImageView
    lateinit var kertasPemain: ImageView
    lateinit var batuCom: ImageView
    lateinit var guntingCom: ImageView
    lateinit var kertasCom: ImageView
    lateinit var hasilSuit: TextView
    lateinit var ulang : ImageView
    var pilihSuit = 0
    var pilihCom = (0 until 4).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         batuPemain = findViewById<ImageView>(R.id.batu1)
         guntingPemain = findViewById<ImageView>(R.id.gunting1)
         kertasPemain = findViewById<ImageView>(R.id.kertas1)
         batuCom = findViewById<ImageView>(R.id.batu2)
         guntingCom = findViewById<ImageView>(R.id.gunting2)
         kertasCom = findViewById<ImageView>(R.id.kertas2)
         hasilSuit = findViewById<TextView>(R.id.hasil)
         ulang = findViewById<ImageView>(R.id.refresh)


        batuPemain.setOnClickListener{
            Log.d(MainActivity::class.java.simpleName,  "Pemain 1 memilih batu")
            selectSuit(batuPemain, pilihan = 1)
            batuPemain.setBackgroundColor(Color.parseColor("#FF709EB3"))
        }
        guntingPemain.setOnClickListener{
            Log.d(MainActivity::class.java.simpleName,  "Pemain 1 memilih gunting")
            selectSuit(batuPemain, pilihan = 2)
            guntingPemain.setBackgroundColor(Color.parseColor("#FF709EB3"))
        }
        kertasPemain.setOnClickListener{
            Log.d(MainActivity::class.java.simpleName,  "Pemain 1 memilih kertas")
            selectSuit(batuPemain, pilihan = 3)
            kertasPemain.setBackgroundColor(Color.parseColor("#FF709EB3"))
        }
        ulang.setOnClickListener{
            hapusPemain()
            hapusCom()

        }

    }
    private fun com(){
        if(pilihSuit>0) {
            if (pilihCom == 1) {
                Log.d(MainActivity::class.java.simpleName, "Com memilih batu")
                batuCom.setBackgroundColor(Color.parseColor("#FF709EB3"))
            }
            if (pilihCom == 2) {
                Log.d(MainActivity::class.java.simpleName, "Com memilih gunting")
                guntingCom.setBackgroundColor(Color.parseColor("#FF709EB3"))
            }
            if (pilihCom == 3) {
                Log.d(MainActivity::class.java.simpleName, "Com memilih kertas")
                kertasCom.setBackgroundColor(Color.parseColor("#FF709EB3"))
            }
        }
    }
    private fun selectSuit(view: ImageView, pilihan:Int){
        pilihSuit = pilihan
        com()
        Suit()
        hapusPemain()
    }

    private fun Suit(){
        if((pilihSuit == 1 && pilihCom == 1)||(pilihSuit==2 && pilihCom==2) || (pilihSuit == 3 && pilihCom == 3)){
            Log.d(MainActivity::class.java.simpleName, "DRAW")
            hasilSuit.setBackgroundColor(Color.parseColor("#FF3F51B5"))
            hasilSuit.setTextColor(Color.parseColor("#FFE9EFE9"))
            hasilSuit.setText("DRAW")
        }
        if((pilihSuit == 1 && pilihCom == 2)||(pilihSuit==2 && pilihCom==3) || (pilihSuit == 3 && pilihCom == 1)){
            Log.d(MainActivity::class.java.simpleName, "Pemain 1 Menang !!!")
            hasilSuit.setBackgroundColor(Color.parseColor("#FF4CAF50"))
            hasilSuit.setTextColor(Color.parseColor("#FFE9EFE9"))
            hasilSuit.setText("Pemain 1 MENANG")
        }
        if((pilihSuit == 1 && pilihCom == 3)||(pilihSuit==2 && pilihCom==1) || (pilihSuit == 3 && pilihCom == 2)){
            Log.d(MainActivity::class.java.simpleName, "Pemain 2 Menang !!!")
            hasilSuit.setBackgroundColor(Color.parseColor("#FF4CAF50"))
            hasilSuit.setTextColor(Color.parseColor("#FFE9EFE9"))
            hasilSuit.setText("Pemain 2 MENANG")
        }
    }
    private fun hapusPemain(){
        batuPemain.setBackgroundColor(0)
        guntingPemain.setBackgroundColor(0)
        kertasPemain.setBackgroundColor(0)
    }
    private fun hapusCom(){
        batuCom.setBackgroundColor(0)
        guntingCom.setBackgroundColor(0)
        kertasCom.setBackgroundColor(0)
    }
}






