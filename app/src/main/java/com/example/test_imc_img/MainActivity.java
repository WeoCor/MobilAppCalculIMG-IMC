package com.example.test_imc_img;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private EditText poids;
    private EditText taille;
    private EditText age;
    private RadioButton f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poids = findViewById(R.id.etpoids);
        taille = findViewById(R.id.ettaille);
        age = findViewById(R.id.etage);
        f = findViewById(R.id.rbf);
        Button btnimg = findViewById(R.id.btnimg);
        Button btnimc = findViewById(R.id.btnimc);

        btnimc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Declaration of variable
                int s;
                Float p;
                Float t;
                int a;
                Float imc;

                p= Float.parseFloat(poids.getText().toString());
                t= Float.parseFloat(taille.getText().toString());
                a= Integer.parseInt(age.getText().toString());

                if(f.isChecked()){
                    s=0;
                }else{
                    s=1;
                }
                //convertir la taille en m
                t=t/100;
                imc=p/(t*t);
                //Intent
                Intent in = new Intent(MainActivity.this,TEST_IMC.class);
                Bundle bn = new Bundle();
                bn.putInt("age",a);
                bn.putFloat("taille",t);
                bn.putFloat("poids",p);
                bn.putInt("sexe",s);
                bn.putFloat("imc",imc);

                in.putExtras(bn);
                startActivity(in);

            }
        });

        //programmation of the second btn

        btnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int s;
                Float p;
                Float t;
                int a;
                Float img;

                p= Float.parseFloat(poids.getText().toString());
                t= Float.parseFloat(taille.getText().toString());
                a= Integer.parseInt(age.getText().toString());

                if(f.isChecked()){
                    s=0;
                }else{
                    s=1;
                }
                t=t/100;

                img = (float)(1.29*(p/(t*t)) + 0.2*a - (11.4*s)-8);

                Intent in = new Intent(MainActivity.this, TEST_IMG.class);
                Bundle bn = new Bundle();

                bn.putInt("age",a);
                bn.putFloat("taille",t);
                bn.putFloat("poids",p);
                bn.putInt("sexe",s);
                bn.putFloat("img",img);

                in.putExtras(bn);
                startActivity(in);
            }
        });
    }
}