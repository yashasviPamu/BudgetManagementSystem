package com.example.budgetmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Expenses extends AppCompatActivity {
EditText Expedit1,Expedit2;
Button Add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);
        Expedit1=findViewById(R.id.expname);
        Expedit2=findViewById(R.id.expamount);
        Add=findViewById(R.id.add);
        final myDbAdapter mdb = new myDbAdapter(this);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = mdb.insertValues("E "+Expedit1.getText().toString(),Expedit2.getText().toString());
                if(isInserted=true)
                    Toast.makeText(Expenses.this,"Data inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Expenses.this,"Data not inserted",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

