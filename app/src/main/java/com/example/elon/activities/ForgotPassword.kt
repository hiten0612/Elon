package com.example.elon.activities

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.elon.R
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)



        txtAcc.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SkillVideo::class.java)
            startActivity(intent)
        })
        btnSubmit.setOnClickListener(View.OnClickListener {

            forgotValidate()


        })
        txtForgotLogin.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    private fun forgotValidate() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        if (fEmail.text!!.trim().isEmpty()) {

            builder.setMessage("Please enter email")

            builder.setPositiveButton("Ok", fun(dialog: DialogInterface, id: Int) {
                dialog.cancel()
            })
            val alert = builder.create()
            alert.show()
            // Toast.makeText(this@ForgotPassword, "Enter email", Toast.LENGTH_SHORT).show()
            return
        } else if (!Patterns.EMAIL_ADDRESS.matcher(fEmail.text.toString()).matches()) {

            builder.setMessage("Please enter valid email")

            builder.setPositiveButton("Ok", fun(dialog: DialogInterface, id: Int) {
                dialog.cancel()
            })
            val alert = builder.create()
            alert.show()
            //  Toast.makeText(this@ForgotPassword, "Enter valid email", Toast.LENGTH_SHORT).show()
            return
        }
        finish()
    }
}