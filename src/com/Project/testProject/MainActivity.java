package com.Project.testProject;

import java.util.ArrayList;

import com.Project.testProject.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGestureListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;


@SuppressLint("NewApi")
public class MainActivity extends Activity {
	GridView gridView;
	ArrayList<Item> gridArray = new ArrayList<Item>();
	 CustomGridViewAdapter customGridAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//set grid view item
		Bitmap gridIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.a);
		
		gridArray.add(new Item(gridIcon));
		gridArray.add(new Item(gridIcon));
		gridArray.add(new Item(gridIcon));
		gridArray.add(new Item(gridIcon));
		gridArray.add(new Item(gridIcon));
		gridArray.add(new Item(gridIcon));
		gridArray.add(new Item(gridIcon));
		gridArray.add(new Item(gridIcon));
		gridArray.add(new Item(gridIcon));
		gridArray.add(new Item(gridIcon));
		gridArray.add(new Item(gridIcon));
		gridArray.add(new Item(gridIcon));
		gridArray.add(new Item(gridIcon));
		gridArray.add(new Item(gridIcon));
		gridArray.add(new Item(gridIcon));
		gridArray.add(new Item(gridIcon));
		
		gridView = (GridView) findViewById(R.id.gridView1);
		customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
		gridView.setAdapter(customGridAdapter);
		
		gridView.setOnTouchListener(new OnSwipeTouchListener(this){
			public void onSwipeTop() {
				customGridAdapter.generateRandomIndex(0, 15);
				customGridAdapter.isDone = true ;
				gridView.setAdapter(customGridAdapter);
				
		    }
		    public void onSwipeRight() {
		    	final int numVisibleChildren = gridView.getChildCount();
		    	final int firstVisiblePosition = gridView.getFirstVisiblePosition();

		    	for ( int i = 0; i < numVisibleChildren; i++ ) {
		    	    int positionOfView = firstVisiblePosition + i;;
		    	    //if (positionOfView == positionIamLookingFor) 
		    	        View view = gridView.getChildAt(i);
		    	        GridModel model = (GridModel) view.getTag();
		    	        if(model.getImageId() != null){
		    	        	Log.d("debug","index "+ model.getImageId().getId());
		    	        }
		    	}
		    }
		    public void onSwipeLeft() {
		       
		    }
		    public void onSwipeBottom() {
		        
		    }

		public boolean onTouch(View v, MotionEvent event) {
		    return gestureDetector.onTouchEvent(event);
		}
		});
		
		
	}


}
