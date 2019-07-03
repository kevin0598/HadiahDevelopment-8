package com.example.asus.hadiahsound;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
MediaPlayer player;
ImageView image1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        image1=findViewById(R.id.image1);
        player=MediaPlayer.create(this,R.raw.mayo);
        player.setLooping(true);
        player.start();

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.pause();
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
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
