package com.example.mediaplayer.adapter

import android.content.Context
import android.content.Intent
//import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.example.mediaplayer.R
import com.example.mediaplayer.dataclass
import com.example.mediaplayer.exo_player_activity


class RecyclerAdapter(val context: Context,val items:ArrayList<dataclass>):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {




    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current_item=items.get(position)
        holder.Moviename.text=current_item.name

        val requestOptions: RequestOptions= RequestOptions()
            .placeholder(R.drawable.ic_place_holder)
            .error(R.drawable.ic_error)
            .fitCenter()

        Glide.with(context)
            .setDefaultRequestOptions(requestOptions)
            .load(current_item.img_url).dontAnimate()
            .into(holder.movie_icon)

        holder.itemView.setOnClickListener(View.OnClickListener {
//            Toast.makeText(
//                context,
//                " ${current_item.url}",
//                Toast.LENGTH_SHORT
//            ).show()

            val intent:Intent= Intent(context, exo_player_activity::class.java)
            intent.putExtra("arg", current_item.url)
            context.startActivity(intent)

        })

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val Moviename=view.findViewById<TextView>(R.id.Moviename)
        val movie_icon=view.findViewById<ImageView>(R.id.movie_icon)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.playlist_template, parent, false))
    }


}

