package com.sureshssk2006.vikramaditya;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    //Declaration
    Button mBackgroundStoryButton, mStoryButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //typecasting
        mBackgroundStoryButton = (Button) findViewById(R.id.button2);
        mStoryButton1 = (Button) findViewById(R.id.button);

        //Setting the onClickListener
        mBackgroundStoryButton.setOnClickListener(this);
        mStoryButton1.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    //Opens the story view activity for all the butons
    @Override
    public void onClick(View v) {
        int i = Integer.parseInt(v.getTag().toString());
        Intent intentStory = new Intent(getApplicationContext(), StoryDisplay.class);
        intentStory.putExtra("TAG", i);
        startActivity(intentStory);
    }
}
