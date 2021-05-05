package com.example.subspays

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_subscription.*

class AddSubscription : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth
    lateinit var ref: DatabaseReference
    lateinit var mDatabase: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_subscription)
        mAuth=FirebaseAuth.getInstance()
        mDatabase= FirebaseDatabase.getInstance()
        ref = FirebaseDatabase.getInstance().getReference("Users")
        val serviceName=nameOfTheService.text.toString().trim()
        val category=nameOfTheCategory.text.toString().trim()
        val paymentDate=NextPayment



    }
}