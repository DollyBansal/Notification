package com.dolly.notification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.Toast;

public class NotificationReceiverActivity extends AppCompatActivity {

    private WebView webView;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onNewIntent(getIntent());
    }

    private void initializeWebView(String url) {
        webView = findViewById(R.id.web_view);
        webView.loadUrl(url);
    }


    @Override
    public void onNewIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.containsKey("imageUri")) {
                setContentView(R.layout.layout);
                // extract the extra-data in the Notification
                //  String value = extras.getString("imageUri");

                String value = extras.getString("imageUri");

                System.out.println("extras = " + value);
                String url = "https://" + value;

                if (URLUtil.isValidUrl(url)) {
                    initializeWebView(url);
                } else {
                    // enter valid URL
                    Toast.makeText(getApplicationContext(), "not VALID URL", Toast.LENGTH_LONG).show();

                }

            }
        }


    }
}
