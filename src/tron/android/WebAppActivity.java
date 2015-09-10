package tron.android;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
//import android.widget.LinearLayout;

public class WebAppActivity extends Activity {

    public static boolean DEV = true; //TODO

    private static final String TAG = "tron";

    public static final void trace( String str ) {
        android.util.Log.d( TAG, str );
    }

    ////////////////////////////////////////////////////////////////////////////

    //protected AppLayout layout;
    protected WebView webview;
    protected SystemUi systemUi;

    ////////////////////////////////////////////////////////////////////////////

    /**
    */
    protected void init( int webviewId, String indexFile ) {

        //webview = new WebView( WebAppActivity.this );
        webview = (WebView) findViewById( webviewId );
        //webview.setInitialScale( 100 );
        //webview.setBackgroundColor(Color.BLACK);
        webview.clearCache(true);
    //    webview.setLayoutParams( new LinearLayout.LayoutParams( ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT, 1.0F ) );
        //webview.setWebViewClient( new WebAppClient() );
        //webview.setWebChromeClient( new WebAppChromeClient() );
        createWebViewClient();
        createWebChromeClient();

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        //settings.setAllowUniversalAccessFromFileURLs(true);
        //settings.setDomStorageEnabled(true);
        //settings.setLoadWithOverviewMode(true);
        //settings.setUseWideViewPort(true);
        //settings.setAppCacheEnabled(true);
        //settings.setAppCacheMaxSize( appCacheMaxSize );
        //settings.setAppCachePath( appCachePath );
        //settings.setJavaScriptCanOpenWindowsAutomatically(true);
        //settings.setSupportMultipleWindows(true);

        /*
        Display display = getWindowManager().getDefaultDisplay();
        final int displayWidth = display.getWidth();
		final int displayHeight = display.getHeight();

        AppLayout layout = new AppLayout( this, displayWidth, displayHeight );
        layout.setLayoutParams(new LinearLayout.LayoutParams( ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT, 0.0F));
        layout.addView( webview );
        setContentView( layout );
        */

        bindJavascriptInterfaces();
        loadFile( indexFile );
    }

    protected void bindJavascriptInterfaces() {

        addJavascriptInterface( new tron.android.Log(), "Log" );

        systemUi = new SystemUi(this);
        addJavascriptInterface( systemUi, "SystemUi" );

        //addJavascriptInterface( new tron.android.Toast(this), "Toast" );
        //addJavascriptInterface( new tron.android.Network(this), "Network" );

        //tron.android.Tts tts = new tron.android.Tts(this);
        //addJavascriptInterface( tts, "Tts" );
    }

    protected void addJavascriptInterface( Object obj, String id ) {
        webview.addJavascriptInterface( obj, "troid_" + id );
    }

    protected void loadFile( String path ) {
		webview.loadUrl( "file:///android_asset/" + path );
	}

    public void callJavascript( String script ) {
        // instance.runOnUiThread(new Messenger(instance.view, s));
        //instance.handler.post(new JavascriptMessenger(instance.webview, str));
        webview.loadUrl( "javascript:" + script );
    }

    protected void createWebViewClient() {
        webview.setWebViewClient( new WebAppClient() );
    }

    protected void createWebChromeClient() {
        webview.setWebChromeClient( new WebChromeClient() );
    }

    ////////////////////////////////////////////////////////////////////////////

    @Override
    public void onResume() {
        super.onResume();
        if( systemUi != null )
            systemUi.apply();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if( keyCode == KeyEvent.KEYCODE_BACK ) {
            if( webview.canGoBack() ) {
                webview.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    ////////////////////////////////////////////////////////////////////////////

    /*
    private class AppLayout extends LinearLayout {

        private int screenWidth = 0;
		private int screenHeight = 0;

        public AppLayout( Context ctx, int width, int height ) {
            super( ctx );
			screenWidth = width;
			screenHeight = height;
        }
    }
    */
}
