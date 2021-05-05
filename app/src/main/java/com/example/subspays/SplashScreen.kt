package com.example.subspays

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import java.lang.Exception

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val top= AnimationUtils.loadAnimation(this, R.anim.top)
        val logoImg=findViewById<ImageView>(R.id.LogoImg)
        logoImg.startAnimation(top)
        mAuth= FirebaseAuth.getInstance()



        val timeout = 4000

        Handler().postDelayed({
            if(mAuth.currentUser!=null){
                Toast.makeText(this,"User is already logged in!", Toast.LENGTH_LONG).show()
                redirect("MAIN")
            }
            else{
                redirect("LOGIN")
            }

        }, timeout.toLong())


    }
    private fun redirect(name:String) {
        val intent= when(name){
            "LOGIN"->Intent(this, Login::class.java)
            "MAIN"-> Intent(this, MainActivity::class.java)
            else->throw  Exception("no path exists")
        }
        startActivity(intent)
        finish()
    }
}