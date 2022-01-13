package com.example.elon.activities.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.elon.R
import com.example.elon.activities.models.NewQuizModel

class QuizAdapter(val qList: ArrayList<NewQuizModel>, val context: Context) :
    RecyclerView.Adapter<QuizAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.quiz_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val qModel = qList[position]
        Glide.with(context).load(qModel.quizImg).into(holder.quizImg)
        holder.quizName.text = qModel.quizName




    }

    override fun getItemCount(): Int {
        return qList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var quizImg: ImageView = itemView.findViewById(R.id.quizImg)
        var quizName: TextView = itemView.findViewById(R.id.quizName)
        var quiz_card:CardView = itemView.findViewById(R.id.quiz_card)


    }

}