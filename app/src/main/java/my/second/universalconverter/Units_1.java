package my.second.universalconverter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Units_1 extends AppCompatActivity {
    String univ1;
    String univ2;
    private String spinner1;
    private String spinner2;
    private String spinner3;
    private String spinner4;
    private TextView tv;
    private TextView tv1;
    private EditText ed1;
    private EditText ed2;
    private EditText ed3;
    private EditText ed4;
    private double val1;
    private  double val2;
    private double val3;
    private  double val4;
    private Button bt;
    private int pos1;
    private int pos2;
    private EditText ed5;
    private EditText ed6;
    private EditText ed7;
    private Button btn_area;
    private TextView tv8;
    private ImageView im;
    private TextView tv6;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.units_1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//            }
//        });

        Intent i = getIntent();
        Bundle bd = i.getExtras();
        final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
//        tv = findViewById(R.id.textView4);
        //////////////////////////////////////////////////////////////
        int pos = i.getIntExtra("pos",0);
        int unit_or_fin = i.getIntExtra("main_grid",0);
//        tv.setText("Celcius ̊ C");
        //////////////////////////////////////////////////////////////

//        ed1 = findViewById(R.id.editText);
//        ed2 = findViewById(R.id.editText1);
//        final Spinner s =  findViewById(R.id.spinner);
//        final Spinner s1 =  findViewById(R.id.spinner1);
//
//        final String[] spinner_selected = new String[2];
//        final Button btn = findViewById(R.id.button);
//
//        tv1 = findViewById(R.id.textView5);
//        tv1 = findViewById(R.id.textView5);

///////////////////////////////////////////////////////////////////////////////////////////////////////
                                             //UNITS//
///////////////////////////////////////////////////////////////////////////////////////////////////////

if(unit_or_fin==0) {
    //-----BMI-----
    setContentView(R.layout.units_1);

//    MobileAds.setRequestConfiguration(new RequestConfiguration.Builder().setTestDeviceIds(Collections.singletonList("B8A97AFE36E8F28CA5AE1CE938B87344"))
//                .build());
//        new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("B8A97AFE36E8F28CA5AE1CE938B87344"));
//    AdView madView = findViewById(R.id.adView);
//    AdRequest adRequest = new AdRequest.Builder().build();
//
//    madView.loadAd(adRequest);

    tv = findViewById(R.id.textView4);
    ed1 = findViewById(R.id.editText);
    ed2 = findViewById(R.id.editText1);

    final Spinner s =  findViewById(R.id.spinner);
    final Spinner s1 =  findViewById(R.id.spinner1);


    final String[] spinner_selected = new String[2];
    final Button btn = findViewById(R.id.button);

//    s.getBackground().setColorFilter(getResources().getColor(R.color.orange), PorterDuff.Mode.SRC_ATOP);

    tv1 = findViewById(R.id.textView5);

    if (pos == 0) {
        tv1.setText("BMI");
        ed1.setHint("Weight");
        ed2.setHint("Height");
        String[] arraySpinner = new String[]{"Kilograms", "Pounds"};
        String[] arraySpinner1 = new String[]{"Centimeters", "Meters", "Feet", "Inches"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner1);
        adapter1.setDropDownViewResource(R.layout.spinner_item);

        s.setAdapter(adapter);
        s1.setAdapter(adapter1);


            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Code here executes on main thread after user presses button
                    vibe.vibrate(20);
                    bmi();


                }
            });



    }

    //-----Discount-----


    else if (pos == 1) {
        tv1.setText("Discount");
        ed1.setHint("Price");
        ed2.setHint("%");
        String[] arraySpinner = new String[]{"Original Price"};
        String[] arraySpinner1 = new String[]{"Discount %off"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner1);
        adapter1.setDropDownViewResource(R.layout.spinner_item);

        s.setAdapter(adapter);
        s1.setAdapter(adapter1);
        s.setEnabled(false);
        s1.setEnabled(false);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                vibe.vibrate(20);
                discount();

//                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            }
        });


    }

    //-----Percentage-----


    else if (pos == 2) {
        tv1.setText("Percentage");
        ed1.setHint("%");
        ed2.setHint("Total");
        String[] arraySpinner = new String[]{"Percentage(%)"};
        String[] arraySpinner1 = new String[]{"Total"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner1);
        adapter1.setDropDownViewResource(R.layout.spinner_item);

        s.setAdapter(adapter);
        s1.setAdapter(adapter1);
        s.setEnabled(false);
        s1.setEnabled(false);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                vibe.vibrate(20);
                perc();
//                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            }
        });


    }


    //-----Length-----


    else if (pos == 3) {
        tv1.setText("Length");
        ed1.setHint("First Input");
        ed2.setHint("Second Input");
        String[] arraySpinner = new String[]{
                "Kilometer km", "Meter m", "Decimeter dm", "Centimeter cm", "Millimeter mm", "Micrometer µm", "Picometer pm", "Nautical mile nmi", "Miles m", "Inches in", "Yards yd","Foot ft"
        };
        String[] arraySpinner1 = new String[]{
                "Kilometer km", "Meter m", "Decimeter dm", "Centimeter cm", "Millimeter mm", "Micrometer µm", "Picometer pm", "Nautical mile nmi", "Miles m","Inches in", "Yards yd","Foot ft"
        };


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner1);
        adapter1.setDropDownViewResource(R.layout.spinner_item);

        s.setAdapter(adapter);
        s1.setAdapter(adapter1);
        len();
        btn.setVisibility(View.GONE);
//        btn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Code here executes on main thread after user presses button
//                vibe.vibrate(20);
//                if(ed1.getText().toString().isEmpty() || ed2.getText().toString().isEmpty()){
//                    Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_LONG).show();
//                }else {
//                    tv.setText("Value already computed.");
//                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
//                }
//            }
//        });


    }

    //-----Area-----


    else if (pos == 4) {
        setContentView(R.layout.area);
        Button btn_area = findViewById(R.id.button10);
        final Spinner s_area = findViewById(R.id.spinner_area);
        final CardView cv = findViewById(R.id.cardView);
        tv6 = findViewById(R.id.textView6);
        tv6.setText("Area");
        tv8 = findViewById(R.id.textView8);
//        tv8.setText("Area");
        ed5 = findViewById(R.id.editText2);
        ed6 = findViewById(R.id.editText3);
        ed7 = findViewById(R.id.editText4);
//        final ImageView im = findViewById(R.id.imageView6);
//        final TextView tv8 = findViewById(R.id.textView8);



        String[] arraySpinner3 = new String[]{"Circle", "Square", "Rectangle", "Triangle","Parallelogram","Trapezium","Ellipse","Cube","Rectangular Prism","Cylinder","Cone","Sphere","Hemisphere"};

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner3);
        adapter3.setDropDownViewResource(R.layout.spinner_item);


        s_area.setAdapter(adapter3);


        btn_area.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vibe.vibrate(20);
                // Code here executes on main thread after user presses button
//                bmi();
                double val;
                double val1;
                double val2;
                String res;
