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
import com.example.elon.activities.interfaces.Listener
import com.example.elon.activities.models.NewSkillModel

class LinearSkillAdapter(
    private val linearSkillList: ArrayList<NewSkillModel>,
    val context: Context,
    val listener: Listener
) :
    RecyclerView.Adapter<LinearSkillAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.linear_skill_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val sModel = linearSkillList[position]
        Glide.with(context).load(sModel.skillImg).into(holder.tabSkillImg)
        holder.tabSkillName.text = sModel.skillName
//        holder.tabQuizDes.text = qModel.quizDes
        holder.itemView.setOnClickListener(View.OnClickListener {
            listener.onItemClick(position)
        })

    }

    override fun getItemCount(): Int {
        return linearSkillList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tabSkillImg: ImageView = itemView.findViewById(R.id.tabSkillImg)
        var tabSkillName: TextView = itemView.findViewById(R.id.tabSkillName)
//        var tabQuizDes: TextView = itemView.findViewById(R.id.tabS)

    }

}