package com.reo.searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.reo.searchview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.button2.setOnClickListener(buttonClickListener1);
    }
    class ButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            // 사용자가 입력한 검색어를 가져온다.
            String str1 = activityMainBinding.searchView.getQuery().toString();
            activityMainBinding.textView.setText(str1);

            SearchViewTextQueryListeneer1 searchViewTextQueryListeneer1 = new SearchViewTextQueryListeneer1();
            activityMainBinding.searchView.setOnQueryTextListener(searchViewTextQueryListeneer1);
        }
    }
    
    //검색어를 입력했거나 엔터 버튼을 눌렀을 때
    class SearchViewTextQueryListeneer1 implements SearchView.OnQueryTextListener{
        //엔터 버튼을 눌렀을 때
        @Override
        public boolean onQueryTextSubmit(String query) {
            activityMainBinding.textView.setText(query);
            //false : 키보드가 내려간다. true : 키보드가 유지된다.
            return true;
        }
        //검색어 입력 시
        @Override
        public boolean onQueryTextChange(String newText) {
            activityMainBinding.textView2.setText(newText);
            return true;
        }
    }
}