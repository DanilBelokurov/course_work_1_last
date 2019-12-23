package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private String id;
    private String subject;
    private ArrayList<Integer> mark = new ArrayList<Integer>();
     
    public Student(){ }
    
    public Student(String subject){
        this.subject = subject;
    }
 
    public String getId() {
        return id;
    }
     
    public String getSubject() {
        return subject;
    }
 
    public void setSubject(String subject) {
        this.subject = subject;
    }
 
    public ArrayList<Integer> getMark() {
        return  mark;
    }
 
    public void setMark(String  mark) {
    	//System.out.println(mark);
        if(mark!=null) {
        	String[] tmp= mark.split(" ");
        	this.mark.add( Integer.parseInt(tmp[0]));
        }
    }
}