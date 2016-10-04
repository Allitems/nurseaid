package com.nurseaid.protocol;

public class Message {
	
	public String type;
	public String text;
	
	public void prepareMessage(String m[])
	{
		this.type = m[0];
		this.text = m[1];
	}

}
