package controller.course;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CourseServiceImpl;


/**
 * Servlet implementation class FindCourse
 */
@WebServlet("/FindCourse")
public class FindCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCourse() {
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
		
		CourseServiceImpl couservice = new CourseServiceImpl();    
		//更新添加没有课程时跳出提醒去添加课程
		if(couservice.findCourseList().isEmpty()){
			String info = "现在还没有课程，请添加课程";
			request.setAttribute("info", info);
			request.getRequestDispatcher("adm_findcourse.jsp").forward(request, response);
		}
	
		request.setAttribute("courseList",couservice.findCourseList());	
		request.getRequestDispatcher("adm_findcourse.jsp").forward(request, response); //转发到adm_findcourse.jsp

	}

}
