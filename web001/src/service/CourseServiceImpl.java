package service;

import java.util.List;

import dao.CourseDaoImpl;
import model.Course;

public class CourseServiceImpl implements CourseService {
	CourseDaoImpl couDao = new CourseDaoImpl();
	public boolean addCourse(Course course) {
		// TODO �Զ����ɵķ������
		return couDao.addCourse(course);
	}

	public boolean deleteCourseById(int id) {
		// TODO �Զ����ɵķ������
		return couDao.deleteCourseById(id);
	}

	public List<Course> findCourseList() {
		return couDao.findCourseList();
		// TODO �Զ����ɵķ������
		
	}

	public boolean updateCourse(Course course) {
		// TODO �Զ����ɵķ������
		return couDao.updateCourse(course);
	}

	@Override
	public Course findCourseById(int id) {
		// TODO �Զ����ɵķ������
		return couDao.findCourseById(id);
	}


	

	

}
