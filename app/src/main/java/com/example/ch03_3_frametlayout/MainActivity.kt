package com.example.ch03_3_frametlayout

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edAnswer= findViewById<EditText>(R.id.ed_answer)
        val tvRiddle= findViewById<TextView>(R.id.tv_riddle)
        val tvResult= findViewById<TextView>(R.id.tv_result)
        val btnRiddle= findViewById<Button>(R.id.btn_riddle)
        val btnAnswer= findViewById<Button>(R.id.btn_answer)
        val btnReAnswer= findViewById<Button>(R.id.btn_reAnswer)
        val btnShowAnswer= findViewById<Button>(R.id.btn_showAnswer)
        //radioButton 彈跳式按鈕

        //list store riddle
        var index = 0 //var can change, val connot change
        val riddleList = mutableListOf("0000,猜一成語。:四大皆空","台灣女孩,猜一字。:始")//if want to add riddle -> var
        //click btnRiddle
        edAnswer.text = null
        tvResult.text = null
        btnRiddle.setOnClickListener {
            val countRiddle = riddleList.count()
            val (riddle,answer) = riddleList[index].split(":")
            tvRiddle.text = "謎題:"+ riddle
            index++
            if (index>=countRiddle)index=0 //出題
            //按答題
            btnAnswer.setOnClickListener{
                val ans = edAnswer.text
                if(ans.toString()==answer){
                    tvResult.text= "答對啦!!"
                    Toast.makeText(this,edAnswer.text,Toast.LENGTH_SHORT).show()
                }
                else{
                    tvResult.text= "沒猜中，再猜一次?"
                    //Toast.makeText(this,edAnswer.text,Toast.LENGTH_SHORT).show()
                }
            }
            //按重答
            btnReAnswer.setOnClickListener{
                edAnswer.text=null
                tvResult.text= null
            }
            //看謎底
            btnShowAnswer.setOnClickListener{
                tvResult.text= "謎底是:"+answer
            }


        } // var,val no chinese //{} = method
    }
}
