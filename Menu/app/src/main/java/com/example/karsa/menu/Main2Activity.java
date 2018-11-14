package com.example.karsa.menu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private Button Activiti_Valtas_Vissza;
    private EditText Adat_Edit_Text;
    private String File_Nev="adatok";
    public void Valtozok(){
        Activiti_Valtas_Vissza=(Button)findViewById(R.id.Activiti_Valtas_Vissza);
        Adat_Edit_Text=(EditText)findViewById(R.id.Adat_Edit_Text);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Valtozok();

        Activiti_Valtas_Vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mentés
                String adat=Adat_Edit_Text.getText().toString();
                SharedPreferences sharedPreferences=getSharedPreferences(File_Nev, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit=sharedPreferences.edit();
                edit.putString("adat",adat);
                edit.commit();//edit.apply(); same shit
                //vissza
                Intent next_activity2=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(next_activity2);
                finish();
            }
        });
    }
}
