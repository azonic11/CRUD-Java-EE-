package Controllers;


import DbObjects.Author;
import Dao.AuthorDao;
import Dao.AuthorDao;
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


public class AuthorController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/authorEdit.jsp";
    private static String LIST_AUTHOR = "/authorList.jsp";
    private AuthorDao dao;

    public AuthorController() {
        super();
        dao = new AuthorDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")){
            int authorId = Integer.parseInt(request.getParameter("authorId"));
            dao.deleteAuthor(authorId);
            forward = LIST_AUTHOR;
            request.setAttribute("authors", dao.getAllAuthor());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int authorId = Integer.parseInt(request.getParameter("authorId"));
            Author author = dao.getAuthorById(authorId);
            request.setAttribute("author", author);
        } else if (action.equalsIgnoreCase("listAuthors")){
            forward = LIST_AUTHOR;
            request.setAttribute("authors", dao.getAllAuthor());
        } else {
            forward = INSERT_OR_EDIT;
        }


        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Author author = new Author();
        author.setFirstName(request.getParameter("firstName"));
        author.setLastName(request.getParameter("lastName"));
      
        //parsing date from DD-MM-YYYY to YYYY-MM-DD
        try{
            DateTimeFormatter format = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );
            LocalDate localDate = LocalDate.parse(request.getParameter("date").toString(), format );
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(localDate.toString());
            author.setDate(date);
           
            
        }catch(Exception e){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String sDate =(request.getParameter("date").toString());
             
            try {
               Date d = format.parse(sDate);
                 author.setDate(d);
            } catch (ParseException ex) {
                Logger.getLogger(AuthorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        String authorid = request.getParameter("authorId");
        System.out.println("autor id in doPost is "+authorid);
        if(authorid == null || authorid.isEmpty())
        {
            dao.addAuthor(author);
        }
        else
        {
            author.setAuthorId(Integer.parseInt(authorid));
            dao.updateAuthor(author);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_AUTHOR);
        request.setAttribute("authors", dao.getAllAuthor());
        
        view.forward(request, response);
    }
}