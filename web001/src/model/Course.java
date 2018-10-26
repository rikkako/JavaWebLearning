package model;

public class Course {
	/*
	 *<th>课程</th>        
	  <th>课程ID</th>          
	  <th>任课老师</th>
	  <th>上课地点</th>          
	  <th>课时</th>         
	  <th>学分</th>
	  <th>最大人数</th>
	  <th>操作</th> 
	  */
	private String courseName;
	private int    courseId;
	private String teacher;
	private String classRoom;
	private int    lesson;
	private int    credit;
	private int    maxNum;
	
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
	public int getLesson() {
		return lesson;
	}
	public void setLesson(int lesson) {
		this.lesson = lesson;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	
	

}
