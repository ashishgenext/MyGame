package com.Project.testProject;

import android.graphics.Bitmap;


public class Item {
	
	int ImageId;
	
	
	public Item(int ImageId) {
		super();
		
		this.ImageId = ImageId ;
		
	}

	public int getBitmapImageId(){
		return this.ImageId ;
	}
	

}
