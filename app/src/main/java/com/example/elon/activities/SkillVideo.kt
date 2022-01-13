package com.example.elon.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.elon.R
import kotlinx.android.synthetic.main.skill_video.*

class SkillVideo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.skill_video)


        btnCancel.setOnClickListener(View.OnClickListener {
            finish()
        })

    }
}