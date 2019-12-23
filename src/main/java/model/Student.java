package model;

import java.io.Serializable;

public class Student implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private String id;
    private String subject;
    private int mark;
     
    public Student(){ }
    
    public Student(String subject, int mark){
        this.subject = subject;
        this. mark =  mark;
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
 
    public int getMark() {
        return  mark;
    }
 
    public void setMark(int  mark) {
        this. mark =  mark;
    }
}