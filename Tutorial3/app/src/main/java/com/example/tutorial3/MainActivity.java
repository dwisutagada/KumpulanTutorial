package com.example.tutorial3;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView header;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        header = (TextView) findViewById(R.id.txtHeader);
    }

    public void launchSecondActivity(View view) {
// Membuat objek Intent
        Intent i = new Intent(this, SecondActivity.class);
// Menjalankan Activity dengan parameter Intent
        startActivity(i);
    }
}
