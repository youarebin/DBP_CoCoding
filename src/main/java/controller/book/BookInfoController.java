package controller.book;

import model.domain.Book;
import model.service.BookManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class BookInfoController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        BookManager bookMgr = BookManager.getInstance();
        
        int bookId = Integer.parseInt(request.getParameter("id"));
      
        try {
            Book bookDetail = bookMgr.getBookDetail(bookId);
            
            if(bookDetail.getBookImg() == null || bookDetail.getBookImg().isEmpty()) {
                bookDetail.setBookImg("images/noimage.png");
            }

            request.setAttribute("bookDetail", bookDetail);
            return "/book/BookDetail.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "오류가 발생했습니다: " + e.getMessage());
            return "/book/list.jsp";
        }
    }
    
}
