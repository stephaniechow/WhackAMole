package com.example.chows.whackamole2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EndPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_page);
    }
    public void RestartGame(View view){
        Intent intent = new Intent(this, StartPage.class);
        startActivity(intent);
    }
}
