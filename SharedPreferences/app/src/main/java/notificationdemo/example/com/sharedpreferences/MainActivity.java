package notificationdemo.example.com.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    EditText message;
    SeekBar seekBar;
    float font_size;
    String font_color;
    String text_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        message=(EditText)findViewById(R.id.message);
        seekBar=(SeekBar)findViewById(R.id.seekBar);

        //to load the data if present prviousy
        SharedPreferences sharedPreferences=MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),MODE_PRIVATE);

        text_info=sharedPreferences.getString(getString(R.string.TEXT_INFO),"");
        font_color=sharedPreferences.getString(getString(R.string.FONT_COLOR),"");
        font_size=sharedPreferences.getFloat(getString(R.string.FONT_SIZE),25);

        message.setText(text_info);

        if(font_color.contains("GREEN")){
            message.setTextColor(Color.GREEN);

        }else if(font_color.contains("RED")){
            message.setTextColor(Color.RED);
        }else{
            message.setTextColor(Color.BLUE);
        }
        if(font_size==25){
            seekBar.setProgress(0);
        }else{
            seekBar.setProgress((int)font_size);
        }
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                message.setTextSize(TypedValue.COMPLEX_UNIT_DIP,progress);          //we set unit to dp+Complex_Unit_DIP to make it ind of system
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                font_size=seekBar.getProgress();
            }
        });

    }
    public void changeColor(View v){
        switch(v.getId()){
            case R.id.green:
                message.setTextColor(Color.GREEN);
                font_color="GREEN";
                break;
            case R.id.red:message.setTextColor(Color.RED);
                font_color="RED";
                break;
            case R.id.blue:
                font_color="BLUE";
                message.setTextColor(Color.BLUE);
                break;

        }
    }
    public void onSave(View v){
        //private mode
        //making an editor to put data init

        SharedPreferences sharedPreferences=MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putFloat(getString(R.string.FONT_SIZE),font_size);
        editor.putString(getString(R.string.FONT_COLOR),font_color);
        editor.putString(getString(R.string.TEXT_INFO),message.getText().toString());

        //to save this info to shared preference api
        editor.commit();
    }

    public void onClear(View v){
        SharedPreferences sharedPreferences=MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    //app share button
    public void onShare(View view){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Here is the share content body";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

}
