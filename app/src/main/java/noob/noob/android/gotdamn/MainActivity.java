package noob.noob.android.gotdamn;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Random;
import android.media.MediaPlayer;
import android.view.View.OnClickListener;

import com.emilio.noob.R;


public class MainActivity extends AppCompatActivity {
    private static Random rgenerator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playNoobNoobSound = (Button) this.findViewById(R.id.button);

        final MediaPlayer gd1 = MediaPlayer.create(this, R.raw.gotdamn1);
        final MediaPlayer gd2 = MediaPlayer.create(this, R.raw.gotdamn2);
        final MediaPlayer gd3 = MediaPlayer.create(this, R.raw.gotdamn3);
        final MediaPlayer stuffToDo = MediaPlayer.create(this, R.raw.gotsufftodo);
        final MediaPlayer mission = MediaPlayer.create(this, R.raw.mission);

        //Listener to play random sound clip when button is pressed.
        playNoobNoobSound.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                int dur = Toast.LENGTH_SHORT;

                Toast.makeText(context, stringGenerator(), dur).show();

                int i = rgenerator.nextInt((5-1) + 1) + 1;

                if (i == 1) {
                    gd1.start();
                } else if (i == 2) {
                    gd2.start();
                } else if (i == 3) {
                    gd3.start();
                } else if (i == 4) {
                    stuffToDo.start();
                } else if (i == 5) {
                    mission.start();
                }

            }
        });
    }

    //Random String generator takes from values/arrays.xml
    public String stringGenerator() {

        Resources res = getResources();
        String[] s = res.getStringArray(R.array.popups);

        String toDisplay = s[rgenerator.nextInt(s.length)];
        return toDisplay;
    }
}
