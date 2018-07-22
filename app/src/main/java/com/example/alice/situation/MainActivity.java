package com.example.alice.situation;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText password;
    private CheckBox show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = (EditText) findViewById(R.id.EtPassword);
        show = (CheckBox) findViewById(R.id.show);

        show.setOnClickListener(new OnClickListenerImp1());
    }

    private class OnClickListenerImp1 implements View.OnClickListener{
        @Override
        public void onClick(View v){
            if (MainActivity.this.show.isChecked()){
                MainActivity.this.password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }else{
                MainActivity.this.password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }
}