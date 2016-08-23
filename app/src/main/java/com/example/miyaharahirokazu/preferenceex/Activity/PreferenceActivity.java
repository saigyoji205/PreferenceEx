package com.example.miyaharahirokazu.preferenceex.Activity;


import static com.example.miyaharahirokazu.preferenceex.Constants.FileConstants.*;
import static com.example.miyaharahirokazu.preferenceex.Constants.LayoutConstants.*;
import static com.example.miyaharahirokazu.preferenceex.Constants.FileName.*;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.io.File;


/**
 * Created by miyaharahirokazu on 16/08/23.
 */
public class PreferenceActivity extends BaseActivity implements View.OnClickListener{

    private EditText mEditText;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        //エディットテキストの生成
        mEditText =new EditText(this);
        mEditText.setText("");
        mEditText.setLayoutParams(new LinearLayout.LayoutParams(MP,WC));
        addViewToLayout(mEditText);

        addViewToLayout(makeButton("書き込み",TAG_WRITE));
        addViewToLayout(makeButton("読み込み",TAG_READ));

    }

    private View makeButton(String text, String tag) {
        Button button = new Button(this);
        button.setText(text);
        button.setTag(tag);
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));
        return button;
    }

    @Override
    protected void addViewToLayout(View v) {
        super.addViewToLayout(v);
    }

    @Override
    public void onClick(View v) {
        String tag = (String)v.getTag();
        //プレファレンスオブジェクトの取得
        SharedPreferences pref = getSharedPreferences(PREFERENCE_NAME,MODE_PRIVATE); //getSharedPreferences("ファイル名","モード") 1.PRIVATE:他のアプリからアクセス不可,2.WORLD_READABLE:他のアプリからの読み込み可能,3.WORLD_WRITEABLE:他のアプリからの書き込みが可能

        //プレファレンスへの書き込み
        if (TAG_WRITE.equals(tag)){
            SharedPreferences.Editor editor = pref.edit(); //書き込み準備
            editor.putString("text",mEditText.getText().toString());
            editor.commit();
        }
        //プレファレンスの読み込み
        else if (TAG_READ.equals(tag)){
            mEditText.setText(pref.getString("text",""));
        }

    }
}
