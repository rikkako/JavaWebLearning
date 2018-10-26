package dao;

import java.util.List;

import model.Course;

public interface CourseDao {
	public boolean addCourse(Course course);
	public List<Course> findCourseList();
	public boolean deleteCourseById(int id);
	public boolean updateCourse(Course course); 
	public Course findCourseById(int id);
}
