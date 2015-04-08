package com.Project.testProject;

import java.util.ArrayList;

import com.Project.testProject.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;


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
		
		
		
		
		
		gridView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				//Log.d("debug","spacing" + gridView.getHorizontalSpacing());
				
			}

			
		});
	}

	
}
