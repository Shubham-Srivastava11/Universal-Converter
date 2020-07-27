package my.second.universalconverter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Calculator extends AppCompatActivity {
    private int[] numericButtons = {R.id.button0,R.id.button1,R.id.button2,R.id.button3,R.id.button4,
            R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9 };
    private  int[] operatorButtons = {R.id.buttonadd,R.id.buttonsub,R.id.buttonmul,R.id.buttondiv,R.id.Remainder};
    private TextView edt1;
    private  boolean lastNumeric;
    private boolean stateError;
    private boolean lastDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.calculator);

        // Find the TextView
        this.edt1 = findViewById(R.id.display);
        // Find and set OnClickListener to numeric buttons
        setNumericOnClickListener();
        // Find and set OnClickListener to operator buttons, equal button and decimal point button
        setOperatorOnClickListener();
    }

    /**
     * Find and set OnClickListener to numeric buttons.
     */
    private void setNumericOnClickListener() {
        // Create a common OnClickListener
        final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Just append/set the text of clicked button
                vibe.vibrate(20);
                Button button = (Button) v;
                if (stateError) {
                    // If current state is Error, replace the error message
                    edt1.setText(button.getText());
                    stateError = false;
                } else {
                    // If not, already there is a valid expression so append to it
                    edt1.append(button.getText());
                }
                // Set the flag
                lastNumeric = true;
            }
        };
        // Assign the listener to all the numeric buttons
        for (int id : numericButtons) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    /**
     * Find and set OnClickListener to operator buttons, equal button and decimal point button.
     */
    private void setOperatorOnClickListener() {
        // Create a common OnClickListener for operators
        final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(20);
                // If the current state is Error do not append the operator
                // If the last input is number only, append the operator
                if (lastNumeric && !stateError) {
                    Button button = (Button) v;
                    edt1.append(button.getText());
                    lastNumeric = false;
                    lastDot = false;    // Reset the DOT flag
                }
            }
        };
        // Assign the listener to all the operator buttons
        for (int id : operatorButtons) {
            findViewById(id).setOnClickListener(listener);
        }
        // Decimal point
        findViewById(R.id.buttonDot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(20);
                if (lastNumeric && !stateError && !lastDot) {
                    edt1.append(".");
                    lastNumeric = false;
                    lastDot = true;
                }
            }
        });
        // Clear button
        findViewById(R.id.buttonDel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(20);
                edt1.setText("");  // Clear the screen
                // Reset all the states and flags
                lastNumeric = false;
                stateError = false;
                lastDot = false;
            }
        });
        // Back Button
        findViewById(R.id.buttonback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibe.vibrate(20);
                int len = edt1.getText().length();
                String s = edt1.getText().toString();
                if(len==0 || len==1){
                    edt1.setText("");

                }else {
                    if(!lastNumeric){
                    edt1.setText(s.substring(0,len-1));
                    lastNumeric=true;}
                    else {
                        edt1.setText(s.substring(0,len-1));
                    }
                }
            }
        });

        // Equal button
        findViewById(R.id.buttoneql).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(20);
                onEqual();
            }
        });
    }

    /**
     * Logic to calculate the solution.
     */
    private void onEqual() {
        // If the current state is error, nothing to do.
        // If the last input is a number only, solution can be found.
        if (lastNumeric && !stateError) {
            // Read the expression
            String txt = edt1.getText().toString();
            // Create an Expression (A class from exp4j library)
            Expression expression = new ExpressionBuilder(txt).build();
            try {
                // Calculate the result and display
                double result = expression.evaluate();
                edt1.setText(String.valueOf(result));
                lastDot = true; // Result contains a dot
            } catch (ArithmeticException ex) {
                // Display an error message
                edt1.setText("Error");
                stateError = true;
                lastNumeric = false;
            }
        }
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Calculator.this, MainActivity .class);
        startActivity(intent);
        super.onBackPressed();
    }
}