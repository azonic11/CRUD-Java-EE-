package Controllers;


import DbObjects.Book;
import Dao.BookDao;
import Dao.BookDao;
import Dao.MainInfoDao;
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


public class MainInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;
   
    private static String LIST_BOOK = "/mainInfoList.jsp";
    private MainInfoDao dao;
    
    public MainInfo() {
        super();
        dao = new MainInfoDao();
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
      
           
            forward = LIST_BOOK;
            request.setAttribute("XXX", dao.getMainInfo());
            System.out.println(dao.getMainInfo().size());

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    }
}