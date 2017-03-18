package com.apareciumlabs.brionsilva.rhino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 *
 * This activity will provide a simple UI for the user to input an
 * arithmetic expression and to find the answer to that exact question.
 *
 * @author brionsilva
 * @version 1.0
 * @since 18/03/2017
 */

public class HomeScreen extends AppCompatActivity {


    EditText arithmeticET;
    Button answerBtn,resetBtn;
    TextView errorTV,answerTV,answerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //initializing the text boxes, buttons etc.
        arithmeticET = (EditText) findViewById(R.id.arithmeticET);
        answerBtn = (Button) findViewById(R.id.answerBtn);
        resetBtn = (Button) findViewById(R.id.resetBtn);
        errorTV = (TextView) findViewById(R.id.errorTextView);
        answerTV = (TextView) findViewById(R.id.answerTextView);
        answerLabel = (TextView) findViewById(R.id.lblAnswer);


        //The onclick listener for the answer button
        answerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(arithmeticET.getText().toString().equals("") || arithmeticET.getText().toString().equals(null) ){

                        errorTV.setText("Please enter a value in the text box.");

                    }else {

                        //removes any text from the error text area if there's any
                        errorTV.setText(null);
                        //setting the answer label
                        answerLabel.setText(R.string.answer);

                        //Catching the entered value from the edit text box
                        String value = arithmeticET.getText().toString();

                        //Making an object of the RHINO evaluate engine class
                        EvaluateEngine evaluateEngine = new EvaluateEngine();

                        /*Passing the value to the rhino evaluate engine and storing the retuned
                        answer in a double variable*/
                        Double answer = evaluateEngine.evaluate(value);

                        //Displaying the answer in a text view
                        answerTV.setText(answer.toString());
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
