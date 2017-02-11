package com.palmintelligence.administrator.jlictv001;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Administrator on 2016/7/28 0028.
 */
public class SplashActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Handler x = new Handler();
        x.postDelayed(new splashhandler(), 2000);

    }
    class splashhandler implements Runnable{

        public void run() {
            startActivity(new Intent(getApplication(),MainActivity.class));
            SplashActivity.this.finish();
        }

    }
}
