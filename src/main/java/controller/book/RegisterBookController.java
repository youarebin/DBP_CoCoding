package controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.dao.BookDAO;
import model.domain.RegistrationEntity;

public class RegisterBookController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BookDAO bookDAO = new BookDAO();
        
        //POST
        RegistrationEntity registrationBook = new RegistrationEntity(
        Integer.parseInt(request.getParameter("bookId")),
        Integer.parseInt(request.getParameter("customerId")),
        request.getParameter("bookImg"),
        request.getParameter("publisher"),
        request.getParameter("category"),
        request.getParameter("registrationDate"),
        request.getParameter("desiredLocation"),
        request.getParameter("usagePeriod"),
        request.getParameter("desiredPrice"));
        
        bookDAO.create(registrationBook);
        return "redirect:/user/myPage";
        
    }
}