//                setContentView(R.layout.card_area_vol);
//                final ImageView im = findViewById(R.id.imageView6);
//                final TextView tv8 = findViewById(R.id.textView8);
//                final TextView tv_ar_vl = findViewById(R.id.area_vol);
//                tv_ar_vl.setText(spinner3);

                switch (spinner3) {
                    case "Circle":
                        if(ed7.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed7.getText().toString());
                        res = String.format("%.2f", 3.14 * val * val);
                        tv8.setText(res+" sq. units");
                            im.setImageResource(R.drawable.area_circle);
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Square":
                        if(ed7.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this,"Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed7.getText().toString());
                        res = String.format("%.2f", val * val);
                        tv8.setText(res+" sq. units");
                            im.setImageResource(R.drawable.area_square);
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Rectangle":
                        if(ed5.getText().toString().isEmpty() || ed6.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed5.getText().toString());
                            val1 = Double.parseDouble(ed6.getText().toString());
                            res = String.format("%.2f", val * val1);
                            tv8.setText(res+" sq. units");
                            im.setImageResource(R.drawable.area_rect);
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Parallelogram":
                        if(ed5.getText().toString().isEmpty() || ed6.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed5.getText().toString());
                        val1 = Double.parseDouble(ed6.getText().toString());
                        res = String.format("%.2f", val * val1);
                        tv8.setText(res+" sq. units");
                            im.setImageResource(R.drawable.area_para);
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Triangle":
                        if(ed5.getText().toString().isEmpty() || ed6.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed5.getText().toString());
                            val1 = Double.parseDouble(ed6.getText().toString());
                            res = String.format("%.2f", (val * val1)/2);
                            tv8.setText(res+" sq. units");
                            im.setImageResource(R.drawable.area_tri);
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Trapezium":
                        if(ed5.getText().toString().isEmpty() || ed6.getText().toString().isEmpty() || ed7.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed5.getText().toString());
                            val1 = Double.parseDouble(ed6.getText().toString());
                            val2 = Double.parseDouble(ed7.getText().toString());
                            res = String.format("%.2f", ((val + val1)/2)*val2);
                            tv8.setText(res+" sq. units");
                            im.setImageResource(R.drawable.area_trap);
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Ellipse":
                        if(ed5.getText().toString().isEmpty() || ed6.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed5.getText().toString());
                            val1 = Double.parseDouble(ed6.getText().toString());
                            res = String.format("%.2f", 3.14 *val * val1);
                            tv8.setText(res+" sq. units");
                            im.setImageResource(R.drawable.area_ellipse);
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Cube":
                        if(ed7.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this,"Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed7.getText().toString());
                            res = String.format("%.2f", val * val*6);
                            tv8.setText(res+" sq. units");
                            im.setImageResource(R.drawable.area_cube);
                        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Rectangular Prism":
                        if(ed5.getText().toString().isEmpty() || ed6.getText().toString().isEmpty() || ed7.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed5.getText().toString());
                            val1 = Double.parseDouble(ed6.getText().toString());
                            val2 = Double.parseDouble(ed7.getText().toString());
                            res = String.format("%.2f", 2*(val*val1 + val1*val2 + val2*val));
                            tv8.setText(res+" sq. units");
                            im.setImageResource(R.drawable.area_rect_prism);
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Cylinder":
                        if(ed5.getText().toString().isEmpty() || ed6.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed5.getText().toString());
                            val1 = Double.parseDouble(ed6.getText().toString());
                            res = String.format("%.2f", 2*3.14*val*(val+val1));
                            tv8.setText(res+" sq. units");
                            im.setImageResource(R.drawable.area_cyl);
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Cone":
                        if(ed5.getText().toString().isEmpty() || ed6.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed5.getText().toString());
                            val1 = Double.parseDouble(ed6.getText().toString());
                            res = String.format("%.2f", 3.14 *val*(val+val1));
                            tv8.setText(res+" sq. units");
                            im.setImageResource(R.drawable.area_cone);
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Sphere":
                        if(ed7.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this,"Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);


                            val = Double.parseDouble(ed7.getText().toString());
                            res = String.format("%.2f", 4*3.14*val*val);
                            tv8.setText(res+" sq. units");
                            im.setImageResource(R.drawable.area_sphere);
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Hemisphere":
                        if(ed7.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this,"Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed7.getText().toString());
                            res = String.format("%.2f", 3*3.14*val*val);
                            tv8.setText(res+" sq. units");
                            im.setImageResource(R.drawable.area_hemi);
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                }

//                area(tv8);

//                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            }
        });

        s_area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
//                cv.setVisibility(View.GONE);
                ed5.setText("");
                ed6.setText("");
                ed7.setText("");

//            Toast.makeText(Units_1.this, s1.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                spinner3 = s_area.getSelectedItem().toString();
                switch (spinner3) {
                    case "Circle":
                        ed7.setVisibility(View.VISIBLE);
                        ed7.setHint("Radius");
                        ed5.setVisibility(View.GONE);
                        ed6.setVisibility(View.GONE);

                        break;
                    case "Sphere":
                        ed7.setVisibility(View.VISIBLE);
                        ed7.setHint("Radius");
                        ed5.setVisibility(View.GONE);
                        ed6.setVisibility(View.GONE);
//                        im.setImageResource(R.drawable.area_sphere);
                        break;
                    case "Hemisphere":
                        ed7.setVisibility(View.VISIBLE);
                        ed7.setHint("Radius");
                        ed5.setVisibility(View.GONE);
                        ed6.setVisibility(View.GONE);
//                        im.setImageResource(R.drawable.area_hemi);
                        break;
                    case "Square":
                        ed7.setVisibility(View.VISIBLE);
                        ed7.setHint("Side");
                        ed5.setVisibility(View.GONE);
                        ed6.setVisibility(View.GONE);
//                        im.setImageResource(R.drawable.area_square);
                        break;
                    case "Cube":
                        ed7.setVisibility(View.VISIBLE);
                        ed7.setHint("Side");
                        ed5.setVisibility(View.GONE);
                        ed6.setVisibility(View.GONE);
//                        im.setImageResource(R.drawable.area_cube);
                        break;
                    case "Rectangle":
                        ed7.setVisibility(View.GONE);
                        ed5.setVisibility(View.VISIBLE);
                        ed6.setVisibility(View.VISIBLE);
                        ed5.setHint("Length");
                        ed6.setHint("Width");
//                        im.setImageResource(R.drawable.area_rect);
                        break;
                    case "Triangle":
                        ed7.setVisibility(View.GONE);
                        ed5.setVisibility(View.VISIBLE);
                        ed6.setVisibility(View.VISIBLE);
                        ed5.setHint("Base");
                        ed6.setHint("Height");
//                        im.setImageResource(R.drawable.area_tri);
                        break;
                    case "Parallelogram":
                        ed7.setVisibility(View.GONE);
                        ed5.setVisibility(View.VISIBLE);
                        ed6.setVisibility(View.VISIBLE);
                        ed5.setHint("Base");
                        ed6.setHint("Vertical Height");
//                        im.setImageResource(R.drawable.area_para);
                        break;
                    case "Trapezium":
                        ed7.setVisibility(View.VISIBLE);
                        ed5.setVisibility(View.VISIBLE);
                        ed6.setVisibility(View.VISIBLE);
                        ed5.setHint("Parallel side 1");
                        ed6.setHint("Parallel side 2");
                        ed7.setHint("Height");
//                        im.setImageResource(R.drawable.area_trap);
                        break;
                    case "Ellipse":
                        ed7.setVisibility(View.GONE);
                        ed5.setVisibility(View.VISIBLE);
                        ed6.setVisibility(View.VISIBLE);
                        ed5.setHint("Minor Axis");
                        ed6.setHint("Major Axis");
//                        im.setImageResource(R.drawable.area_ellipse);
                        break;
                    case "Rectangular Prism":
                        ed7.setVisibility(View.VISIBLE);
                        ed5.setVisibility(View.VISIBLE);
                        ed6.setVisibility(View.VISIBLE);
                        ed5.setHint("Length");
                        ed6.setHint("Width");
                        ed7.setHint("Height");
//                        im.setImageResource(R.drawable.area_rect_prism);
                        break;
                    case "Cylinder":
                        ed7.setVisibility(View.GONE);
                        ed5.setVisibility(View.VISIBLE);
                        ed6.setVisibility(View.VISIBLE);
                        ed5.setHint("Radius");
                        ed6.setHint("Height");
//                        im.setImageResource(R.drawable.area_cyl);
                        break;
                    case "Cone":
                        ed7.setVisibility(View.GONE);
                        ed5.setVisibility(View.VISIBLE);
                        ed6.setVisibility(View.VISIBLE);
                        ed5.setHint("Radius");
                        ed6.setHint("Slant Height");
//                        im.setImageResource(R.drawable.area_cone);
                        break;


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }


    //-----Volume-----

    else if (pos == 5) {
        setContentView(R.layout.area);
        Button btn_area = findViewById(R.id.button10);
        final Spinner s_area = findViewById(R.id.spinner_area);
        final CardView cv = findViewById(R.id.cardView);
        tv6 = findViewById(R.id.textView6);
        tv6.setText("Volume");
        tv8 = findViewById(R.id.textView8);
//        tv8.setText("Area");
        ed5 = findViewById(R.id.editText2);
        ed6 = findViewById(R.id.editText3);
        ed7 = findViewById(R.id.editText4);
//        final ImageView im = findViewById(R.id.imageView6);
//        final TextView tv8 = findViewById(R.id.textView8);



        String[] arraySpinner3 = new String[]{"Cube","Cuboid","Square or Rectangular Pyramid","Cylinder","Right Circular Cone","Sphere","Hemisphere","Prism","Ellipsoid","Tetrahedron"};

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner3);
        adapter3.setDropDownViewResource(R.layout.spinner_item);


        s_area.setAdapter(adapter3);


        btn_area.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                vibe.vibrate(20);
                // Code here executes on main thread after user presses button
//                bmi();
                double val;
                double val1;
                double val2;
                String res;
//                setContentView(R.layout.card_area_vol);

//                final ImageView im = findViewById(R.id.imageView6);
//                final TextView tv8 = findViewById(R.id.textView8);
//                final TextView tv_ar_vl = findViewById(R.id.area_vol);
//                tv_ar_vl.setText(spinner3);
                switch (spinner3) {


                    case "Right Circular Cone":
                        if(ed5.getText().toString().isEmpty() || ed6.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed5.getText().toString());
                            val1 = Double.parseDouble(ed6.getText().toString());
                            im.setImageResource(R.drawable.vol_cone);
                            res = String.format("%.2f", (3.14*val* val * val1)/3);
                            tv8.setText(res+" cubic units");

                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Cuboid":
                        if(ed5.getText().toString().isEmpty() || ed6.getText().toString().isEmpty() || ed7.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed5.getText().toString());
                            val1 = Double.parseDouble(ed6.getText().toString());
                            val2 = Double.parseDouble(ed7.getText().toString());
                            im.setImageResource(R.drawable.vol_cuboid);
                            res = String.format("%.2f",val*val1*val2);
                            tv8.setText(res+" cubic units");
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Prism":
                        if(ed5.getText().toString().isEmpty() || ed6.getText().toString().isEmpty() || ed7.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed5.getText().toString());
                            val1 = Double.parseDouble(ed6.getText().toString());
                            val2 = Double.parseDouble(ed7.getText().toString());
                            im.setImageResource(R.drawable.vol_prism);
                            res = String.format("%.2f",(val*val1*val2)/2);
                            tv8.setText(res+" cubic units");
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Ellipsoid":
                        if(ed5.getText().toString().isEmpty() || ed6.getText().toString().isEmpty() || ed7.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed5.getText().toString());
                            val1 = Double.parseDouble(ed6.getText().toString());
                            val2 = Double.parseDouble(ed7.getText().toString());
                            im.setImageResource(R.drawable.vol_ellip);
                            res = String.format("%.2f", (3.14 *val * val1* val2*4)/3);
                            tv8.setText(res+" cubic units");
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Cube":
                        if(ed7.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this,"Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            im.setImageResource(R.drawable.vol_cube);
                            val = Double.parseDouble(ed7.getText().toString());
                            res = String.format("%.2f", val * val* val);
                            tv8.setText(res+" cubic units");
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Square or Rectangular Pyramid":
                        if(ed5.getText().toString().isEmpty() || ed6.getText().toString().isEmpty() || ed7.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed5.getText().toString());
                            val1 = Double.parseDouble(ed6.getText().toString());
                            val2 = Double.parseDouble(ed7.getText().toString());
                            im.setImageResource(R.drawable.vol_pyramid);
                            res = String.format("%.2f", (val*val1*val2)/3);
                            tv8.setText(res+" cubic units");
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Cylinder":
                        if(ed5.getText().toString().isEmpty() || ed6.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed5.getText().toString());
                            val1 = Double.parseDouble(ed6.getText().toString());
                            im.setImageResource(R.drawable.vol_cyl);
                            res = String.format("%.2f", 3.14*val*val*val1);
                            tv8.setText(res+" cubic units");
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Tetrahedron":
                        if(ed7.getText().toString().isEmpty() ){
                            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            val = Double.parseDouble(ed7.getText().toString());
                            im.setImageResource(R.drawable.vol_tetra);
                            res = String.format("%.2f", (val*val*val)/(6*Math.sqrt(2)) );
                            tv8.setText(res+" cubic units");
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Sphere":
                        if(ed7.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this,"Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            im.setImageResource(R.drawable.vol_sphere);
                            val = Double.parseDouble(ed7.getText().toString());
                            res = String.format("%.2f", (4*3.14*val*val*val)/3);
                            tv8.setText(res+" cubic units");
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                    case "Hemisphere":
                        if(ed7.getText().toString().isEmpty()){
                            Toast.makeText(Units_1.this,"Please provide input", Toast.LENGTH_SHORT).show();
                        }else {
//                            cv.setVisibility(View.VISIBLE);
                            setContentView(R.layout.card_area_vol);
                            final ImageView im = findViewById(R.id.imageView6);
                            final TextView tv8 = findViewById(R.id.textView8);
                            final TextView tv_ar_vl = findViewById(R.id.area_vol);
                            tv_ar_vl.setText(spinner3);

                            im.setImageResource(R.drawable.vol_hemi);
                            val = Double.parseDouble(ed7.getText().toString());
                            res = String.format("%.2f", (2*3.14*val*val*val)/3);
                            tv8.setText(res+" cubic units");
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);}
                        break;
                }

//                area(tv8);

//                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            }
        });

        s_area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
//                cv.setVisibility(View.GONE);
                ed5.setText("");
                ed6.setText("");
                ed7.setText("");

//            Toast.makeText(Units_1.this, s1.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                spinner3 = s_area.getSelectedItem().toString();
                switch (spinner3) {

                    case "Sphere":
                        ed7.setVisibility(View.VISIBLE);
                        ed7.setHint("Radius");
                        ed5.setVisibility(View.GONE);
                        ed6.setVisibility(View.GONE);
//                        im.setImageResource(R.drawable.vol_sphere);
                        break;
                    case "Hemisphere":
                        ed7.setVisibility(View.VISIBLE);
                        ed7.setHint("Radius");
                        ed5.setVisibility(View.GONE);
                        ed6.setVisibility(View.GONE);
//                        im.setImageResource(R.drawable.vol_hemi);
                        break;

                    case "Cube":
                        ed7.setVisibility(View.VISIBLE);
                        ed7.setHint("Side");
                        ed5.setVisibility(View.GONE);
                        ed6.setVisibility(View.GONE);
//                        im.setImageResource(R.drawable.vol_cube);
                        break;
                    case "Tetrahedron":
                        ed7.setVisibility(View.VISIBLE);
                        ed7.setHint("Side");
                        ed5.setVisibility(View.GONE);
                        ed6.setVisibility(View.GONE);
//                        im.setImageResource(R.drawable.vol_tetra);
                        break;

                    case "Right Circular Cone":
                        ed7.setVisibility(View.GONE);
                        ed5.setVisibility(View.VISIBLE);
                        ed6.setVisibility(View.VISIBLE);
                        ed5.setHint("Base");
                        ed6.setHint("Height");
//                        im.setImageResource(R.drawable.vol_cone);
                        break;

                    case "Square or Rectangular Pyramid":
                        ed7.setVisibility(View.VISIBLE);
                        ed5.setVisibility(View.VISIBLE);
                        ed6.setVisibility(View.VISIBLE);
                        ed5.setHint("Length");
                        ed6.setHint("Width");
                        ed7.setHint("Height");
//                        im.setImageResource(R.drawable.vol_pyramid);
                        break;
                    case "Ellipsoid":
                        ed7.setVisibility(View.VISIBLE);
                        ed5.setVisibility(View.VISIBLE);
                        ed6.setVisibility(View.VISIBLE);
                        ed5.setHint("Semi-Axis 1");
                        ed6.setHint("Semi-Axis 2");
                        ed7.setHint("Semi-Axis 3");
//                        im.setImageResource(R.drawable.vol_ellip);
                        break;
                    case "Cuboid":
                        ed7.setVisibility(View.VISIBLE);
                        ed5.setVisibility(View.VISIBLE);
                        ed6.setVisibility(View.VISIBLE);
                        ed5.setHint("Length");
                        ed6.setHint("Width");
                        ed7.setHint("Height");
//                        im.setImageResource(R.drawable.vol_cuboid);
                        break;
                    case "Cylinder":
                        ed7.setVisibility(View.GONE);
                        ed5.setVisibility(View.VISIBLE);
                        ed6.setVisibility(View.VISIBLE);
                        ed5.setHint("Radius");
                        ed6.setHint("Height");
//                        im.setImageResource(R.drawable.vol_cyl);
                        break;
                    case "Prism":
                        ed7.setVisibility(View.VISIBLE);
                        ed5.setVisibility(View.VISIBLE);
                        ed6.setVisibility(View.VISIBLE);
                        ed5.setHint("length/Side");
                        ed6.setHint("Width/Side");
                        ed7.setHint("Height");
//                        im.setImageResource(R.drawable.vol_prism);
                        break;


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    //-----Temperature-----

    else if (pos == 6) {
        tv1.setText("Temperature");
        ed1.setHint("First Input");
        ed2.setHint("Second Input");
        String[] arraySpinner = new String[]{"Celcius  ̊ C", "Fahrenheit  ̊ F", "Kelvin"};
        String[] arraySpinner1 = new String[]{"Celcius  ̊ C", "Fahrenheit  ̊ F", "Kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner1);
        adapter1.setDropDownViewResource(R.layout.spinner_item);

        s.setAdapter(adapter);
        s1.setAdapter(adapter1);
        temp();
/////////////////////////////////////////////

////////////////////////////////////////////////
        btn.setVisibility(View.GONE);
//        btn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Code here executes on main thread after user presses button
//                if(ed1.getText().toString().isEmpty() || ed2.getText().toString().isEmpty()){
//                    Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_LONG).show();
//                }else {
//                    tv.setText("Value already computed.");
//                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
//                }
////
//
//
//            }
//        });


    }

    //-----Mass-----


    else if (pos == 7) {
        tv1.setText("Mass");
        ed1.setHint("First Input");
        ed2.setHint("Second Input");
        String[] arraySpinner = new String[]{"Kilograms","Grams","Milligrams" ,"Pounds","Ounces","Tonnes","Grains"};
        String[] arraySpinner1 = new String[]{"Kilograms","Grams","Milligrams" ,"Pounds","Ounces","Tonnes","Grains"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner1);
        adapter1.setDropDownViewResource(R.layout.spinner_item);

        s.setAdapter(adapter);
        s1.setAdapter(adapter1);
        mass();
        btn.setVisibility(View.GONE);
//        btn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Code here executes on main thread after user presses button
//                vibe.vibrate(20);
//                bmi();
//                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
//            }
//        });


    }

    //-----Time-----

    else if (pos == 8) {
        tv1.setText("Time");
        ed1.setHint("First Input");
        ed2.setHint("Second Input");
        String[] arraySpinner = new String[]{"Centuries", "Decades", "Year", "Months", "Weeks", "Days", "Hours", "Minutes", "Seconds", "Milliseconds", "Microseconds"};
        String[] arraySpinner1 = new String[]{"Centuries", "Decades", "Year", "Months", "Weeks", "Days", "Hours", "Minutes", "Seconds", "Milliseconds", "Microseconds"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner1);
        adapter1.setDropDownViewResource(R.layout.spinner_item);

        s.setAdapter(adapter);
        s1.setAdapter(adapter1);
        time();
        btn.setVisibility(View.GONE);
//        btn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Code here executes on main thread after user presses button
//
//                vibe.vibrate(20);
//                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
//            }
//        });


    }
    else if(pos == 9){
    Intent intent = new Intent(Units_1.this, Numeral.class);
    startActivity(intent);

    }


    s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int position, long id) {

//            Toast.makeText(Units_1.this, s.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            spinner1 = s.getSelectedItem().toString();
            ed1.setHint(spinner1);
            pos1 = position;


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
            pos2 = position;
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });


}
///////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //FINANCE//
///////////////////////////////////////////////////////////////////////////////////////////////////////
else if(unit_or_fin==1 && pos == 1){

//    if (pos == 1) {



        setContentView(R.layout.finance);
        tv1 = findViewById(R.id.textView5);

        tv = findViewById(R.id.textView4);
        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText1);
        ed3 = findViewById(R.id.year);
        ed4 = findViewById(R.id.month);
    ed1.setHint("Enter Amount");
    ed2.setHint("Enter annual rate");
        final Spinner s =  findViewById(R.id.spinner);
        final Spinner s1 =  findViewById(R.id.spinner1);
        ed3.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "30")});
        ed4.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "11")});
        final String[] spinner_selected = new String[2];
        final Button btn = findViewById(R.id.button);
        s.setEnabled(false);
        s1.setEnabled(false);
        tv1.setText("Loan");

        String[] arraySpinner = new String[]{"Principal"};
        String[] arraySpinner1 = new String[]{"Interest(Percentage)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner1);
        adapter1.setDropDownViewResource(R.layout.spinner_item);

        s.setAdapter(adapter);
        s1.setAdapter(adapter1);
//
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                loan();
                vibe.vibrate(20);

            }
        });


