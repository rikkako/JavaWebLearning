package action.user;

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
		int usertype = Integer.valueOf(request.getParameter("usertype"));
		if( usertype == 0){
			request.setAttribute("errorinfo", "请选择用户类型");         
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if( userid == null || "".equals(userid)){
			request.setAttribute("errorinfo", "用户id不能为空");         
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if( password == null || "".equals(password)){
			request.setAttribute("errorinfo", "密码不能为空");         
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		UserServiceImpl userservice = new UserServiceImpl();
		user.setUserId(request.getParameter("userid"));
		user.setPassword(request.getParameter("password"));
		user.setUserType(Integer.valueOf(request.getParameter("usertype")));
		String info = "";
		if(userservice.login(user) == 1){
			request.getSession().setAttribute("username", userservice.findName(userid));
			request.getSession().setAttribute("usertype", usertype);
			response.sendRedirect("administrator.jsp");
		}else{
			info = "登陆失败";
			request.setAttribute("info", info);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}

}
