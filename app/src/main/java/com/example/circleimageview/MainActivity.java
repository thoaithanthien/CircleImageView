package com.example.circleimageview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<User> arrayListUser;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Anh xa
        arrayListUser = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recircleView);

        // Add user
        arrayListUser.add(new User(R.drawable.walker, "Walker"));
        arrayListUser.add(new User(R.drawable.chau, "Quoc Hoa"));
        arrayListUser.add(new User(R.drawable.yennhie, "Yen Nhi"));

        arrayListUser.add(new User(R.drawable.walker, "Walker"));
        arrayListUser.add(new User(R.drawable.chau, "Pham Thoai"));
        arrayListUser.add(new User(R.drawable.yennhie, "Truong Quy"));

        arrayListUser.add(new User(R.drawable.walker, "Walker"));
        arrayListUser.add(new User(R.drawable.chau, "Tran Chau"));
        arrayListUser.add(new User(R.drawable.yennhie, "Yen Nhi"));

        // Dua Du lieu theo dang LinerLayoutManage
        userAdapter = new UserAdapter(this,arrayListUser);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(userAdapter);
        // Phan cach giua cac dong
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder dragged, @NonNull RecyclerView.ViewHolder target) {
                int positionDragged = dragged.getAbsoluteAdapterPosition();
                int positionTarget = target.getAbsoluteAdapterPosition();

                Collections.swap(arrayListUser, positionDragged,positionTarget);

                userAdapter.notifyItemMoved(positionDragged, positionTarget);
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });

        helper.attachToRecyclerView(recyclerView);
    }
}