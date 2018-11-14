package com.example.karsa.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    private Button Activiti_Valtas_Oda;
    public void Valtozok(){
        Activiti_Valtas_Oda=(Button)findViewById(R.id.Activiti_Valtas_Oda);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Valtozok();

        Activiti_Valtas_Oda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next_activity3=new Intent(Main3Activity.this,MainActivity.class);
                startActivity(next_activity3);
                finish();
            }
        });
}}
