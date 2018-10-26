package service;

import java.util.List;

import dao.CourseDaoImpl;
import model.Course;

public class CourseServiceImpl implements CourseService {
	CourseDaoImpl couDao = new CourseDaoImpl();
	public boolean addCourse(Course course) {
		// TODO 自动生成的方法存根
		return couDao.addCourse(course);
	}

	public boolean deleteCourseById(int id) {
		// TODO 自动生成的方法存根
		return couDao.deleteCourseById(id);
	}

	public List<Course> findCourseList() {
		return couDao.findCourseList();
		// TODO 自动生成的方法存根
		
	}

	public boolean updateCourse(Course course) {
		// TODO 自动生成的方法存根
		return couDao.updateCourse(course);
	}

	@Override
	public Course findCourseById(int id) {
		// TODO 自动生成的方法存根
		return couDao.findCourseById(id);
	}


	

	

}
