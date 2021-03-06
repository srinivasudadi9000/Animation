package srinivasu.animation;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewAnimationUtils;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends Activity implements OnClickListener{
   FloatingActionButton start_fab;
   TextView statsu_tv,tapstatus_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        tapstatus_tv = (TextView) findViewById(R.id.tapstatus_tv);
        statsu_tv = (TextView) findViewById(R.id.statsu_tv);
        start_fab = (FloatingActionButton) findViewById(R.id.start_fab);
        start_fab.setOnClickListener(this);

        Intent guide = new Intent(Dashboard.this,Guide.class);
        startActivity(guide);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_fab:
                vibrate();
                if (statsu_tv.getText().toString().equals("START")){
                    statsu_tv.setTextColor(getResources().getColor(R.color.green));
                    statsu_tv.setText("STOP");
                    tapstatus_tv.setText("Tap for stop");
                }
                else{
                    statsu_tv.setTextColor(getResources().getColor(R.color.white));
                    statsu_tv.setText("START");

                    tapstatus_tv.setText("Tap for start");
                }
                break;
        }
    }

    public void vibrate(){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
        }else{
            //deprecated in API 26
            v.vibrate(50);
        }
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(getBaseContext(), "Destroying application ", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }


}
