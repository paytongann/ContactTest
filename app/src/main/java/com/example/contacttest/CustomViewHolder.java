package com.example.contacttest;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView tv_name, tv_email;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_name = itemView.findViewById(R.id.tv_name);
        tv_email = itemView.findViewById(R.id.tv_email);
    }

    public void onBindViewHolder(final ContactsPojo item,
                                 final CustomListener listener){
        tv_name.setText(item.name);
        tv_email.setText(item.email);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(item);
            }
        });
    }
}