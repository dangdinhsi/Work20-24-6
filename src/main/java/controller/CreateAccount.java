package controller;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Ref;
import entity.Account;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class CreateAccount extends HttpServlet {


    private static BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    private static ImagesService imagesService = ImagesServiceFactory.getImagesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/account/form.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectifyService.register(Account.class);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = new Account();
        account.setUsername(username);
        try {
            account.passxuli(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        Student student = new Student();
        student.setFullName(req.getParameter("fullName"));
        student.setRollNumber(req.getParameter("rollNumber"));

        student.setAccountRef(Ref.create(account));
        account.setStudentRef(Ref.create(student));

        Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        List<BlobKey> blobKeys =blobs.get("myFile");
        if(blobKeys!=null && blobKeys.size()>0){
            ServingUrlOptions servingUrlOptions = ServingUrlOptions.Builder.withBlobKey(blobKeys.get(0));
            student.setAvatarUrl(imagesService.getServingUrl(servingUrlOptions));
        }

        ofy().save().entity(account).now();
        ofy().save().entity(student).now();
        resp.sendRedirect("/account/list");
    }
}
