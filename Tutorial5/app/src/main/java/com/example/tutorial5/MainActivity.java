package com.example.tutorial5;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnExplicitBroadcast;
    // Membuat variabel beritipe ConnectionReceiver
    ConnectionReceiver cr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnExplicitBroadcast = findViewById(R.id.btnExplicitBroadcast);
        btnExplicitBroadcast.setOnClickListener(this);
// Membuat variabel cr menjadi variabel objek
        cr = new ConnectionReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();
// Membuat objek Intent
        IntentFilter filter = new IntentFilter();
// Menentukan action Intent Filter
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
// Mendaftarkan Broadcast Receiver
        registerReceiver(cr, filter);
    }

    public void broadcastIntent() {
        Intent intent = new Intent();
        intent.setAction("IntentA");
// Mengatur komponen nilai untuk Broadcast Receiver
        intent.setComponent(new ComponentName(getPackageName(),"com.example.applicationbroadcastreceiver.ConnectionReceiver"));
        getApplicationContext().sendBroadcast(intent);
    }

    // Override fungsi onStop
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(cr);
    }


    // Override fungsi onClick
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnExplicitBroadcast:
                broadcastIntent();
                break;
        }
    }
}

