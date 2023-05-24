package com.cdp.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class primerapantalla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primerapantalla);
    }


    public void iniciarsesion(View View){
        Intent i = new Intent(this,iniciarsesion.class);
        startActivity(i);
    }
    public void registro(View View){
        Intent i = new Intent(this,registrarse.class);
        startActivity(i);
    }
}