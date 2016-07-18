package rishabh.example.com.experiment1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Jindal on 6/30/2016.
 */
public class ScreenReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case Intent.ACTION_SCREEN_OFF:
                BaseActivity.unlockScreen();
                break;

            case Intent.ACTION_SCREEN_ON:
                // and do whatever you need to do here
                BaseActivity.clearScreen();
        }
    }

}
