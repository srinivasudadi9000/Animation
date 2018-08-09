package srinivasu.animation;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Home extends Activity implements View.OnClickListener{
TextView connect_tv;
Button okay_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        okay_btn = (Button) findViewById(R.id.okay_btn);
        connect_tv = (TextView) findViewById(R.id.connect_tv);
        connect_tv.setSelected(true);
      /*  Animation marquee = AnimationUtils.loadAnimation(this, R.anim.marquee);
        connect_tv.startAnimation(marquee);*/
        okay_btn.setOnClickListener(this);
        SharedPreferences.Editor s = getSharedPreferences("values",MODE_PRIVATE).edit();
        s.putString("value1","dadi");
        s.putString("value2","srinivasu");
        s.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.okay_btn:
                Intent dashboard = new Intent(Home.this,Dashboard.class);
              //  startActivity(dashboard);
                SharedPreferences getvalues = getSharedPreferences("values",MODE_PRIVATE);
                System.out.println("Value1 "+getvalues.getString("value1",""));
                System.out.println("Value2 "+getvalues.getString("value2",""));

                SharedPreferences.Editor s = getSharedPreferences("values",MODE_PRIVATE).edit();
              //  s.putString("value1","dadi");
                s.putString("value2","dadisrinivasu");
                s.commit();

                SharedPreferences getvalue = getSharedPreferences("values",MODE_PRIVATE);
                System.out.println("Value1 "+getvalue.getString("value1",""));
                System.out.println("Value2 "+getvalue.getString("value2",""));

                break;
        }
    }

}
