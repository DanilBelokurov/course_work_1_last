package model;

import java.util.ArrayList;
import java.util.TreeMap;

public class Teacher {
	
	private TreeMap<String, Integer> mark=new TreeMap<>();
	private String student;
    
    public Teacher(String student){
        this.student = student;
    }
    public int numberOfMark() {
    	return mark.size();
    }
    public TreeMap<String, Integer> getMark() {
		return mark;
	}
	public void setMark(String mark) {
		if(mark!=null) {
		String[] tmp=mark.split(" ");
		int markInt=Integer.parseInt(tmp[0]);
		String data=tmp[1];
		this.mark.put(data, markInt);
		}
	}
	
	public String getStudent() {
		return student;
	}
}