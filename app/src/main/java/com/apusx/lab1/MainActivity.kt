package com.apusx.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.apusx.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttongen.setOnClickListener(){

           if (binding.inputtext.text.toString().isNotEmpty()){
               binding.textresult.text = generatePass(binding.inputtext.text.toString().trim())
           }else{
               Toast.makeText(this,"Enter ident",Toast.LENGTH_LONG).show()
           }
        }


    }

    fun generatePass(inputstr:String) : String{

        val charset = ('A'..'Z')
        val charsetsmall = ('a'..'z')
        val charsetnum = (0..9)
        val charsetlust = listOf("!","”","#","$","%","&","'","(",")","*")

        val n = inputstr.length
        val b1:String = charset.random().toString()
        val b2:String = charset.random().toString()
        val b3 = (n*n).mod(10)
        val b4 = charsetnum.random()
        val b5 = charsetlust.random()
        val b6 = charsetsmall.random()

        println(b1+b2+b3+b4+b5+b6)
        return b1+b2+b3+b4+b5+b6
    }

}