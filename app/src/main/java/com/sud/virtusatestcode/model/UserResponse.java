package com.sud.virtusatestcode.model;

import com.google.gson.annotations.SerializedName;

public class UserResponse{

	@SerializedName("data")
	private Data data;

	@SerializedName("support")
	private Support support;

	public Data getData(){
		return data;
	}

	public Support getSupport(){
		return support;
	}
}