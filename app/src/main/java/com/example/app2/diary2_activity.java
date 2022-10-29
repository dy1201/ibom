
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		2_login
	 *	@date 		Tuesday 06th of September 2022 10:38:21 AM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package com.example.app2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;


import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//import figma.R;

public class diary2_activity extends Activity {

	private ImageButton diary_list_btn, diary_list_btn2, home_btn, graph_btn, album_btn;
	private ImageView image0;
	private EditText title;
	private EditText content;
	private TextView save;
	private TextView date;
	private TextView cancel;
	private Button add;

	private static final int REQUEST_CODE = 0;

//	private final StorageReference storageReference = FirebaseStorage.getInstance().getReference();
//	private final DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference("Diary").child("title").push();
//	private final DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference("Diary").child("content").push();
//	private final DatabaseReference reference3 = FirebaseDatabase.getInstance().getReference("Diary").child("date").push();

	public String msg1;
	public String msg2;
	public String msg3;
	private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
	private DatabaseReference databaseReference = firebaseDatabase.getReference();
	private ChildEventListener childEventListener;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diary2);

		date = findViewById(R.id.date);
		title = findViewById(R.id.title);
		content = findViewById(R.id.content);
		save = findViewById(R.id.save);
		add = findViewById(R.id.add);
		image0 = findViewById(R.id.image0);

		date.setText(getTime());

//		image = findViewById(R.id.image);
//		byte[] byteArray = getIntent().getByteArrayExtra("image");
//		Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//		image.setImageBitmap(bitmap);

//		FirebaseStorage storage = FirebaseStorage.getInstance("gs://ibom-b80f4.appspot.com/");
//		StorageReference storageReference = storage.getReference();
//		StorageReference imgReference = storageReference.child("image_store/baby.png");
//
//		if(imgReference!=null) {
//			imgReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//				@Override
//				public void onSuccess(Uri uri) {
//					Glide.with(diary2_activity.this).load(uri).into(image);
//				}
//			});
//		}

//		Intent intent = getIntent();
//		String Title = intent.getStringExtra("title");
//		title.setText(Title);
//		String Content = intent.getStringExtra("content");
//		content.setText(Content);

//		save.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				ByteArrayOutputStream stream = new ByteArrayOutputStream();
//				Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
//				float scale = (float) (340/(float)bitmap.getWidth());
//				int image_w = (int) (bitmap.getWidth() * scale);
//				int image_h = (int) (bitmap.getHeight() * scale);
//				Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
//				resize.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//				byte[] byteArray = stream.toByteArray();
//
//				Intent intent = new Intent(getApplicationContext(), diary_activity.class);
//				intent.putExtra("image", byteArray);
//				intent.putExtra("text", title.getText().toString());
//				intent.putExtra("date", date.getText().toString());
//				startActivity(intent);
//			}
//		});

		save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
//				Diary diary = new Diary(title.getText().toString(), content.getText().toString(), date.getText().toString());
//				reference.push().setValue(diary);
//				reference1.setValue(title.getText().toString());
//				reference2.setValue(content.getText().toString());
//				reference3.setValue(date.getText().toString());
//				reference.child("image").setValue(image);

				msg1 = title.getText().toString();
				msg2 = content.getText().toString();
				msg3 = date.getText().toString();
				databaseReference.child("Diary").child("title").setValue(msg1);
				databaseReference.child("Diary").child("content").setValue(msg2);
				databaseReference.child("Diary").child("date").setValue(msg3);

				Intent intent = new Intent(getApplicationContext(), diary_activity.class);
				startActivity(intent);

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
		album_btn = (ImageButton) findViewById(R.id.vector_ek27);
		album_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getApplicationContext(), album_activity.class);
				startActivity(intent);
			}
		});

		cancel = findViewById(R.id.cancel);
		cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getApplicationContext(), diary_activity.class);
				startActivity(intent);
			}
		});

		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent();
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				startActivityForResult(intent, REQUEST_CODE);
			}
		});

	}

	public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				try {
					Uri uri = data.getData();
					Picasso.get().load(uri).error(R.drawable.ic_ibom_background).into(image0);
				} catch (Exception e) {

				}
			} else if (resultCode == RESULT_CANCELED) {

			}
		}

	}

	private String getTime() {
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		String getTime = dateFormat.format(date);
		return getTime;
	}



}
	
	