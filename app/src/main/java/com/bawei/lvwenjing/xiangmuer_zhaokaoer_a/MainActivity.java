package com.bawei.lvwenjing.xiangmuer_zhaokaoer_a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText ed2;
    boolean b = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText ed1 = (EditText) findViewById(R.id.et1);
        ed2 = (EditText) findViewById(R.id.et2);
        CheckBox cb = (CheckBox) findViewById(R.id.cb3);
        CheckBox cb1 = (CheckBox) findViewById(R.id.cb1);
        Button bt = (Button) findViewById(R.id.bt1);
        SpannableString spannableString = new SpannableString("我已阅读并且同意服务条款");
        spannableString.setSpan(new ForegroundColorSpan(Color.BLUE), 8, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        cb.setText(spannableString);
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    b = true;
                } else {
                    b = false;
                }
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, TiaoActivity.class);

                if (TextUtils.isEmpty(ed1.getText()) || TextUtils.isEmpty(ed2.getText())) {
                    Toast.makeText(MainActivity.this, "用户名或密码为空", Toast.LENGTH_SHORT).show();
                }else {
                    intent.putExtra("password", "您的用户名：" + ed1.getText());
                    intent.putExtra("name", "您的用户密码：" + ed2.getText());
                    if (b == false) {
                        intent.putExtra("cb", false);
                    } else {
                        intent.putExtra("cb", true);
                    }
                    startActivity(intent);
                }

            }
        });
    }
}
