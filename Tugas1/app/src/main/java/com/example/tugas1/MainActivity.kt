package com.example.tugas1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tv:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFragment1.setOnClickListener {replaceFragment(Fragment_1())}
        binding.btnFragment2.setOnClickListener {replaceFragment(Fragment_2())}


        tv = findViewById(R.id.textView2)

        val username =intent.getParcelableExtra<User>("User")?.username
        val password =intent.getParcelableExtra<User>("Password")?.password
        tv.text = "Username: $username dan Password: $password"

        val btnImplicit : Button = findViewById(R.id.btn_implicit)
        btnImplicit.setOnClickListener(this)
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(androidx.fragment.R.id.fragment_container_view_tag, fragment)
        fragmentTransaction.commit()

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_implicit-> {
//                val message = "Hallo, Test !"
//                val intent = Intent()
//                intent.action = Intent.ACTION_SEND
//                intent.putExtra(Intent.EXTRA_TEXT, message)
//                intent.type = "text/plain"
//                startActivity(intent)

                val intent = Intent()
                intent.putExtra("history", "Anda sudah login")
                setResult(RESULT_OK,intent)
                finish()
            }
        }
    }
}

