package tron.android;

import android.content.Context;
import android.webkit.JavascriptInterface;

//import java.util.ArrayList;
//import java.util.Iterator;

public class SystemUi {

    private WebAppActivity activity;

    //private boolean navigationControlsVisible = true;
    //private int currentFlag = 0;
    private int flag = 0;
    //private ArrayList<Integer> flags = new ArrayList<Integer>();

    public SystemUi( WebAppActivity a ) {
        activity = a;
    }

    public final void apply() {
        applySystemUiVisibility( this.flag );
    }

    ////////////////////////////////////////////////////////////////////////////

    @JavascriptInterface
    public final void setFlag( int flag ) {
        this.flag = flag;
        applySystemUiVisibility( this.flag );
    }

    /*
    @JavascriptInterface
    public final void addFlag( int flag ) {
        this.flags.add( flag );
    }

    @JavascriptInterface
    public final void removeFlag( int flag ) {
    }

    @JavascriptInterface
    public final void apply() {
        applySystemUiVisibility();
    }
    */

    /*
    @JavascriptInterface
    public final void showNavigationControls() {
        navigationControlsVisible = true;
        applySystemUiVisibility();
    }

    @JavascriptInterface
    public final void hideNavigationControls() {
        navigationControlsVisible = false;
        applySystemUiVisibility();
    }
    */

    ////////////////////////////////////////////////////////////////////////////

    /*
    private int getSystemUiVisibilityFlag() {
       //int flag = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
       int flag = 0;
       if( !navigationControlsVisible ) flag |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
       return flag;
    }

    private void applySystemUiVisibility() {
        applySystemUiVisibility( getSystemUiVisibilityFlag() );
    }
    */

    /*
    private int getFlag() {
        int _flag;
        if( flag == 0 )
            _flag = flag;
        else {
            _flag = 0;
            for( Iterator<Integer> iter = flags.iterator(); iter.hasNext(); ) {
                int i = iter.next();
                WebAppActivity.trace( "NNNNN "+i);
                _flag |= i;
            }
        }
        return _flag;
    }
    */

    private void applySystemUiVisibility( final int flag ) {
        //final int flag = getFlag();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.getWindow().getDecorView().setSystemUiVisibility( flag );
            }
        });
    }

}
