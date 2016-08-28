package com.nurseaid.message;

import java.util.HashMap;

public class MessageCode {
	
	HashMap<String, String[]> bundle = new HashMap();
	
	public MessageCode()
	{
		bundle.put("ERROR_LOGIN", new String[]{"error", "SOmething Went Wfong"});
		
		bundle.put("INFO_LOGIN", new String[]{"success", "Queue Created"});
	}
	
}
