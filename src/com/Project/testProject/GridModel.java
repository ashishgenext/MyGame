package com.Project.testProject;

import android.widget.ImageView;


class GridModel{
	ImageView imageItem;

	GridModel(ImageView imageId){
		this.imageItem = imageId ;
	}
	
	ImageView getImageId(){
		return this.imageItem ;
	}
}