package com.example.alice.situation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText edit;
    private Button btn;
    private TextView showView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText) findViewById(R.id.myed);
        btn = (Button) findViewById(R.id.mybtn);
        showView = (TextView) findViewById(R.id.mytext);
        btn.setOnClickListener(new ShowListener());
    }

    private class ShowListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            String info = MainActivity.this.edit.getText().toString();
            MainActivity.this.showView.setText("输入的内容是："+info);
        }
    }
}
