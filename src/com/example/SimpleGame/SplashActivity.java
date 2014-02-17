package com.example.SimpleGame;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by respect on 2/17/14.
 */
public class SplashActivity  extends Activity {
    public static final String GAME_PREFERENCES = "GamePrefs";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        TextView logo1 = (TextView)findViewById(R.id.TextviewTopTitle);
        Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        logo1.startAnimation(fade1);

        Animation spinin = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        LayoutAnimationController controller = new LayoutAnimationController(spinin);
        TableLayout table = (TableLayout)findViewById(R.id.tableLayout);
        for(int i = 0; i < table.getChildCount(); i++)
        {
            TableRow row = (TableRow)table.getChildAt(i);
            row.setLayoutAnimation(controller);
        }

        Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        TextView logo2 = (TextView)findViewById(R.id.TextviewBottomTitle);
        logo2.startAnimation(fade2);

        fade2.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this, MenuActivity.class));
                SplashActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        SharedPreferences settings = getSharedPreferences(GAME_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString("UserName", "Yrysbek");
        prefEditor.putInt("Age", 20);
        prefEditor.commit();

    }

    @Override
    protected void onPause() {
        super.onPause();

        TextView logo1 = (TextView)findViewById(R.id.TextviewTopTitle);
        logo1.clearAnimation();

        TableLayout table = (TableLayout)findViewById(R.id.tableLayout);
        for(int i = 0; i < table.getChildCount(); i++){
            TableRow row = (TableRow)table.getChildAt(i);
            row.clearAnimation();
        }
    }


}
