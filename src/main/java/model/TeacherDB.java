package model;

import java.sql.*;
import java.util.ArrayList;

public class TeacherDB {
	private static String url = "jdbc:mysql://localhost:3306/example";
    private static String username = "root";
    private static String password = "root";
    private static String subjectName;
    private static int group;
    private static ArrayList<Integer> groups;
    
    public TeacherDB(String id, int idx) {
    	 groups = new ArrayList<>();
    	System.out.print(id);
    	String [] tmp= id.split("_");
    	TeacherDB.subjectName=tmp[0];
    	for(int i=0;i<tmp.length;i++) {
    	if(i!=0)
    		groups.add(Integer.parseInt(tmp[i]));
    	}
    	if(idx==0)
    		TeacherDB.group=groups.get(idx);
    	else
    		TeacherDB.group=idx;
    }
    
    public int getGroup(int idx) {
    	return groups.get(idx);
    }
    
    public int getNumberGroup() {
    	return groups.size();
    }
    public ArrayList<Teacher> select() {
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        try{
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
            	Statement statement = conn.createStatement();
                ResultSet list = statement.executeQuery("SHOW TABLES;");
                ArrayList<String> stTables=new ArrayList<String>();
                while(list.next()){
                		if(list.getString(1).contains(Integer.toString(group))){
                			stTables.add(list.getString(1));
                		}
                }
                for(int i=0; i<stTables.size();i++) {
                	ResultSet resultSet = statement.executeQuery("SELECT * FROM "+ stTables.get(i)+ " WHERE subject='"+subjectName+"';");
                	String [] tmp= stTables.get(i).split("_");
                	char[] tmpChar;
                	StringBuilder stName = new StringBuilder();
                	for (int j=0;j<2;j++) {
                	tmpChar = tmp[j].toCharArray();
                	tmpChar[0] = Character.toUpperCase(tmpChar[0]);
                	stName.append(tmpChar);
                	stName.append(" ");
                	}
                	Teacher t = new Teacher(stName.toString());
                	int k=2;
                	while(resultSet.next()){
                		while(k<12) {
                			int mark = resultSet.getInt(k);
                			t.setMark(mark);
                			k++;
                		}
                	}
                	teachers.add(t);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return teachers;
    }
     
    public static int update(String stName, int group, int mark) {
        try{
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
            	String [] tmp= stName.split(" ");
    			String stId=tmp[0]+"_"+tmp[1]+"_"+Integer.toString(group);
                String sql = "UPDATE "+ stId +"SET mark = ? WHERE subject = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, mark);
                    preparedStatement.setString(2, subjectName);
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

}