package com.example.garrett.lab4_gduffy;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;

import static java.security.AccessController.getContext;


/**
 * Created by Garrett on 2/19/2017.
 */

public class DetailActivity extends Activity {

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_detail);

        TextView day = (TextView) findViewById(R.id.weekDay);
        TextView date = (TextView) findViewById(R.id.Date);
        TextView time = (TextView) findViewById(R.id.dayTime);
        TextView stadium = (TextView) findViewById(R.id.stadium);
        TextView location = (TextView) findViewById(R.id.Location);


        ImageView teamOneLogo = (ImageView) findViewById(R.id.teamOneLogo);
        TextView teamOneName = (TextView) findViewById(R.id.teamOneName);
        TextView teamOneMascot = (TextView) findViewById(R.id.teamOneMascot);
        TextView teamOneRecord = (TextView) findViewById(R.id.teamOneRecord);


        TextView score = (TextView) findViewById(R.id.gameScore);
        TextView gametime = (TextView) findViewById(R.id.timeLeft);


        ImageView teamTwoLogo = (ImageView) findViewById(R.id.teamTwoLogo);
        TextView teamTwoName = (TextView) findViewById(R.id.teamTwoName);
        TextView teamTwoMascot = (TextView) findViewById(R.id.teamTwoMascot);
        TextView teamTwoRecord = (TextView) findViewById(R.id.teamTwoRecord);

        final Button cameraBtn = (Button) findViewById(R.id.cameraButton);


        String[] gameInfo = getIntent().getStringArrayExtra("team");
        day.setText(gameInfo[0]);
        date.setText(gameInfo[1]);
        time.setText(gameInfo[2]);
        stadium.setText(gameInfo[3]);
        location.setText(gameInfo[4]);


        //String mDrawName = "R.mipmap." + gameInfo[5];

        teamOneLogo.setImageBitmap(BitmapFactory.decodeFile(gameInfo[5]));
        teamOneName.setText(gameInfo[6]);
        teamOneMascot.setText(gameInfo[7]);
        teamOneRecord.setText(gameInfo[8]);

        score.setText(gameInfo[9]);
        gametime.setText(gameInfo[10]);

        teamTwoName.setText(gameInfo[11]);
        teamTwoMascot.setText(gameInfo[12]);
        teamTwoRecord.setText(gameInfo[13]);
       // int twoID = Integer.parseInt(gameInfo[14]);
       // String mDrawableName = gameInfo[14];
       // int resID = getContext().getResources().getIdentifier(mDrawableName , "mipmap", getContext().getPackageName());

       // teamTwoLogo.setImageResource(twoID);


    }

    public void clicked(View v) {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(cameraIntent);
    }


}

