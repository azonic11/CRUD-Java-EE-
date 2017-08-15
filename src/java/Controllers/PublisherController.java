package Controllers;


import DbObjects.Publisher;
import Dao.PublisherDao;
import Dao.PublisherDao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PublisherController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/publisherEdit.jsp";
    private static String LIST_PUBLISHER = "/publisherList.jsp";
    private PublisherDao dao;

    public PublisherController() {
        super();
        dao = new PublisherDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")){
            int publisherId = Integer.parseInt(request.getParameter("publisherId"));
            dao.deletePublisher(publisherId);
            forward = LIST_PUBLISHER;
            request.setAttribute("publishers", dao.getAllPublisher());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int publisherId = Integer.parseInt(request.getParameter("publisherId"));
            Publisher publisher = dao.getPublisherById(publisherId);
            request.setAttribute("publisher", publisher);
        } else if (action.equalsIgnoreCase("listPublisher")){
            forward = LIST_PUBLISHER;
            request.setAttribute("publishers", dao.getAllPublisher());
        } else {
            forward = INSERT_OR_EDIT;
        }


        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Publisher publisher = new Publisher();
        publisher.setName(request.getParameter("name"));
        publisher.setAdress(request.getParameter("adress"));
        publisher.setPhoneNumber(request.getParameter("phoneNumber"));
       
        
        
        String publisherid = request.getParameter("publisherId");
        System.out.println("autor id in doPost is "+publisherid);
        if(publisherid == null || publisherid.isEmpty())
        {
            dao.addPublisher(publisher);
        }
        else
        {
            publisher.setPublisherId(Integer.parseInt(publisherid));
            dao.updatePublisher(publisher);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PUBLISHER);
        request.setAttribute("publishers", dao.getAllPublisher());
        view.forward(request, response);
    }
}