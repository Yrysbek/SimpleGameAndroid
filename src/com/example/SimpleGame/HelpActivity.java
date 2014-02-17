package com.example.SimpleGame;
import android.app.Activity;
import android.os.Bundle;

/**
 * Created by respect on 2/17/14.
 */
public class HelpActivity extends Activity {
    public static final String GAME_PREFERENCES = "GamePrefs";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
    }
}
