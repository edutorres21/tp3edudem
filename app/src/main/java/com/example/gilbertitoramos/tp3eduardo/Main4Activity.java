package com.example.gilbertitoramos.tp3eduardo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

        TextView t1,t2,t3;
        EditText et;
        ImageView iv;
        Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent i2= getIntent();
        final UserInfo[] etudiant= (UserInfo[]) i2.getSerializableExtra("listeetudiant");
        final int pos= (int)i2.getIntExtra("position",-1);


        t1= findViewById(R.id.nom);
        t2=findViewById(R.id.codepermanent);
        t3= findViewById(R.id.email);
        iv=findViewById(R.id.picture);
        et=findViewById(R.id.note);

        if(etudiant[pos].picturepath.equals("stevejobs"))
            iv.setImageResource(R.drawable.steve);
        else if(etudiant[pos].picturepath.equals("stevewozniak"))
            iv.setImageResource(R.drawable.wozniak);
        else  if(etudiant[pos].picturepath.equals("vitalikbuterin"))
            iv.setImageResource(R.drawable.vitalik);

        t1.setText(etudiant[pos].nom);
        t2.setText(etudiant[pos].codepermanent);
        t3.setText(etudiant[pos].email);



        et.setText(""+etudiant[pos].note);

        bt=findViewById(R.id.retoura3);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Main4Activity.this,Main3Activity.class);
                i.putExtra("listeetu",etudiant);
                boolean noteint=(Integer.parseInt(et.getText().toString())>3)? true:false;
                if(et.getText().equals("")|| noteint) {
                    Toast.makeText(getApplicationContext(), "Erreur: Note no valide note=0",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    etudiant[pos].note = Integer.parseInt(et.getText().toString());
                }
                startActivity(i);

            }
        });

    }
}
