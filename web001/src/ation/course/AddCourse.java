package ation.course;

import java.io.IOException;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.CourseMapper;
import model.Course;
import service.CourseServiceImpl;

/**
 * Servlet implementation class addCourseServlet
 */
@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Course cou = new Course();   
		if(request.getParameter("course")=="" || request.getParameter("course_id") == "" || request.getParameter("teacher")==""
				|| request.getParameter("classroom")=="" ||request.getParameter("lesson")=="" || request.getParameter("credit")==""
				|| request.getParameter("max_num")=="" ){
			request.setAttribute("adderror", "添加失败，课程信息不能为空");       
			request.getRequestDispatcher("adm_addcourse.jsp").forward(request, response);
		}
		else{
			//通过request获取form表单中的输入数据
			cou.setCourseName(request.getParameter("course"));
			cou.setCourseId(Integer.parseInt(request.getParameter("course_id")));
			cou.setTeacher(request.getParameter("teacher"));
			cou.setClassRoom(request.getParameter("classroom"));
			cou.setLesson(Integer.parseInt(request.getParameter("lesson")));
			cou.setCredit(Integer.parseInt(request.getParameter("credit")));
			cou.setMaxNum(Integer.parseInt(request.getParameter("max_num")));
			
			SqlSessionFactory sqlSessionFactory = null;
			int result = -1;
			try {
	            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
	            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			SqlSession sqlSession = null;        
			try {
				sqlSession = sqlSessionFactory.openSession();
				CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
				result = courseMapper.addCourse(cou);
				sqlSession.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {            
	        	if (sqlSession != null) {
	                sqlSession.close();
	            }
	        }
			
			String info = "";
			if(result == 1){
				info = "添加成功！";
			} else {
				info = "添加失败课程id冲突！";
			}
			request.setAttribute("info", info);
			request.getRequestDispatcher("adm_addcourse.jsp").forward(request, response);
		}
		
	}

}
