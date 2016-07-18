package rishabh.example.com.servicebound;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Jindal on 7/1/2016.
 */
public class MyService extends Service {

    IBinder iBinder=new LocalData();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public class LocalData extends Binder{

        MyService getService(){
            return MyService.this;

        }


    }
    public String getFirstMessage(){
        return "first message";

    }
    public String getSecondMessage(){
        return  "Second message";
    }
}
