package rishabh.example.com.fileinternalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        textView=(TextView)findViewById(R.id.text);

        textView.setVisibility(View.GONE);

    }
    public void writeMessage(View v){


        try {
            String message=editText.getText().toString();
            FileOutputStream fileOutputStream= openFileOutput("test",MODE_PRIVATE);
            fileOutputStream.write(message.getBytes());
            fileOutputStream.close();

            editText.setText("");
            Toast.makeText(this,"message saved",Toast.LENGTH_SHORT);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void readMessage(View v){

        try {
            String message;
            FileInputStream fileInputStream=openFileInput("test");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer=new StringBuffer();
            while((message=bufferedReader.readLine())!=null){
                stringBuffer.append(message);
            }

            textView.setText(stringBuffer);
            textView.setVisibility(View.VISIBLE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
