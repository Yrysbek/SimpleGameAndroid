package com.example.SimpleGame;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by respect on 2/17/14.
 */
public class HelpActivity extends Activity {
    public static final String GAME_PREFERENCES = "GamePrefs";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);

        InputStream iFile = getResources().openRawResource(R.raw.help);
        TextView textView = (TextView)findViewById(R.id.TextView_HelpText);
        String helpText = null;
        try {
            helpText = inputStreamToString(iFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        textView.setText(helpText);
    }

    public String inputStreamToString(InputStream is) throws IOException {
        StringBuffer sBuffer = new StringBuffer();
        DataInputStream dataIO = new DataInputStream(is);
        String strLine = null;

        while ((strLine = dataIO.readLine()) != null) {
            sBuffer.append(strLine + "\n");
        }

        dataIO.close();
        is.close();

        return sBuffer.toString();
    }
}
