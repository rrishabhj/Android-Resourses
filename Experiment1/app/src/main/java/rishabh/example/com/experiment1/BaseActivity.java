package rishabh.example.com.experiment1;

import android.app.Activity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Jindal on 6/30/2016.
 */
public class BaseActivity extends Activity {
    public static void unlockScreen () {
        if (current == null) return;

        Log.i( "TAG", "Turning on screen ... " );

        Window window = current.getWindow();
        window.addFlags( WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD );
        window.addFlags( WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED );
        window.addFlags( WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON   );
    }
    public static void clearScreen () {
        if (current == null) return;

        Log.i( "TAG", "Clearing screen flag when on ... " );

        Window window = current.getWindow();
        window.clearFlags( WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD );
        window.clearFlags( WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED );
        window.clearFlags( WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON   );
    }
    private static BaseActivity current;

    @Override
    protected void onResume () {
        current = this;
    }
}
