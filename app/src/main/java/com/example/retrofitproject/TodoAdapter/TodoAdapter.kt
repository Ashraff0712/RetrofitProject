package com.example.retrofitproject.TodoAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitproject.R
import com.example.retrofitproject.model.Todos

class TodoAdapter(private var mList : List<Todos>): RecyclerView.Adapter<TodoAdapter.ViewHolder>() {
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val title:TextView = itemView.findViewById(R.id.tvTitle)
        val id:TextView = itemView.findViewById(R.id.tvId)
        val completed:TextView = itemView.findViewById(R.id.tvCompleted)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todolist,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = mList[position].title
        holder.id.text = mList[position].id.toString()
        holder.completed.text = mList[position].completed.toString()
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}