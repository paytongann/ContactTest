package com.example.contacttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ContactInfo extends AppCompatActivity {

    TextView tvId, tvName, tvEmail, tvAddress, tvGender, tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        tvId = findViewById(R.id.tv_id);
        tvName = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);
        tvAddress = findViewById(R.id.tv_address);
        tvGender = findViewById(R.id.tv_gender);
        tvPhone = findViewById(R.id.tv_phone);

        tvId.setText("Id: " + getIntent().getStringExtra("Id"));
        tvName.setText("Name: " + getIntent().getStringExtra("Name"));
        tvEmail.setText("Email: " + getIntent().getStringExtra("Email"));
        tvAddress.setText("Address: " + getIntent().getStringExtra("Address"));
        tvGender.setText("Gender: " + getIntent().getStringExtra("Gender"));
        tvPhone.setText("Phone:\n\t\t" +"Mobile: " +getIntent().getStringExtra("Mobile") + "\n\t\tHome: " +
                getIntent().getStringExtra("Home") + "\n\t\tOffice: " + getIntent().getStringExtra("Office"));
    }
}
