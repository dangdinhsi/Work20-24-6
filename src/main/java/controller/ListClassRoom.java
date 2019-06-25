package controller;

import com.googlecode.objectify.ObjectifyService;
import entity.Classroom;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class ListClassRoom extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectifyService.register(Classroom.class);
        List<Classroom> list = ofy().load().type(Classroom.class).list();
        req.setAttribute("list",list);
        req.getRequestDispatcher("/classroom/list.jsp").forward(req,resp);
    }
}
