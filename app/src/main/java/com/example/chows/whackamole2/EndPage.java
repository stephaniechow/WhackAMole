package com.example.chows.whackamole2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class EndPage extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_page);

        t = (TextView) findViewById(R.id.textView);

        String s = getString(R.string.text,MainActivity.score);
        t.setText(s);
    }
    public void restartGame(View view){
        Intent intent = new Intent(this, StartPage.class);
        startActivity(intent);
    }
}
