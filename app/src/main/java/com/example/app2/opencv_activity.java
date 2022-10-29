package com.example.app2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;

public class opencv_activity extends Activity {

    private ImageButton btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opencv);

        btn = findViewById(R.id.vector_ek21);

        WebView webView = (WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.setBackgroundColor(255);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);

        // 자신이 실행시킨 스트리밍의 주소를 넣어주세요.
        webView.loadUrl("http://192.168.0.5:8080/");

//        //홈 버튼
//        ImageButton home_btn = (ImageButton) findViewById(R.id.vector_ek54);
//        home_btn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), main_activity.class);
//                startActivity(intent);
//            }
//        });

        //다이어리 버튼
        ImageButton diary_btn = (ImageButton) findViewById(R.id.vector_ek23);
        diary_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), diary_activity.class);
                startActivity(intent);
            }
        });


        //그래프 버튼
        ImageButton graph_btn = (ImageButton) findViewById(R.id.vector_ek26);
        graph_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), graph_activity.class);
                startActivity(intent);
            }
        });

        //앨범 버튼
        ImageButton album_btn = (ImageButton) findViewById(R.id.vector_ek27);
        album_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), album_activity.class);
                startActivity(intent);
            }
        });

    }

}