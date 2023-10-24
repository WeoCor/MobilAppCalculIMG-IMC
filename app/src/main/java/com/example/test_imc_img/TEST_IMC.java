package com.example.test_imc_img;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TEST_IMC extends AppCompatActivity {
    private TextView pd,tl,age,sex,imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_imc);

        pd=findViewById(R.id.tvpoids);
        tl=findViewById(R.id.tvtaille);
        age=findViewById(R.id.tvage);
        sex=findViewById(R.id.tvsexe);
        imc=findViewById(R.id.tvIMC);

        Bundle b = getIntent().getExtras();
        int age1 = b.getInt("age");
        int sx1 = b.getInt("sexe");
        Float pd1 = b.getFloat("poids");
        Float tl1 = b.getFloat("taille");
        Float imc1 = b.getFloat("imc");

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
        imc.setText("Votre IMC = "+String.format("%.02f",imc1));
        age.setText("Votre Age est "+age1+"ans");

    }
}