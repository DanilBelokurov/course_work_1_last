package model;

import java.util.ArrayList;

public class Teacher {
	
    private ArrayList<Integer> mark = new ArrayList<Integer>();
	private String student;
    
    public Teacher(String student){
        this.student = student;
    }
    
    public int numberOfMark() {
    	return mark.size();
    }
    
    public int getMark(int indx) {
		return mark.get(indx);
	}
    
	public void setMark(int mark) {
		if(mark!=0)
			this.mark.add(mark);
	}
	
	public String getStudent() {
		return student;
	}
}