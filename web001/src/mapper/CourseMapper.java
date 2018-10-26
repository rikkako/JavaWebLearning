package mapper;

import java.util.List;

import model.Course;


public interface CourseMapper {
	public int addCourse(Course course);
	public List<Course> findCourseList();
	public boolean deleteCourseById(int id);
	public boolean updateCourse(Course course); 
	public Course findCourseById(int id);
}
