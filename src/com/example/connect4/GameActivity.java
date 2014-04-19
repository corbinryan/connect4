package com.example.connect4;

import java.util.HashMap;

import com.example.connect4.R.id;
import com.example.connect4.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.Button;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class GameActivity extends Activity {
    /**+
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * If set, will toggle the system UI visibility upon interaction. Otherwise,
     * will show the system UI visibility upon interaction.
     */
    private static final boolean TOGGLE_ON_CLICK = true;

    /**
     * The flags to pass to {@link SystemUiHider#getInstance}.
     */
    private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

    /**
     * The instance of the {@link SystemUiHider} for this activity.
     */
    private SystemUiHider mSystemUiHider;
    
    public interface Contants {
    	String LOG = "com.example.connect4";
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    public void onTileClick(View btnTile){
        String btnText;
        String dbgMsg = "";
        GameTile thisTile = (GameTile)btnTile;
        dbgMsg += String.format("onTileClick(): GameTile Id= %d\n", thisTile.getId());
    	if(thisTile.getText() == getResources().getString(R.string.tile_blank))
    	{
            btnText = getResources().getString(R.string.tile_x);
    		thisTile.setText(btnText);
    	}
    	else if(thisTile.getText() == getResources().getString(R.string.tile_x))
    	{
            btnText = getResources().getString(R.string.tile_o);
    		thisTile.setText(btnText);
    	}
    	else
    	{
            btnText = getResources().getString(R.string.tile_blank);
    		thisTile.setText(btnText);
    	}
        for(String dir : new String[]{"n", "ne", "e", "se", "s", "sw", "w", "nw"})
        {
        	dbgMsg += String.format("\t%s Id = %d\n", dir, thisTile.NeighborTiles.get(dir));
        	Integer id = thisTile.NeighborTiles.get(dir);
        	if(id != null)
        	{
        		GameTile neighborTile = (GameTile)findViewById(id);
        		if(neighborTile != null)
        		{
        			neighborTile.setText(btnText);
        		}
        	}
        }
        Log.d(Contants.LOG, dbgMsg);
    }
}
