package com.example.mob_app_lab71;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PhotoGalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);
        boolean isFragmentContainerEmpty = savedInstanceState == null;
        if (isFragmentContainerEmpty) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, PhotoGalleryFragment.newInstance()).commit();
        }
    }
}