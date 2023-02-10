package com.reo.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.reo.radiobutton.databinding.ActivityMainBinding;

import java.util.RandomAccess;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.button.setOnClickListener(buttonClickListener1);

        ButtonClickListener2 buttonClickListener2 = new ButtonClickListener2();
        activityMainBinding.button2.setOnClickListener(buttonClickListener2);

        CheckedChangedListener1 checkedChangedListener1 = new CheckedChangedListener1();
        activityMainBinding.radioGroup1.setOnCheckedChangeListener(checkedChangedListener1);
        activityMainBinding.radioGroup2.setOnCheckedChangeListener(checkedChangedListener1);


        ButtonClickListener3 buttonClickListener3 = new ButtonClickListener3();
        activityMainBinding.button3.setOnClickListener(buttonClickListener3);
    }

    class ButtonClickListener1 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //체크 되어 있는 라디오 버튼의 아이디를 추출한다
            int checkId = activityMainBinding.radioGroup1.getCheckedRadioButtonId();

            switch (checkId){
                case R.id.radioButton:
                    activityMainBinding.textView.setText("라디오 1-1");
                    break;
                case R.id.radioButton2:
                    activityMainBinding.textView.setText("라디오1-2");
                    break;
                case R.id.radioButton3:
                    activityMainBinding.textView.setText("라디오1-3");
            }
        }
    }
    class ButtonClickListener2 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int checkId= activityMainBinding.radioGroup2.getCheckedRadioButtonId();
            switch (checkId){
                case R.id.radioButton4:
                    activityMainBinding.textView2.setText("라디오2-1");
                    break;
                case R.id.radioButton5:
                    activityMainBinding.textView2.setText("라디오2-2");
                    break;
                case R.id.radioButton6:
                    activityMainBinding.textView2.setText("라디오2-3");
            }
        }
    }
    class CheckedChangedListener1 implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            // 체크상태가 변경된 라디오 그룹의 아이디를 가져온다.
            int groupId = group.getId();

            switch (groupId){
                case  R.id.radioGroup1:
                    switch (checkedId){
                        case R.id.radioButton:
                            activityMainBinding.textView3.setText("라디오 1-1");
                            break;
                        case R.id.radioButton2:
                            activityMainBinding.textView3.setText("라디오 1-2");
                            break;
                        case R.id.radioButton3:
                            activityMainBinding.textView3.setText("라디오 1-3");
                    }
                    break;
                case R.id.radioGroup2:
                    switch (checkedId){
                        case R.id.radioButton4:
                            activityMainBinding.textView3.setText("라디오 2-1");
                            break;
                        case R.id.radioButton5:
                            activityMainBinding.textView3.setText("라디오 2-2");
                            break;
                        case R.id.radioButton6:
                            activityMainBinding.textView3.setText("라디오 2-3");
                            break;
                    }
                    break;
            }
        }
    }
    class ButtonClickListener3 implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //체크 상태를 설정한다.
            activityMainBinding.radioButton3.setChecked(true);
            activityMainBinding.radioButton4.setChecked(true);
        }
    }
}