package com.example.subspays

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var mAuth:FirebaseAuth
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView:NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(appbar)
        drawerLayout=findViewById(R.id.drawer)
        navView=findViewById(R.id.navigation_view)
        val toggle = ActionBarDrawerToggle(this,drawerLayout,appbar,0,0)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
        addsub.setOnClickListener {
            val intent=Intent(this,AddSubscription::class.java)
            startActivity(intent)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btn_profile -> {
                Toast.makeText(this,"Your Profile",Toast.LENGTH_LONG).show()

            }
            R.id.btn_category -> {
                Toast.makeText(this,"Category",Toast.LENGTH_LONG).show()

            }
            R.id.btn_subs -> {
                Toast.makeText(this,"Subscription",Toast.LENGTH_LONG).show()

            }
            R.id.btn_logout -> {
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this,Login::class.java)
                startActivity(intent)

            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}