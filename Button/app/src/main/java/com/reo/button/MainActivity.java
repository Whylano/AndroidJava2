package com.reo.button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import com.reo.button.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        //Button 문자열 변경
        activityMainBinding.button.setText("버튼 입니다");

        //ImageButton의 이미지 변경
        //Bitmapp 객체 생성
        Resources res= getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res,R.drawable.imgflag8);
        activityMainBinding.imageButton2.setImageBitmap(bitmap);

        //버튼에 리스너 설정
        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.button.setOnClickListener(buttonClickListener1);

        //이미지 버튼에 리스너 설정
        ImageButtonClickListener1 imageButtonClickListener1 = new ImageButtonClickListener1();
        activityMainBinding.imageButton2.setOnClickListener(imageButtonClickListener1);

        //버튼2와 버튼3에 리스너 설정
        ButtonClickListener2 buttonClickListener2 = new ButtonClickListener2();
        activityMainBinding.button2.setOnClickListener(buttonClickListener2);
        activityMainBinding.button3.setOnClickListener(buttonClickListener2);
    }
    //Button의 Click리스너
    class ButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            activityMainBinding.textView.setText("버튼을 눌렸습니다");
        }
    }
    //ImageButton의 Click 리스너
    class ImageButtonClickListener1 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            activityMainBinding.textView.setText("이미지 버튼을 눌렸습니다");
        }
    }
    //버튼2와 버튼3의 리스너
    class ButtonClickListener2 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //사용자가 누른 버튼의 id를 가져온다
            int id = v.getId();

            //id를 통해 분기한다.
            switch (id){
                case R.id.button2:
                    activityMainBinding.textView.setText("버튼 2를 눌렸습니다");
                    break;
                case R.id.button3:
                    activityMainBinding.textView.setText("버튼 3을 눌렸습니다");
                    break;

            }
        }
    }

}