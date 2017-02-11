package com.palmintelligence.administrator.jlictv001;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/8/9 0009.
 */
public class LoginActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private EditText accountEdit;
    private EditText pwdEdit;
    private Button login_button,back_button;
    private CheckBox rememberpass;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);




















        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit=(EditText)findViewById(R.id.account);
        pwdEdit=(EditText)findViewById(R.id.pwd);
        login_button=(Button)findViewById(R.id.login);
        back_button=(Button)findViewById(R.id.quit);
        rememberpass=(CheckBox)findViewById(R.id.remember_pass);
        TableLayout view=(TableLayout)findViewById(R.id.login_Tablelayout);
        //设置背景透明度。
        view.getBackground().setAlpha(90);
        //设置SharedPreferences。
        boolean isRemember=preferences.getBoolean("remember_password",false);
        if(isRemember){
            //将帐号密码设置到文本框中,读取SharedPreferences数据
            String account=preferences.getString("account","");
            String pwd=preferences.getString("password","");
            accountEdit.setText(account);
            pwdEdit.setText(pwd);
            rememberpass.setChecked(true);
        }
        //登录界面操作
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account=accountEdit.getText().toString();
                String password=pwdEdit.getText().toString();
                if (account.equals("1410912219")&&password.equals("1410912219")){
                    editor=preferences.edit();
                    if (rememberpass.isChecked()){
                        //复选框被选中
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                }else {
                        editor.clear();
                    }
                     editor.commit();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                   // intent.putExtra("account",account);
                    startActivity(intent);
                    finish();
                    }else {
                    Toast.makeText(LoginActivity.this,"帐号或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
