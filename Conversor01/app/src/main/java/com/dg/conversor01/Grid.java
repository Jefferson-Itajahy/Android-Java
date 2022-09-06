package com.dg.conversor01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Grid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        GridView gridView = findViewById(R.id.gridv);
        gridView.setAdapter(new Adaptery(this));
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent i = new Intent(Grid.this, MainActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(Grid.this, "O Euro ainda não foi implementado!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}