package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain Chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request = (HttpServletRequest) Request;
        HttpServletResponse response = (HttpServletResponse) Response;
        HttpSession session = request.getSession();

        //如果是login.jsp，则不拦截，直接放行，不用进行其他操作
        if(request.getRequestURI().indexOf("index.jsp")!=-1 
        		||request.getRequestURI().indexOf("Login")!=-1
        		||request.getRequestURI().indexOf("Register")!=-1){
        	Chain.doFilter(Request, Response);
            return ;
        }
        //因为登录后保存了username，所以可以先检查username判断是否登录
        if(session.getAttribute("username")!=null){
        	Chain.doFilter(Request, Response);//已登录，则放行，
        	return ;
        }else{
            response.sendRedirect("index.jsp");//未登录，重定向到登录页面
            return ;
        }
	}


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
