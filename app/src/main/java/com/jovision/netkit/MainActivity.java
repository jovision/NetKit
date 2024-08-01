package com.jovision.netkit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jovision.netkit.mvp.net.rto_subscriber.ProgressDialogHandler;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProgressDialogHandler hander = new ProgressDialogHandler(this);
    }
}