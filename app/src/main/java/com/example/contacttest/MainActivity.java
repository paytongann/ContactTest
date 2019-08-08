package com.example.contacttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements CustomListener {

    RecyclerView recyclerView;
    CustomAdapter adapter;
    String name;

    Callback<ResultPojo> callback = new Callback<ResultPojo>(){

        @Override
        public void onResponse(Call<ResultPojo> call, Response<ResultPojo> response) {
            if(response.isSuccessful()){
                adapter = new CustomAdapter();
                adapter.setDataSet(response.body());
                adapter.setListener(MainActivity.this);
                recyclerView.setAdapter(adapter);
            }
        }

        @Override
        public void onFailure(Call<ResultPojo> call, Throwable t) {
            Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        initRetrofit();
    }

    public void initRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.androidhive.info/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        apiInterface.getContacts().enqueue(callback);
    }

    @Override
    public void onClick(ContactsPojo item) {
        Intent intent = new Intent(this, ContactInfo.class);
        intent.putExtra("Name", item.name);
        intent.putExtra("Id",item.id);
        intent.putExtra("Email", item.email);
        intent.putExtra("Address",item.address);
        intent.putExtra("Gender", item.gender);
        intent.putExtra("Mobile", item.phone.mobile);
        intent.putExtra("Home", item.phone.home);
        intent.putExtra("Office", item.phone.office);
        setResult(RESULT_OK,intent);
        startActivity(intent);
    }
}
