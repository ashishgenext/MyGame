package com.Project.testProject;

import android.graphics.Bitmap;


public class Item {
	Bitmap image;
//	String title;
	
	public Item(Bitmap image) {
		super();
		this.image = image;
	//	this.title = title;
	}
	public Bitmap getImage() {
		return image;
	}
	public void setImage(Bitmap image) {
		this.image = image;
	}

	/*public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
 */	

}
