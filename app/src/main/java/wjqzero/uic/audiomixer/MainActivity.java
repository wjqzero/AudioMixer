package wjqzero.uic.audiomixer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bc = (Button)findViewById(R.id.btn_test);
        Button bt = (Button)findViewById(R.id.btn_test2);

        final SoundPool soundPool;
        soundPool= new SoundPool(10, AudioManager.STREAM_SYSTEM,5);
        soundPool.load(this,R.raw.a0,1);

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
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    soundPool.play(1, 1, 1, 0, -1, 1);
                }
                return true;
            }
        });
    }
}
