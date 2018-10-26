package service;

import java.util.List;

import dao.CourseDaoImpl;
import model.Course;

public class CourseServiceImpl implements CourseService {
	CourseDaoImpl couDao = new CourseDaoImpl();
	public boolean addCourse(Course course) {

		return couDao.addCourse(course);
	}

	public boolean deleteCourseById(int id) {

		return couDao.deleteCourseById(id);
	}

	public List<Course> findCourseList() {
		return couDao.findCourseList();
		
	}

	public boolean updateCourse(Course course) {

		return couDao.updateCourse(course);
	}

	@Override
	public Course findCourseById(int id) {

		return couDao.findCourseById(id);
	}


	

	

}
