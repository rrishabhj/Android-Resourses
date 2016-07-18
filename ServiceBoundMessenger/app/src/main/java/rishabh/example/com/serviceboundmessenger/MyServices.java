package rishabh.example.com.serviceboundmessenger;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Jindal on 7/1/2016.
 */
public class MyServices extends Service {

    Messenger messenger=new Messenger(new DataHandler());
    public final static int JOB_1=1;
    public final static int JOB_2=2;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }
    class DataHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case JOB_1:
                    Toast.makeText(MyServices.this,"hello from job 1",Toast.LENGTH_SHORT).show();
                    break;
                case JOB_2:
                    Toast.makeText(MyServices.this,"hello from job 1",Toast.LENGTH_SHORT).show();
                    break;
                default: super.handleMessage(msg);

            }

        }
    }
}
