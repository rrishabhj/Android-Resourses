package rishabh.example.com.servicedemo1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Jindal on 7/1/2016.
 */
public class MyServices extends Service {

    final class MyThreadService implements Runnable{
        private int startId;
        MyThreadService(int startId){
            this.startId=startId;
        }

        @Override
        public void run() {
            synchronized (this  ){
                for(int i=0;i<10;i++){
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
            stopSelf(startId);

        }

    }
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"service is created",Toast.LENGTH_SHORT).show();
        Log.i("tag","service is started");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("tag","service is running...");

            Thread thread=new Thread(new MyThreadService(startId));
        thread.start();
            /* this will cause the main thread to wait for quite a bit
            it will hang your app and will be not responding
         */
        /*
        synchronized (this  ){
            for(int i=0;i<10;i++){
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }*/

        Toast.makeText(this,"service is running",Toast.LENGTH_SHORT).show();
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"service is stopped",Toast.LENGTH_SHORT).show();
        Log.i("tag","service is destroyed");


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
