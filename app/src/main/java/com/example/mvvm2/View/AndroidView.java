package com.example.mvvm2.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvm2.Model.Model;
import com.example.mvvm2.R;

public class AndroidView extends AppCompatActivity {
    private TextView mainText;
    private EditText mainEditText;
    private Button mainButton;
    Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = findViewById(R.id.textView);
        mainEditText = findViewById(R.id.editText);
        mainButton = findViewById(R.id.button);
    }

    public void onClick(View view){
        model.setData(mainEditText.getText().toString());
        mainText.setText(model.getData());
    }
}
