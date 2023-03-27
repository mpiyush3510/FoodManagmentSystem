package com.mpiyush3510.demo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.mpiyush3510.demo.MainActivity;
import com.mpiyush3510.demo.R;
import com.mpiyush3510.demo.databinding.SignUpBinding;

public class SignUp extends AppCompatActivity {
SignUpBinding binding;
ArrayAdapter<String> arrayAdapter;
String[] CityList={
        "Ahmedabad","Amreli","Anand","Bharuch","Bhavnagar","Bhuj","Botad","Dahod","Deesa",
        "Gandhidham","Gandhinagar","Godhra","Gondal","Jamnagar","Jetpur","Junagadh","Kalol",
        "Mehsana","Morbi","Nadiad","Navsari","Palanpur","Patan","Porbandar","Rajkot","Surat",
        "Surendranagar","Vadodara","Valsad","Vapi","Veraval"
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=SignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Callers();
    }

    private void CityList(){
        arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.citylist_view,CityList);
        binding.City.setAdapter(arrayAdapter);
    }
    private void Callers() {
        binding.SignUp.setOnClickListener(v -> {
            if(isValidate()) {
                startActivity(new Intent(SignUp.this, MainActivity.class));
            }
        });
        binding.AlreadyAccount.setOnClickListener(v -> {startActivity(new Intent(SignUp.this,SignIn.class));});
        CityList();
    }

    private boolean isValidate() {
        if(binding.FirstName.getText().toString().isEmpty()){
            showToast("Please Enter Your Name");
            return false;
        } else if (binding.LastName.getText().toString().isEmpty()) {
            showToast("Please Enter Your Last Name");
            return false;
        } else if (binding.Email.getText().toString().isEmpty()) {
            showToast("Please Enter Your Email");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.Email.getText().toString()).matches()) {
            showToast("Enter Correct Email");
            return false;
        } else if (binding.PhoneNo.getText().toString().isEmpty()) {
            showToast("Please Enter Phone Number");
            return false;
        } else if (!Patterns.PHONE.matcher(binding.PhoneNo.getText().toString()).matches()) {
            showToast("Please Enter Correct Phone No");
            return false;
        } else if (binding.PhoneNo.getText().toString().length()<10) {
            showToast("PhoneNo Length Should be 10");
            return false;
        } else if (!binding.Male.isChecked() && !binding.Female.isChecked()) {
            showToast("Please Choose Your Gender");
            return false;
        } else if (binding.City.getText().toString().isEmpty()) {
            showToast("City Can't be Selected");
            return false;
        } else if (binding.Password.getText().toString().isEmpty()) {
            showToast("Password can't be Empty");
            return false;
        }else if (binding.Password.getText().toString().length()<6) {
            showToast("Password Length should be 6");
            return false;
        }
        else if (binding.ConfirmPassword.getText().toString().isEmpty()) {
            showToast("Confirm Password can't be Empty");
            return false;
        }
        else if (!binding.ConfirmPassword.getText().toString().matches(binding.Password.getText().toString())) {
            showToast("Confirm Password Should be Same as Password");
            return false;
        }
        return true;
    }

    private void showToast(String str) {
        Toast toast = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT);
        toast.show();
    }
}