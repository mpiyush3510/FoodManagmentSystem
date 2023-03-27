package com.mpiyush3510.demo.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mpiyush3510.demo.MainActivity;
import com.mpiyush3510.demo.databinding.SignInBinding;

public class SignIn extends AppCompatActivity {
    SignInBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=SignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Callers();
    }

    private void Callers() {
        binding.SignIn.setOnClickListener(v -> {
            if(isValidate()) {
                startActivity(new Intent(SignIn.this, MainActivity.class));
            }
        });
        binding.NewUser.setOnClickListener(v -> {startActivity(new Intent(SignIn.this,SignUp.class));});
    }

    private boolean isValidate() {
        if(binding.EmailOrPhone.getText().toString().isEmpty()){
            showToast("Please Enter Email or Number");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher( binding.EmailOrPhone.getText().toString()).matches() &&
                !Patterns.PHONE.matcher(binding.EmailOrPhone.getText().toString()).matches()) {
            showToast("Enter Correct User ID !");
            return false;
        } else if (binding.Password.getText().toString().isEmpty()) {
            showToast("Enter Password");
            return false;
        } else if (binding.Password.getText().toString().length()<6) {
            showToast("Password length should be 6");
            return false;
        }
        return true;
    }

    private void showToast(String str) {
        Toast toast = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT);
        toast.show();
    }

}