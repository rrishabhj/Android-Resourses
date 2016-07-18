package rishabh.example.com.jsonarraydemo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Jindal on 7/11/2016.
 */
public class MySingleton {
    private RequestQueue requestQueue;
    private static  MySingleton mInstance;
    private static Context context;

    MySingleton(Context con){
        context=con;
        requestQueue=getRequestQue();

    }
    public RequestQueue getRequestQue(){
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized  MySingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MySingleton(context);
        }
        return mInstance;
    }
    public<T> void addToRequestQue(Request<T> request)
    {
        requestQueue.add(request);
    }

}
