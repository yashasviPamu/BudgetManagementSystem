package com.example.budgetmanagementsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class graphs extends AppCompatActivity {
ListView lview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphs);
        lview=findViewById(R.id.lv1);
        myDbAdapter mdb = new myDbAdapter(getApplicationContext());
        Cursor res = mdb.getAllData();
        if(res.getCount()==0) {
            showMessage("Error", "No data found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext())
        {
            buffer.append("Id : "+res.getString(0)+"\n");
            buffer.append("Name :"+res.getString(1)+"\n");
            buffer.append("Amount : "+res.getString(2)+"\n\n");
        }
        showMessage("BudgetData",buffer.toString());
    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.setNeutralButton("Stats", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent l = new Intent(graphs.this,Statistics.class);
                startActivity(l);
            }
        });
        builder.show();
    }
}
