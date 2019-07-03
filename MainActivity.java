package com.example.asus.hadiahsound;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView image1;
    Button button1;
    public static MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1=findViewById(R.id.image1);
        button1=findViewById(R.id.button1);
        player=MediaPlayer.create(this,R.raw.instrumen);
        resume();
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.isPlaying()){
                    player.pause();
                }else {
                    player.start();
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.pause();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void resume(){
        if ((player.isPlaying())==false){
            player.setLooping(true);
            player.start();
        }
    }
    @Override
    public void onPause(){
        try{
            super.onPause();
            player.pause();
        }catch (Exception e){
            Toast.makeText(this,"Masuk Exception",Toast.LENGTH_LONG).show();
        }
    }

}
