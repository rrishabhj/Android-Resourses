package rishabh.example.com.passworddialogue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyPreferences myPreferences;
    String password;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView);
        // showDialog();
        myPreferences = new MyPreferences();
        if (MyPreferences.isFirst(this)) {
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
        }
        SharedPreferences sharedPreferences=((DataProvider)getApplicationContext()).getSharedPreferences("MY_LOGIN",MODE_PRIVATE);
        password=sharedPreferences.getString("MY_PASSW","not working");
        textView.setText(password);
    }
}

