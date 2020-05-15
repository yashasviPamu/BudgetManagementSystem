package com.example.budgetmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {
TextView displayBudget,displayExpense,displayAvailable,percentageAvailable,details;
ProgressBar progressBar;
private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        myDbAdapter mdb = new myDbAdapter(this);
        int sum = mdb.getAdditionOfBudget();
        int sum1 = mdb.getAdditionOfExpense();
        displayBudget=findViewById(R.id.tv);
        displayBudget.setText("Total Budget = "+sum);
        displayExpense=findViewById(R.id.tv1);
        displayExpense.setText("Total Expense = "+sum1);
        progressBar=findViewById(R.id.progress);
        int available = sum-sum1;
        displayAvailable=findViewById(R.id.tv2);
        displayAvailable.setText("Total Available = "+available);
        details=findViewById(R.id.tv3);
        details.setText("Percentage of available balance ");
        percentageAvailable=findViewById(R.id.tv4);
        final int availablepercent = ((sum - sum1)*100)/sum;
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable(){
                    @Override
                    public void run() {
                        progressBar.setProgress(availablepercent);
                        percentageAvailable.setText(availablepercent+"/"+progressBar.getMax());
                    }
                });
                try {
                    // Sleep for 200 milliseconds.
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
