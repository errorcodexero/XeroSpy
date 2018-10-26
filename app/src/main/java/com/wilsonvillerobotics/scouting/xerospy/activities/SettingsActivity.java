package com.wilsonvillerobotics.scouting.xerospy.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wilsonvillerobotics.scouting.xerospy.fragments.SettingsFragment;

import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;

/**
 * Created by tomso on 12/2/2016.
 * More info: https://developer.android.com/guide/topics/ui/settings.html
 */
public class SettingsActivity extends AppCompatActivity implements PreferenceChangeListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        SettingsFragment frag = new SettingsFragment();
        frag.setArguments(getIntent().getExtras());
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, frag)
                .commit();
    }

    @Override
    public void preferenceChange(PreferenceChangeEvent evt) {

    }
}