package com.example.chase.coolcal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

    String runningNum = "";
    String leftValue ="";
    String rightValue = "";
    Operation currentOperation;
    long result = 0;
    TextView resultsTxt;

    public enum Operation {
        add, subtract, divide, multiply, equal
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button oneBtn = (Button)findViewById(R.id.oneButton);
        Button twoBtn =(Button)findViewById(R.id.twoButton);
        Button threeBtn = (Button)findViewById(R.id.threeButton);
        Button fourBtn = (Button)findViewById(R.id.fourButton);
        Button fiveBtn = (Button)findViewById(R.id.fivebutton);
        Button sixBtn = (Button)findViewById(R.id.sixButton);
        Button sevenBtn = (Button)findViewById(R.id.sevenbutton);
        Button eightBtn = (Button)findViewById(R.id.eightButton);
        Button nineBtn = (Button)findViewById(R.id.nineButton);
        Button zeroBtn = (Button)findViewById(R.id.zeroButton);

        ImageButton equalBtn = (ImageButton)findViewById(R.id.equal);
        ImageButton mutipleBtn = (ImageButton)findViewById(R.id.multiBtn);
        ImageButton divideBtn = (ImageButton)findViewById(R.id.divide);
        ImageButton subBtn = (ImageButton)findViewById(R.id.subtract);
        ImageButton addBtn = (ImageButton)findViewById(R.id.addButton);

        Button clearBtn = (Button)findViewById(R.id.clearButton);
        resultsTxt = (TextView)findViewById(R.id.resultsText);



        oneBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
            numberPressed(1);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(2);
            }
        });

      threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(3);

            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(4);

            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(4);

            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(6);

            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(7);

            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(8);

            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(9);

            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(0);

            }
        });

        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                processOperation(Operation.equal);
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                processOperation(Operation.divide);

            }
        });

        mutipleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                processOperation(Operation.multiply);

            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                processOperation(Operation.subtract);

            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                processOperation(Operation.add);

            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                leftValue = "";
                rightValue = "";
                result = 0;
                runningNum = "";
                currentOperation = null;
                resultsTxt.setText("0");
            }
        });


    }

    void processOperation(Operation operation){
        if (currentOperation != null){
            if (runningNum != "") {
                rightValue = runningNum;
                runningNum = "";

                switch (currentOperation){
                    case add:
                      result = Long.parseLong(leftValue) + Long.parseLong(rightValue);
                        break;
                    case subtract:
                        result = Long.parseLong(leftValue) - Long.parseLong(rightValue);
                        break;
                    case multiply:
                        result = Long.parseLong(leftValue) * Long.parseLong(rightValue);
                        break;
                    case divide:
                        result = Long.parseLong(leftValue) / Long.parseLong(rightValue);
                        break;

                }

                leftValue = String.valueOf(result);
                resultsTxt.setText(leftValue);
            }
            currentOperation = operation;
        } else {
            leftValue = runningNum;
            runningNum = "";
        }

        currentOperation = operation;
    }

    void numberPressed(long number) {

        runningNum += String.valueOf(number);
        resultsTxt.setText(runningNum);

    }




}
