package tron.android;

import android.webkit.JavascriptInterface;

public final class Log {

    private static final String TAG = "tron";

    public Log() {}

    @JavascriptInterface
    public final void debug(String str) {
        android.util.Log.d( TAG, str );
    }

    @JavascriptInterface
    public final void error(String str) {
        android.util.Log.e( TAG, str );
    }

    @JavascriptInterface
    public final void info(String str) {
        android.util.Log.i( TAG, str );
    }

    @JavascriptInterface
    public final void verbose(String str) {
        android.util.Log.v( TAG, str );
    }

    @JavascriptInterface
    public final void warn(String str) {
        android.util.Log.w( TAG, str );
    }

    @JavascriptInterface
    public final void wtf(String str) {
        android.util.Log.wtf( TAG, str );
    }

}
