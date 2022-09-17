package com.example.mediaplayer

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.mediaplayer.model.Model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository : Application() {
//    https://jsonplaceholder.typicode.com/users
    var mutablelivedata : MutableLiveData<List<Model>> = MutableLiveData<List<Model>>()
    val url="https://jsonplaceholder.typicode.com/"
    val retrofit:Retrofit=Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
    val apiService:API=retrofit.create(API::class.java)
    val callBack:Call<List<Model>> =apiService.getmodels()
    fun getModeldata():MutableLiveData<List<Model>> {
        var mutablelivedata : MutableLiveData<List<Model>> = MutableLiveData<List<Model>>()
        callBack.enqueue(object :Callback<List<Model>>{
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



//
//    call.enqueue(object :Callback<List<Model>> {
//        override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
//            val data: List<Model>? = response.body()
//            for (i in 0..data!!.size) {
////                    var details2 :String= data.get(i).email
////                    Log.v("details2", "${details2}")
////                    details += " " + data.get(i).email
////                    Log.i("details", "${details}")
//                }
////                details=data.get(0).email
//            }
//            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
//                val data:List<Model>?=null
//            }
//        })

