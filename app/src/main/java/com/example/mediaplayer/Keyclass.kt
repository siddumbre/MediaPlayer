package com.example.mediaplayer

import com.google.gson.*
import com.google.gson.annotations.SerializedName

class dataclassList{
    @SerializedName("data")
    var data:ArrayList<dataclass> = ArrayList()
    override fun toString(): String {
        return "dataclassList(data=$data)"
    }
}

class dataclass{
    @SerializedName("name")
    val name:String=""
    @SerializedName("url")
    val url:String=""
    @SerializedName("img_url")
    val img_url:String=""
    override fun toString(): String {
        return "dataclass(name=$name,url=$img_url,img_url=$img_url)"
    }
}


