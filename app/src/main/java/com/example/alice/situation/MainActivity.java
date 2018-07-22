package com.example.alice.situation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView showView;
    private TextView note;
    private EditText editNum1;
    private EditText editNum2;
    private Button btnAdd;
    private Button btnSub;
    private Button btnMul;
    private Button btnDiv;
    private int num1 = 0;
    private int num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showView = (TextView) findViewById(R.id.tvResult);
        note = (TextView) findViewById(R.id.op);
        editNum1 = (EditText) findViewById(R.id.etNum1);
        editNum2 = (EditText) findViewById(R.id.etNum2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        btnAdd.setOnClickListener(new AddListener());
        btnSub.setOnClickListener(new AddListener());
        btnMul.setOnClickListener(new AddListener());
        btnDiv.setOnClickListener(new AddListener());

        editNum1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MainActivity.this.editNum1.setText("");
            }
        });

        editNum2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MainActivity.this.editNum2.setText("");
            }
        });
    }

    private class AddListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            MainActivity.this.num1 = Integer.parseInt(MainActivity.this.editNum1.getText().toString());
            MainActivity.this.num2 = Integer.parseInt(MainActivity.this.editNum2.getText().toString());
            MainActivity.this.note.setText("+");
            MainActivity.this.showView.setText(String.valueOf(num1+num2));
        }
    }

    private class DivListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            MainActivity.this.num1 = Integer.parseInt(MainActivity.this.editNum1.getText().toString());
            MainActivity.this.num2 = Integer.parseInt(MainActivity.this.editNum2.getText().toString());
            MainActivity.this.note.setText("除号");
            MainActivity.this.showView.setText(String.valueOf(num1/num2));
        }
    }

    private class SubListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            MainActivity.this.num1 = Integer.parseInt(MainActivity.this.editNum1.getText().toString());
            MainActivity.this.num2 = Integer.parseInt(MainActivity.this.editNum2.getText().toString());
            MainActivity.this.note.setText("-");
            MainActivity.this.showView.setText(String.valueOf(num1-num2));
        }
    }

    private class MulListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            MainActivity.this.num1 = Integer.parseInt(MainActivity.this.editNum1.getText().toString());
            MainActivity.this.num2 = Integer.parseInt(MainActivity.this.editNum2.getText().toString());
            MainActivity.this.note.setText("×");
            MainActivity.this.showView.setText(String.valueOf(num1*num2));
        }
    }
}
