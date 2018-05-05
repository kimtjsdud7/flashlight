package com.example.samsungativ9pro.buttonapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {
    ImageButton bunnyOn, bunnyOff;
    Camera cam;
    Parameters p;
    boolean status;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        bunnyOn = findViewById(R.id.bunnyOn);
        bunnyOff = findViewById(R.id.bunnyOff);

        bunnyOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!status) {
                    bunnyOn.setImageResource(R.drawable.on);
                    cam = Camera.open();
                    p = cam.getParameters();
                    p.setFlashMode(Parameters.FLASH_MODE_TORCH);
                    cam.setParameters(p);
                    cam.startPreview();
                    status = true;
                }
            }
        });
        bunnyOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    bunnyOff.setImageResource(R.drawable.off);
                    cam.stopPreview();
                    cam.release();
                    status = false;
                }
            }
        });

    }
}
