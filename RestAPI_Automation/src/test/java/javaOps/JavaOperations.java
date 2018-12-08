package javaOps;

import java.util.HashMap;

public class JavaOperations {

	private String timezone;
	private float latitude;
	private float longitude;
	private HashMap<String,String> minutely;
	private HashMap<String,String> hourly;
	private HashMap<String,String> daily;
	private HashMap<String,String> flags;
	private HashMap<String,String> currently;
	private int offset;
	
	public float getLatitude(){
		return latitude;
	}
	public float getLongitude(){
		return longitude;
	}
	public String gettimezone(){
		return timezone;
	}
	public HashMap<String,String> getMinutely(){
		return minutely;
	}
	public HashMap<String,String> getHourly(){
		return hourly;
	}
	public HashMap<String,String> getCurrently(){
		return currently;
	}
	public HashMap<String,String> getDaily(){
		return daily;
	}
	public HashMap<String,String> getFlags(){
		return flags;
	}
	public int getOffset(){
		return offset;
	}
}
