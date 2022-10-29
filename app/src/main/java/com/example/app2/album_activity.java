
	 
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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;


import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

//import figma.R;

public class album_activity extends Activity {

	private ImageButton home_btn, diary_btn, graph_btn, album_btn;
	private ImageView image, image1, image2, image3;
	private Bitmap bitmap;
	private ProgressBar progressBar;
	private CardView card;

	private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
	private DatabaseReference databaseReference = firebaseDatabase.getReference();
	private ChildEventListener childEventListener;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.album);

		image = findViewById(R.id.image);
		image1 = findViewById(R.id.image1);
//		card = findViewById(R.id.card);
//		image2 = findViewById(R.id.image2);
//		image3 = findViewById(R.id.image3);

////		FirebaseStorage storage = FirebaseStorage.getInstance("gs://ibom-b80f4.appspot.com/");
//		FirebaseStorage storage = FirebaseStorage.getInstance("gs://opencv-f7f23.appspot.com/");
//
//		StorageReference storageReference = storage.getReference();
//
////		StorageReference imgReference = storageReference.child("image_store/baby.png");
//		StorageReference imgReference = storageReference.child("image_store/ex.png_20221018_213442.png");
//
//		if(imgReference!=null) {
//			imgReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//				@Override
//				public void onSuccess(Uri uri) {
//					Glide.with(album_activity.this).load(uri).into(image1);
//				}
//			});
//		}

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
//					ViewGroup.LayoutParams layoutParams2 = card.getLayoutParams();

					ImageView iv = new ImageView(album_activity.this);
//					CardView cv = new CardView(album_activity.this);
//					iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
					iv.setLayoutParams(layoutParams1);
//					cv.setLayoutParams(layoutParams2);
					list.addView(iv);
//					list.addView(cv);

					item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
						@Override
						public void onComplete(@NonNull Task<Uri> task) {
							if (task.isSuccessful()) {
								Glide.with(album_activity.this).load(task.getResult()).into(iv);

								iv.setOnLongClickListener(new View.OnLongClickListener() {
									@Override
									public boolean onLongClick(View view) {
//										ByteArrayOutputStream stream = new ByteArrayOutputStream();
//										Bitmap bitmap = ((BitmapDrawable)iv.getDrawable()).getBitmap();
//										float scale = (float) (1024/(float)bitmap.getWidth());
//										int image_w = (int) (bitmap.getWidth() * scale);
//										int image_h = (int) (bitmap.getHeight() * scale);
//										Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
//										resize.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//										byte[] byteArray = stream.toByteArray();
//
//										Intent intent = new Intent(getApplicationContext(), diary2_activity.class);
//										intent.putExtra("image", byteArray);
//										startActivity(intent);

//										Intent galleryIntent = new Intent();
//										galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
//										galleryIntent.setType("image/");

										databaseReference.child("Diary").child("image").push().setValue("aaa");

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

		//웃는 버튼
		TextView smile_btn = (TextView) findViewById(R.id._____ek12);
		smile_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getApplicationContext(), smile_activity.class);
				startActivity(intent);
			}
		});

		//슬픈 버튼
		TextView sad_btn = (TextView) findViewById(R.id._____ek13);
		sad_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getApplicationContext(), sad_activity.class);
				startActivity(intent);
			}
		});

		//자는 버튼
		TextView sleep_btn = (TextView) findViewById(R.id._____ek14);
		sleep_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getApplicationContext(), sleep_activity.class);
				startActivity(intent);
			}
		});

//		image1.setOnLongClickListener(new View.OnLongClickListener() {
//			@Override
//			public boolean onLongClick(View view) {
//				ByteArrayOutputStream stream = new ByteArrayOutputStream();
//				Bitmap bitmap = ((BitmapDrawable)image1.getDrawable()).getBitmap();
//				float scale = (float) (1024/(float)bitmap.getWidth());
//				int image_w = (int) (bitmap.getWidth() * scale);
//				int image_h = (int) (bitmap.getHeight() * scale);
//				Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
//				resize.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//				byte[] byteArray = stream.toByteArray();
//
//				Intent intent = new Intent(getApplicationContext(), diary2_activity.class);
//				intent.putExtra("image", byteArray);
//				startActivity(intent);
//
//				return true;
//			}
//		});

	}


}
	
	