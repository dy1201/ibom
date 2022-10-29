
	 
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
import android.net.Uri;
import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Comment;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import figma.R;

public class diary_activity extends Activity {

	private ImageButton diary2_btn, home_btn, diary_btn, graph_btn, album_btn;
	private ImageButton image;
	private TextView title;
	private TextView date;
	private Button add;
	private View view;

	private Button btn;
	private EditText input;
	public String msg;
	private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
	private DatabaseReference databaseReference = firebaseDatabase.getReference();
	private ChildEventListener childEventListener;
	private FirebaseDatabase mDatabase;
	private DatabaseReference mReference1;
	private DatabaseReference mReference2;
	private DatabaseReference mReference3;
	private ChildEventListener mChild;

//	private ListView list1;
//	private ListView list2;
//	private ListView list3;
//	private ArrayAdapter<String> adapter1;
//	List<Object> Array1 = new ArrayList<>();
//	private ArrayAdapter<String> adapter2;
//	List<Object> Array2 = new ArrayList<>();
//	private ArrayAdapter<String> adapter3;
//	List<Object> Array3 = new ArrayList<>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diary);

		image = findViewById(R.id.imgBtn);
		title = findViewById(R.id.title);
		date = findViewById(R.id.date);
		add = findViewById(R.id.add);
		view = findViewById(R.id.view);

//		list1 = findViewById(R.id.list1);
//		list2 = findViewById(R.id.list2);
//		list3 = findViewById(R.id.list3);

//		initDatabase();

//		adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());
//		adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());
//		adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());
//		list1.setAdapter(adapter1);
//		list2.setAdapter(adapter2);
//		list3.setAdapter(adapter3);

//		btn = findViewById(R.id.btn);
//		btn.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				msg = input.getText().toString();
//				databaseReference.child("message").push().setValue(msg);
//			}
//		});

//		mReference1 = mDatabase.getReference("Diary").child("title");
//		mReference1.addValueEventListener(new ValueEventListener() {
//			@Override
//			public void onDataChange(@NonNull DataSnapshot snapshot) {
//				adapter1.clear();
//
//				for (DataSnapshot messageData : snapshot.getChildren()) {
//					String msg2 = messageData.getValue().toString();
//
//					Array1.add(msg2);
//					adapter1.add(msg2);
//				}
//				adapter1.notifyDataSetChanged();
//				list1.setSelection(adapter1.getCount() - 1);
//			}
//
//			@Override
//			public void onCancelled(@NonNull DatabaseError error) {
//
//			}
//		});

//		mReference2 = mDatabase.getReference("Diary").child("content");
//		mReference2.addValueEventListener(new ValueEventListener() {
//			@Override
//			public void onDataChange(@NonNull DataSnapshot snapshot) {
//				adapter2.clear();
//
//				for (DataSnapshot messageData : snapshot.getChildren()) {
//					String msg2 = messageData.getValue().toString();
//					Array2.add(msg2);
//					adapter2.add(msg2);
//				}
//				adapter2.notifyDataSetChanged();
//				list2.setSelection(adapter2.getCount() - 1);
//			}
//
//			@Override
//			public void onCancelled(@NonNull DatabaseError error) {
//
//			}
//		});
//
//		mReference3 = mDatabase.getReference("Diary").child("date");
//		mReference3.addValueEventListener(new ValueEventListener() {
//			@Override
//			public void onDataChange(@NonNull DataSnapshot snapshot) {
//				adapter3.clear();
//
//				for (DataSnapshot messageData : snapshot.getChildren()) {
//					String msg2 = messageData.getValue().toString();
//					Array3.add(msg2);
//					adapter3.add(msg2);
//				}
//				adapter3.notifyDataSetChanged();
//				list3.setSelection(adapter3.getCount() - 1);
//			}
//
//			@Override
//			public void onCancelled(@NonNull DatabaseError error) {
//
//			}
//		});



//		byte[] byteArray = getIntent().getByteArrayExtra("image");
//		Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//		image.setImageBitmap(bitmap);

//		Intent intent = getIntent();
//		String text = intent.getStringExtra("text");
//		title.setText(text);
//		String Date = intent.getStringExtra("date");
//		date.setText(Date);

//		ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.diary, R.id.view);
//		list.setAdapter(adapter);

		FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference reference1 = database.getReference("Diary").child("title");
		DatabaseReference reference2 = database.getReference("Diary").child("date");
		DatabaseReference reference3 = database.getReference("Diary").child("image");

//		reference1.addChildEventListener(new ChildEventListener() {
//			@Override
//			public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//				Log.d("MainActivity","ChildEventListener - onChildAdded : " + snapshot.getValue());
//			}
//
//			@Override
//			public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//				Log.d("MainActivity", "ChildEventListener - onChildChanged : " + previousChildName);
//			}
//
//			@Override
//			public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//				Log.d("MainActivity", "ChildEventListener - onChildRemoved : " + snapshot.getKey());
//			}
//
//			@Override
//			public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//				Log.d("MainActivity", "ChildEventListener - onChildMoved" + previousChildName);
//			}
//
//			@Override
//			public void onCancelled(@NonNull DatabaseError error) {
//				Log.d("MainActivity", "ChildEventListener - onCancelled" + error.getMessage());
//			}
//		});

//		ChildEventListener childEventListener = new ChildEventListener() {
//			@Override
//			public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//				Comment comment = snapshot.getValue(Comment.class);
//			}
//
//			@Override
//			public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//				Comment newComment = snapshot.getValue(Comment.class);
//				String commentKey = snapshot.getKey();
//			}
//
//			@Override
//			public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//				String commentKey = snapshot.getKey();
//			}
//
//			@Override
//			public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//				Comment movedComment = snapshot.getValue(Comment.class);
//				String commentKey = snapshot.getKey();
//			}
//
//			@Override
//			public void onCancelled(@NonNull DatabaseError error) {
//
//			}
//		};
//		reference1.addChildEventListener(childEventListener);
//		reference2.addChildEventListener(childEventListener);

		reference1.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot snapshot) {
				String Title = snapshot.getValue(String.class);
				title.setText(Title);
			}
			@Override
			public void onCancelled(@NonNull DatabaseError error) {
			}
		});

		reference2.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot snapshot) {
				String Date = snapshot.getValue(String.class);
				date.setText(Date);
			}
			@Override
			public void onCancelled(@NonNull DatabaseError error) {
			}
		});

//		reference3.child("image").addListenerForSingleValueEvent(new ValueEventListener() {
//			@Override
//			public void onDataChange(@NonNull DataSnapshot snapshot) {
//				String link = snapshot.getValue(String.class);
//				Picasso.get().load(link).into(image);
//			}
//			@Override
//			public void onCancelled(@NonNull DatabaseError error) {
//			}
//		});

		FirebaseStorage storage = FirebaseStorage.getInstance("gs://ibom-b80f4.appspot.com/");
		StorageReference storageReference = storage.getReference();
		StorageReference imgReference = storageReference.child("image_store/baby.png");

		if(imgReference!=null) {
			imgReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
				@Override
				public void onSuccess(Uri uri) {
					Glide.with(diary_activity.this).load(uri).into(image);
				}
			});
		}

//		reference.addChildEventListener(new ChildEventListener() {
//			@Override
//			public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//				Diary diary = snapshot.getValue(Diary.class);
//				adapter.add(diary.getTitle());
//			}
//
//			@Override
//			public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//			}
//
//			@Override
//			public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//			}
//
//			@Override
//			public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//			}
//
//			@Override
//			public void onCancelled(@NonNull DatabaseError error) {
//
//			}
//		});

//		byte[] byteArray = getIntent().getByteArrayExtra("image");
//		Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

		//다이어리2 버튼
		diary2_btn = (ImageButton) findViewById(R.id.imgBtn);
		diary2_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
//				ByteArrayOutputStream stream = new ByteArrayOutputStream();
//				Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
//				float scale = (float) (340/(float)bitmap.getWidth());
//				int image_w = (int) (bitmap.getWidth() * scale);
//				int image_h = (int) (bitmap.getHeight() * scale);
//				Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
//				resize.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//				byte[] byteArray = stream.toByteArray();

				Intent intent = new Intent(getApplicationContext(), diary2_activity.class);
//				intent.putExtra("image", byteArray);
//				intent.putExtra("title", title.getText().toString());
//				intent.putExtra("content", date.getText().toString());
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

		//다이어리 버튼
		diary_btn = (ImageButton) findViewById(R.id.vector_ek55);
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
		album_btn = (ImageButton) findViewById(R.id.vector_ek27);
		album_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getApplicationContext(), album_activity.class);
				startActivity(intent);
			}
		});

		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getApplicationContext(), diary2_activity.class);
				startActivity(intent);
			}
		});
	}

//	private void initDatabase() {
//		mDatabase = FirebaseDatabase.getInstance();
//		mReference1 = mDatabase.getReference("log");
//		mReference1.child("log").setValue("check");
//		mReference2 = mDatabase.getReference("log");
//		mReference2.child("log").setValue("check");
//		mReference3 = mDatabase.getReference("log");
//		mReference3.child("log").setValue("check");
//
//		mChild = new ChildEventListener() {
//			@Override
//			public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//			}
//
//			@Override
//			public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//			}
//
//			@Override
//			public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//			}
//
//			@Override
//			public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//			}
//
//			@Override
//			public void onCancelled(@NonNull DatabaseError error) {
//
//			}
//		};
//		mReference1.addChildEventListener(mChild);
//		mReference2.addChildEventListener(mChild);
//		mReference3.addChildEventListener(mChild);
//	}
//
//	protected void onDestroy() {
//		super.onDestroy();
//		mReference1.removeEventListener(mChild);
//		mReference2.removeEventListener(mChild);
//		mReference3.removeEventListener(mChild);
//	}
}
	
	