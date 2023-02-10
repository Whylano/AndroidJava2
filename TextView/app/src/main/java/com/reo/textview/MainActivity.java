package com.reo.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.reo.textview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());
        
        //문자열 설정
        activityMainBinding.textView2.setText("안녕하세요");

        //문자열 가져오기
        String str1 = activityMainBinding.textView2.getText().toString();
        //CharSequence(안드로이드 OS가 메모리를 아끼려고 반환타입을 시퀀스로 줌)를 toString으로 변환
        System.out.println(str1);

        //배경 색상 지정
        //activityMainBinding.textView2.setBackgroundColor(Color.RED);
        // activityMainBinding.textView2.setBackgroundColor(Color.rgb(0,255,191));

        activityMainBinding.textView2.setBackgroundColor(Color.argb(50,0,255,191));

        activityMainBinding.textView2.setText("문자열1");//SetText를 쓰면 수정이 계속된다

        //문자열 추가
        activityMainBinding.textView2.append("\n문자열2");
        activityMainBinding.textView2.append("\n문자열3");
    }
}