package controller;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import entity.Classroom;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class CreateClassRoom extends HttpServlet {


    private static BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    private static ImagesService imagesService = ImagesServiceFactory.getImagesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/classroom/form.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Classroom classroom = new Classroom(name, description);



        Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        List<BlobKey> blobKeys = blobs.get("myFile");
        if (blobKeys != null && blobKeys.size() > 0) {
            ServingUrlOptions servingUrlOptions = ServingUrlOptions.Builder.withBlobKey(blobKeys.get(0));
            classroom.setImageUrl(imagesService.getServingUrl(servingUrlOptions));
        }else {

        }


        HashMap<String, String> errors = classroom.validate();
        if(errors.size()==0){
            ofy().save().entity(classroom).now();
            resp.sendRedirect("/classroom/list");
        }else {
            req.setAttribute("room",classroom);
            req.setAttribute("errors",errors);
            req.getRequestDispatcher("/classroom/form.jsp").forward(req,resp);
        }


    }
}
