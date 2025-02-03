package com.example.bmicalculator;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class bmicalculation extends AppCompatActivity {







    android.widget.Button recalculatebmibtn;

    TextView bmiText,bmiCategory,Gender;
    Intent intent;
    ImageView imageView;
    String Bmi;
    float intbmi;

    String Height;
    String Weight;
    float intheight,intweight;
    RelativeLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmicalculation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //getSupportActionBar().setElevation(0);
        //getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        //getSupportActionBar().setTitle("Result");
        //ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("1E1D1D"));
        //getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent=getIntent();


        bmiText=findViewById(R.id.bmitext);
        bmiCategory=findViewById(R.id.bmicategory);
        Gender=findViewById(R.id.gendertext);
        background=findViewById(R.id.contentLayout);
        imageView=findViewById(R.id.ticklogo);
        Height=intent.getStringExtra("height");
        Weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(Height);
        intweight=Float.parseFloat(Weight);

        intheight=intheight/100;

        intbmi=intweight/(intheight*intheight);

        Bmi=Float.toString(intbmi);

        if(intbmi<18.5){
            bmiCategory.setText("Underweight");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.underweightfinal);
        }
        else if(intbmi<25 && intbmi>18.4){

            bmiCategory.setText("Normal");
            //background.setBackgroundColor(Color.YELLOW);
            imageView.setImageResource(R.drawable.normalfinal);
        }
        else if(intbmi<29.5 &&intbmi >24.9){

            bmiCategory.setText("Overweight");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.overweightfinal);
        }
        else{

            bmiCategory.setText("Obese");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.obesefinal);
        }

        Gender.setText(intent.getStringExtra("gender"));
        bmiText.setText(Bmi);






        //getSupportActionBar().hide();
        recalculatebmibtn=findViewById(R.id.recalculatebmi);

        recalculatebmibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(bmicalculation.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}