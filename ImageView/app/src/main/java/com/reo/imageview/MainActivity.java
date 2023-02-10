package com.reo.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.reo.imageview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ButtonClickListener buttonClickListener = new ButtonClickListener();
        activityMainBinding.button.setOnClickListener(buttonClickListener);
    }
    class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //이미지 뷰에 이미지를 설정한다.
            activityMainBinding.imageView4.setImageResource(R.drawable.img_android);

        }
    }
}