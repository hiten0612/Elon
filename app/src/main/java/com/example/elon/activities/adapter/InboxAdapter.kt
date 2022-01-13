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
import com.example.elon.activities.models.InboxDataModel

class InboxAdapter(val iList: ArrayList<InboxDataModel>, val context: Context) :
    RecyclerView.Adapter<InboxAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.inbox_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model = iList[position]

        Glide.with(context).load(model.pImg).into(holder.pImg)
        holder.pNAme.text = model.pName
        holder.pMessage.text = model.pMessage

    }

    override fun getItemCount(): Int {

        return iList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var pImg: ImageView = itemView.findViewById(R.id.pImg)
        var pNAme: TextView = itemView.findViewById(R.id.pName)
        var pMessage: TextView = itemView.findViewById(R.id.pMessage)

    }


}