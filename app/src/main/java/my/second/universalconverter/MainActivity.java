package my.second.universalconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> thumb=new ArrayList<Item>();
    ArrayList<Item> main_icon = new ArrayList<Item>();
    GridView gv;
    GridView gv1;
    TextView tv;
    private int backButtonCount=0;
    private int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        gv = (GridView) findViewById(R.id.basegrid);
        thumb.add(new Item("Units",R.drawable.settings1));
        thumb.add(new Item("Finance",R.drawable.rupee2));
        thumb.add(new Item("Calculator",R.drawable.calculator_grey));
        thumb.add(new Item("Support Me",R.drawable.support));

        tv = findViewById(R.id.textView7);

        final ImageAdapter imageAdapter = new ImageAdapter(this, R.layout.grid_item, thumb);
        gv.setAdapter(imageAdapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                vibe.vibrate(20);
                pos = position;
//                view.setBackgroundColor(Color.parseColor("#ffffff"));

//                TextView tv =(TextView) view;
//                tv.setBackgroundColor(Color.parseColor("#ffffff"));
//                tv.setTextColor(Color.RED);
//                if(pos==0){
//                    Item i = thumb.get(1);
//                    i.item_Image = R.drawable.rupee2;}
//                else {
//                    String name = thumb.get(0).item_Name;
//                    thumb.get(0)
//                }
                fun(pos);

            }
        });


        tv.setText("Units");
        gv1 = findViewById(R.id.gridview);
        main_icon.add(new Item("BMI", R.drawable.scale));
        main_icon.add(new Item("Discount", R.drawable.label));
        main_icon.add(new Item("Percentage", R.drawable.discount));
        main_icon.add(new Item("Length", R.drawable.measurement));
        main_icon.add(new Item("Area", R.drawable.ruler));
        main_icon.add(new Item("Volume", R.drawable.cube));
        main_icon.add(new Item("Temperature", R.drawable.thermometer));
        main_icon.add(new Item("Mass", R.drawable.user));
        main_icon.add(new Item("Time", R.drawable.clock));
        main_icon.add(new Item("Numeric", R.drawable.binary));



        ImageAdapter img = new ImageAdapter(this, R.layout.grid_item, main_icon);
        gv1.setAdapter(img);


        gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                vibe.vibrate(20);
                Intent intent = new Intent(MainActivity.this, Units_1.class);

                intent.putExtra("pos", position);// put image data in Intent
                startActivity(intent); // start Intent

            }
        });



    }

    private void onLeftSwipe() {

        Intent go = new Intent(MainActivity.this, Calculator.class);
        startActivity(go);
    }


    public void fun(int pos){
        final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(pos==0) {
            thumb.set(0, new Item("Units", R.drawable.settings1));
            thumb.set(1, new Item("Finance", R.drawable.rupee2));
            thumb.set(2, new Item("Calculator",R.drawable.calculator_grey));

            ImageAdapter imageAdapter = new ImageAdapter(this, R.layout.grid_item, thumb);
            gv.setAdapter(imageAdapter);

            ArrayList<Item> main_icon = new ArrayList<Item>();
            tv.setText("Units");
            gv1 = findViewById(R.id.gridview);
            main_icon.add(new Item("BMI", R.drawable.scale));
            main_icon.add(new Item("Discount", R.drawable.label));
            main_icon.add(new Item("Percentage", R.drawable.discount));
            main_icon.add(new Item("Length", R.drawable.measurement));
            main_icon.add(new Item("Area", R.drawable.ruler));
            main_icon.add(new Item("Volume", R.drawable.cube));
            main_icon.add(new Item("Temperature", R.drawable.thermometer));
            main_icon.add(new Item("Mass", R.drawable.user));
            main_icon.add(new Item("Time", R.drawable.clock));
            main_icon.add(new Item("Numeric", R.drawable.binary));

            ImageAdapter img = new ImageAdapter(this, R.layout.grid_item, main_icon);
            gv1.setAdapter(img);


            gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // set an Intent to Another Activity
                    vibe.vibrate(20);
                    Intent intent = new Intent(MainActivity.this, Units_1.class);

                    intent.putExtra("pos", position);
                    intent.putExtra("main_grid",0);// put image data in Intent
                    startActivity(intent); // start Intent

                }
            });

        }
        else  if(pos==1){

            thumb.set(0, new Item("Units", R.drawable.settings));
            thumb.set(1, new Item("Finance", R.drawable.rupee1));
            thumb.set(2, new Item("Calculator",R.drawable.calculator_grey));
            ImageAdapter imageAdapter = new ImageAdapter(this, R.layout.grid_item, thumb);
            gv.setAdapter(imageAdapter);
            ArrayList<Item> main_icon = new ArrayList<Item>();
            tv.setText("Finance");
            gv1 = findViewById(R.id.gridview);
            main_icon.add(new Item("Currency",R.drawable.money));
            main_icon.add(new Item("Loan",R.drawable.payment));
            main_icon.add(new Item("Split Bill",R.drawable.piechart));
            main_icon.add(new Item("GST",R.drawable.tax));

            ImageAdapter img = new ImageAdapter(this, R.layout.grid_item, main_icon);
            gv1.setAdapter(img);
            gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // set an Intent to Another Activity
                    vibe.vibrate(20);
                    Intent intent = new Intent(MainActivity.this, Units_1.class);

                    intent.putExtra("pos", position);// put image data in Intent
                    intent.putExtra("main_grid",1);
                    startActivity(intent);


                }
            });

        }
        else  if(pos==2){

            thumb.set(0, new Item("Units", R.drawable.settings));
            thumb.set(1, new Item("Finance", R.drawable.rupee2));
            thumb.set(2, new Item("Calculator",R.drawable.calculator_orange));
            ImageAdapter imageAdapter = new ImageAdapter(this, R.layout.grid_item, thumb);
            gv.setAdapter(imageAdapter);
            Intent intent = new Intent(MainActivity.this, Calculator.class);

            startActivity(intent);
//            ArrayList<Item> main_icon = new ArrayList<Item>();
//            tv.setText("Finance");
//            gv1 = findViewById(R.id.gridview);
//            main_icon.add(new Item("Currency",R.drawable.money));
//            main_icon.add(new Item("Loan",R.drawable.payment));
//            main_icon.add(new Item("Split Bill",R.drawable.piechart));
//            main_icon.add(new Item("GST",R.drawable.tax));

//            ImageAdapter img = new ImageAdapter(this, R.layout.grid_item, main_icon);
//            gv1.setAdapter(img);


        }
        else if(pos==3){
            Intent intent = new Intent(MainActivity.this,Support.class);
            startActivity(intent);
        }
    }
    @Override
    public void onBackPressed() {
        if(backButtonCount>=1){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);}
        else {
            Toast.makeText(this, "Press Again to Exit",Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
//        super.onBackPressed();
    }
}