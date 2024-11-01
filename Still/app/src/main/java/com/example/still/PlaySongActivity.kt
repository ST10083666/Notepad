package com.example.still

import android.media.AudioManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import com.bumptech.glide.Glide
import java.io.IOException
import org.json.JSONObject

private const val TAG = "PlaySongActivity"

class PlaySongActivity : BaseActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_song)

        val songUrl = intent.getStringExtra("SongUrl")
        val songName = intent.getStringExtra("SongName")

        if (songUrl.isNullOrEmpty()) {
            Toast.makeText(this, "Song URL is missing", Toast.LENGTH_SHORT).show()
            Log.e(TAG, "No song URL provided")
            finish() // Close the activity if URL is missing
            return
        }

        Glide.with(this)
            .load(R.drawable.lofi) // replace with your WebP file name
            .into(findViewById<ImageView>(R.id.display))

        setupMediaPlayer(songUrl)
    }


    private fun setupMediaPlayer(songUrl: String) {
        mediaPlayer = MediaPlayer().apply {
            try {
                setDataSource(songUrl)
                setOnPreparedListener {
                    it.start() // Start playback when prepared
                }
                setOnErrorListener { _, what, extra ->
                    Log.e(TAG, "MediaPlayer error: what = $what, extra = $extra")
                    Toast.makeText(this@PlaySongActivity, "Error playing audio", Toast.LENGTH_SHORT).show()
                    true
                }
                prepareAsync() // Prepare asynchronously to avoid blocking UI thread
            } catch (e: IOException) {
                Log.e(TAG, "Error setting up MediaPlayer", e)
                Toast.makeText(this@PlaySongActivity, "Error setting up media player", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
