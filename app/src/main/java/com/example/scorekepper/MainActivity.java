package com.example.scorekepper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Per OnSavedInstanceState
    public static final String scoreBlau = "Score blau";
    public static final String scoreVermell = "Score vermell";
    public static final String temaActual = "Tema escollit";

    private int score1;
    private int score2;

    private LinearLayout linearLayout;

    private boolean darkTheme = false;

    private TextView txtScore1;
    private TextView txtScore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        txtScore1 = findViewById(R.id.score1);
        txtScore2 = findViewById(R.id.score2);

        linearLayout = findViewById(R.id.layout);

        //Carrega score des savedInstanceState
        if(savedInstanceState != null){
            score1 = savedInstanceState.getInt(scoreBlau);
            score2 = savedInstanceState.getInt(scoreVermell);
            darkTheme = savedInstanceState.getBoolean(temaActual);
            txtScore1.setText(String.valueOf(score1));
            txtScore2.setText(String.valueOf(score2));
        }
    }

    public void sumar(View view){

        int buttonID = view.getId();
        switch(buttonID){
            case R.id.imageplus1:
                score1++;
                txtScore1.setText(String.valueOf(score1));
                break;
            case R.id.imageplus2:
                score2++;
                txtScore2.setText(String.valueOf(score2));
                break;
        }

    }

    public void restar(View view){

        int buttonID = view.getId();
        switch(buttonID){
            case R.id.imageminus1:
                score1--;
                txtScore1.setText(String.valueOf(score1));
                break;
            case R.id.imageminus2:
                score2--;
                txtScore2.setText(String.valueOf(score2));
                break;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Guarda s'score
        outState.putInt(scoreBlau, score1);
        outState.putInt(scoreVermell, score2);
        outState.putBoolean(temaActual, darkTheme);
        super.onSaveInstanceState(outState);
    }

    public void setTheme(View view) {
        int txtViewID = view.getId();
        switch(txtViewID){
        }
    }
}