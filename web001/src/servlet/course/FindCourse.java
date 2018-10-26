package servlet.course;

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
		
		CourseServiceImpl couservice = new CourseServiceImpl();    //ʵ����ѧ��ҵ�����
		//�������û�пγ�ʱ��������ȥ��ӿγ�
		if(couservice.findCourseList() == null){
			String info = "���ڻ�û�пγ̣�����ӿγ�";
			request.setAttribute("info", info);
			request.getRequestDispatcher("adm_findcourse.jsp").forward(request, response);
		}
		////��ȡѧ����Ϣ����ӵ�request����
		request.setAttribute("courseList",couservice.findCourseList());	
		request.getRequestDispatcher("adm_findcourse.jsp").forward(request, response); //ת����adm_findcourse.jsp
	}

}
