package com.hp.mealsapp_mvvm.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import com.hp.mealsapp_mvvm.R
import com.hp.mealsapp_mvvm.Youtube.YoutubeConfig
import kotlinx.android.synthetic.main.activity_youtube_player.*
import timber.log.Timber

class YoutubePlayerActivity : YouTubeBaseActivity() {
   lateinit var onInitializedListener: YouTubePlayer.OnInitializedListener
    lateinit var youTubePlayerView: YouTubePlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_player)
        youTubePlayerView=findViewById(R.id.player)
        play_button.visibility = View.GONE
        onInitializedListener = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                provider: YouTubePlayer.Provider,
                youTubePlayer: YouTubePlayer,
                b: Boolean
            ) {
                youTubePlayer.loadVideo(YoutubeConfig.getVideoId(intent.getStringExtra("playurl")))
                youTubePlayer.setFullscreen(true)
                youTubePlayer.setShowFullscreenButton(false)

            }

            override fun onInitializationFailure(
                provider: YouTubePlayer.Provider,
                youTubeInitializationResult: YouTubeInitializationResult
            ) {
            }

        }
        Timber.e("Player init started")
        youTubePlayerView.initialize(YoutubeConfig.getApiKey(),onInitializedListener)
        Timber.e("Player init successfull")




    }
}