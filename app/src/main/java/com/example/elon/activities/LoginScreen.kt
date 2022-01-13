package com.example.elon.activities

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.elon.R
import kotlinx.android.synthetic.main.activity_login_screen.*

class LoginScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        Appreance.init(this)

        etEmail.setText(Appreance.getEmail())
        etPassword.setText(Appreance.getPassword())

        btnReg.setOnClickListener(View.OnClickListener {

            val intent = Intent(this@LoginScreen, RegisterScreen::class.java)
            startActivity(intent)

        })

        rootForgot.setOnClickListener(
            View.OnClickListener {
                val intent = Intent(this@LoginScreen, ForgotPassword::class.java)
                startActivity(intent)
            })

        btnLogin.setOnClickListener(View.OnClickListener {

            loginValidate(etEmail.text.toString(), etPassword.text.toString())
        })


    }

    private fun loginValidate(email: String, password: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        if (etEmail.text!!.trim().isEmpty()) {

            builder.setMessage("Please enter email")

            builder.setPositiveButton("Ok", fun(dialog: DialogInterface, id: Int) {
                dialog.cancel()
            })
            val alert = builder.create()
            alert.show()
            // Toast.makeText(this@LoginScreen, "Enter email", Toast.LENGTH_SHORT).show()
            return
        } else if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString()).matches()) {


            builder.setMessage("Please enter valid email")

            builder.setPositiveButton("Ok", fun(dialog: DialogInterface, id: Int) {
                dialog.cancel()
            })
            val alert = builder.create()
            alert.show()
            // Toast.makeText(this@LoginScreen, "Enter valid email", Toast.LENGTH_SHORT).show()
            return
        }
        if (etPassword.text!!.trim().isEmpty()) {


            builder.setMessage("Please enter password")

            builder.setPositiveButton("Ok", fun(dialog: DialogInterface, id: Int) {
                dialog.cancel()
            })
            val alert = builder.create()
            alert.show()
            //  Toast.makeText(this@LoginScreen, "Enter password", Toast.LENGTH_SHORT).show()
            return
        }


        doLogin(email, password)
        val intent = Intent(this@LoginScreen, DashBoard::class.java)
        startActivity(intent)
        finish()


    }

    private fun doLogin(email: String, password: String) {
        Appreance.setLogin(true)
        Appreance.saveLogin(email, password)
    }


}