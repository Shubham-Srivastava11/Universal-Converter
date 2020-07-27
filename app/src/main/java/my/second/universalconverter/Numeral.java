package my.second.universalconverter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Numeral extends AppCompatActivity {
    private String spinner1;
    private String spinner2;
    private int[] num = {R.id.button0,R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,
            R.id.button7,R.id.button8,R.id.button9,R.id.buttonA,R.id.buttonB,R.id.buttonC,R.id.buttonD,R.id.buttonE,R.id.buttonF};
    private EditText ed1;
    private EditText ed2;
    private boolean lastDot;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);


        setContentView(R.layout.numeral);



        ed1 = findViewById(R.id.num_ed1);
        ed2 = findViewById(R.id.num_ed2);

        final Spinner s =  findViewById(R.id.spinner_num1);
        final Spinner s1 =  findViewById(R.id.spinner_num2);




        String[] arraySpinner = new String[]{"Binary", "Decimal","Octal" ,"Hexadecimal"};
        String[] arraySpinner1 = new String[]{"Binary", "Decimal","Octal" ,"Hexadecimal"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner1);
        adapter1.setDropDownViewResource(R.layout.spinner_item);

        s.setAdapter(adapter);
        s1.setAdapter(adapter1);
//        numeric();


        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
//            Toast.makeText(Units_1.this, s.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                spinner1 = s.getSelectedItem().toString();
                ed1.setHint(spinner1);
                ed1.setText("");
                if(spinner1.equals("Binary")){
                    for (int i : num) {
                        findViewById(i).setEnabled(false);
                        Button btn = findViewById(i);
                        btn.setTextColor(Color.parseColor("#1Affffff"));
                    }
                    findViewById(R.id.button0).setEnabled(true);
                    Button btn = findViewById(R.id.button0);
                    btn.setTextColor(Color.parseColor("#EB7D16"));
                    findViewById(R.id.button1).setEnabled(true);
                    Button btn1 = findViewById(R.id.button1);
                    btn1.setTextColor(Color.parseColor("#EB7D16"));
                    findViewById(R.id.buttonDot).setEnabled(true);
                    Button btn2 = findViewById(R.id.buttonDot);
                    btn2.setTextColor(Color.parseColor("#EB7D16"));
                }
                else if(spinner1.equals("Decimal")){
                    for (int i : num) {
                        findViewById(i).setEnabled(true);
                        Button btn = findViewById(i);
                        btn.setTextColor(Color.parseColor("#EB7D16"));
                    }
                    Button btn = findViewById(R.id.buttonA);
                    btn.setEnabled(false);
                    btn.setTextColor(Color.parseColor("#1Affffff"));
                    Button btn1 = findViewById(R.id.buttonB);
                    btn1.setEnabled(false);
                    btn1.setTextColor(Color.parseColor("#1Affffff"));
                    Button btn2 = findViewById(R.id.buttonC);
                    btn2.setEnabled(false);
                    btn2.setTextColor(Color.parseColor("#1Affffff"));
                    Button btn3 = findViewById(R.id.buttonD);
                    btn3.setEnabled(false);
                    btn3.setTextColor(Color.parseColor("#1Affffff"));
                    Button btn4 = findViewById(R.id.buttonE);
                    btn4.setEnabled(false);
                    btn4.setTextColor(Color.parseColor("#1Affffff"));
                    Button btn5 = findViewById(R.id.buttonF);
                    btn5.setEnabled(false);
                    btn5.setTextColor(Color.parseColor("#1Affffff"));

                }
                else if(spinner1.equals("Octal")){
                    for (int i : num) {
                        findViewById(i).setEnabled(true);
                        Button btn = findViewById(i);
                        btn.setTextColor(Color.parseColor("#EB7D16"));
                    }
                    Button btn = findViewById(R.id.buttonA);
                    btn.setEnabled(false);
                    btn.setTextColor(Color.parseColor("#1Affffff"));
                    Button btn1 = findViewById(R.id.buttonB);
                    btn1.setEnabled(false);
                    btn1.setTextColor(Color.parseColor("#1Affffff"));
                    Button btn2 = findViewById(R.id.buttonC);
                    btn2.setEnabled(false);
                    btn2.setTextColor(Color.parseColor("#1Affffff"));
                    Button btn3 = findViewById(R.id.buttonD);
                    btn3.setEnabled(false);
                    btn3.setTextColor(Color.parseColor("#1Affffff"));
                    Button btn4 = findViewById(R.id.buttonE);
                    btn4.setEnabled(false);
                    btn4.setTextColor(Color.parseColor("#1Affffff"));
                    Button btn5 = findViewById(R.id.buttonF);
                    btn5.setEnabled(false);
                    btn5.setTextColor(Color.parseColor("#1Affffff"));
                    Button btn6 = findViewById(R.id.button8);
                    btn6.setEnabled(false);
                    btn6.setTextColor(Color.parseColor("#1Affffff"));
                    Button btn7 = findViewById(R.id.button9);
                    btn7.setEnabled(false);
                    btn7.setTextColor(Color.parseColor("#1Affffff"));

                }
                else if(spinner1.equals("Hexadecimal")){for (int i : num) {
                    findViewById(i).setEnabled(true);
                    Button btn = findViewById(i);
                    btn.setTextColor(Color.parseColor("#EB7D16"));
                }


                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
//            Toast.makeText(Units_1.this, s1.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                spinner2 = s1.getSelectedItem().toString();
                ed2.setHint(spinner2);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        setNumericOnClickListener();
        numeric();
    }





    private void setNumericOnClickListener() {
        // Create a common OnClickListener
        final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Just append/set the text of clicked button
                vibe.vibrate(20);
                Button button = (Button) v;

                    ed1.append(button.getText());
                    lastDot = false;
            }
        };
        // Assign the listener to all the numeric buttons
        for (int id : num) {
            findViewById(id).setOnClickListener(listener);
        }
        findViewById(R.id.buttonDot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(20);
                if (!lastDot) {
                    ed1.append(".");
                    lastDot = true;
                }
            }
        });
        // Clear button
        findViewById(R.id.buttonac).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(20);
                ed1.setText("");  // Clear the screen
                // Reset all the states and flags
                lastDot = false;
            }
        });
        // Back Button
        findViewById(R.id.buttonback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibe.vibrate(20);
                int len = ed1.getText().length();
                String s = ed1.getText().toString();
                if(len==0 || len==1){
                    ed1.setText("");

                }else {
                        ed1.setText(s.substring(0,len-1));

                }
            }
        });
    }

    public void numeric(){
        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                String value = s.toString();

                if (value.equals("")) {
//                        ed1.setText("");
                    ed2.setText("");
                } else if(spinner1.equals("Decimal")){
                    if(spinner2.equals("Decimal")){
                        ed2.setText(value);
                    }else if(spinner2.equals("Binary")){
                        String val = Integer.toBinaryString(Integer.parseInt(value));
                        ed2.setText(val);
                    }else if(spinner2.equals("Octal")){
                        String val = Integer.toOctalString(Integer.parseInt(value));
                        ed2.setText(val);
                    }
                    else if(spinner2.equals("Hexadecimal")){
                        String val = Integer.toHexString(Integer.parseInt(value));
                        ed2.setText(val);
                    }
                }
                else if(spinner1.equals("Binary")){
                    if(spinner2.equals("Decimal")){
                        int val = Integer.parseInt(value,2);
                        ed2.setText(String.valueOf(val));
                    }else if(spinner2.equals("Binary")){
                        ed2.setText(value);
                    }else if(spinner2.equals("Octal")){
                        int val1 = Integer.parseInt(value,2);
                        String val = Integer.toOctalString(val1);
                        ed2.setText(val);
                    }
                    else if(spinner2.equals("Hexadecimal")){
                        int val1 = Integer.parseInt(value,2);
                        String val = Integer.toHexString(val1);
                        ed2.setText(val);
                    }
                }
                else if(spinner1.equals("Octal")){
                    if(spinner2.equals("Decimal")){
                        int val = Integer.parseInt(value,8);
                        ed2.setText(String.valueOf(val));
                    }else if(spinner2.equals("Binary")){
                        int val1 = Integer.parseInt(value,8);
                        String val = Integer.toBinaryString(val1);
                        ed2.setText(val);
                    }else if(spinner2.equals("Octal")){
                        ed2.setText(value);
                    }
                    else if(spinner2.equals("Hexadecimal")){
                        int val1 = Integer.parseInt(value,8);
                        String val = Integer.toHexString(val1);
                        ed2.setText(val);
                    }
                }
                else if(spinner1.equals("Hexadecimal")){
                    if(spinner2.equals("Decimal")){
                        int val1 = Integer.parseInt(value,16);

                        ed2.setText(String.valueOf(val1));
                    }else if(spinner2.equals("Binary")){
                        int val1 = Integer.parseInt(value,16);
                        String val = Integer.toBinaryString(val1);
                        ed2.setText(val);
                    }else if(spinner2.equals("Octal")){
                        int val1 = Integer.parseInt(value,16);
                        String val = Integer.toOctalString(val1);
                        ed2.setText(val);
                    }
                    else if(spinner2.equals("Hexadecimal")){
                        ed2.setText(value);
                    }
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(final CharSequence s, int start, int before, int count) {
            }
        });

    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Numeral.this, MainActivity .class);
        startActivity(intent);
        super.onBackPressed();
    }
}
