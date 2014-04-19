/**
 * 
 */
package com.example.connect4;

import java.util.HashMap;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.RecyclerListener;

/**
 * @author Ryan
 *
 */


public class GameTile extends android.widget.Button{
	
	public enum TileStatus {BLANK, PLAYER1, PLAYER2};
	
	public TileStatus Status = TileStatus.BLANK;
	public HashMap<String, Integer> NeighborTiles = new HashMap<String, Integer>();

	
	public GameTile(Context context)
	{
		super(context);
	}
	
	public GameTile(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		ApplyAttrs(context, attrs);
	}
	
	public GameTile(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		ApplyAttrs(context, attrs);
	}
	
	private void ApplyAttrs(Context context, AttributeSet attrs)
	{
		NeighborTiles.put("n", null); 
		NeighborTiles.put("ne", null);
		NeighborTiles.put("e", null);
		NeighborTiles.put("se", null);
		NeighborTiles.put("s", null);
		NeighborTiles.put("sw", null);
		NeighborTiles.put("w", null);
		NeighborTiles.put("nw", null);
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.GameTile);
		for(int i = 0; i < a.getIndexCount(); i++)
		{
			int neighbor;
			
			int attr = a.getIndex(i);
			switch (attr)
			{
			case R.styleable.GameTile_neighborN:
				neighbor = a.getResourceId(i, -1);
				NeighborTiles.put("n", neighbor);
				break;
			case R.styleable.GameTile_neighborNE:
				neighbor = a.getResourceId(i, -1);
				NeighborTiles.put("ne", neighbor);
				break;
			case R.styleable.GameTile_neighborE:
				neighbor = a.getResourceId(i, -1);
				NeighborTiles.put("e", neighbor);
				break;
			case R.styleable.GameTile_neighborSE:
				neighbor = a.getResourceId(i, -1);
				NeighborTiles.put("se", neighbor);
				break;
			case R.styleable.GameTile_neighborS:
				neighbor = a.getResourceId(i, -1);
				NeighborTiles.put("s", neighbor);
				break;
			case R.styleable.GameTile_neighborSW:
				neighbor = a.getResourceId(i, -1);
				NeighborTiles.put("w", neighbor);
				break;
			case R.styleable.GameTile_neighborW:
				neighbor = a.getResourceId(i, -1);
				NeighborTiles.put("w", neighbor);
				break;
			case R.styleable.GameTile_neighborNW:
				neighbor = a.getResourceId(i, -1);
				NeighborTiles.put("ne", neighbor);
				break;
			}
		}
		a.recycle();
	}
	
	public void RegisterNeighbor(String direction, int neighbor)
	{
		NeighborTiles.put(direction, neighbor);
	}
/*	
	protected Boolean SearchForFourInARow()
	{
		for(String dir : new String[]{"n", "ne", "e", "se", "s", "sw", "w", "nw"})
		{
			if (SearchNeighborForFourInARow(dir, 0))
			{
				return true;
			}
		}
		return false;
	}
	
	protected Boolean SearchNeighborForFourInARow(String dir, int InARowCount)
	{
		GameTile NeighborTile = ((GameTile)NeighborTiles.get(dir));
		if(NeighborTile.Status == this.Status)
		{
			InARowCount++;
			if(InARowCount > 3)
			{
				return true;
			}
			else
			{
				return NeighborTile.SearchNeighborForFourInARow(dir, InARowCount);
			}
		}
		else
		{
			return false;
		}
	}	
*/
}
