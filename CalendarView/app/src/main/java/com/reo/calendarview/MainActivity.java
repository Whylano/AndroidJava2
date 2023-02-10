package com.reo.calendarview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import com.reo.calendarview.databinding.ActivityMainBinding;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ButtonClicListener1 buttonClicListener1 = new ButtonClicListener1();
        activityMainBinding.button.setOnClickListener(buttonClicListener1);

        ButtonClickListener2 buttonClickListener2 = new ButtonClickListener2();
        activityMainBinding.button2.setOnClickListener(buttonClickListener2);

        CalendarListener1 calendarListener1 = new CalendarListener1();
        activityMainBinding.calendarView.setOnDateChangeListener(calendarListener1);
    }

    class ButtonClicListener1 implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, 2022);
            calendar.set(Calendar.MONTH, 6);
            calendar.set(Calendar.DAY_OF_MONTH, 20);

            long date = calendar.getTimeInMillis();
            //날짜를 설정한다.
            activityMainBinding.calendarView.setDate(date);
        }
    }

    class ButtonClickListener2 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //setDate 메서드로 설정된 날짜를 가져온다.
            long date = activityMainBinding.calendarView.getDate();

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(date);

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            activityMainBinding.textView.setText(year + "/" + month + "/" + day);
        }
    }

    // 사용자가 캘린더에서 날짜를 선택했을 때...
    class CalendarListener1 implements CalendarView.OnDateChangeListener {
        // 두 번째 : 설정된 날짜의 년도
        // 세 번째 : 설정된 날짜의 월
        // 네 번째 : 설정된 날짜의 일
        @Override
        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
            // 사용자가 선택한 날짜를 setDate 메서드로 설정해준다.
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            long date = calendar.getTimeInMillis();
            activityMainBinding.calendarView.setDate(date);

            activityMainBinding.textView2.setText(year + "/" + (month + 1) + "/" + dayOfMonth);
        }
    }
}