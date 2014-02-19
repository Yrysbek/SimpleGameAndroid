package com.example.SimpleGame;
import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TableLayout;

/**
 * Created by respect on 2/17/14.
 */
public class ScoresActivity  extends Activity {
    public static final String GAME_PREFERENCES = "GamePrefs";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scores);

        TabHost tabHost = (TabHost)findViewById(R.id.scoresTabHost);
        tabHost.setup();

        TabSpec allScoresTab = tabHost.newTabSpec("allTab");
        allScoresTab.setIndicator(getResources().getString(R.string.all_scores),
                getResources().getDrawable(android.R.drawable.star_on));
        allScoresTab.setContent(R.id.ScrollViewAllScores);
        tabHost.addTab(allScoresTab);

        TabSpec friendsScoresTab = tabHost.newTabSpec("friendTab");
        friendsScoresTab.setIndicator(getResources().getString(R.string.frieds_scores),
                getResources().getDrawable(android.R.drawable.star_on));
        friendsScoresTab.setContent(R.id.ScrollViewAllScores);
        tabHost.addTab(friendsScoresTab);

        tabHost.setCurrentTabByTag("allTab");

        TableLayout scoresLayout = (TableLayout)findViewById(R.id.TableLayoutScores);

        XmlResourceParser scores = getResources().getXml(R.xml.allscores);

//        int eventType = -1;
//        boolean bFoundScores = false;
//// Find Score records from XML
//        while (eventType != XmlResourceParser.END_DOCUMENT) {
//            if (eventType == XmlResourceParser.START_TAG) {
//// Get the name of the tag (eg scores or score)
//                String strName = scores.getName();
//                if (strName.equals("score")) {
//                    bFoundScores = true;
//                    String scoreValue = scores.getAttributeValue(null,
//                            "score");
//                    String scoreRank = scores.getAttributeValue(null, "rank");
//                    String scoreUserName =
//                            scores.getAttributeValue(null, "username");
//                    insertScoreRow(scoresLayout, scoreValue, scoreRank,
//                            scoreUserName);
//                }
//            }
//            eventType = scores.next();
//        }

    }
}
