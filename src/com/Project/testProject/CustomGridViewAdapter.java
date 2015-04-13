package com.Project.testProject;

import java.util.ArrayList;
import java.util.Random;
import com.Project.testProject.R;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class CustomGridViewAdapter extends ArrayAdapter<Item> {
	Context context;
	int layoutResourceId;
	int randomIndex = -1;
	boolean isDone = true ;
	ArrayList<Item> data = new ArrayList<Item>();

	public CustomGridViewAdapter(Context context, int layoutResourceId,
			ArrayList<Item> data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
		generateRandomIndex(0,25);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		Log.d("debug","postion-"+ position );
		View row = convertView;
		GridModel gridModel = null;
		
		if (row == null) {
			
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);
			row.setBackgroundResource(R.drawable.square);
			ImageView imageItem  = (ImageView) row.findViewById(R.id.item_image);
			gridModel = new GridModel(imageItem);
			row.setTag(R.string.is_image,"false");
			row.setTag(R.string.image_id,-1);	
			row.setTag(gridModel);
			if(position > 15) row.setVisibility(View.GONE);
		} else {
			gridModel = (GridModel) row.getTag();
		}

		Item item = data.get(position);
				
		if(randomIndex == position && isDone == true){
		gridModel.getImageId().setImageResource(item.getBitmapImageId());
			isDone = false ;
			row.setTag(R.string.is_image, "true");
			row.setTag(R.string.image_id,item.getBitmapImageId());
		}
		
		return row;

	}

	int generateRandomIndex(int min,int max){
		
		Random random = new Random();
		randomIndex = random.nextInt((max - min) + min) +min;
		return randomIndex ;
	}
	
	


}