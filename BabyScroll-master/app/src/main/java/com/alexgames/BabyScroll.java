package com.alexgames;

import android.app.ListActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;

public class BabyScroll extends ListActivity implements TextToSpeech.OnInitListener {
    TextToSpeech talker;
    MediaPlayer player,p2;

    private Toast currentToast;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currentToast = new Toast(getApplicationContext());
        currentToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        currentToast.setDuration(Toast.LENGTH_LONG);

        GoFullScreen();

        talker = new TextToSpeech(this, this);

        BabyScrollItemBuilder itemBuilder = new BabyScrollItemBuilder();

        ArrayList<BabyScrollItem> items = itemBuilder.GetAlphabetItems();

        CircularArrayAdapter<BabyScrollItem> adapter = new CircularArrayAdapter<BabyScrollItem>(this, R.layout.list_item, items);
        setListAdapter(adapter);

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);

        lv.setSelectionFromTop(adapter.MIDDLE, 0);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                View textView = view.findViewById(R.id.txtItem);

                LayoutInflater inflater = getLayoutInflater();

                View toastLayout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));

                TextView toastText = (TextView) toastLayout.findViewById(R.id.text);

                CharSequence charsToShow = ((TextView) textView).getText();
                toastText.setText(charsToShow);

                ImageView imageView = (ImageView) view.findViewById(R.id.imgItem);

                ImageView image = (ImageView) toastLayout.findViewById(R.id.image);
                image.setImageDrawable(imageView.getDrawable());

                toastText.setText(GetTalkText(charsToShow.toString()));

                currentToast.cancel();
                currentToast.setView(toastLayout);
                currentToast.show();

                TalkItem(view);
            }
        });

        InitializeMediaPlayer();
    }

    private void GoFullScreen() {
        final Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void onResume() {
        super.onResume();

        if (player == null) {
            InitializeMediaPlayer();
        } else {
            player.start();
        }
    }

    private void InitializeMediaPlayer() {
        player = MediaPlayer.create(this, R.raw.kidsmusic);
        player.setLooping(true);
        player.setVolume(0.2f, 0.2f);
        player.start();
    }

    private void ShutDownPlayer() {
        if (player != null) {
            if (player.isPlaying())
                player.stop();

            player.reset();
            player.release();
            player = null;
        }
    }

    public void onPause() {
        super.onPause();
        ShutDownPlayer();
    }

    private void TalkItem(View view) {
        View textView = view.findViewById(R.id.txtItem);
        String viewText = ((TextView) textView).getText().toString();
        player.stop();

        /*
        if (viewText.equals("A")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("B")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("C")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("D")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("E")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("F")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("G")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("H")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("I")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("J")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("K")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("L")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("M")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("N")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("O")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("P")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("Q")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("R")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("S")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("T")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("U")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("V")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("W")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("X")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("Y")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        } else if (viewText.equals("Z")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
        }
        p2.start();*/
         if(viewText.equals("A")) {
            p2 = MediaPlayer.create(this, R.raw.m1);
            p2.start();
        }
        //talker.speak(viewText + " " + GetTalkText(viewText), TextToSpeech.QUEUE_FLUSH, null);
    }

    private String GetTalkText(String viewText) {
        String result = "";

        if (viewText.equals("A")) {
            result = "Apple";
        } else if (viewText.equals("B")) {
            result = "Ball";
        } else if (viewText.equals("C")) {
            result = "Car";
        } else if (viewText.equals("D")) {
            result = "Doggy";
        } else if (viewText.equals("E")) {
            result = "Elephant";
        } else if (viewText.equals("F")) {
            result = "Fire Truck";
        } else if (viewText.equals("G")) {
            result = "Grapes";
        } else if (viewText.equals("H")) {
            result = "Hamster";
        } else if (viewText.equals("I")) {
            result = "Ice cream";
        } else if (viewText.equals("J")) {
            result = "Jungle";
        } else if (viewText.equals("K")) {
            result = "Koala";
        } else if (viewText.equals("L")) {
            result = "Love";
        } else if (viewText.equals("M")) {
            result = "Mermaid";
        } else if (viewText.equals("N")) {
            result = "Noodles";
        } else if (viewText.equals("O")) {
            result = "Octopus";
        } else if (viewText.equals("P")) {
            result = "Penguin";
        } else if (viewText.equals("Q")) {
            result = "Question Mark";
        } else if (viewText.equals("R")) {
            result = "Rocket";
        } else if (viewText.equals("S")) {
            result = "Snake";
        } else if (viewText.equals("T")) {
            result = "Tiger";
        } else if (viewText.equals("U")) {
            result = "Umbrella";
        } else if (viewText.equals("V")) {
            result = "Van";
        } else if (viewText.equals("W")) {
            result = "Walrus";
        } else if (viewText.equals("X")) {
            result = "Xylophone";
        } else if (viewText.equals("Y")) {
            result = "Yellow";
        } else if (viewText.equals("Z")) {
            result = "Zebra";
        }

        return result;
    }

    public void onInit(int status) {
    }

    @Override
    public void onDestroy() {

        if (currentToast != null) {
            currentToast.cancel();
        }

        if (talker != null) {
            talker.stop();
            talker.shutdown();
        }
        ShutDownPlayer();

        super.onDestroy();
    }
}
