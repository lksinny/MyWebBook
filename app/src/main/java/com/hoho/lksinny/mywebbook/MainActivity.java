package com.hoho.lksinny.mywebbook;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

  WebView webViewMain;
  Button buttonTitle, button1, button2, button3;
  View.OnClickListener cListener;

  @Override
  public void onBackPressed() {
    //super.onBackPressed();
    if(webViewMain.canGoBack()){
      webViewMain.goBack();
    } else {
      finish();
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    webViewMain = (WebView)findViewById(R.id.webViewMain);
    buttonTitle = (Button)findViewById(R.id.buttonTitle);
    button1 = (Button)findViewById(R.id.button1);
    button2 = (Button)findViewById(R.id.button2);
    button3 = (Button)findViewById(R.id.button3);

    cListener = new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //TODO Auto-generated method stub
        switch (v.getId()) {
          case R.id.buttonTitle:
            buttonTitleClick();
            break;
          case R.id.button1:
            button1Click();
            break;
          case R.id.button2:
            button2Click();
            break;
          case R.id.button3:
            button3Click();
            break;
          default:
            break;
        }
      }
    };

    buttonTitle.setOnClickListener(cListener);
    button1.setOnClickListener(cListener);
    button2.setOnClickListener(cListener);
    button3.setOnClickListener(cListener);

    WebSettings webSettings = webViewMain.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setBuiltInZoomControls(true);
    webSettings.setDisplayZoomControls(false);

    webViewMain.setWebViewClient(new WebViewClient() {

    });

    webViewMain.setWebChromeClient(new WebChromeClient() {

    });

    webViewMain.loadUrl("http://m.clien.net/cs3/");
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  void buttonTitleClick(){}

  void button1Click(){}

  void button2Click(){}

  void button3Click(){}

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
