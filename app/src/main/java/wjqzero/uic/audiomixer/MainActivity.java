package wjqzero.uic.audiomixer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bc = (Button)findViewById(R.id.btn_test);
        Button bt = (Button)findViewById(R.id.btn_test2);
        TextView tv = (TextView)findViewById(R.id.tv_rate);
        SeekBar sb = (SeekBar)findViewById(R.id.sb_rate);

        final int rate;

        final SoundPool soundPool;
        soundPool= new SoundPool(10, AudioManager.STREAM_SYSTEM,5);
        soundPool.load(this,R.raw.e4,1);

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Button was clicked!", Toast.LENGTH_SHORT)
                        .show();
                soundPool.play(1,1, 1, 0, 0, 1);
            }
        });

        bt.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event){
                //rate =
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    soundPool.play(1, 1, 1, 0, -1, 0.5F);
                }
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    soundPool.autoPause();
                }
                return true;
            }
        });
    }
}
