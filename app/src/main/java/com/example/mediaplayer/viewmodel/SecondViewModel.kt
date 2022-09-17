package com.example.mediaplayer.viewmodel

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mediaplayer.API
import com.example.mediaplayer.Repository
import com.example.mediaplayer.model.Model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondViewModel: ViewModel() {
     var mutablelivedata :MutableLiveData<List<Model>> = MutableLiveData()
    var repo: Repository= Repository()

    fun getmutablelivedata(): MutableLiveData<List<Model>>{
//        if (mutablelivedata==null){
//            mutablelivedata=repo.getModeldata()
//        }
        Log.v("test","Sent mutable data ${mutablelivedata}")
        return mutablelivedata

    }

    fun getModel():LiveData<List<Model>>{
    if (mutablelivedata==null){
        mutablelivedata=repo.getModeldata()
        Log.v("test","Got the model")
    }
        else{
        mutablelivedata=repo.getModeldata()
        Log.v("test","Did not get the model")
    }

    return mutablelivedata


    }


    val url="https://jsonplaceholder.typicode.com/"
    val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
    val apiService: API =retrofit.create(API::class.java)
    val callBack:Call<List<Model>> =apiService.getmodels()

    fun getModeldata():MutableLiveData<List<Model>> {
        var mutablelivedata : MutableLiveData<List<Model>> = MutableLiveData<List<Model>>()
        callBack.enqueue(object : Callback<List<Model>> {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
                val data: List<Model>? = response.body()
                mutablelivedata.value=data
            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                TODO("Not yet implemented")
                mutablelivedata.value=null
            }
        })



        return mutablelivedata
    }




}