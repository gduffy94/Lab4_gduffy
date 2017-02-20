package com.example.garrett.lab4_gduffy;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.*;

/**
 * Created by Garrett on 2/10/2017.
 */

class ScheduleAdapter extends ArrayAdapter<String[]> {
    ScheduleAdapter (Context context, ArrayList<String[]> schedule) {
        super(context, R.layout.schedule_item, schedule);
    }
    public View getView (int position, View convertView, ViewGroup parent) {
        LayoutInflater scheduleInflater = LayoutInflater.from(getContext());
        View scheduleView = scheduleInflater.inflate(R.layout.schedule_item, parent, false);

        String[] matchItem = getItem(position);
        TextView teamName = (TextView) scheduleView.findViewById(R.id.teamName);
        ImageView teamLogo = (ImageView) scheduleView.findViewById(R.id.teamLogo);
        TextView schedule = (TextView) scheduleView.findViewById(R.id.schedule);

        String mDrawableName = matchItem[0];
        int resID = getContext().getResources().getIdentifier(mDrawableName , "mipmap", getContext().getPackageName());
        teamLogo.setImageResource(resID);
        teamName.setText(matchItem[1]);
        schedule.setText(matchItem[2]);
        return scheduleView;
    }
}