package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;
import dao.DBconn;

public class CourseDaoImpl implements CourseDao {
	PreparedStatement statement = null;
	DBconn db = new DBconn();
	Connection connection = db.getConn();
	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO "
				+ "course_table(coursename,courseid,teacher,classroom,lesson,credit,maxnum) "
				+ "values(?,?,?,?,?,?,?)";	
		try{
			statement = connection.prepareStatement(sql);	
			statement.setString(1, course.getCourseName());
			statement.setInt   (2, course.getCourseId());
			statement.setString(3, course.getTeacher());
			statement.setString(4, course.getClassRoom());
			statement.setInt   (5, course.getLesson());
			statement.setInt   (6, course.getCredit());
			statement.setInt   (7, course.getMaxNum());
			
			int rs = statement.executeUpdate();      
			if(rs>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	@Override
	public List<Course> findCourseList() {
		// TODO Auto-generated method stub
		
		List<Course> listCou = new ArrayList<Course>();
		String sql ="SELECT * FROM course_table";        
		try {
			statement=connection.prepareStatement(sql);
			ResultSet rs =statement.executeQuery();	            
			while (rs.next()) {	                          
				Course course = new Course();
				
				course.setCourseName(rs.getString("coursename"));
				course.setCourseId(rs.getInt("courseid"));
				course.setTeacher(rs.getString("teacher"));
				course.setClassRoom(rs.getString("classroom"));
				course.setLesson(rs.getInt("lesson"));
				course.setCredit(rs.getInt("credit"));
				course.setMaxNum(rs.getInt("maxnum"));
			
				listCou.add(course);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(listCou.size()==0){
			
			return null;
		};
		return listCou;
	}
	
public Course findCourseById(int id) {
		
		Course course = null;
		String sql ="SELECT * FROM course_table where courseid=?"; 
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id); 
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {	                         
				course = new Course();
				course.setCourseName(rs.getString("coursename"));
				course.setCourseId(rs.getInt("courseid"));
				course.setTeacher(rs.getString("teacher"));
				course.setClassRoom(rs.getString("classroom"));
				course.setLesson(rs.getInt("lesson"));
				course.setCredit(rs.getInt("credit"));
				course.setMaxNum(rs.getInt("maxnum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}
	
	public boolean deleteCourseById(int id) {
		
		String sql ="delete from course_table where courseid=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			int rs=statement.executeUpdate();
			if(rs>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean updateCourse(Course course) {
		
		String sql ="update course_table set coursename=?,teacher=?,classroom=?,lesson=?,credit=?,maxnum=? where courseid=?";
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, course.getCourseName());
			statement.setString(2, course.getTeacher());
			statement.setString(3, course.getClassRoom());
			statement.setInt(4, course.getLesson());
			statement.setInt(5, course.getCredit());
			statement.setInt(6, course.getMaxNum());
			statement.setInt(7, course.getCourseId());
			int rs = statement.executeUpdate();       
			if(rs>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	
	
}
