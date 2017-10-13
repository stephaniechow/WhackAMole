package com.example.chows.whackamole2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton a, b, c, d, e, f, g, h, i;

    TextView t;

    ImageButton[] moles;

    int mistakes;
    int k;
    public  static int score;

    Random r;

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

        mistakes = -1;
        k=1;
        score=0;

        r = new Random();

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
