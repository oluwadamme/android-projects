package com.example.videoplayerapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // From file storage
        val videoView:VideoView = findViewById(R.id.video_view)
        videoView.setVideoPath("android.resource://"+packageName+"/"+ R.raw.sample_video)

        val mediaController =MediaController(this)

        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)
//        videoView.start() // to start video automatically

        // From internet
        val videoView2:VideoView= findViewById(R.id.video_view2)

        val uri= Uri.parse("https://sample-videos.com/video123/mp4/240/big_buck_bunny_240p_2mb.mp4")

        videoView2.setVideoURI(uri)
        val mediaController2 =MediaController(this)

        mediaController2.setAnchorView(videoView)
        mediaController2.setMediaPlayer(videoView)
        videoView2.setMediaController(mediaController2)
        videoView2.start()
    }
}