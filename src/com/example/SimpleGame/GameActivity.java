package com.example.SimpleGame;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

/**
 * Created by respect on 2/17/14.
 */
public class GameActivity extends Activity {
    public static final String GAME_PREFERENCES = "GamePrefs";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.gameoptions, menu);
        menu.findItem(R.id.help_menu_item).setIntent(
                new Intent(this, HelpActivity.class));
        menu.findItem(R.id.settings_menu_item).setIntent(
                new Intent(this, SettingsActivity.class));
        menu.findItem(R.id.scores_menu_item).setIntent(
                new Intent(this, ScoresActivity.class));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        startActivity(item.getIntent());
        return true;
    }
}
