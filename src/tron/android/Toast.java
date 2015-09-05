package tron.android;

import android.content.Context;
import android.webkit.JavascriptInterface;

public final class Toast {

    private Context ctx;

    public Toast( Context c ) {
        ctx = c;
    }

    @JavascriptInterface
    public final void show( String msg ) {
        android.widget.Toast.makeText( ctx, msg, android.widget.Toast.LENGTH_SHORT ).show();
    }

}
