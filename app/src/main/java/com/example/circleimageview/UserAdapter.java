package com.example.circleimageview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context context;
    private ArrayList<User> arrayListUser;

    public UserAdapter(Context context, ArrayList<User> arrayListUser) {
        this.context = context;
        this.arrayListUser = arrayListUser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.item_user, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = arrayListUser.get(position); // impotant
        // Dua data len
        holder.tvName.setText(arrayListUser.get(position).getName());
        holder.imgView.setImageResource(arrayListUser.get(position).getImgID());

        // Bat su kien RecircleView
        holder.Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGotoSecondActivity(user);
            }
        });
    }

    public void onClickGotoSecondActivity(User user) {
        Intent intent = new Intent(context, SeconActivity.class);
        // Su dung bunble de truyen du lieu giua cac Intent
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user", user);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (arrayListUser != null) {
            return arrayListUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgView;
        private TextView tvName;
        private RelativeLayout Main;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            Main = itemView.findViewById(R.id.Main);
            imgView = itemView.findViewById(R.id.img_user);
            tvName = itemView.findViewById(R.id.tv_user);
        }
    }
}
