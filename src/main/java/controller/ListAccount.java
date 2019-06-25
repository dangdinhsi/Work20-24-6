package controller;

import com.googlecode.objectify.ObjectifyService;
import entity.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class ListAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectifyService.register(Account.class);
        List<Account> list = ofy().load().type(Account.class).list();
        req.setAttribute("list",list);
        req.getRequestDispatcher("/account/list.jsp").forward(req,resp);

    }
}
