package com.sureshssk2006.vikramaditya;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class StoryDisplay extends ActionBarActivity {

    TextView mTextViewStory;
    String story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_display);

        mTextViewStory = (TextView) findViewById(R.id.tag_no);
        Intent intent = getIntent();
        int ButtonNo = intent.getIntExtra("TAG", 0);
        //mTextViewStory.setText("" + ButtonNo);

        GetStory(ButtonNo);
    }

    private void GetStory(int buttonNo) {
        String fileName = "" + Integer.toString(buttonNo) + ".txt";
        AssetManager mAssetManager = getAssets();
        try {
            InputStream mInputStream = mAssetManager.open(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(mInputStream));
            story = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mTextViewStory.setText(story);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_story_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
