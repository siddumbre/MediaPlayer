package com.example.mediaplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.util.Util
import com.google.gson.Gson

class exo_player_activity : AppCompatActivity() {


    private lateinit var simpleExoPlayer: SimpleExoPlayer
    private lateinit var playerview: StyledPlayerView



//    Intent intent = getIntent();
//    String str = intent.getStringExtra(“message_key”)
//    val intent:Intent=getIntent()
//    val vid=intent.extras!!.getString("arg")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exo_player)

//        private val viewBinding by lazy(LazyThreadSafetyMode.NONE) {
//            ActivityPlayerBinding.inflate(layoutInflater)
//        }

        val video_url = intent.extras!!.getString("arg")
        iniExoplayer(video_url!!)

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"OnStart Finished",Toast.LENGTH_SHORT)
    }

//    override fun onStart() {
//        super.onStart()
//        if (Util.SDK_INT >= 24) {
//            iniExoplayer(video_url!!)
//        }
//    }






        private fun iniExoplayer(video_url:String) {
//        var gson= Gson()
//        val main=MainActivity()
//        val jsonstring=main.getJsonAssets(this,"MediaFiles.json")
//        val data_model=gson.fromJson(jsonstring,dataclassList::class.java)

            playerview = findViewById(R.id.movie_player)
            simpleExoPlayer = SimpleExoPlayer.Builder(this).build()
            playerview.setPlayer(simpleExoPlayer)
            val mediaItem: MediaItem = MediaItem.fromUri(video_url!!)
            simpleExoPlayer.setMediaItem(mediaItem)
            simpleExoPlayer.prepare()
            simpleExoPlayer.playWhenReady



        }
}

