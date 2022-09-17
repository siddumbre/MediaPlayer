package com.example.mediaplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediaplayer.adapter.SecondAdapter
import com.example.mediaplayer.databinding.ActivitySecondBinding
import com.example.mediaplayer.model.Model
import com.example.mediaplayer.viewmodel.SecondViewModel
import android.graphics.Movie
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView


class SecondActivity : AppCompatActivity() {
    private lateinit var viewmodel: SecondViewModel
    private lateinit var adapt: SecondAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        viewmodel=ViewModelProviders.of(this,defaultViewModelProviderFactory).get(SecondViewModel::class.java)
        viewmodel = ViewModelProvider(this).get(SecondViewModel::class.java)
//        viewmodel.getModel()


        val recycerview2=findViewById<RecyclerView>(R.id.recycler_view2)
        recycerview2.setHasFixedSize(true)
        viewmodel.getModeldata()
//        adapt=SecondAdapter(this)
//        recycerview2.adapter=adapt
//        recycerview2.layoutManager=LinearLayoutManager(this)


        viewmodel.getmutablelivedata().observe(this, Observer<List<Model>> {
            if(it!=null){
                adapt=SecondAdapter(this)
                adapt.addemailList(it as List<Model>)
                Log.v("test","Live data observed")
                recycerview2.adapter=adapt
                recycerview2.layoutManager=LinearLayoutManager(this)

                adapt.notifyDataSetChanged()
            }
            else{
                Log.v("test","Not observed")
            }

        })

    }

//    fun initRecyclerView(){
//         recyclerView=findViewById<RecyclerView>(R.id.recycler_view2)
//        adapt= SecondAdapter(List<Model>)
//
//
//
//    }
//https://jsonplaceholder.typicode.com/users





}