package com.example.chows.whackamole2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity{

    ImageButton a, b, c, d, e, f, g, h, i;

    TextView t,t2;

    ImageButton[] moles;

    int mistakes;
    int k;
    public  static int score;

    Random r;

    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = (ImageButton) findViewById(R.id.imageButton2);
        b = (ImageButton) findViewById(R.id.imageButton3);
        c = (ImageButton) findViewById(R.id.imageButton4);
        d = (ImageButton) findViewById(R.id.imageButton5);
        e = (ImageButton) findViewById(R.id.imageButton6);
        f = (ImageButton) findViewById(R.id.imageButton7);
        g = (ImageButton) findViewById(R.id.imageButton8);
        h = (ImageButton) findViewById(R.id.imageButton9);
        i = (ImageButton) findViewById(R.id.imageButton10);

        moles = new ImageButton[] {a,b,c,d,e,f,g,h,i};

        t = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView3);

        mistakes = -1;
        k=1;
        score=0;

        r = new Random();

        countDownTimer = new CountDownTimer(1500,1500){
            @Override
            public void onTick(long millisUntilFinished){
            }
            @Override
            public void onFinish(){
                k=1;
                game(a);
            }
        };

        /*final MediaPlayer whackSoundMP= MediaPlayer.create(this, R.raw.whacksounds);

        for(int i = 0; i<moles.length; i++){
            moles[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    whackSoundMP.start();
                }
            });
        }*/

        countDownTimer.start();
        game(a);
    }

    public void game(View view){
        //final MediaPlayer whackSoundMP= MediaPlayer.create(this, R.raw.whacksounds);

        countDownTimer.cancel();
        int id = view.getId();
        /*moles[id].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whackSoundMP.start();
            }
        });*/
        if(id == k){
            score+=1;
            String s = getString(R.string.text,score);
            t.setText(s);
        }
        else{
            mistakes+=1;
            String s = getString(R.string.lives, 3-mistakes);
            t2.setText(s);
        }
        if(mistakes == 3){
            t.setText(R.string.loser);
            countDownTimer.cancel();
            Intent i = new Intent(this, EndPage.class);
            startActivity(i);
        }
        else{
            for(int z = 0; z<moles.length; z++){
                moles[z].setBackgroundResource(R.drawable.nomole);
            }
            int index = r.nextInt(9);
            k = moles[index].getId();
            moles[index].setBackgroundResource(R.drawable.mole);
        }

    }


}
