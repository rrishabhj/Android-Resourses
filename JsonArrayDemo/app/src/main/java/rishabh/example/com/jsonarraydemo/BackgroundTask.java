package rishabh.example.com.jsonarraydemo;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Jindal on 7/13/2016.
 */
public class BackgroundTask {
    Context context;
    ArrayList<Contact> list=new ArrayList<>();
    String json_url="http://api.openweathermap.org/data/2.5/forecast?q=Delhi,in&mode=json&units=metric&cnt=7&appid=b27b184496375e6d0831bb2dad6c5a3a";

    public BackgroundTask(Context context) {
        this.context = context;
    }

    public ArrayList<Contact> getList(){

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, json_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    int dayIndex=0;
                    JSONArray days=response.getJSONArray("list");

                    JSONObject dayinfo=days.getJSONObject(dayIndex);
                    Log.i("tag",dayinfo.toString());
                    JSONObject temperatureInfo=dayinfo.getJSONObject("main");
                    Log.i("tag",temperatureInfo.toString());
                    Log.i("tag",Double.toString(temperatureInfo.getDouble("temp_max")));
                    Contact cont=new Contact(Double.toString(temperatureInfo.getDouble("temp_max")),"kuch bhi");
                    list.add(cont);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();
                Toast.makeText(context,"error loading database",Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton.getInstance(context).addToRequestQue(jsonObjectRequest);


        return list;

        /*
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(json_url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int count=0;
                int dayIndex=0;
                while(count<response.length()){
                    try {
                        JSONObject jsonObject=response.getJSONObject(count);
                        JSONArray days=jsonObject.getJSONArray("list");
                        response.get
                        JSONObject dayinfo=days.getJSONObject(dayIndex);
                        JSONObject temperatureInfo=dayinfo.getJSONObject("main");
                        Contact contact=new Contact(Double.toString(temperatureInfo.getDouble("temp_max")),"kuch bhi");
                        list.add(contact);
                        count++;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"error...",Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });
        MySingleton.getInstance(context).addToRequestQue(jsonArrayRequest);
        return list;
        */

    }

}
