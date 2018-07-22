package com.example.alice.situation;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private Button change;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        change = (Button) findViewById(R.id.btnChang);
        img = (ImageView) findViewById(R.id.img);

        change.setOnClickListener(new myOnClickListenerImp1());
    }

    private class myOnClickListenerImp1 implements View.OnClickListener{
        @Override
        public void onClick(View v){
            if (MainActivity.this.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED){
                MainActivity.this.change.setText("错误！无法改变屏幕方向。");
            }else if (MainActivity.this.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
                MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }else if (MainActivity.this.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
                MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            MainActivity.this.img.setImageResource(R.drawable.bg);
            MainActivity.this.change.setText("改变当前横屏为竖屏显示");
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            MainActivity.this.img.setImageResource(R.drawable.bg2);
            MainActivity.this.change.setText("改变当前竖屏为横屏显示");
        }
        super.onConfigurationChanged(newConfig);
    }
}