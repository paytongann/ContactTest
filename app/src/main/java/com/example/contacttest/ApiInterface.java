package com.example.contacttest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    //https://api.androidhive.info/contacts/
    //Never add the blackslash only ?
    @GET("contacts")
    Call<ResultPojo> getContacts();
}
