package com.example.mvvm2.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvm2.Model.Model;
import com.example.mvvm2.R;

import java.util.Observable;
import java.util.Observer;

public class AndroidView extends AppCompatActivity {
    private TextView outputView;
    private EditText inputText;
    private Button enterButton;
    Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputView = findViewById(R.id.outputView);
        inputText = findViewById(R.id.inputText);
        enterButton = findViewById(R.id.enterButton);

        model.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                outputView.setText(model.getData());
            }
        });
    }

    public void enterData(View view){
        model.setData(inputText.getText().toString());
    }
}


