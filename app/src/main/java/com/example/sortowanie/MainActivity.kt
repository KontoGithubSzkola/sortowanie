package com.example.sortowanie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val losowanie = findViewById<Button>(R.id.los)
        val sortowanie = findViewById<Button>(R.id.sort)

        val text = findViewById<TextView>(R.id.text)
        val switch:List<Switch> = listOf(
            findViewById(R.id.s1),
            findViewById(R.id.s2),
            findViewById(R.id.s3),
            findViewById(R.id.s4),
            findViewById(R.id.s5),
            findViewById(R.id.s6),
            findViewById(R.id.s7),
            findViewById(R.id.s8),
            findViewById(R.id.s9)
        )
        losowanie.setOnClickListener {
            var i = 0
            while (i < 9){
                switch[i].text = Random.nextInt(0,50).toString()
                i += 1
            }
        }
        sortowanie.setOnClickListener {
            var x = 0
            val numery:MutableList<Int> = mutableListOf()
            while (x < 9){
                if (switch[x].isChecked){
                    numery.add(switch[x].text.toString().toInt())
                }
                x += 1
            }
            for (j in 0 until numery.size-1)
                for (i in 0 until numery.size-1)
                    if (numery[i] > numery[i+1]){
                        val pom = numery[i]
                        numery[i] = numery[i+1]
                        numery[i+1] = pom
            text.text = numery.toString()
        }
    }
}
}