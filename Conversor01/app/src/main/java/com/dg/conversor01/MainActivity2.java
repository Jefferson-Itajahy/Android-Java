package com.dg.conversor01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tvOla;
    Intent i;
    Button btnRetornar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvOla = findViewById(R.id.tvOla);
        i = getIntent();

        btnRetornar = findViewById(R.id.btnRetornar);

        tvOla.setText("Resultado: " + i.getExtras().getString("resultado"));

        btnRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("retorno", i.getExtras().getString("resultado"));
                setResult(2, i);
                finish();
            }
        });
    }
}