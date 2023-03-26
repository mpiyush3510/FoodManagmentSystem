package com.mpiyush3510.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.mpiyush3510.demo.Activities.SignIn;
import com.mpiyush3510.demo.Activities.SignUp;
import com.mpiyush3510.demo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Callers();
    }

    private void Callers() {
        binding.SignUp.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SignUp.class));
        });
        binding.SignIn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SignIn.class));
        });
    }
}