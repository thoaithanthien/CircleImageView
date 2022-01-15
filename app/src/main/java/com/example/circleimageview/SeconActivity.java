package com.example.circleimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SeconActivity extends AppCompatActivity {
    private ImageView imgSecond;
    private TextView tvNameSecond;
    private ArrayList<User> arrayListUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secon);
        imgSecond = (ImageView) findViewById(R.id.img_second);
        tvNameSecond = (TextView) findViewById(R.id.tv_userSecond);
        arrayListUser = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }
            User user = (User) bundle.get("object_user");
        imgSecond.setImageResource(user.getImgID());
        tvNameSecond.setText(user.getName());
    }
}