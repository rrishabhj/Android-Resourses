package rishabh.example.com.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Jindal on 7/1/2016.
 */
public class MyService extends IntentService {

    public MyService() {
        super("MyThread");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"service started..",Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"service running..",Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"service destroyed..",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this  ){
            for(int i=0;i<10;i++){
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }

    }
}
