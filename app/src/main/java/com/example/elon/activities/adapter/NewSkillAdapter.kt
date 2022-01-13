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

class NewSkillAdapter(
    private val sList: ArrayList<NewSkillModel>,
    val context: Context,
    val listener: Listener
) :
    RecyclerView.Adapter<NewSkillAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.skill_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val skillModel = sList[position]
        Glide.with(context).load(skillModel.skillImg).into(holder.skillImg)
        holder.skillName.text = skillModel.skillName

        holder.itemView.setOnClickListener(View.OnClickListener {
            listener.onItemClick(position)
        })
    }

    override fun getItemCount(): Int {
        return sList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var skillImg: ImageView = itemView.findViewById(R.id.skillImg)
        var skillName: TextView = itemView.findViewById(R.id.skillName)


    }

}