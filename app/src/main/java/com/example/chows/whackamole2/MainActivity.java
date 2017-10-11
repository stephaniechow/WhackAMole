package com.example.chows.whackamole2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton a = (ImageButton) findViewById(R.id.imageButton2);
    ImageButton b = (ImageButton) findViewById(R.id.imageButton3);
    ImageButton c = (ImageButton) findViewById(R.id.imageButton4);
    ImageButton d = (ImageButton) findViewById(R.id.imageButton5);
    ImageButton e = (ImageButton) findViewById(R.id.imageButton6);
    ImageButton f = (ImageButton) findViewById(R.id.imageButton7);
    ImageButton g = (ImageButton) findViewById(R.id.imageButton8);
    ImageButton h = (ImageButton) findViewById(R.id.imageButton9);
    ImageButton i = (ImageButton) findViewById(R.id.imageButton10);

    TextView t = (TextView) findViewById(R.id.textView);

    ImageButton[] moles = {a,b,c,d,e,f,g,h,i};

    int mistakes = 0;
    int k = 1;
    int score = 0;

    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game(a);
    }

    public void game(View view){
        int id = view.getId();
        if(id == k){
            score+=1;
            String s = getString(R.string.text,score);
            t.setText(s);
        }
        else{
            mistakes+=1;
        }
        if(mistakes == 3){
            String lose = getString(R.string.loser);
            t.setText(lose);
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
