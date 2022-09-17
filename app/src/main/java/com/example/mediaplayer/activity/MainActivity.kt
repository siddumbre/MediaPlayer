package com.example.mediaplayer.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mediaplayer.R
import com.example.mediaplayer.SecondActivity
import com.example.mediaplayer.adapter.RecyclerAdapter
import com.example.mediaplayer.dataclassList
import com.google.gson.Gson

//import com.google.android.exoplayer2.source.MediaSource
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,"OnCreate Finished",Toast.LENGTH_SHORT).show()

        val actionbar=actionBar
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setLogo(R.mipmap.`ic_launcher2.xml`)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        supportActionBar?.title="Movies app"

        val btn=findViewById<Button>(R.id.button_second)
        btn.setOnClickListener {
            val intent :Intent= Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        var gson=Gson()
        val jsonstring=getJsonAssets(this,"MediaFiles.json")
        val data_model=gson.fromJson(jsonstring, dataclassList::class.java)

     val recycler_view=findViewById<RecyclerView>(R.id.recycler_view) as RecyclerView
//
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(applicationContext, 2)
        recycler_view.layoutManager=LinearLayoutManager(this)
      val itemAdapter: RecyclerAdapter = RecyclerAdapter(this,data_model.data)
        recycler_view.itemAnimator=DefaultItemAnimator()
        recycler_view.adapter=itemAdapter


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"OnStart Finished",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"OnResume Finished",Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"OnRestart Finished",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"OnPause Finished",Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"OnStop Finished",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"OnDestroy Finished",Toast.LENGTH_SHORT).show()
    }









    fun getJsonAssets( context:Context,filename:String):String? {
        var json:String?=null
        try {
            val myfile=context.assets.open(filename)
            val size=myfile.available()
            val buffer=ByteArray(size)
            myfile.read(buffer)
            myfile.close()
            json= String(buffer)
        }
        catch (exception:IOException){
            exception.printStackTrace()
            return null
        }
        return json
    }


}
