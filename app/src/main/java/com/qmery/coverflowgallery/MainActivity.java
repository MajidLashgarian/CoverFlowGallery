package com.qmery.coverflowgallery;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity
{

    /** Videos which must show in list */
    private VideoAdapter videos = new VideoAdapter();

    /** Video list which stored in videos*/
    private ArrayList<ThumbnailView> thumbnails = new ArrayList<ThumbnailView>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 0 ; i < 5 ; i++){
            ThumbnailView tempView = new ThumbnailView(this);
            tempView.setImage(this.getResources().getDrawable(R.drawable.p1));
            tempView.setTime("2:20");
            thumbnails.add(tempView);
        }
        videos.videos = thumbnails ;
        ((ListView)findViewById(R.id.listView)).setAdapter(videos);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
