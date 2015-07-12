package meysam.soundprofilecontrol;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton sound = (ImageButton) findViewById(R.id.imageButtonSound);
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager a = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                a.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                //For UI only
                Animation anim = AnimationUtils.loadAnimation(Main.this, R.anim.animation);
                ImageButton b = (ImageButton) view;
                b.startAnimation(anim);
                Toast.makeText(Main.this, "Sound On", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton vibrate = (ImageButton) findViewById(R.id.imageButtonV);
        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager a = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                a.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                //For UI only
                Animation anim = AnimationUtils.loadAnimation(Main.this, R.anim.animation);
                ImageButton b = (ImageButton) view;
                b.startAnimation(anim);
                Toast.makeText(Main.this, "Vibrate", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton silent = (ImageButton) findViewById(R.id.imageButtonSilent);
        silent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioManager a = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                a.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                //For UI only
                Animation anim = AnimationUtils.loadAnimation(Main.this, R.anim.animation);
                ImageButton b = (ImageButton) view;
                b.startAnimation(anim);
                Toast.makeText(Main.this, "Silent", Toast.LENGTH_SHORT).show();
            }
        });

        final ImageButton info = (ImageButton) findViewById(R.id.imageButtoninfo);
        info.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (android.os.Build.VERSION.SDK_INT >= 16)
                            info.setBackground(getResources().getDrawable(R.mipmap.info_orange));
                        else
                            info.setBackgroundDrawable(getResources().getDrawable(R.mipmap.info_orange));
                        Toast.makeText(Main.this, "Developer: Meysam Rezaee", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_UP:
                        if (android.os.Build.VERSION.SDK_INT >= 16)
                            info.setBackground(getResources().getDrawable(R.mipmap.info));
                        else
                            info.setBackgroundDrawable(getResources().getDrawable(R.mipmap.info));
                        break;
                }
                return false;
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
