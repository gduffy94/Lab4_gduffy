package com.example.garrett.lab4_gduffy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ArrayList<String[]> myList = new ArrayList<String[]>();
        String[] teamLogo = {"osu", "fsu", "wf", "bc", "ncs", "gt", "v", "cs"};
        String[] team_array = {"Ohio State", "Florida State", "Wake Forest", "Boston College", "North Carolina State", "Georgia Tech", "Virginia", "Chicago State"};
        String[] schedule = {"Feb 11", "Feb 12", "Feb 14", "Feb 16", "Feb 19", "Feb 20", "Feb 21", "Feb 24"};

        String[] scheduleComma = {"Feb 11,", "Feb 12,", "Feb 14,", "Feb 16,", "Feb 19,", "Feb 20,", "Feb 21,", "Feb 24,"};
        String[] day = {"Saturday,", "Sunday,", "Tuesday,", "Thursday,", "Sunday,", "Monday,", "Tuesday,", "Friday,"};
        String[] time = {"6:00 PM", "6:00 PM", "7:30 PM", "6:00 PM", "12:30 PM", "7:30 PM", "6:00 PM", "7:30 PM"};
        String[] stadium = {"Value City Arena,", "Purcell Pavilion,", "Purcell Pavilion,", "Conte Forum,", "PNC Arena,", "Purcell Pavilion,", "Purcell Pavilion,", "Purcell Pavilion,"};
        String[] location = {"Columbus, OH", "Notre Dame, IN", "Notre Dame, IN", "Chestnut Hill, MA", "Raleigh, NC", "Notre Dame, IN", "Notre Dame, IN", "Notre Dame, IN"};

        String[] teamOneMascot = {"Buckeyes", "Seminoles", "Demon Deacons", "Eagles", "Wolfpack", "Yellow Jackets", "Cavaliers", "Cougars"};
        String[] teamOneRecord = {"(15-13)", "(21-6)", "(15-12)", "(9-18)", "(14-14)", "(16-11)", "(18-8)", "(6-22)"};

        String[] score = {"67 - 80", "72 - 84", "81 - 88", "76 - 84", "72 - 81", "0 - 0", "0 - 0", "0 - 0"};
        String[] gametime = {"Final", "Final", "Final", "Final", "Final", "", "", ""};


        setContentView(R.layout.activity_main);

        for (int i = 0; i < 8; i++) {
            String[] row = new String[3];
            row[0] = teamLogo[i];
            row[1] = team_array[i];
            row[2] = schedule[i];
            myList.add(row);
        }

        ScheduleAdapter scheduleAdapter1 = new ScheduleAdapter(this, myList);

        ListView scheduleListView = (ListView) findViewById(R.id.scheduleListView);

        scheduleListView.setAdapter(scheduleAdapter1);

        final ArrayList<String[]> gameList = new ArrayList<String[]>();
        for (int i = 0; i < 8; i++) {
            String[] gameRow = new String[15];
            gameRow[0] = day[i];
            gameRow[1] = scheduleComma[i];
            gameRow[2] = time[i];
            gameRow[3] = stadium[i];
            gameRow[4] = location[i];
            gameRow[5] = "@mipmap/" + teamLogo[i];
            gameRow[6] = team_array[i];
            gameRow[7] = teamOneMascot[i];
            gameRow[8] = teamOneRecord[i];
            gameRow[9] = score[i];
            gameRow[10] = gametime[i];
            gameRow[11] = "Notre Dame";
            gameRow[12] = "Fighting Irish";
            gameRow[13] = "(21 - 7)";
            gameRow[14] = "R.mipmap.irish";
            gameList.add(gameRow);
        }


        AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentBundle = new Intent(MainActivity.this, DetailActivity.class);

                intentBundle.putExtra("team", gameList.get(position));

                startActivity(intentBundle);


            }

        };
        scheduleListView.setOnItemClickListener(clickListener);


    }
}
