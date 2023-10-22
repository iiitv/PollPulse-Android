package com.example.votingapp;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity{

    public View.OnClickListener click(){
        Intent intent = new Intent(this, Verification_page.class);

        startActivity(intent);

        return null;
    }



}
