package com.reo.seekbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.reo.seekbar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.button.setOnClickListener(buttonClickListener1);
    }

    class ButtonClickListener1 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //SeekBar에 설정된 값을 가져온다.
            int value1 = activityMainBinding.seekBar3.getProgress();
            int value2 = activityMainBinding.seekBar4.getProgress();

            activityMainBinding.textView.setText("SeekBar1 : " + value1);
            activityMainBinding.textView2.setText("SeekBar2 : " + value2);

            ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
            activityMainBinding.button.setOnClickListener(buttonClickListener1);

            ButtonClickListener2 buttonClickListener2 = new ButtonClickListener2();
            activityMainBinding.button2.setOnClickListener(buttonClickListener2);

            ButtonClickListener3 buttonClickListener3 = new ButtonClickListener3();
            activityMainBinding.button3.setOnClickListener(buttonClickListener3);

            ButtonClickListener4 buttonClickListener4 = new ButtonClickListener4();
            activityMainBinding.button4.setOnClickListener(buttonClickListener4);

            SeekBarChangeListener seekBarChangeListener = new SeekBarChangeListener();
            activityMainBinding.seekBar3.setOnSeekBarChangeListener(seekBarChangeListener);
            activityMainBinding.seekBar4.setOnSeekBarChangeListener(seekBarChangeListener);
        }
    }

    class ButtonClickListener2 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //값을 설정한다.
            activityMainBinding.seekBar3.setProgress(1);
            //안드로이드 누가 버전이상인 경우
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
                activityMainBinding.seekBar4.setProgress(9, true);
            } else {
                activityMainBinding.seekBar4.setProgress(9);
            }
        }
    }

    class ButtonClickListener3 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //1 증가
            activityMainBinding.seekBar3.incrementProgressBy(1);
            activityMainBinding.seekBar4.incrementProgressBy(1);
        }
    }

    class ButtonClickListener4 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //1감소
            activityMainBinding.seekBar3.incrementProgressBy(-1);
            activityMainBinding.seekBar4.incrementProgressBy(-1);
        }
    }

    //Seekbar의 값이 변경되었을 때
    class SeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
        //값이 변경된 후
        @Override
        // 첫 번째 : 값이 설정된 Seekbar
        // 두 번째 : 설정된 값
        // 세 번째 : 사용자 변경 여부
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // 값이 변경된 Seekbar의 아이디
            int seekBarId = seekBar.getId();
            switch (seekBarId) {
                case R.id.seekBar3:
                    activityMainBinding.textView.setText("첫 번째 SeekBar : " + progress + "\n");
                    break;
                case R.id.seekBar4:
                    activityMainBinding.textView.setText("두 번째 SeekBar : " + progress + "\n");
            }
            //사용자가 설정했는지...
            if (fromUser == true) {
                activityMainBinding.textView.append("사용자에 의해 설정되었습니다");
            } else {
                activityMainBinding.textView.append("코드를 통해 설정되었습니다");
            }
        }

        // 사용자가 값 설정을 위해 터치 했을 때
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            //사용자가 터치한 seekbar의 id를 가져온다.
            int seekBarId = seekBar.getId();

            switch (seekBarId) {
                case R.id.seekBar3:
                    activityMainBinding.textView2.setText("첫 번째 SeekBar 터치");
                    break;
                case R.id.seekBar4:
                    activityMainBinding.textView2.setText("두 번째 SeekBar 터치 시작");
                    break;
            }
        }

        //사용자가 값 설정을 위해 터치 한 후 떼었을 때
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // 사용자가 터치 했다가 뗀 SeekBar의 ID를 추출한다.
            int seekBarId = seekBar.getId();

            switch (seekBarId) {
                case R.id.seekBar3:
                    activityMainBinding.textView2.setText("첫 번째 SeekBar 터치 종료");
                    break;
                case R.id.seekBar4:
                    activityMainBinding.textView2.setText("두 번째 SeekBar 터치 종료");
                    break;
            }
        }
    }
}