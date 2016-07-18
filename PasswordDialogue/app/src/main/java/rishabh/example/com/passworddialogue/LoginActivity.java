package rishabh.example.com.passworddialogue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText=(EditText)findViewById(R.id.editText);
        textView=(TextView)findViewById(R.id.textView2);
    }



    public void startMain(View v){
        password=editText.getText().toString();
        SharedPreferences sharedPreferences=((DataProvider)getApplicationContext()).getSharedPreferences("MY_LOGIN",MODE_PRIVATE);

        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("MY_PASSW",password);
        editor.commit();
        //SharedPreferences sharedPreference=LoginActivity.this.getSharedPreferences("MY_LOGIN",MODE_PRIVATE);

        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    public void showPre(View v){
        SharedPreferences sharedPreferences=((DataProvider)getApplicationContext()).getSharedPreferences("MY_LOGIN",MODE_PRIVATE);
        textView.setText(sharedPreferences.getString("MY_PASSW","naao"));
    }

}
