package com.example.soheb.webtest;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import org.xwalk.core.XWalkView;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        XWalkView xWalkView = (XWalkView) findViewById(R.id.webView);
        xWalkView.load("http://www.youtube.com", null);
    }

    public void launchURL(View view) {
        XWalkView xWalkView = (XWalkView) findViewById(R.id.webView);
        xWalkView.load(getFullUrl(), null);
        hideAndroidKeyboard(view);
    }

    private void hideAndroidKeyboard(View view) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @NonNull
    private String getFullUrl() {
        EditText url = (EditText) findViewById(R.id.URL);
        String fullUrl = url.getText().toString();
        if (!fullUrl.contains("://")) {
            fullUrl = "http://" + fullUrl;
        }
        return fullUrl;
    }
}
