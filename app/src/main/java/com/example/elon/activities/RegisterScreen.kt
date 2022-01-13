package com.example.elon.activities

import android.content.DialogInterface
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.elon.R
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_register_screen.*


class RegisterScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)

        btnRegister.setOnClickListener(View.OnClickListener {
            registerValidate()

        })
        txtLogin.setOnClickListener(View.OnClickListener {
            finish()
        })


    }

    private fun registerValidate() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        if (rSurName.text!!.trim().isEmpty()) {


            builder.setMessage("Please enter surname")

            builder.setPositiveButton("Ok", fun(dialog: DialogInterface, id: Int) {
                dialog.cancel()
            })
            val alert = builder.create()
            alert.show()
            //  Toast.makeText(this@RegisterScreen, "Enter surname", Toast.LENGTH_SHORT).show()

            return
        }
        if (rEmail.text!!.trim().isEmpty()) {

            builder.setMessage("Please enter email")

            builder.setPositiveButton("Ok", fun(dialog: DialogInterface, id: Int) {
                dialog.cancel()
            })
            val alert = builder.create()
            alert.show()
            //  Toast.makeText(this@RegisterScreen, "Enter email", Toast.LENGTH_SHORT).show()
            return
        } else if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString()).matches()) {

            builder.setMessage("Please enter valid email")

            builder.setPositiveButton("Ok", fun(dialog: DialogInterface, id: Int) {
                dialog.cancel()
            })
            val alert = builder.create()
            alert.show()
            // Toast.makeText(this@RegisterScreen, "Enter valid email", Toast.LENGTH_SHORT).show()
            return
        }
        if (rPassword.text!!.trim().isEmpty()) {

            builder.setMessage("Please enter password")

            builder.setPositiveButton("Ok", fun(dialog: DialogInterface, id: Int) {
                dialog.cancel()
            })
            val alert = builder.create()
            alert.show()
            // Toast.makeText(this@RegisterScreen, "Enter password", Toast.LENGTH_SHORT).show()
            return
        }
        if (rAgainPassword.text != rPassword.text) {

            builder.setMessage("Please enter valid password")

            builder.setPositiveButton("Ok", fun(dialog: DialogInterface, id: Int) {
                dialog.cancel()
            })
            val alert = builder.create()
            alert.show()
            // Toast.makeText(this@RegisterScreen, "Enter valid password", Toast.LENGTH_SHORT).show()
        }
        finish()
    }


}