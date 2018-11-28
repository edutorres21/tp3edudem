package com.example.gilbertitoramos.tp3eduardo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
 TextView textvuser;
 Button btn;
 Intent retour;
 UserInfo [] listeusers;
 int[] notes;
 String userconnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textvuser= findViewById(R.id.text_user);
        btn= findViewById(R.id.btnretourdebut);
        ListView listView = (ListView) findViewById(R.id.liste);
        userconnect=getIntent().getStringExtra("username");
        listeusers= (UserInfo[]) getIntent().getSerializableExtra("listeetu");

        if(listeusers!=null) {
            listView.setAdapter(new CustomAdapter(this, listeusers));
            textvuser.setText(listeusers[0].nom);
        }
        else if(listeusers==null && userconnect!=null) {
            listView.setAdapter(new CustomAdapter(this, CreationUsers(userconnect)));
            textvuser.setText(userconnect);
        }



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                retour= new Intent(getApplicationContext(),MainActivity.class);
                int sommenotes=0;
                if(listeusers!=null) {
                    notes=new int[listeusers.length];
                    for (int i=0;i<listeusers.length;i++){
                        notes[i]=listeusers[i].note;

                        sommenotes+=notes[i];
                    }
                    String sommetotalnotes=""+sommenotes;

                    retour.putExtra("usr",listeusers[0].nom);

                    retour.putExtra("password","12345");
                    retour.putExtra("sommenotes",sommetotalnotes);
                }

                startActivity(retour);
            }
        });


    }
    public UserInfo[] CreationUsers(String userconnecte){
         String[] rooms = this.getResources().getStringArray(R.array.listeusers);
         listeusers= new UserInfo[3];
         for (int i=0; i<listeusers.length;i++) {

             listeusers[i] = new UserInfo();
             String courriel = rooms[i].replaceAll("\\s+", "");
             if(i==0) {

                 listeusers[i].nom = userconnecte;
                 listeusers[i].codepermanent = "TOREDU1979237";
                 listeusers[i].email = userconnecte + "@gmail.com";
                 listeusers[i].picturepath = courriel.toLowerCase();
             }
             else{

                 listeusers[i].nom = rooms[i];
                 listeusers[i].codepermanent = "RGTG17098306";
                 listeusers[i].email = courriel + "@gmail.com";
                 listeusers[i].picturepath = courriel.toLowerCase();

             }

         }

        return listeusers;
    }
}
