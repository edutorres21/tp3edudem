package com.example.gilbertitoramos.tp3eduardo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
   TextView txtresult;
   String erreur="Erreur dans le mot passe";
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtresult=findViewById(R.id.erreuractivity);
        txtresult.setText(erreur);
        btn= findViewById(R.id.btnreculer);
        btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent saveerror=  new Intent(Main2Activity.this,MainActivity.class);
            saveerror.putExtra("txtmsgerreur",erreur);
            startActivity(saveerror);

        }
    });



    }
}


//txtmsgerreur