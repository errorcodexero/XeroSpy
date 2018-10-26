package com.wilsonvillerobotics.scouting.xerospy.activities;


import android.app.Activity;
import android.os.Bundle;

import com.wilsonvillerobotics.scouting.xerospy.R;
import com.wilsonvillerobotics.scouting.xerospy.database.DatabaseHelper;

/**
 * Created by Luke on 1/24/2017.
 */

public class DriveTeamFeedbackActivity extends Activity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive_team_feedback);


    }
}
