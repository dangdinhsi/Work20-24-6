package filter;

import com.googlecode.objectify.ObjectifyService;
import entity.Account;
import entity.Classroom;
import entity.Student;

import javax.servlet.*;
import java.io.IOException;

public class ObjectifyRegisterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        ObjectifyService.register(Account.class);
        ObjectifyService.register(Classroom.class);
        ObjectifyService.register(Student.class);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
