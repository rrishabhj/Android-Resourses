package g2.sound;

import android.app.Dialog;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    AudioManager am;
    MediaPlayer music;
    Vibrator vibrater;
    Boolean status=false;
    private String m_Text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Dialog dialog= new Dialog(this);
       //dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR);

        dialog.setContentView(R.layout.popup_for_share);  //design your own layout for Dialog
        dialog.setCancelable(false);
        Button b1 = (Button) dialog.findViewById(R.id.button4);
        final EditText input = (EditText) dialog.findViewById(R.id.input);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set some codes
                if(input.getText().toString().equals("choni")){
                    dialog.hide();
                    status=true;
                }else{
                    status=false;
                }
            }
        });

        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog.show();



        music=new MediaPlayer();
        vibrater = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        m_Text=new String();


    }

    public  void promptPass(View view){


    }
    public void playMusic(View view){
        am =(AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //for switching to normal mode
        if(am.getRingerMode()==AudioManager.RINGER_MODE_SILENT) {
            am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        }

        //to raising the volume to peak;
            am.setStreamVolume(
                    AudioManager.STREAM_MUSIC,
                    am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                    0);
            music = MediaPlayer.create(this, R.raw.screem_sound);

            music.start();
        // Start without a delay
        // Vibrate for 1000 milliseconds
        // Sleep for 100 milliseconds
        long[] pattern = {0, 1000, 100};

        // The '0' here means to repeat indefinitely
        // '0' is actually the index at which the pattern keeps repeating from (the start)
        // To repeat the pattern from any other point, you could increase the index, e.g. '1'
        vibrater.vibrate(pattern, 0);
            music.setLooping(true);

    }
    public void stopMusic(View view){
        music.stop();
        vibrater.cancel();
    }

}
