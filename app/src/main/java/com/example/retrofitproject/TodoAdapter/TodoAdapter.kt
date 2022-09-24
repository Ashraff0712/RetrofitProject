package com.example.retrofitproject.TodoAdapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitproject.R
import com.example.retrofitproject.model.Todos


class TodoAdapter(private val dataSet: List<Todos>):
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.tvTitle)
        val id: TextView = view.findViewById(R.id.tvId)
        val completed: TextView = view.findViewById((R.id.tvCompleted))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_todolist,parent,false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.title.text = dataSet.get(position).title.toString()
        holder.id.text = dataSet.get(position).id.toString()
        holder.completed.text = dataSet.get(position).completed.toString()
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}