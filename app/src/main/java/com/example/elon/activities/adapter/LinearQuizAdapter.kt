package com.example.elon.activities.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.elon.R
import com.example.elon.activities.models.NewQuizModel

class LinearQuizAdapter(private val linearQuizList: ArrayList<NewQuizModel>, val context: Context) :
    RecyclerView.Adapter<LinearQuizAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.linear_quiz_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val qModel = linearQuizList[position]
        Glide.with(context).load(qModel.quizImg).into(holder.tabQuizImg)
        holder.tabQuizName.text = qModel.quizName


//        holder.tabQuizDes.text = qModel.quizDes

    }

    override fun getItemCount(): Int {
        return linearQuizList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tabQuizImg: ImageView = itemView.findViewById(R.id.tabQuizImg)
        var tabQuizName: TextView = itemView.findViewById(R.id.tabQuizName)
        var tabQuizDes: TextView = itemView.findViewById(R.id.tabQuizDes)

    }

}

