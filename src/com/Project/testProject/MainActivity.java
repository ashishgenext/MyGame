package com.Project.testProject;

import java.util.ArrayList;
import com.Project.testProject.R;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;


@SuppressLint("NewApi")
public class MainActivity extends Activity {
	GridView gridView;
	ArrayList<Item> gridArray = new ArrayList<Item>();
	 CustomGridViewAdapter customGridAdapter;
	 Bitmap gridIcon ;
	
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TypedArray imgs = getResources().obtainTypedArray(R.array.images);
	
		for(int i=0;i<26;i++){
			//gridIcon = BitmapFactory.decodeResource(this.getResources(), imgs.getResourceId(i, -1));
			gridArray.add(new Item(imgs.getResourceId(i, -1)));
		}
		
		gridView = (GridView) findViewById(R.id.gridView1);
		
		customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
		gridView.setAdapter(customGridAdapter);
		
		gridView.setOnTouchListener(new OnSwipeTouchListener(this){
			public void onSwipeTop() {
				customGridAdapter.generateRandomIndex(0, 25);
				customGridAdapter.isDone = true ;
				gridView.setAdapter(customGridAdapter);
				
		    }
		    public void onSwipeRight() {
		    	final int numVisibleChildren = gridView.getChildCount();
		    	final int firstVisiblePosition = gridView.getFirstVisiblePosition();
		    
		    	for ( int i = 0; i < numVisibleChildren; i++ ) {
		    	    int positionOfView = firstVisiblePosition + i;
		    	        View view = gridView.getChildAt(i);
		    	        String isImage = (String) view.getTag(R.string.is_image);
		    	        if(isImage.equals("true")){
		    	        	Log.d("debug","index "+ i);
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
