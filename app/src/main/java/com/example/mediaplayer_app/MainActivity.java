package com.example.mediaplayer_app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.net.URI;

public class MainActivity extends AppCompatActivity {

    ImageButton btnPlay,btnPause,btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnStop = findViewById(R.id.btnStop);

        MediaPlayer mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        //raw folder - rubicorn drill
        String audioPath_app = "android.resource://"+getPackageName()+"/raw/rubicorndrill";
        Uri audioPath_app_uri = Uri.parse(audioPath_app);

        try {
            mp.setDataSource(this,audioPath_app_uri);
            mp.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();

                //to goto particular time interval in ms
                mp.seekTo(0);
            }
        });
    }
}