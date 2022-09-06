package com.dg.conversor01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtValorReais;
    Button btnConverter;
    TextView tvResultadoDolar;
    String resultado;
    //==============================================
    double valorReais;
    ListView lvDados;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    //==============================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValorReais       = findViewById(R.id.edtValorReais);
        btnConverter        = findViewById(R.id.btnConverter);
        tvResultadoDolar    = findViewById(R.id.tvResultadoDolar);

        //=======================================================
        lvDados = findViewById(R.id.lvDados);
        arrayList = new ArrayList<>();

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);

        lvDados.setAdapter(adapter);
        //=======================================================

        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtValorReais.getText().toString().isEmpty()){
                    tvResultadoDolar.setText("Favor digitar um valor");
                } else {
                    valorReais = Double.parseDouble(edtValorReais.getText().toString());
                    DecimalFormat arredondar = new DecimalFormat("#.##");
                    double valorDolares = Double.parseDouble(arredondar.format(valorReais * 0.18));

                    //tvResultadoDolar.setText(String.valueOf(valorDolares) + "$");
                    resultado = String.valueOf(valorDolares);

                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("resultado", resultado);
                   startActivityForResult(i, 1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == 2 && data != null){
            resultado = data.getExtras().getString("retorno");
            tvResultadoDolar.setText(resultado);
            //==========================================================
            arrayList.add("R$ " + valorReais + " -->  $ " + resultado);
            adapter.notifyDataSetChanged();
            //==========================================================
        } else {
            Toast.makeText(this, "Resultado inválido!", Toast.LENGTH_SHORT).show();
        }
    }
}