//    }
    s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int position, long id) {

//            Toast.makeText(Units_1.this, s.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            spinner1 = s.getSelectedItem().toString();
            ed1.setHint(spinner1);


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



}

else if(unit_or_fin==1 && pos!=1){
    setContentView(R.layout.units_1);
    tv = findViewById(R.id.textView4);
    ed1 = findViewById(R.id.editText);
    ed2 = findViewById(R.id.editText1);
    final Spinner s =  findViewById(R.id.spinner);
    final Spinner s1 =  findViewById(R.id.spinner1);

    final String[] spinner_selected = new String[2];
    final Button btn = findViewById(R.id.button);

    tv1 = findViewById(R.id.textView5);

    if (pos == 0) {
        tv1.setText("Currency");
        String[] arraySpinner = new String[]{"United States Dollar (USD)", "Indian Rupees (INR)", "Euro (EUR)", "British Pound (GBP)","Japanese Yen (JPY)","United Arab Emirates Dirham (AED)"};
        String[] arraySpinner1 = new String[]{"United States Dollar (USD)", "Indian Rupees (INR)", "Euro (EUR)", "British Pound (GBP)","Japanese Yen (JPY)","United Arab Emirates Dirham (AED)"};
        ed1.setHint("Currency 1");
        ed2.setHint("Currenct 2");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner1);
        adapter1.setDropDownViewResource(R.layout.spinner_item);

        s.setAdapter(adapter);
        s1.setAdapter(adapter1);

        currency();
        btn.setVisibility(View.GONE);
//        btn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Code here executes on main thread after user presses button
//
////                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
////                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
//            }
//        });


    }

    if (pos == 2) {
        tv1.setText("Split Bill");
        String[] arraySpinner = new String[]{"Total Amount"};
        String[] arraySpinner1 = new String[]{"No of Person"};
        ed1.setHint("Enter Amount");
        ed2.setHint("Enter persons");
        ed2.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "999")});
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner1);
        adapter1.setDropDownViewResource(R.layout.spinner_item);

        s.setAdapter(adapter);
        s1.setAdapter(adapter1);
        s.setEnabled(false);
        s1.setEnabled(false);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                vibe.vibrate(20);
                split();
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            }
        });


    }

    if (pos == 3) {
        tv1.setText("GST");
        String[] arraySpinner = new String[]{"Original Price"};
        String[] arraySpinner1 = new String[]{"3%", "5%", "12%", "18%", "28%"};
        ed1.setHint("Price");
        ed2.setHint("Final Price");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.spinner_item, arraySpinner1);
        adapter1.setDropDownViewResource(R.layout.spinner_item);

        s.setAdapter(adapter);
        s1.setAdapter(adapter1);
        s.setEnabled(false);
        ed2.setVisibility(View.GONE);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                vibe.vibrate(20);
                gst();
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            }
        });


    }

    s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int position, long id) {

//            Toast.makeText(Units_1.this, s.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            spinner1 = s.getSelectedItem().toString();
            ed1.setHint(spinner1);
            pos1 = position;



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
            if(spinner1.equals("Total Amount")){
                pos2=position;
            }else {
            ed2.setHint(spinner2);
            pos2 = position;}
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });


}





    }
