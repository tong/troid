package tron.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.webkit.JavascriptInterface;

public class Network {

    private ConnectivityManager cm;

    public Network( Context ctx ) {
        this.cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @JavascriptInterface
    public boolean isAvailable() {
		android.net.NetworkInfo info = cm.getActiveNetworkInfo();
		if( info != null )
			return info.isConnected();
		return false;
	}

    @JavascriptInterface
    public boolean isWifiActive() {
		android.net.NetworkInfo info = cm.getActiveNetworkInfo();
		if( info != null )
			return info.getTypeName().equals( "WIFI" );
		return false;
	}




}
