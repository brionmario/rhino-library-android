package com.apareciumlabs.brionsilva.rhino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    EditText arithmeticET;
    Button answerBtn,resetBtn;
    TextView errorTV,answerTV,answerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        arithmeticET = (EditText) findViewById(R.id.arithmeticET);
        answerBtn = (Button) findViewById(R.id.answerBtn);
        resetBtn = (Button) findViewById(R.id.resetBtn);
        errorTV = (TextView) findViewById(R.id.errorTextView);
        answerTV = (TextView) findViewById(R.id.answerTextView);
        answerLabel = (TextView) findViewById(R.id.lblAnswer);


        answerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(arithmeticET.getText().toString().equals("") || arithmeticET.getText().toString().equals(null) ){

                        errorTV.setText("Please enter a value in the text box.");

                    }else {

                        errorTV.setText(null);
                        answerLabel.setText(R.string.answer);
                            String value = arithmeticET.getText().toString();

                            arithmeticET.setText(value.toString());
                        }

                    }



            });

        resetBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                errorTV.setText(null);
                arithmeticET.setText(null);
            }
        });
    }
}
