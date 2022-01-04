package com.example.mymusic;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button play,pause,stop;
    MediaPlayer mediaPlayer;
    int pauseCurrentposition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.btn_play);
        pause = findViewById(R.id.btn_pause);
        stop = findViewById(R.id.btn_stop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_play:
                        if (mediaPlayer == null) {
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music1);
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
                            mediaPlayer.start();

                       } else if (!mediaPlayer.isPlaying()) {
                            mediaPlayer.seekTo(pauseCurrentposition);
                            mediaPlayer.start();

                        }
                        break;

                    case R.id.btn_pause:
                        if (mediaPlayer != null) {
                            mediaPlayer.pause();
                            pauseCurrentposition = mediaPlayer.getCurrentPosition();
                        }

                        break;
                    case R.id.btn_stop:
                        if (mediaPlayer != null) {

                            mediaPlayer.stop();
                            mediaPlayer =null;
                        }


                        break;
                }

            }
}
