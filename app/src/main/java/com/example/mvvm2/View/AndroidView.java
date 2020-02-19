package com.example.mvvm2.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvm2.R;

public class AndroidView extends AppCompatActivity {
    private TextView outputView;
    private EditText inputText;
    private Button enterButton;
    private AndroidLowerCaseViewModel lowerCasePresenter = new AndroidLowerCaseViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputView = findViewById(R.id.outputView);
        inputText = findViewById(R.id.inputText);
        enterButton = findViewById(R.id.enterButton);

        observeViewModel();
    }

    private void observeViewModel(){
        lowerCasePresenter = new ViewModelProvider(this).get(AndroidLowerCaseViewModel.class);
        final Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                outputView.setText(s);
            }
        };
        lowerCasePresenter.getPresentableData().observe(this, stringObserver);
    }

    public void enterData(View view){
        String input = inputText.getText().toString();

        lowerCasePresenter.setData(input);
    }
}


