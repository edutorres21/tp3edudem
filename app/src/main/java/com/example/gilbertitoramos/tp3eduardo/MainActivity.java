package com.example.gilbertitoramos.tp3eduardo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.io.Serializable;

public class MainActivity extends Activity {

    EditText username,motpasse;
    Button btnsoumettre;
    TextView txtvmsgerreur,sommenotes;
    private SharedPreferences preferencesPassword;
    String preferences,msgerror, userextra,passwordextra,notesextra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencesPassword = getPreferences(Context.MODE_PRIVATE);
        preferences=preferencesPassword.getString("password","12345");
        CreationPasswordSharedPreferences();
        username= findViewById(R.id.usernom);
        motpasse= findViewById(R.id.password);
        btnsoumettre= findViewById(R.id.btnsend);
        txtvmsgerreur= findViewById(R.id.msgerreur);
        sommenotes=findViewById(R.id.sommenotes);
        userextra=getIntent().getStringExtra("usr");
        passwordextra=getIntent().getStringExtra("password");
        notesextra=  getIntent().getStringExtra("sommenotes");
        if(userextra!=null && passwordextra!=null && notesextra!=null){
            username.setText(userextra);
            motpasse.setText(passwordextra);
            txtvmsgerreur.setText("");
            if(!notesextra.equals("0"))
               sommenotes.setText("la note pour la presentation est :"+notesextra);
        }
        msgerror = getIntent().getStringExtra("txtmsgerreur");
        if(msgerror!=null){

            txtvmsgerreur.setText(msgerror);
         }
         btnsoumettre.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent activityresult;

                 if(VerificationPassword(motpasse.getText().toString(),preferences)){
                     activityresult=  new Intent(getApplicationContext(),Main3Activity.class);
                     activityresult.putExtra("username",username.getText().toString());
                     startActivity(activityresult);
                 }
                 else{
                     activityresult=  new Intent(getApplicationContext(),Main2Activity.class);
                     startActivity(activityresult);
                 }
            }
         });


    }

    public void CreationPasswordSharedPreferences (){
        SharedPreferences.Editor passwordedit=preferencesPassword.edit();
        passwordedit.putString("password","12345");
        passwordedit.apply();
    }

    public Boolean VerificationPassword(String passwordusername,String p){
        if(passwordusername.equals(p))
            return true;
        return false;
    }
}
