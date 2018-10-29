package service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

//import dao.CourseDaoImpl;
import mapper.CourseMapper;
import mapper.SqlSessionFactoryUtils;
import model.Course;

public class CourseServiceImpl implements CourseService {
//	CourseDaoImpl couDao = new CourseDaoImpl();
	
	private SqlSession sqlSession = null; 
	private CourseMapper cMapper;
	public boolean addCourse(Course course) {

		int result = 0;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			cMapper = sqlSession.getMapper(CourseMapper.class);
			result = cMapper.addCourse(course);
			sqlSession.commit();
			
        } catch (Exception e) {
            e.printStackTrace();
        } finally {            
        	if (sqlSession != null) {
                sqlSession.close();
            }
        }
		
		if(result>0){
			return true;
		}
		return false;
	}

	public boolean deleteCourseById(int id) {

		int result = 0;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			cMapper = sqlSession.getMapper(CourseMapper.class);
			result = cMapper.deleteCourseById(id);
			sqlSession.commit();
			
        } catch (Exception e) {
            e.printStackTrace();
        } finally {            
        	if (sqlSession != null) {
                sqlSession.close();
            }
        }
		
		if(result>0) return true;
		
		return false;
		//return couDao.deleteCourseById(id);
	}

	public List<Course> findCourseList() {
		List<Course> cList = new ArrayList<Course>();
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			cMapper = sqlSession.getMapper(CourseMapper.class);
			cList = cMapper.findCourseList();
			sqlSession.commit();
			
        } catch (Exception e) {
            e.printStackTrace();
        } finally {            
        	if (sqlSession != null) {
                sqlSession.close();
            }
        }
		
		return cList;
		//return couDao.findCourseList();
		
	}

	public boolean updateCourse(Course course) {
		int result = 0;
		try{
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			cMapper = sqlSession.getMapper(CourseMapper.class);
			result = cMapper.updateCourse(course);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
                sqlSession.close();
            }
		}
		
		if(result>0) return true;
		return false;
		//return couDao.updateCourse(course);
	}

	@Override
	public Course findCourseById(int id) {
		Course course = new Course();
		try{
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			cMapper = sqlSession.getMapper(CourseMapper.class);
			course = cMapper.findCourseById(id);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (sqlSession != null) {
                sqlSession.close();
            }
		}
		
		return course;
		//return couDao.findCourseById(id);
	}


	

	

}
