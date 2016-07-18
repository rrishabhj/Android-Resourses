package rishabh.example.com.fileexternalstorage;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
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
        textView=(TextView)findViewById(R.id.textView2);
    }

    public void writeMessage(View v){

        String state= Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){

            File root=Environment.getExternalStorageDirectory();
            File dir=new File(root.getAbsolutePath()+"/myappfile");

            if(!dir.exists()){
                dir.mkdir();

            }
            File file=new File(dir,"mymessage.txt");
            Toast.makeText(this,"successfull dir!",Toast.LENGTH_SHORT).show();
            String message=editText.getText().toString();
            try {
                FileOutputStream fos=new FileOutputStream(file);

                fos.write(message.getBytes());
                fos.close();
                Toast.makeText(this,"successfull write!",Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            Toast.makeText(this,"less external storage!",Toast.LENGTH_SHORT).show();
        }

    }
    public void readMessage(View v){
        File root=Environment.getExternalStorageDirectory();
        File dir=new File(root.getAbsolutePath()+"/myappfile");
        File file=new File(dir,"mymessage.txt");
        String message;
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader isr=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(isr);
            StringBuffer stringBuffer=new StringBuffer();

            while((message=bufferedReader.readLine())!=null){
                stringBuffer.append(message+ "\n");
            }
            textView.setText(stringBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
