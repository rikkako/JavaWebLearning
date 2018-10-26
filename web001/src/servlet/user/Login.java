package servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		User user = new User();
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		if( userid == null || "".equals(userid)){
			request.setAttribute("errorinfo", "�û�id����Ϊ��");          // ���ô�������
			request.getRequestDispatcher("adm_editcourse.jsp").forward(request, response);
		}
		if( password == null || "".equals(password)){
			request.setAttribute("errorinfo", "���벻��Ϊ��");          // ���ô�������
			request.getRequestDispatcher("adm_editcourse.jsp").forward(request, response);
		}
		
		UserServiceImpl userservice = new UserServiceImpl();
		user.setUserId(Integer.valueOf(request.getParameter("userid")));
		user.setPassword(request.getParameter("password"));
		user.setUserType(Integer.valueOf(request.getParameter("usertype")));
		StringBuffer info = new StringBuffer();
		if(userservice.login()){
			info.append("��½�ɹ�");
			int type = Integer.valueOf(request.getParameter("usertype"));
			switch(type){
			case 1:
				request.getSession().setAttribute("user", user);
				response.sendRedirect("administrator.jsp");
				break;
			case 2:
				
			case 3:
				
				
			}
		}else{
			info.append("����ʧ��");
			request.setAttribute("info", info);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

}
