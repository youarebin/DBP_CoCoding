package controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.dao.BookDAO;
import model.domain.Book;
import model.domain.RegistrationEntity;

public class RegisterBookController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 현재 세션에서 사용자 정보 가져오기
        HttpSession session = request.getSession();
        Integer customerId = (Integer) session.getAttribute("customerId");
        
        if (customerId == null) {
            return "redirect:/user/login"; // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
        }
        
        
        try {
            Book book = new Book();
            book.setBookTitle(request.getParameter("bookTitle"));
            book.setCategory(request.getParameter("category"));
            book.setAuthor(request.getParameter("author")); 
            book.setPublisher(request.getParameter("publisher"));
            book.setPublishedDate(request.getParameter("publishedDate"));
            book.setDescription(request.getParameter("description"));
            book.setBookImg(request.getParameter("bookImg")); 

            // RegistrationEntity 정보 생성
            RegistrationEntity registration = new RegistrationEntity();
            registration.setCustomerId(customerId); // 세션에서 가져온 사용자 ID
            registration.setRegistrationDate(request.getParameter("registrationDate")); // 폼에 추가 필요
            registration.setDesiredLocation(request.getParameter("desiredLocation"));
            registration.setUsagePeriod(request.getParameter("usagePeriod"));
            registration.setDesiredPrice(request.getParameter("desiredPrice"));
            
            BookDAO bookDAO = new BookDAO();
            int result = bookDAO.create(book, registration);
            
            if (result > 0) {
                return "redirect:/user/myPage"; // 성공 시 마이페이지로 리다이렉트
            } else {
                request.setAttribute("error", "책 등록에 실패했습니다.");
                return "/book/BookRegisterForm.jsp"; // 실패 시 등록 폼으로 돌아감
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "오류가 발생했습니다: " + e.getMessage());
            return "/book/registerForm.jsp";
        }
        
    }
}