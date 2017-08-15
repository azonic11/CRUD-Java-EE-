package Controllers;


import Dao.AuthorDao;
import Dao.BookAutorDao;
import DbObjects.Book;
import Dao.BookDao;
import Dao.BookDao;
import Dao.PublisherDao;
import DbObjects.BookAuthor;
import Utils.SetOfAuthors;
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


public class BookController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/bookEdit.jsp";
    private static String LIST_BOOK = "/bookList.jsp";
    private BookDao dao;
    private PublisherDao pubDao;
    private AuthorDao autDao;
    SetOfAuthors autList;
    public BookController() {
        super();
        dao = new BookDao();
        pubDao=new PublisherDao();
        autDao=new AuthorDao();
        autList=new SetOfAuthors();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")){
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            dao.deleteBook(bookId);
            forward = LIST_BOOK;
            request.setAttribute("books", dao.getAllBook());
            request.setAttribute("publishers",pubDao.getAllPublisher());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            Book book = dao.getBookById(bookId);
            request.setAttribute("default", new BookAutorDao().getAuthorIdByBookId(bookId));
            request.setAttribute("book", book);
            request.setAttribute("publishers", pubDao.getAllPublisher());
            request.setAttribute("authors",new SetOfAuthors().getAuthorsList() );
            request.setAttribute("autors1", autDao.getAllAuthor());
            
        } else if (action.equalsIgnoreCase("listBooks")){
            
        
            forward = LIST_BOOK;
            request.setAttribute("books", dao.getAllBook());
            request.setAttribute("publishers",pubDao.getAllPublisher());
            request.setAttribute("authors",new SetOfAuthors().getAuthorsList());
        } else {
            forward = INSERT_OR_EDIT;
        }
       // SetOfAuthors autList=new SetOfAuthors();
       // System.out.println("autorys "+autList.getAuthorsList().get(1).toString());
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book();
        BookAuthor ba1=new BookAuthor();
         BookAuthor ba2=new BookAuthor();
        try{
            book.setTitle(request.getParameter("title"));
            book.setPublisherId(Integer.parseInt(request.getParameter("publisherId")));
           
            book.setNumOfPage(Integer.parseInt(request.getParameter("numOfPage")));
            book.setPrice(Float.parseFloat(request.getParameter("price").replaceAll(",",".")));
            book.setDescription(request.getParameter("description"));
            
            System.out.println(request.getParameter("autor1"));
            new BookAutorDao().deleteBookAutho(Integer.parseInt(request.getParameter("bookId")));
            if(Integer.parseInt(request.getParameter("autor1"))!=0){
                ba1.setAuthorId(Integer.parseInt(request.getParameter("autor1")));
                ba1.setBookId(Integer.parseInt(request.getParameter("bookId")));
                new BookAutorDao().addBookAutor(ba1);
            }
            
            if(Integer.parseInt(request.getParameter("autor2"))!=0){
                ba2.setAuthorId(Integer.parseInt(request.getParameter("autor2")));
                ba2.setBookId(Integer.parseInt(request.getParameter("bookId")));
                new BookAutorDao().addBookAutor(ba2);
            }
            
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        String bookid = request.getParameter("bookId");
        System.out.println("book id in doPost is "+bookid);
        if(bookid == null || bookid.isEmpty())
        {
            dao.addBook(book);
        }
        else
        {
            book.setBookId(Integer.parseInt(bookid));
            dao.updateBook(book);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_BOOK);
        request.setAttribute("books", dao.getAllBook());
        request.setAttribute("publishers",pubDao.getAllPublisher());
        request.setAttribute("autors1",autDao.getAllAuthor());
        request.setAttribute("authors",autList.getAuthorsList() );

        
        view.forward(request, response);
    }
}