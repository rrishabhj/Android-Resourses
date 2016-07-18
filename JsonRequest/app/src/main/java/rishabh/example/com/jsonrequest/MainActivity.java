package rishabh.example.com.jsonrequest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView name,email,mobile;
    Button button;
    String server_url="http://api.openweathermap.org/data/2.5/forecast?q=Delhi,in&mode=json&units=metric&cnt=7&appid=b27b184496375e6d0831bb2dad6c5a3a";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(TextView)findViewById(R.id.name_txt);
        email=(TextView)findViewById(R.id.email_txt);
        mobile=(TextView)findViewById(R.id.mobile_txt);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, server_url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            name.setText(response.getString("temp_min"));
                            //email.setText(response.getString("Email"));
                           // mobile.setText(response.getString("Mobile"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();
                        Toast.makeText(getApplicationContext(),"error loading database",Toast.LENGTH_SHORT).show();
                    }
                });
                MySingleton.getInstance(getApplicationContext()).addToRequestQue(jsonObjectRequest);
            }
        });
    }
}
