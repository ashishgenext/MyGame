package com.Project.testProject;

import java.util.ArrayList;
import java.util.Random;

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
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toast;


@SuppressLint("NewApi")
public class MainActivity extends Activity {
	TableLayout tablelayout;
	ArrayList<Item> gridArray = new ArrayList<Item>();
	CustomGridViewAdapter customGridAdapter;
	ArrayList<ImageView> imageViewArray = new ArrayList();
	ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16;
	int randomIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table_layout);
		initData();
		
		int initialImageIndex = generateRandomIndex(0, 15);
		int initialViewArrayIndex = generateRandomIndex(0, 25);
		imageViewArray.get(initialViewArrayIndex).setImageResource(gridArray.get(initialImageIndex).ImageId);
		imageViewArray.get(initialViewArrayIndex).setTag(R.string.is_image,"true");
		imageViewArray.get(initialViewArrayIndex).setTag(R.string.image_id,gridArray.get(initialImageIndex));



	}

	protected void initData(){

		tablelayout = (TableLayout) findViewById(R.id.tableLayout1);
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView2 = (ImageView) findViewById(R.id.imageView2);
		imageView3 = (ImageView) findViewById(R.id.imageView3);
		imageView4 = (ImageView) findViewById(R.id.imageView4);
		imageView5 = (ImageView) findViewById(R.id.imageView5);
		imageView6 = (ImageView) findViewById(R.id.imageView6);
		imageView7 = (ImageView) findViewById(R.id.imageView7);
		imageView8 = (ImageView) findViewById(R.id.imageView8);
		imageView9 = (ImageView) findViewById(R.id.imageView9);
		imageView10 = (ImageView) findViewById(R.id.imageView10);
		imageView11 = (ImageView) findViewById(R.id.imageView11);
		imageView12 = (ImageView) findViewById(R.id.imageView12);
		imageView13 = (ImageView) findViewById(R.id.imageView13);
		imageView14 = (ImageView) findViewById(R.id.imageView14);
		imageView15 = (ImageView) findViewById(R.id.imageView15);
		imageView16 = (ImageView) findViewById(R.id.imageView16);
		tablelayout.setOnTouchListener(new OnSwipeTouchListener(this){
			public void onSwipeTop() {

			}
			public void onSwipeRight() {

			}
			public void onSwipeLeft() {

			}
			public void onSwipeBottom() {

			}

			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		});
		imageViewArray.add(imageView1);
		imageViewArray.add(imageView2);
		imageViewArray.add(imageView3);
		imageViewArray.add(imageView4);
		imageViewArray.add(imageView5);
		imageViewArray.add(imageView6);
		imageViewArray.add(imageView7);
		imageViewArray.add(imageView8);
		imageViewArray.add(imageView9);
		imageViewArray.add(imageView10);
		imageViewArray.add(imageView11);
		imageViewArray.add(imageView12);
		imageViewArray.add(imageView13);
		imageViewArray.add(imageView14);
		imageViewArray.add(imageView15);
		imageViewArray.add(imageView16);

		TypedArray imgs = getResources().obtainTypedArray(R.array.images);

		for(int i=0;i<26;i++){
			gridArray.add(new Item(imgs.getResourceId(i, -1)));
		}

	}

int generateRandomIndex(int min,int max){
		
		Random random = new Random();
		randomIndex = random.nextInt((max - min) + min) +min;
		return randomIndex ;
	}
	
}


