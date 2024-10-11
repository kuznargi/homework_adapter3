package com.eco.adapters3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    ArrayAdapter<String> adapter;
    TextView name;
    ImageView image;
    String []products={"Banana","Strawberry","Ananas"};
    Integer[]icons={R.drawable.banana,R.drawable.strawberry,R.drawable.fruit};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.product_name);
        name=findViewById(R.id.name);
        image=findViewById(R.id.img);
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,products);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        AdapterView.OnItemSelectedListener itemSelectedListener= new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                name.setText(item);
                name.setVisibility(View.VISIBLE);
                image.setImageResource(icons[position]);
                image.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        };
        spinner.setOnItemSelectedListener(itemSelectedListener);

    }

}