package rishabh.example.com.volleyexample2;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    String server_url="http://php.net/manual/en/features.commandline.webserver.php";
    String image_server_url="http://i.imgur.com/7spzG.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView) findViewById(R.id.imageView);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageRequest request = new ImageRequest(image_server_url,
                        new Response.Listener<Bitmap>() {
                            @Override
                            public void onResponse(Bitmap bitmap) {
                                imageView.setImageBitmap(bitmap);
                            }
                        }, 0, 0, null,
                        new Response.ErrorListener() {
                            public void onErrorResponse(VolleyError error) {
                               // imageView.setImageResource(R.drawable.image_load_error);
                                Toast.makeText(getApplicationContext(),"error loading image",Toast.LENGTH_SHORT).show();

                                Log.i("tag",""+error.getMessage());
                            }
                        });
                    MySingleton.getInstance(getApplicationContext()).addToRequestQue(request);
                /*
                for string request we use StringRequest which can be done as here

                StringRequest stringRequest=new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("errorr.....");
                    }
                });
                MySingleton.getInstance(getApplicationContext()).addToRequestQue(stringRequest);

            */
            }
        });
    }
}
