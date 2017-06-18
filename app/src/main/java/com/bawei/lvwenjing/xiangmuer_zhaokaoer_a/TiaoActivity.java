package com.bawei.lvwenjing.xiangmuer_zhaokaoer_a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TiaoActivity extends Activity {

    private TextView tv3;
    private SpannableString span;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiao);
        span = new SpannableString("查看是否记住密码");
        span.setSpan(new BackgroundColorSpan(Color.BLUE), 0, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        Intent intent = getIntent();
        String password = intent.getStringExtra("password");
        String name = intent.getStringExtra("name");
        final boolean cb = intent.getBooleanExtra("cb", false);

        TextView tv1 = (TextView) findViewById(R.id.ttv1);
        TextView tv2 = (TextView) findViewById(R.id.ttv2);
        tv3 = (TextView) findViewById(R.id.ttv3);
        tv2.setText(password);
        tv1.setText(name);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv3.setText(span);
                if (cb == false) {
                    //吐司位置的设置
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "您选择的是未记住密码", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                } else {
                    //吐司位置的设置
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "您选择的是记住密码", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

            }
        });

    }
}
