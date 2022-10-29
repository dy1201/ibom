package com.example.app2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

public class smile_activity extends Activity {

    private ImageButton home_btn, diary_btn, graph_btn, album_btn;
    private ImageView image1;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smile);

        image1 = findViewById(R.id.image1);

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://detection-73dd9.appspot.com");
        StorageReference storageReference = storage.getReference();
        StorageReference imgReference = storageReference.child("happy/");

        imgReference.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                int i = 0;
                for (StorageReference item : listResult.getItems()) {
                    GridLayout list = findViewById(R.id.list);

                    ViewGroup.LayoutParams layoutParams1 = image1.getLayoutParams();

                    ImageView iv = new ImageView(smile_activity.this);
                    iv.setLayoutParams(layoutParams1);
                    list.addView(iv);

                    item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {
                            if (task.isSuccessful()) {
                                Glide.with(smile_activity.this).load(task.getResult()).into(iv);

                                iv.setOnLongClickListener(new View.OnLongClickListener() {
                                    @Override
                                    public boolean onLongClick(View view) {

                                        return true;
                                    }
                                });

                            } else {
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });

                }
            }
        });

        //홈 버튼
        home_btn = (ImageButton) findViewById(R.id.vector_ek54);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), main_activity.class);
                startActivity(intent);
            }
        });

        //다이어리 버튼
        diary_btn = (ImageButton) findViewById(R.id.vector_ek23);
        diary_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), diary_activity.class);
                startActivity(intent);
            }
        });

        //그래프 버튼
        graph_btn = (ImageButton) findViewById(R.id.vector_ek26);
        graph_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), graph_activity.class);
                startActivity(intent);
            }
        });

        //앨범 버튼
        album_btn = (ImageButton) findViewById(R.id.vector_ek75);
        album_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), album_activity.class);
                startActivity(intent);
            }
        });


    }
}
