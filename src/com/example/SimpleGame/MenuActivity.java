package com.example.SimpleGame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by respect on 2/17/14.
 */
public class MenuActivity  extends Activity {
    public static final String GAME_PREFERENCES = "GamePrefs";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        ListView menuList = (ListView)findViewById(R.id.ListView_Menu);
        String[] items = { getResources().getString(R.string.menu_item_play),
                getResources().getString(R.string.menu_item_scores),
                getResources().getString(R.string.menu_item_settings),
                getResources().getString(R.string.menu_item_help) };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.menu_item, items);
        menuList.setAdapter(adapter);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView)view;
                String strText = textView.getText().toString();
                if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_play))){
                    startActivity(new Intent(MenuActivity.this,GameActivity.class));
                }
                else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_scores))){
                    startActivity(new Intent(MenuActivity.this,ScoresActivity.class));
                }
                else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_settings))){
                    startActivity(new Intent(MenuActivity.this,SettingsActivity.class));
                }
                else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_help))){
                    startActivity(new Intent(MenuActivity.this,HelpActivity.class));
                }
            }
        });

    }
}
