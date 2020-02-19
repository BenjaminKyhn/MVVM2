package com.example.mvvm2.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvm2.Model.Model;
import com.example.mvvm2.Persistence.FirebaseHandler;
import com.example.mvvm2.R;

import java.util.Observable;
import java.util.Observer;

public class AndroidView extends AppCompatActivity {
    private TextView outputView;
    private EditText inputText;
    private Button enterButton;
    private LowerCasePresenter lowerCasePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiseModulesWithFirebase();

        outputView = findViewById(R.id.outputView);
        inputText = findViewById(R.id.inputText);
        enterButton = findViewById(R.id.enterButton);

        observePresenter();
    }

    private void initialiseModulesWithFirebase() {
        FirebaseHandler dataProvider = new FirebaseHandler(null);
        Model model = ((FirebaseHandler) dataProvider).getModel();
        lowerCasePresenter = new LowerCasePresenter(model);
    }

    private void observePresenter(){
        lowerCasePresenter.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if (o instanceof LowerCasePresenter){
                    String data = ((LowerCasePresenter) o).getPresentableData();
                    outputView.setText(data);
                }
            }
        });
    }

    public void enterData(View view){
        String input = inputText.getText().toString();
        lowerCasePresenter.setData(input);
    }
}


