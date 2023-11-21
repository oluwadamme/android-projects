package com.example.musicplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    var finaltime=0.0
    var currenttime=0.0;
    var onetime=0
    var forwardTime = 10000
    var backwardTime = 10000

    // Handler
    var handler: Handler = Handler()

    // Media Player
    var mediaPlayer = MediaPlayer()
    lateinit var time_txt: TextView
    lateinit var seekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play_btn:Button =findViewById(R.id.play_btn)
        val pause_btn:Button=findViewById(R.id.pause_icon)
        val fwd_btn:Button=findViewById(R.id.fwd_icon)
        val back_btn:Button=findViewById(R.id.back_btn)
        val title_txt : TextView = findViewById(R.id.song_title)
         time_txt=findViewById(R.id.time_left)
         seekBar = findViewById(R.id.seek_bar)
        mediaPlayer = MediaPlayer.create(this, R.raw.ringtone)
          seekBar.isClickable=false

        play_btn.setOnClickListener(){
            mediaPlayer.start()
            finaltime= mediaPlayer.duration.toDouble()
            currenttime= mediaPlayer.currentPosition.toDouble()

            // Checking if it is playing for one time
            if (onetime==0){
                seekBar.max=finaltime.toInt()
                onetime=1
            }

            time_txt.text=currenttime.toString()
            seekBar.setProgress(currenttime.toInt())


            handler.postDelayed(updateSongTime,100)

        }

        //Set song title
        title_txt.text=""+ resources.getResourceEntryName(R.raw.ringtone)

        // Pause the song
        pause_btn.setOnClickListener(){
            mediaPlayer.pause()
        }

        // Forward song
        fwd_btn.setOnClickListener(){
            val temp = currenttime
            if ((temp+forwardTime)<=finaltime){
                currenttime=currenttime+forwardTime
                mediaPlayer.seekTo(currenttime.toInt())
            }else{
                Toast.makeText(this,"Cannot move song further",Toast.LENGTH_LONG).show()
            }
        }

        // playing back song

        back_btn.setOnClickListener(){
            val temp = currenttime
            if ((temp-backwardTime)>0){
                currenttime=currenttime-backwardTime
                mediaPlayer.seekTo(currenttime.toInt())
            }else{
                Toast.makeText(this,"Cannot move song backward ",Toast.LENGTH_LONG).show()
            }
        }




    }
    // Create the Runnable
    var updateSongTime:Runnable = object :Runnable {
        override fun run() {

            currenttime = mediaPlayer.currentPosition.toDouble()
            time_txt.text= "" +
                    String.format(
                        "%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes(currenttime.toLong()),
                        TimeUnit.MILLISECONDS.toSeconds(currenttime.toLong()
                                -TimeUnit.MINUTES.toSeconds(
                            TimeUnit.MILLISECONDS.toMinutes(
                                currenttime.toLong())
                        )
                        )
                    )

            seekBar.progress=currenttime.toInt()
            handler.postDelayed(this,100)
        }
    }
}