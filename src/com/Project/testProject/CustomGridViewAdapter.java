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
	ArrayList<Item> data = new ArrayList<Item>();

	public CustomGridViewAdapter(Context context, int layoutResourceId,
			ArrayList<Item> data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
	//	Log.d("debug","pos:"+position);
		View row = convertView;
		RecordHolder holder = null;
		Random random = new Random();
		int randomNum = random.nextInt((16 - 1) + 1) + 1;
		
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
			
			holder = new RecordHolder();
			//holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
			
			
			holder.imageItem = (ImageView) row.findViewById(R.id.item_image);
			
			row.setTag(holder);
		} else {
			holder = (RecordHolder) row.getTag();
		}

		Item item = data.get(position);
	//	holder.txtTitle.setText(item.getTitle());
		
		if(randomNum == position){
		holder.imageItem.setImageBitmap(item.getImage());
		}
		//holder.imageItem.setImageDrawable(layerDrawable);
		
		return row;

	}

	
	static class RecordHolder {
		
		ImageView imageItem;

	}
}