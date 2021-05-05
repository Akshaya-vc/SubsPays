package com.example.subspays

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_subscription.*
import java.text.SimpleDateFormat
import java.util.*

class AddSubscription : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth
    lateinit var ref: DatabaseReference
    lateinit var mDatabase: FirebaseDatabase
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        var format = SimpleDateFormat("dd/MMM/YYYY", Locale.US)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_subscription)
        mAuth=FirebaseAuth.getInstance()
        mDatabase= FirebaseDatabase.getInstance()
        ref = FirebaseDatabase.getInstance().getReference("Users")
        val serviceName=nameOfTheService.text.toString().trim()
        val category=nameOfTheCategory.text.toString().trim()
        val paymentCycle=payementcycle.text.toString().trim()
        val amount=amount.text.toString().trim()
        val remindMe = remindme.text.toString().trim()

        NextPayment.setOnClickListener {
            val now = Calendar.getInstance()
            val datepicker = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    val selectDate = Calendar.getInstance()
                    selectDate.set(Calendar.YEAR, year)
                    selectDate.set(Calendar.MONTH, month)
                    selectDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    val date = format.format(selectDate.time)
                    NextPayment.text = "$date"
                },
                now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH)
            )
            datepicker.show()

        }
        btn_save.setOnClickListener{
            val currentUser = mAuth.currentUser
            val currentUserdb = ref.child(currentUser?.uid!!)
            currentUserdb.child("ServiceName").setValue(serviceName)
            currentUserdb.child("Category").setValue(category)
            currentUserdb.child("PaymentCycle").setValue(paymentCycle)
            currentUserdb.child("Amount").setValue(amount)
            currentUserdb.child("Remind").setValue(remindMe)
            val intent= Intent(this,AddSubscription::class.java)
            startActivity(intent)
        }







    }
}