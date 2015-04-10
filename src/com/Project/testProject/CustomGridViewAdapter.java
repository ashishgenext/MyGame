package com.Project.testProject;

import java.util.ArrayList;
import java.util.Random;

import com.Project.testProject.R;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
		generateRandomIndex(0,15);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		//Log.d("debug","pos:"+position);
		View row = convertView;
		GridModel gridModel = null;
		
		
		//	Log.d("debug", "msg"+parent.getChildCount());
	//	Resources r = context.getResources();
	//	Drawable[] layers = new Drawable[2];
	//	layers[0] = r.getDrawable(R.drawable.square);
	//	layers[1] = r.getDrawable(R.drawable.a_32);
	//	LayerDrawable layerDrawable = new LayerDrawable(layers);
		
		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);
			row.setBackgroundResource(R.drawable.square);
		//	row.setVisibility(View.GONE);
			ImageView imageItem  = (ImageView) row.findViewById(R.id.item_image);
			gridModel = new GridModel(imageItem);
			//holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
			
			
			//holder.imageItem = (ImageView) row.findViewById(R.id.item_image);
			
			row.setTag(gridModel);
		} else {
			gridModel = (GridModel) row.getTag();
		}

		Item item = data.get(position);
	//	holder.txtTitle.setText(item.getTitle());
		
		if(randomIndex == position && isDone == true){
	//	GridModel.imageItem.setImageBitmap(item.getImage());
		gridModel.getImageId().setImageBitmap(item.getImage());
			isDone = false ;
		}
		//holder.imageItem.setImageDrawable(layerDrawable);
		
		return row;

	}

	int generateRandomIndex(int min,int max){
		
		Random random = new Random();
		randomIndex = random.nextInt((max - min) + min) +min;
		return randomIndex ;
	}
	
	


}