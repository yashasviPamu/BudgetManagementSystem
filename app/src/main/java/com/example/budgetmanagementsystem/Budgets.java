package com.example.budgetmanagementsystem;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Budgets extends AppCompatActivity {
EditText name, amount;
Button add;
myDbAdapter helper;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budgets);
        name=findViewById(R.id.budname);
        amount=findViewById(R.id.budamount);
        add=findViewById(R.id.add);
        helper = new myDbAdapter(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = helper.insertValues("B "+name.getText().toString(),amount.getText().toString());
                if(isInserted=true)
                    Toast.makeText(Budgets.this,"Data inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Budgets.this,"Data not inserted",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
