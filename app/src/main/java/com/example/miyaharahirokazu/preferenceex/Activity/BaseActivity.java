package com.example.miyaharahirokazu.preferenceex.Activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

/**
 * Created by miyaharahirokazu on 16/08/23.
 */
public class BaseActivity extends Activity {

    private LinearLayout mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //レイアウトの生成
        mLayout = new LinearLayout(this);
        mLayout.setBackgroundColor(Color.WHITE);
        mLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(mLayout);

    }

    protected void addViewToLayout(View v){
        mLayout.addView(v);
    }

}
