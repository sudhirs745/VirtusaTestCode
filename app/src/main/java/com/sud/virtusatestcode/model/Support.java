package com.sud.virtusatestcode.model;

import com.google.gson.annotations.SerializedName;

public class Support{

	@SerializedName("text")
	private String text;

	@SerializedName("url")
	private String url;

	public String getText(){
		return text;
	}

	public String getUrl(){
		return url;
	}
}