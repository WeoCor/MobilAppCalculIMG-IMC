package com.example.test_imc_img;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TEST_IMG extends AppCompatActivity {
    private TextView pd,tl,age,sex,img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_img);

        pd=findViewById(R.id.tvimgpoids);
        tl=findViewById(R.id.tvimgtaille);
        age=findViewById(R.id.tvimgage);
        sex=findViewById(R.id.tvimgsexe);
        img=findViewById(R.id.tvimg);

        Bundle b = getIntent().getExtras();
        int age1 = b.getInt("age");
        int sx1 = b.getInt("sexe");
        Float pd1 = b.getFloat("poids");
        Float tl1 = b.getFloat("taille");
        Float img1 = b.getFloat("img");

        String Sexe;
        if(sx1 == 0){
            Sexe = " une Femme";
        }else{
            Sexe = "un Homme";
        }
        //show result

        sex.setText("Vous etes "+ Sexe);
        pd.setText("Votre poids est de "+pd1);
        tl.setText("Votre taille est"+tl1);
        img.setText("Votre IMG = "+String.format("%.02f",img1));
        age.setText("Votre Age est "+age1+"ans");
    }
}