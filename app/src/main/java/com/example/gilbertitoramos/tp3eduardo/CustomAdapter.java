package com.example.gilbertitoramos.tp3eduardo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] rooms;
    String temp;
    TextView txt;
    UserInfo [] users;
    public CustomAdapter(Context c,UserInfo [] u)
    {
        context = c;
        users=u;
        Resources res = c.getResources();
        rooms = res.getStringArray(R.array.listeusers);
    }
    @Override
    public int getCount() {
        return rooms.length;
    }

    @Override
    public Object getItem(int position) {
        return rooms[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =  inflater.inflate(R.layout.rowsliste ,parent,false);
        txt = (TextView) view.findViewById(R.id.txt_item);
        if(position==0)
            temp=users[0].nom;
        else
            temp = rooms[position];
        txt.setText(temp);
        txt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent= new Intent(context,Main4Activity.class);
                intent.putExtra("listeetudiant",users);
                intent.putExtra("position",position);

                context.startActivity(intent);
            }
        });
        return view;
    }





}
