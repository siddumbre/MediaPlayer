package com.example.mediaplayer.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mediaplayer.model.Model
import com.example.mediaplayer.R
import com.example.mediaplayer.databinding.SecondChildBinding

class SecondAdapter(context:Context):
    RecyclerView.Adapter<SecondAdapter.ViewHolder>() {

private lateinit var emailList: List<Model>


    fun addemailList(cList:List<Model>){
        this.emailList=cList
        Log.v("test","Adapter Got email list ")
    }

    override fun getItemCount(): Int {
        return emailList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem=emailList[position]
//        holder.binding.model!!.email
//        holder.binding.executePendingBindings()
        holder.email.text=currentItem.email
        holder.usrname.text=currentItem.username

    }



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val email=view.findViewById<TextView>(R.id.email)
        val usrname=view.findViewById<TextView>(R.id.username)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.second_child,parent,false))
    }


}