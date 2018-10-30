package mapper;

import java.util.List;

import model.Course;


public interface CourseMapper {
	int addCourse(Course course);
	List<Course> findCourseList();
	int deleteCourseById(int id);
	int updateCourse(Course course); 
	Course findCourseById(int id);
}
