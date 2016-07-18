package rishabh.example.com.instadict2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Jindal on 6/28/2016.
 */
public class DialogService extends Service {
    public DialogService() {
    }


    @Override
    public void onCreate() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        super.onCreate();
        Intent i1=new Intent(this,MeaningDialogActivity.class);
        i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i1);
        stopSelf();



        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        throw new UnsupportedOperationException("Not yet implemented");
    }

}
