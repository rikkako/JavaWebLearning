package servlet.course;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		Course cou = new Course();   //实例化一个课程对象
		if(request.getParameter("course")=="" || request.getParameter("course_id") == "" || request.getParameter("teacher")==""
				|| request.getParameter("classroom")=="" ||request.getParameter("lesson")=="" || request.getParameter("credit")==""
				|| request.getParameter("max_num")=="" ){
			request.setAttribute("adderror", "添加失败，课程信息不能为空");          // 设置错误属性
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
			
			CourseServiceImpl couservice = new CourseServiceImpl();
			String info = "";
			if(couservice.addCourse(cou)){
				info = "添加成功！";
			} else {
				info = "添加失败课程id冲突！";
			}
			request.setAttribute("info", info);
			request.getRequestDispatcher("adm_addcourse.jsp").forward(request, response);
		}
		
	}

}
