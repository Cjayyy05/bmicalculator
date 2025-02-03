package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    android.widget.Button calculatebmibtn;

    TextView Currentheight;
    TextView Currentage, Currentweight;
    ImageView Incrementweight, Decrementweight, Incrementage, Decrementage;
    SeekBar Seekbarforheight;
    RelativeLayout Male, Female;


    int intweight=60;
    int intage=18;
    int currentprogress;
    String intprogress="170";
    String typeofuser="0";
    String weight2="60";
    String age2="18";








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //getSupportActionBar().hide();


        calculatebmibtn=findViewById(R.id.calculatebmi);
        Currentage=findViewById(R.id.currentage);
        Currentweight=findViewById(R.id.currentweight);
        Currentheight=findViewById(R.id.currentheight);
        Incrementage=findViewById(R.id.incrementage);
        Decrementage=findViewById(R.id.decrementage);
        Seekbarforheight=findViewById(R.id.seekbarforheight);
        Incrementweight=findViewById(R.id.incrementweight);
        Decrementweight=findViewById(R.id.decrementweight);
        Male=findViewById(R.id.male);
        Female=findViewById(R.id.female);


        Male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                Female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Male";
            }
        });

        Female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                Female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                typeofuser="Female";
            }
        });






        Seekbarforheight.setMax(300);
        Seekbarforheight.setProgress(190);
        Seekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress=progress;
                intprogress=String.valueOf(currentprogress);
                Currentheight.setText(intprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Incrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage+1;
                age2=String.valueOf(intage);
                Currentage.setText(age2);
            }
        });

        Incrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight+1;
                weight2=String.valueOf(intweight);
                Currentweight.setText(weight2);
            }
        });

        Decrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage-1;
                age2=String.valueOf(intage);
                Currentage.setText(age2);
            }
        });

        Decrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight-1;
                weight2=String.valueOf(intweight);
                Currentweight.setText(weight2);
            }
        });










        calculatebmibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(typeofuser.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select Your Gender", Toast.LENGTH_SHORT).show();
                }
                else if(intprogress.equals("0")){
                    Toast.makeText(getApplicationContext(), "Enter your height", Toast.LENGTH_SHORT).show();
                }
                else if(intage==0||intage<0){
                    Toast.makeText(getApplicationContext(), "Enter appropriate age", Toast.LENGTH_SHORT).show();
                }
                else if (intweight==0||intweight<0) {
                    Toast.makeText(getApplicationContext(), "Enter appropriate weight", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent=new Intent(MainActivity.this,bmicalculation.class);
                    intent.putExtra("gender",typeofuser);
                    intent.putExtra("height",intprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);
                }


            }
        });


    }
}