///////////////////////////////////////////Oncreate end/////////////////////////////////////////////


    public void bmi(){
        if(ed1.getText().toString().isEmpty() || ed2.getText().toString().isEmpty()){
            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
        }
        else {
            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            val1 = Double.parseDouble(ed1.getText().toString());
            val2 = Double.parseDouble(ed2.getText().toString());
            if (spinner1.equals("Pounds")) {
                val1 = val1 * 0.454;
            }
            switch (spinner2) {
                case "Centimeters":
                    val2 = val2 / 100;
                    break;
                case "Feet":
                    val2 = val2 * 0.305;
                    break;
                case "Inches":
                    val2 = val2 * 0.0254;
                    break;
            }

            double bmi = val1 / (val2 * val2);
            String type;
            if (bmi < 18.5) {
                type = "Underweight";
            } else if (bmi > 18.5 && bmi < 24.9) {
                type = "Healthy Weight";
            } else if (bmi > 25 && bmi < 29.9) {
                type = "Overweight";
            } else {
                type = "Obese";
            }

            String new_val = String.format("%.2f", bmi) +"\n" +" Category - " + type;
            tv.setText(new_val);
        }
    }

    public  void discount(){

        if(ed1.getText().toString().isEmpty() || ed2.getText().toString().isEmpty()){
            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
        }
        else {
            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            val1 = Double.parseDouble(ed1.getText().toString());
            val2 = Double.parseDouble(ed2.getText().toString());


            double final_p = val1 * (100 - val2) / 100;
            double save = (val2 * val1) / 100;
            String fin = String.format("%.2f", final_p);
            String sv = String.format("%.2f", save);
            String res = "Final Price - " + fin + " \n(You saved " + sv + ")";
            tv.setText(res);
        }

    }
    public void perc(){
        if(ed1.getText().toString().isEmpty() || ed2.getText().toString().isEmpty()){
            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
        }else {
            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            val1 = Double.parseDouble(ed1.getText().toString());
            val2 = Double.parseDouble(ed2.getText().toString());

            String fin = "Result - " + String.format("%.2f", (val1 * val2) / 100);
            tv.setText(fin);
        }
    }

    public void temp(){
//        val1 = Double.parseDouble(ed1.getText().toString());
//        val2 =Double.parseDouble( ed2.getText().toString());



//                double res = (val1 * 9 / 5) + 32;
//                String fin = String.format("%.2f", res);
//                ed2.setText(fin);


            ed1.addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {
                    String value = s.toString();

                    if (value.equals("")) {
//                        ed1.setText("0");
                        ed2.setText("");
                    } else {
                        if (spinner1.equals("Celcius  ̊ C")) {
                            if (spinner2.equals("Fahrenheit  ̊ F")) {
                                double res = (Double.parseDouble(value) * 9 / 5) + 32;
                                String fin = String.format("%.2f", res);
                                ed2.setText(fin);

                            } else if (spinner2.equals("Kelvin")) {
                                double res = Double.parseDouble(value) + 273.15;
                                String fin = String.format("%.2f", res);
                                ed2.setText(fin);
                            } else {
                                ed2.setText(value);
                            }
                        }


                        if (spinner1.equals("Fahrenheit  ̊ F")) {
                            if (spinner2.equals("Celcius  ̊ C")) {
                                double res = (Double.parseDouble(value) - 32) * 5 / 9;
                                String fin = String.format("%.2f", res);
                                ed2.setText(fin);

                            } else if (spinner2.equals("Kelvin")) {
                                double res = (Double.parseDouble(value) - 32) * 5 / 9 + 273.15;
                                String fin = String.format("%.2f", res);
                                ed2.setText(fin);
                            } else {
                                ed2.setText(value);
                            }
                        }

                        if(spinner1.equals("Kelvin")){
                            if(spinner2.equals("Celcius  ̊ C")){
                                double res = Double.parseDouble(value) - 273.15;
                                String fin = String.format("%.2f", res);
                                ed2.setText(fin);
                            } else if(spinner2.equals("Fahrenheit  ̊ F")){
                                double res = ((Double.parseDouble(value) - 273.15) * 1.8) +32;
                                String fin = String.format("%.2f", res);
                                ed2.setText(fin);
                            }
                            else {
                                ed2.setText(value);
                            }
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

            public  void area(TextView tv8){

                tv8 = findViewById(R.id.textView8);
//                im = findViewById(R.id.imageView6);
                if(ed5.getText().toString().isEmpty() ||ed6.getText().toString().isEmpty() ||ed7.getText().toString().isEmpty() ){
                    Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();                }
                else {
                    if (spinner3.equals("Circle")) {

                        Double val = Double.parseDouble(ed7.getText().toString());
                        String res = String.format("%.2f", 3.14 * val * val);
                        tv8.setText(String.valueOf(val));
                        im.setImageResource(R.drawable.area_circle);


                    }

                }
            }

    public void len(){

// "Kilometer km", "Meter m", "Decimeter dm", "Centimeter cm", "Millimeter mm", "Micrometer µm", "Nanometer nm", "Picometer pm",
// "Nautical mile nmi", "Miles m", "Inches in", "Yards yd","Foot ft"
        NumberFormat numFormat = new DecimalFormat();
        numFormat = new DecimalFormat("0.00000E0");
        final NumberFormat finalNumFormat = numFormat;
        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                String value = s.toString();

                if(value.equals("")){
//                    ed1.setText("");
                    ed2.setText("");
                }
                else {
                    if(spinner1.equals("Kilometer km")) {
                        switch (spinner2){
                            case "Kilometer km" :
                                ed2.setText(value);
                                break;
                            case "Meter m" :
                                String res = String.format("%.2f", Double.parseDouble(value)*1000);
                                ed2.setText(res);
                                break;
                            case "Centimeter cm" :
                                String res1 = String.format("%.2f", Double.parseDouble(value)*100000);
                                ed2.setText(res1);
                                break;
                            case "Decimeter dm" :
                                String res2 = String.format("%.2f", Double.parseDouble(value)*10000);
                                ed2.setText(res2);
                                break;
                            case "Millimeter mm" :
                                String res3 = String.format("%.2f", Double.parseDouble(value)*1000000);
                                ed2.setText(res3);
                                break;
                            case "Micrometer µm" :
                                String res4 = String.format(finalNumFormat.format(Double.parseDouble(value)*1000000000));
                                ed2.setText(res4);
                                break;
                            case "Picometer pm" :
                                String res5 = String.format(finalNumFormat.format(Double.parseDouble(value)* Math.pow(10,15)));
                                ed2.setText(res5);
                                break;
                            case "Nautical mile nmi" :
                                String res6 = String.format("%.2f", Double.parseDouble(value)*0.539957);
                                ed2.setText(res6);
                                break;
                            case "Miles m" :
                                String res7 = String.format("%.2f", Double.parseDouble(value)*0.621371);
                                ed2.setText(res7);
                                break;
                            case "Inches in" :
                                String res8 = String.format("%.2f", Double.parseDouble(value)*39370.1);
                                ed2.setText(res8);
                                break;
                            case "Yards yd" :
                                String res9 = String.format("%.2f", Double.parseDouble(value)*1093.61);
                                ed2.setText(res9);
                                break;
                            case "Foot ft" :
                                String res10 = String.format("%.2f", Double.parseDouble(value)*3280.84);
                                ed2.setText(res10);
                                break;

                        }
                    }


                    if(spinner1.equals("Meter m")) {
                        switch (spinner2){
                            case "Kilometer km" :
                                String res = String.format("%.2f", Double.parseDouble(value)*0.001);
                                ed2.setText(res);
                                break;
                            case "Meter m" :

                                ed2.setText(value);
                                break;
                            case "Centimeter cm" :
                                String res1 = String.format("%.2f", Double.parseDouble(value)*100);
                                ed2.setText(res1);
                                break;
                            case "Decimeter dm" :
                                String res2 = String.format("%.2f", Double.parseDouble(value)*10);
                                ed2.setText(res2);
                                break;
                            case "Millimeter mm" :
                                String res3 = String.format("%.2f", Double.parseDouble(value)*1000);
                                ed2.setText(res3);
                                break;
                            case "Micrometer µm" :
                                String res4 = String.format(finalNumFormat.format(Double.parseDouble(value)*1000000));
                                ed2.setText(res4);
                                break;
                            case "Picometer pm" :
                                String res5 = String.format(finalNumFormat.format(Double.parseDouble(value)* Math.pow(10,12)));
                                ed2.setText(res5);
                                break;
                            case "Nautical mile nmi" :
                                String res6 = String.format(finalNumFormat.format(Double.parseDouble(value)*0.000539957));
                                ed2.setText(res6);
                                break;
                            case "Miles m" :
                                String res7 = String.format(finalNumFormat.format(Double.parseDouble(value)*0.000621371));
                                ed2.setText(res7);
                                break;
                            case "Inches in" :
                                String res8 = String.format("%.2f", Double.parseDouble(value)*39.3701);
                                ed2.setText(res8);
                                break;
                            case "Yards yd" :
                                String res9 = String.format("%.2f", Double.parseDouble(value)*1.09361);
                                ed2.setText(res9);
                                break;
                            case "Foot ft" :
                                String res10 = String.format("%.2f", Double.parseDouble(value)*3.28084);
                                ed2.setText(res10);
                                break;

                        }
                    }

                    if(spinner1.equals("Centimeter cm")) {
                        switch (spinner2){
                            case "Kilometer km" :
                                String res = String.format("%.2f", Double.parseDouble(value)*0.00001);
                                ed2.setText(res);
                                break;
                            case "Meter m" :
                                String res1 = String.format("%.2f",Double.parseDouble(value)*0.01);
                                ed2.setText(value);
                                break;
                            case "Centimeter cm" :

                                ed2.setText(value);
                                break;
                            case "Decimeter dm" :
                                String res2 = String.format("%.2f", Double.parseDouble(value)*0.1);
                                ed2.setText(res2);
                                break;
                            case "Millimeter mm" :
                                String res3 = String.format("%.2f", Double.parseDouble(value)*10);
                                ed2.setText(res3);
                                break;
                            case "Micrometer µm" :
                                String res4 = String.format("%.2f", Double.parseDouble(value)*10000);
                                ed2.setText(res4);
                                break;
                            case "Picometer pm" :
                                String res5 = String.format(finalNumFormat.format(Double.parseDouble(value)* Math.pow(10,10)));
                                ed2.setText(res5);
                                break;
                            case "Nautical mile nmi" :
                                String res6 = String.format(finalNumFormat.format(Double.parseDouble(value)/185200));
                                ed2.setText(res6);
                                break;
                            case "Miles m" :
                                String res7 = String.format(finalNumFormat.format(Double.parseDouble(value)/160934));
                                ed2.setText(res7);
                                break;
                            case "Inches in" :
                                String res8 = String.format("%.2f", Double.parseDouble(value)*0.393701);
                                ed2.setText(res8);
                                break;
                            case "Yards yd" :
                                String res9 = String.format("%.2f", Double.parseDouble(value)*0.0109361);
                                ed2.setText(res9);
                                break;
                            case "Foot ft" :
                                String res10 = String.format("%.2f", Double.parseDouble(value)*0.0328084);
                                ed2.setText(res10);
                                break;

                        }
                    }

                    if(spinner1.equals("Decimeter dm")) {
                        switch (spinner2){
                            case "Kilometer km" :
                                String res = String.format("%.2f", Double.parseDouble(value)*0.0001);
                                ed2.setText(res);
                                break;
                            case "Meter m" :
                                String res2 = String.format("%.2f", Double.parseDouble(value)*0.1);
                                ed2.setText(value);
                                break;
                            case "Centimeter cm" :
                                String res1 = String.format("%.2f", Double.parseDouble(value)*10);
                                ed2.setText(res1);
                                break;
                            case "Decimeter dm" :

                                ed2.setText(value);
                                break;
                            case "Millimeter mm" :
                                String res3 = String.format("%.2f", Double.parseDouble(value)*100);
                                ed2.setText(res3);
                                break;
                            case "Micrometer µm" :
                                String res4 = String.format("%.2f", Double.parseDouble(value)*100000);
                                ed2.setText(res4);
                                break;
                            case "Picometer pm" :
                                String res5 = String.format(finalNumFormat.format(Double.parseDouble(value)* Math.pow(10,11)));
                                ed2.setText(res5);
                                break;
                            case "Nautical mile nmi" :
                                String res6 = String.format(finalNumFormat.format(Double.parseDouble(value)/18520));
                                ed2.setText(res6);
                                break;
                            case "Miles m" :
                                String res7 = String.format(finalNumFormat.format(Double.parseDouble(value)/16093));
                                ed2.setText(res7);
                                break;
                            case "Inches in" :
                                String res8 = String.format("%.2f", Double.parseDouble(value)*3.93701);
                                ed2.setText(res8);
                                break;
                            case "Yards yd" :
                                String res9 = String.format("%.2f", Double.parseDouble(value)*0.109361);
                                ed2.setText(res9);
                                break;
                            case "Foot ft" :
                                String res10 = String.format("%.2f", Double.parseDouble(value)*0.328084);
                                ed2.setText(res10);
                                break;

                        }
                    }

                    if(spinner1.equals("Millimeter mm")) {
                        switch (spinner2){
                            case "Kilometer km" :
                                String res = String.format(finalNumFormat.format(Double.parseDouble(value)*0.000001));
                                ed2.setText(res);
                                break;
                            case "Meter m" :
                                String res3 = String.format("%.2f",Double.parseDouble(value)*0.001);
                                ed2.setText(res3);
                                break;
                            case "Centimeter cm" :
                                String res1 = String.format("%.2f", Double.parseDouble(value)*0.1);
                                ed2.setText(res1);
                                break;
                            case "Decimeter dm" :
                                String res2 = String.format("%.2f", Double.parseDouble(value)*0.01);
                                ed2.setText(res2);
                                break;
                            case "Millimeter mm" :

                                ed2.setText(value);
                                break;
                            case "Micrometer µm" :
                                String res4 = String.format("%.2f", Double.parseDouble(value)*1000);
                                ed2.setText(res4);
                                break;
                            case "Picometer pm" :
                                String res5 = String.format(finalNumFormat.format(Double.parseDouble(value)* Math.pow(10,9)));
                                ed2.setText(res5);
                                break;
                            case "Nautical mile nmi" :
                                String res6 = String.format(finalNumFormat.format(Double.parseDouble(value)/1852000));
                                ed2.setText(res6);
                                break;
                            case "Miles m" :
                                String res7 = String.format(finalNumFormat.format(Double.parseDouble(value)/1609300));
                                ed2.setText(res7);
                                break;
                            case "Inches in" :
                                String res8 = String.format("%.2f", Double.parseDouble(value)/25.4);
                                ed2.setText(res8);
                                break;
                            case "Yards yd" :
                                String res9 = String.format("%.2f", Double.parseDouble(value)/914);
                                ed2.setText(res9);
                                break;
                            case "Foot ft" :
                                String res10 = String.format("%.2f", Double.parseDouble(value)/305);
                                ed2.setText(res10);
                                break;

                        }
                    }

                    if(spinner1.equals("Micrometer µm")) {
                        switch (spinner2){
                            case "Kilometer km" :
                                String res = String.format(finalNumFormat.format(Double.parseDouble(value)/Math.pow(10,9)));
                                ed2.setText(res);
                                break;
                            case "Meter m" :
                                String res3 = String.format(finalNumFormat.format(Double.parseDouble(value)/Math.pow(10,6)));
                                ed2.setText(res3);
                                break;
                            case "Centimeter cm" :
                                String res1 = String.format(finalNumFormat.format(Double.parseDouble(value)/10000));
                                ed2.setText(res1);
                                break;
                            case "Decimeter dm" :
                                String res2 = String.format(finalNumFormat.format(Double.parseDouble(value)/Math.pow(10,5)));
                                ed2.setText(res2);
                                break;
                            case "Millimeter mm" :
                                String res4 = String.format(finalNumFormat.format(Double.parseDouble(value)/1000));
                                ed2.setText(res4);
                                break;
                            case "Micrometer µm" :

                                ed2.setText(value);
                                break;
                            case "Picometer pm" :
                                String res5 = String.format(finalNumFormat.format(Double.parseDouble(value)* Math.pow(10,6)));
                                ed2.setText(res5);
                                break;
                            case "Nautical mile nmi" :
                                String res6 = String.format(finalNumFormat.format(Double.parseDouble(value)/1852000000));
                                ed2.setText(res6);
                                break;
                            case "Miles m" :
                                String res7 = String.format(finalNumFormat.format(Double.parseDouble(value)/1609300000));
                                ed2.setText(res7);
                                break;
                            case "Inches in" :
                                String res8 = String.format(finalNumFormat.format(Double.parseDouble(value)/25400));
                                ed2.setText(res8);
                                break;
                            case "Yards yd" :
                                String res9 = String.format(finalNumFormat.format(Double.parseDouble(value)/914400));
                                ed2.setText(res9);
                                break;
                            case "Foot ft" :
                                String res10 = String.format(finalNumFormat.format(Double.parseDouble(value)/304800));
                                ed2.setText(res10);
                                break;

                        }
                    }

                    if(spinner1.equals("Picometer pm")) {
                        switch (spinner2){
                            case "Kilometer km" :
                                String res = String.format(finalNumFormat.format(Double.parseDouble(value)/Math.pow(10,15)));
                                ed2.setText(res);
                                break;
                            case "Meter m" :
                                String res3 = String.format(finalNumFormat.format(Double.parseDouble(value)/Math.pow(10,12)));
                                ed2.setText(res3);
                                break;
                            case "Centimeter cm" :
                                String res1 = String.format(finalNumFormat.format(Double.parseDouble(value)/Math.pow(10,10)));
                                ed2.setText(res1);
                                break;
                            case "Decimeter dm" :
                                String res2 = String.format(finalNumFormat.format(Double.parseDouble(value)/Math.pow(10,11)));
                                ed2.setText(res2);
                                break;
                            case "Millimeter mm" :
                                String res4 = String.format(finalNumFormat.format(Double.parseDouble(value)/Math.pow(10,9)));
                                ed2.setText(res4);
                                break;
                            case "Micrometer µm" :
                                String res5 = String.format(finalNumFormat.format(Double.parseDouble(value)/Math.pow(10,6)));
                                ed2.setText(res5);
                                break;
                            case "Picometer pm" :

                                ed2.setText(value);
                                break;
                            case "Nautical mile nmi" :
                                String res6 = String.format(finalNumFormat.format(Double.parseDouble(value)/(1.852*Math.pow(10,15))));
                                ed2.setText(res6);
                                break;
                            case "Miles m" :
                                String res7 = String.format(finalNumFormat.format(Double.parseDouble(value)/(1.609*Math.pow(10,15))));
                                ed2.setText(res7);
                                break;
                            case "Inches in" :
                                String res8 = String.format(finalNumFormat.format(Double.parseDouble(value)/(2.54*Math.pow(10,10))));
                                ed2.setText(res8);
                                break;
                            case "Yards yd" :
                                String res9 = String.format(finalNumFormat.format(Double.parseDouble(value)/(9.144*Math.pow(10,11))));
                                ed2.setText(res9);
                                break;
                            case "Foot ft" :
                                String res10 = String.format(finalNumFormat.format(Double.parseDouble(value)/(3.048*Math.pow(10,11))));
                                ed2.setText(res10);
                                break;

                        }
                    }

                    if(spinner1.equals("Nautical mile nmi")) {
                        switch (spinner2){
                            case "Kilometer km" :
                                String res = String.format("%.2f", Double.parseDouble(value)*1.852);
                                ed2.setText(res);
                                break;
                            case "Meter m" :
                                String res3 = String.format("%.2f",Double.parseDouble(value)*1852);
                                ed2.setText(res3);
                                break;
                            case "Centimeter cm" :
                                String res1 = String.format("%.2f", Double.parseDouble(value)*185200);
                                ed2.setText(res1);
                                break;
                            case "Decimeter dm" :
                                String res2 = String.format("%.2f", Double.parseDouble(value)*18520);
                                ed2.setText(res2);
                                break;
                            case "Millimeter mm" :
                                String res4 = String.format(finalNumFormat.format(Double.parseDouble(value)*(1.852*Math.pow(10,6))));
                                ed2.setText(res4);
                                break;
                            case "Micrometer µm" :
                                String res5 = String.format(finalNumFormat.format(Double.parseDouble(value)*(1.852*Math.pow(10,9))));
                                ed2.setText(res5);
                                break;
                            case "Picometer pm" :
                                String res6 = String.format(finalNumFormat.format(Double.parseDouble(value)*(1.852 * Math.pow(10,15))));
                                ed2.setText(value);
                                break;
                            case "Nautical mile nmi" :

                                ed2.setText(value);
                                break;
                            case "Miles m" :
                                String res7 = String.format("%.2f", Double.parseDouble(value)* 1.15078);
                                ed2.setText(res7);
                                break;
                            case "Inches in" :
                                String res8 = String.format("%.2f", Double.parseDouble(value)*72913);
                                ed2.setText(res8);
                                break;
                            case "Yards yd" :
                                String res9 = String.format("%.2f", Double.parseDouble(value)*2025);
                                ed2.setText(res9);
                                break;
                            case "Foot ft" :
                                String res10 = String.format("%.2f", Double.parseDouble(value)*6076.12);
                                ed2.setText(res10);
                                break;

                        }
                    }

                    if(spinner1.equals("Miles m")) {
                        switch (spinner2){
                            case "Kilometer km" :
                                String res = String.format("%.2f", Double.parseDouble(value)*1.60934);
                                ed2.setText(res);
                                break;
                            case "Meter m" :
                                String res3 = String.format("%.2f",Double.parseDouble(value)*1609.34);
                                ed2.setText(res3);
                                break;
                            case "Centimeter cm" :
                                String res1 = String.format("%.2f", Double.parseDouble(value)*160934);
                                ed2.setText(res1);
                                break;
                            case "Decimeter dm" :
                                String res2 = String.format("%.2f", Double.parseDouble(value)*16093.4);
                                ed2.setText(res2);
                                break;
                            case "Millimeter mm" :
                                String res4 = String.format(finalNumFormat.format(Double.parseDouble(value)*(1.609*Math.pow(10,6))));
                                ed2.setText(res4);
                                break;
                            case "Micrometer µm" :
                                String res5 = String.format(finalNumFormat.format(Double.parseDouble(value)*(1.609*Math.pow(10,9))));
                                ed2.setText(res5);
                                break;
                            case "Picometer pm" :
                                String res6 = String.format(finalNumFormat.format(Double.parseDouble(value)*(1.609 * Math.pow(10,15))));
                                ed2.setText(value);
                                break;
                            case "Nautical mile nmi" :
                                String res7 = String.format("%.2f",Double.parseDouble(value)/1.151);
                                ed2.setText(res7);
                                break;
                            case "Miles m" :

                                ed2.setText(value);
                                break;
                            case "Inches in" :
                                String res8 = String.format("%.2f", Double.parseDouble(value)*63360);
                                ed2.setText(res8);
                                break;
                            case "Yards yd" :
                                String res9 = String.format("%.2f", Double.parseDouble(value)*1760);
                                ed2.setText(res9);
                                break;
                            case "Foot ft" :
                                String res10 = String.format("%.2f", Double.parseDouble(value)*5280);
                                ed2.setText(res10);
                                break;

                        }
                    }

                    if(spinner1.equals("Inches in")) {
                        switch (spinner2){
                            case "Kilometer km" :
                                String res = String.format(finalNumFormat.format(Double.parseDouble(value)/39370));
                                ed2.setText(res);
                                break;
                            case "Meter m" :
                                String res3 = String.format("%.2f",Double.parseDouble(value)/39.37);
                                ed2.setText(res3);
                                break;
                            case "Centimeter cm" :
                                String res1 = String.format("%.2f", Double.parseDouble(value)*2.54);
                                ed2.setText(res1);
                                break;
                            case "Decimeter dm" :
                                String res2 = String.format("%.2f", Double.parseDouble(value)/3.937);
                                ed2.setText(res2);
                                break;
                            case "Millimeter mm" :
                                String res4 = String.format("%.2f",Double.parseDouble(value)*25.4);
                                ed2.setText(res4);
                                break;
                            case "Micrometer µm" :
                                String res5 = String.format("%.2f",Double.parseDouble(value)*25400);
                                ed2.setText(res5);
                                break;
                            case "Picometer pm" :
                                String res6 = String.format(finalNumFormat.format(Double.parseDouble(value)*(2.54 * Math.pow(10,10))));
                                ed2.setText(value);
                                break;
                            case "Nautical mile nmi" :
                                String res7 = String.format(finalNumFormat.format(Double.parseDouble(value)/72913));
                                ed2.setText(res7);
                                break;
                            case "Miles m" :
                                String res8 = String.format(finalNumFormat.format(Double.parseDouble(value)/63360));
                                ed2.setText(res8);
                                break;
                            case "Inches in" :

                                ed2.setText(value);
                                break;
                            case "Yards yd" :
                                String res9 = String.format("%.2f", Double.parseDouble(value)/36);
                                ed2.setText(res9);
                                break;
                            case "Foot ft" :
                                String res10 = String.format("%.2f", Double.parseDouble(value)/12);
                                ed2.setText(res10);
                                break;

                        }
                    }

                    if(spinner1.equals("Yards yd")) {
                        switch (spinner2){
                            case "Kilometer km" :
                                String res = String.format(finalNumFormat.format(Double.parseDouble(value)/1094));
                                ed2.setText(res);
                                break;
                            case "Meter m" :
                                String res3 = String.format("%.2f",Double.parseDouble(value)/1.094);
                                ed2.setText(res3);
                                break;
                            case "Centimeter cm" :
                                String res1 = String.format("%.2f", Double.parseDouble(value)*91.44);
                                ed2.setText(res1);
                                break;
                            case "Decimeter dm" :
                                String res2 = String.format("%.2f", Double.parseDouble(value)*9.144);
                                ed2.setText(res2);
                                break;
                            case "Millimeter mm" :
                                String res4 = String.format("%.2f",Double.parseDouble(value)*914);
                                ed2.setText(res4);
                                break;
                            case "Micrometer µm" :
                                String res5 = String.format("%.2f",Double.parseDouble(value)*914400);
                                ed2.setText(res5);
                                break;
                            case "Picometer pm" :
                                String res6 = String.format(finalNumFormat.format(Double.parseDouble(value)*(9.144 * Math.pow(10,11))));
                                ed2.setText(value);
                                break;
                            case "Nautical mile nmi" :
                                String res7 = String.format(finalNumFormat.format(Double.parseDouble(value)/2025));
                                ed2.setText(res7);
                                break;
                            case "Miles m" :
                                String res8 = String.format("%.2f",Double.parseDouble(value)/1760);
                                ed2.setText(res8);
                                break;
                            case "Inches in" :
                                String res9 = String.format("%.2f",Double.parseDouble(value)*36);
                                ed2.setText(res9);
                                break;
                            case "Yards yd" :

                                ed2.setText(value);
                                break;
                            case "Foot ft" :
                                String res10 = String.format("%.2f", Double.parseDouble(value)*3);
                                ed2.setText(res10);
                                break;

                        }
                    }

                    if(spinner1.equals("Foot ft")) {
                        switch (spinner2){
                            case "Kilometer km" :
                                String res = String.format(finalNumFormat.format(Double.parseDouble(value)/3281));
                                ed2.setText(res);
                                break;
                            case "Meter m" :
                                String res3 = String.format("%.2f",Double.parseDouble(value)/3.281);
                                ed2.setText(res3);
                                break;
                            case "Centimeter cm" :
                                String res1 = String.format("%.2f", Double.parseDouble(value)*30.48);
                                ed2.setText(res1);
                                break;
                            case "Decimeter dm" :
                                String res2 = String.format("%.2f", Double.parseDouble(value)*3.048);
                                ed2.setText(res2);
                                break;
                            case "Millimeter mm" :
                                String res4 = String.format("%.2f",Double.parseDouble(value)*305);
                                ed2.setText(res4);
                                break;
                            case "Micrometer µm" :
                                String res5 = String.format(finalNumFormat.format(Double.parseDouble(value)*304800));
                                ed2.setText(res5);
                                break;
                            case "Picometer pm" :
                                String res6 = String.format(finalNumFormat.format(Double.parseDouble(value)*(3.048 * Math.pow(10,11))));
                                ed2.setText(value);
                                break;
                            case "Nautical mile nmi" :
                                String res7 = String.format(finalNumFormat.format(Double.parseDouble(value)/6067));
                                ed2.setText(res7);
                                break;
                            case "Miles m" :
                                String res8 = String.format(finalNumFormat.format(Double.parseDouble(value)/5280));
                                ed2.setText(res8);
                                break;
                            case "Inches in" :
                                String res9 = String.format("%.2f",Double.parseDouble(value)*12);
                                ed2.setText(res9);
                                break;
                            case "Yards yd" :
                                String res10 = String.format("%.2f",Double.parseDouble(value)/3);
                                ed2.setText(res10);
                                break;
                            case "Foot ft" :

                                ed2.setText(value);
                                break;

                        }
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
    public  void mass(){
//        Kilograms","Grams","Milligrams" ,"Pounds","Ounces","Tonnes","Grains
        final double[][] mass = {
/*Kilograms*/             {1.0,1000.0,1000000.0,2.204623,35.273962,0.001,15432.358},
/*Grams*/                 {0.001,1.0,1000.0,0.002205,0.035274,1e-6,15.432358},
/*Milligrams*/            {1e-6,0.001,1.0,2.2046e-6,3.5274e-5,1e-9,0.015432},
/*Pounds*/                {0.453592,453.592,453592,1.0,16,0.000453592,7000.0},
/*Ounces*/                {0.0283495,28.3495,28349.5,0.0625,1.0,2.835e-5,437.5},
/*Tonnes*/                {1000,1e+6,1e+9,2204.62,35274,1.0,15432358.35},
/*Grains*/                {6.4799e-5,0.0647989,64.7989,0.000142857,0.00228571,6.4799e-8,1.0},
                };

        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                String value = s.toString();

                if (value.equals("")) {
//                        ed1.setText("");
                    ed2.setText("");
                }
//                else if((pos1>4 && pos2<2) || (pos1>6 && pos2<5) ) {
//                    String res = String.format(finalNumFormat.format(Double.parseDouble(ed1.getText().toString()) * mass[pos1][pos2]));
//                    ed2.setText(res);
////                    tv.setText(pos1+" "+pos2);
//                }
                else {
                    String res = String.format("%.4f", Double.parseDouble(ed1.getText().toString()) * mass[pos1][pos2]);
                    ed2.setText(res);
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
    public  void time(){
        final double[][] time = {
/*Century*/             {1.0,10.0,100.0,1200.0,5214.285714,36500.0,876000.0,52560000.0,3153600000.0,3153600000000.0,3153600000000000.0},
/*Decade*/              {0.1,1.0,10.0,120.0,521.428571,3650.0,87600.0,5256000.0,315360000.0,315360000000.0,315360000000000.0},
/*Year*/                {0.01,0.10,1.00,12.00,52.1428571,365.00,8760.00,525600.00,31536000.00,31536000000.00,31536000000000.00},
/*Month*/               {0.000833, 0.008333,0.083333, 1.0, 4.345238, 30.416667, 730.0,43800.0,2628000.0,2628000000.0,2628000000000.0},
/*Weeks*/               {0.000192,0.001918,0.019178,0.230137,1.0,7.0,168.000000,10080.000000,604800.000000,604800000.000000,604800000000.000000},
/*Days*/                {2.7397e-5,0.000274,0.002740,0.032877,0.142857,1.0,24.000000,1440.000000,86400.000000,86400000.000000,86400000.000000},
/*Hours*/               {1.14155e-6,1.1416e-5,0.000114,0.001370,0.005952,0.041667,1.0,60.000000,3600.000000,3600000.000000,3600000000.000000},
/*Minutes*/             {1.9026e-8,1.9026e-7,1.9026e-6,2.2831e-5,9.9206e-5,0.000694444,0.0166667,60,3600,3.6e+6,3.6e+9},
/*Seconds*/             {3.171e-10,3.171e-9,3.171e-8,3.8052e-7,1.6534e-6,1.1574e-5,0.000277778,0.0166667,1.0,1000,1e+6},
/*Milli*/               {3.171e-13,3.171e-12,3.171e-11,3.8052e-10,1.6534e-9,1.1574e-8,2.7778e-7,1.6667e-5,0.001,1.0,1000},
/*Micro*/               {3.171e-16,3.171e-15,3.171e-14,3.8052e-13,1.6534e-12,1.1574e-11,2.7778e-10,1.6667e-8,1e-6,0.001,1.0}};
        NumberFormat numFormat = new DecimalFormat();
        numFormat = new DecimalFormat("0.00000E0");

        final NumberFormat finalNumFormat = numFormat;
        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                String value = s.toString();

                if (value.equals("")) {
//                        ed1.setText("");
                    ed2.setText("");
                } else if( String.format("%.1f",Double.parseDouble(ed1.getText().toString()) * time[pos1][pos2]).length()>8) {
                    String res = String.format(finalNumFormat.format(Double.parseDouble(ed1.getText().toString()) * time[pos1][pos2]));
                    ed2.setText(res);
//                    tv.setText(pos1+" "+pos2);
                }else {
                    String res = String.valueOf(Double.parseDouble(ed1.getText().toString()) * time[pos1][pos2]);
                    ed2.setText(res);
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



////////////////////////////////////////////////////////////////////////////////////////////////////
                                        /////Finance Methods/////
////////////////////////////////////////////////////////////////////////////////////////////////////

        public  void gst(){

//            val2 =Double.parseDouble( ed2.getText().toString());
            if(ed1.getText().toString().isEmpty() ){
                Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
            }

            else {
                val1 = Double.parseDouble(ed1.getText().toString());

                switch (spinner2) {
                    case "3%":
                        double res = val1 + (0.03 * val1);
                        String fin = String.format("%.2f", res);
                        String val_gst = "Total Price : " +fin +"\nCGST/SGST : 1.5";
                        tv.setText(val_gst);
                        break;
                    case "5%":
                        double res1 = val1 + (0.05 * val1);
                        String fin1 = String.format("%.2f", res1);
                        String val_gst1 ="Total Price : " + fin1 +"\nCGST/SGST : 2.5";
                        tv.setText(val_gst1);
                        break;
                    case "12%":
                        double res2 = val1 + (0.12 * val1);
                        String fin2 = String.format("%.2f", res2);
                        String val_gst2 = "Total Price : " +fin2 +"\nCGST/SGST : 6";
                        tv.setText(val_gst2);
                        break;
                    case "18%":
                        double res3 = val1 + (0.18 * val1);
                        String fin3 = String.format("%.2f", res3);
                        String val_gst3 ="Total Price : " + fin3 +"\nCGST/SGST : 9";
                        tv.setText(val_gst3);
                        break;
                    case "28%":
                        double res4 = val1 + (0.28 * val1);
                        String fin4 = String.format("%.2f", res4);
                        String val_gst4 ="Total Price : " +fin4 +"\nCGST/SGST : 14";
                        tv.setText(val_gst4);
                        break;
                }
            }

        }

        public  void split(){
            if(ed1.getText().toString().isEmpty() || ed2.getText().toString().isEmpty()){
                Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
            }
            else {
                val1 = Double.parseDouble(ed1.getText().toString());
                val2 = Double.parseDouble(ed2.getText().toString());

                String res = String.format("%.2f", val1 / val2) + " per Head";
                tv.setText(res);
            }

        }

        public void loan(){
        if(ed1.getText().toString().isEmpty() || ed2.getText().toString().isEmpty() || ed3.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()){
            Toast.makeText(Units_1.this, "Please provide input", Toast.LENGTH_SHORT).show();
        }
        else {
            val1 = Double.parseDouble(ed1.getText().toString());
            val2 = Double.parseDouble(ed2.getText().toString());
            val3 = Double.parseDouble(ed3.getText().toString());
            val4 = Double.parseDouble(ed4.getText().toString());
            double rate = val2 / 1200;
            double tenure = val3 * 12 + val4;
            double emi1 = (val1 * rate * Math.pow((1 + rate), tenure));
            double emi2 = (Math.pow((1 + rate), tenure) - 1);
            double emi = emi1 / emi2;
            String res = "Monthly EMI : " + String.format("%.2f", emi) + "\n" + " Total Payment : " + String.format("%.2f", emi * tenure) + "\n" + "Total Interest : " + String.format("%.2f", emi * tenure - val1);
            tv.setText(res);

        }
        }


        public void currency(){
        // usd inr eu pound yen aed
           final Double[][] exch = {
                              {1.0,74.68,0.89,0.80,107.51,3.6732},
                              {0.0133,1.0,0.012,0.011,1.4405,0.0492},
                              {1.1249,83.98,1.0,0.90,120.9605,4.132},
                              {1.25,93.23,1.11,1.0,134.23,4.586},
                              {0.0093, 0.6942,0.0083,0.0074,1.0,0.0342},
                              {0.2722,20.3196,0.242,0.2181,29.267,1.0}};
            ed1.addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {
                    String value = s.toString();

                    if (value.equals("")) {
//                        ed1.setText("");
                        ed2.setText("");
                    } else {
                        String res = String.format("%.4f", Double.parseDouble(ed1.getText().toString()) * exch[pos1][pos2]);
                        ed2.setText(res);
//                        tv.setText(pos1+" "+pos2);
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





}
