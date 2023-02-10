package com.reo.chip;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.reo.chip.R;
import com.reo.chip.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        // Action Chip에 리스너를 설정한다.
        ChipClickListener1 chipClickListener1 = new ChipClickListener1();
        activityMainBinding.chip4.setOnClickListener(chipClickListener1);

        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.button.setOnClickListener(buttonClickListener1);

        // 체크 상태가 변경되었을 때
        ChipCheckChangeListener chipCheckChangeListener = new ChipCheckChangeListener();
        activityMainBinding.chip5.setOnCheckedChangeListener(chipCheckChangeListener);

        // Close 버튼을 눌렀을 때
        ChipCloseClickListener chipCloseClickListener = new ChipCloseClickListener();
        activityMainBinding.chip6.setOnCloseIconClickListener(chipCloseClickListener);
    }

    // Style : Action
    class ChipClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            activityMainBinding.textView.setText("첫 번째 Chip을 눌렀습니다\n");

            // Style : Choice
            // 체크 상태를 가져온다.
            boolean chk5 = activityMainBinding.chip5.isChecked();

            if(chk5 == true){
                activityMainBinding.textView.append("두 번째 Chip : true\n");
            } else {
                activityMainBinding.textView.append("두 번째 Chip : false\n");
            }

            // style : Entry
            // 체크 상태를 가져온다.
            boolean chk6 = activityMainBinding.chip6.isChecked();
            if(chk6 == true){
                activityMainBinding.textView.append("세 번째 Chip : true\n");
            } else {
                activityMainBinding.textView.append("세 번째 Chip : false\n");
            }

            // style : Filter
            boolean chk7 = activityMainBinding.chip7.isChecked();
            if(chk7 == true){
                activityMainBinding.textView.append("네 번째 Chip : true\n");
            } else {
                activityMainBinding.textView.append("네 번째 Chip : false\n");
            }

            // ChipGroup내에서 체크 되어 있는 Chip의 id를 가져온다.
            int chipId = activityMainBinding.chipGroup1.getCheckedChipId();
            switch(chipId){
                case R.id.chip8:
                    activityMainBinding.textView.append("chip8이 선택되었습니다\n");
                    break;
                case R.id.chip9:
                    activityMainBinding.textView.append("chip9가 선택되었습니다\n");
                    break;
                case R.id.chip10:
                    activityMainBinding.textView.append("chip10이 선택되었습니다\n");
                    break;
            }
        }
    }

    class ButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            // Chip의 체크상태를 설정한다.
            activityMainBinding.chip5.setChecked(true);
            activityMainBinding.chip6.setChecked(true);
            activityMainBinding.chip7.setChecked(true);

            activityMainBinding.chip8.setChecked(true);
        }
    }

    // 체크 상태가 변경되었을 때
    class ChipCheckChangeListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        // 두번째 : 체크 상태 값
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b == true){
                activityMainBinding.textView.setText("체크 되었습니다");
            } else {
                activityMainBinding.textView.setText("체크 해제 되었습니다");
            }
        }
    }

    // Close 버튼 이벤트
    class ChipCloseClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            activityMainBinding.textView.setText("Close 버튼을 눌렀습니다");
        }
    }
}








