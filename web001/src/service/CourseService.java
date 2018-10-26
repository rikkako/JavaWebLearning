package service;

import java.util.List;

import model.Course;

public interface CourseService {
	public boolean addCourse(Course course);
	public boolean deleteCourseById(int id);
	public List<Course> findCourseList();
	public boolean updateCourse(Course course);
	public Course findCourseById(int id);
}
