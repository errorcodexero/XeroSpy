package com.wilsonvillerobotics.scouting.xerospy.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.wilsonvillerobotics.scouting.xerospy.contracts.ActionsContract;
import com.wilsonvillerobotics.scouting.xerospy.contracts.EventContract;
import com.wilsonvillerobotics.scouting.xerospy.contracts.MatchContract;
import com.wilsonvillerobotics.scouting.xerospy.contracts.TeamContract;
import com.wilsonvillerobotics.scouting.xerospy.contracts.TeamMatchActionContract;
import com.wilsonvillerobotics.scouting.xerospy.contracts.TeamMatchContract;

public class DatabaseHelper extends SQLiteOpenHelper {

    // static Singleton object
    private static DatabaseHelper sInstance;

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "ecxScoutingData";

    public static synchronized DatabaseHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // creating required tables
        Log.i(LOG, "Creating table " + ActionsContract.ActionsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL(ActionsContract.ActionsEntry.CREATE_TABLE_ACTIONS);

        Log.i(LOG, "Creating table " + EventContract.EventEntry.TABLE_NAME);
        sqLiteDatabase.execSQL(EventContract.EventEntry.CREATE_TABLE_EVENT);

        Log.i(LOG, "Creating table " + MatchContract.MatchEntry.TABLE_NAME);
        sqLiteDatabase.execSQL(MatchContract.MatchEntry.CREATE_TABLE_MATCH);

        Log.i(LOG, "Creating table " + TeamContract.TeamEntry.TABLE_NAME);
        sqLiteDatabase.execSQL(TeamContract.TeamEntry.CREATE_TABLE_TEAM);

        Log.i(LOG, "Creating table " + TeamMatchActionContract.TeamMatchActionEntry.TABLE_NAME);
        sqLiteDatabase.execSQL(TeamMatchActionContract.TeamMatchActionEntry.CREATE_TABLE_TEAM_MATCH_ACTION);

        Log.i(LOG, "Creating table " + TeamMatchContract.TeamMatchEntry.TABLE_NAME);
        sqLiteDatabase.execSQL(TeamMatchContract.TeamMatchEntry.CREATE_TABLE_TEAM_MATCH);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // TODO - do we need to save data before dropping the tables?
        // on upgrade drop older tables
        Log.i(LOG, "Dropping table " + ActionsContract.ActionsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ActionsContract.ActionsEntry.TABLE_NAME);

        Log.i(LOG, "Dropping table " + EventContract.EventEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + EventContract.EventEntry.TABLE_NAME);

        Log.i(LOG, "Dropping table " + MatchContract.MatchEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MatchContract.MatchEntry.TABLE_NAME);

        Log.i(LOG, "Dropping table " + TeamContract.TeamEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TeamContract.TeamEntry.TABLE_NAME);

        Log.i(LOG, "Dropping table " + TeamMatchActionContract.TeamMatchActionEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TeamMatchActionContract.TeamMatchActionEntry.TABLE_NAME);

        Log.i(LOG, "Dropping table " + TeamMatchContract.TeamMatchEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TeamMatchContract.TeamMatchEntry.TABLE_NAME);

        // create new tables
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
        // TODO - should we save data before downgrading the tables?
    }


}
