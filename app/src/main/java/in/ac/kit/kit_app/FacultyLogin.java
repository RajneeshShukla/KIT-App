package in.ac.kit.kit_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FacultyLogin extends AppCompatActivity {
    private WebView webView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_login);


        webView2 = (WebView)findViewById(R.id.main_webview_facoulty1);
        WebSettings webSettings = webView2.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView2.loadUrl("https://erp.kit.ac.in/index.aspx?openFor=Faculty");
        webView2.setWebViewClient(new WebViewClient());
    }

    //this method call when back button is clicke dit goes to previous activity
    @Override
    public void onBackPressed() {
        if(webView2.canGoBack()){
            webView2.goBack();
        }else{
            super.onBackPressed();
        }}
    }

