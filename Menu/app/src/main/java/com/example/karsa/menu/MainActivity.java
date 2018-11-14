package com.example.karsa.menu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button Activiti_Valtas;
    private TextView Adat_Text_View;

    private String File_Nev1="adatok";
    public void Valtozok(){

        Activiti_Valtas=(Button)findViewById(R.id.Activiti_Valtas);
        Adat_Text_View=(TextView)findViewById(R.id.Adat_Text_View);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Valtozok();

        SharedPreferences sharedPreferences=getSharedPreferences(File_Nev1,Context.MODE_PRIVATE);
        String alapertelmezett="nincs adat";
        String adat =sharedPreferences.getString("adat",alapertelmezett);
        Adat_Text_View.setText(adat);
        Activiti_Valtas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent next_activity=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(next_activity);
                finish();
            }
        });
    }
}
