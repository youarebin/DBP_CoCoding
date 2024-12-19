package controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import controller.Controller;
import model.dao.BookDAO;
import model.domain.Book;

public class PurchasedBookListController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 현재 세션에서 사용자 정보 가져오기
        HttpSession session = request.getSession();
        Integer customerId = (Integer) session.getAttribute("customerId");
        
        if (customerId == null) {
            return "redirect:/user/login"; // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
        }
        
        BookDAO bookDAO = new BookDAO();
        List<Book> purchasedBookList = bookDAO.getPurchasedBookList(customerId);
        
        request.setAttribute("purchasedBookList", purchasedBookList);
        request.setAttribute("curUserId", customerId);
        
        return "/book/PurchasedBookList.jsp";
    }
}