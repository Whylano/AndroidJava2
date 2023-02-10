package com.reo.textinputlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.reo.textinputlayout.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.button.setOnClickListener(buttonClickListener1);

        EditTextWatcher editTextWatcher = new EditTextWatcher();
        EditText editText = activityMainBinding.text1.getEditText();
        editText.addTextChangedListener(editTextWatcher);
    }

    class ButtonClickListener1 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //TextInputLayout이 가지고 있는 EditText를 추출한다.
            EditText editText = activityMainBinding.text1.getEditText();
            String str1 = editText.getText().toString();
            activityMainBinding.textView.setText(str1);

            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editText.getWindowToken(),0);

            editText.clearFocus();
        }
    }

    class EditTextWatcher implements TextWatcher{
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() >10){
                activityMainBinding.text1.setError("10 글자 이하로 입력해주세요");
            } else{
                activityMainBinding.text1.setError(null);
            }
        }
    }
}