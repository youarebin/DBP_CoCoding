package controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.text.SimpleDateFormat;

import controller.Controller;
import model.dao.BookDAO;
import model.domain.BookApplicant;

public class ApplyBookController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 현재 세션에서 사용자 정보 가져오기
        HttpSession session = request.getSession();
        Integer customerId = (Integer) session.getAttribute("customerId");
        
        if (customerId == null) {
            return "redirect:/user/login"; // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
        }
        
        //POST
        try {
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            
            BookApplicant applicant = new BookApplicant(
                    bookId,
                    customerId,
                    request.getParameter("name"),
                    request.getParameter("email"),
                    new Date(),// applicationDate (현재 날짜로 설정)
                    request.getParameter("desiredPrice"),
                    request.getParameter("desiredLocation"),
                    request.getParameter("description")
            );
            
            BookDAO bookDAO = new BookDAO();
            int result = bookDAO.insertApplicant(applicant);
            
            if (result > 0) { // 성공 시 마이페이지로 리다이렉트
                return "redirect:/user/myPage"; 
            } else { // 실패 시 등록 폼으로 돌아감
                request.setAttribute("error", "책 등록에 실패했습니다.");
                return "/book/BookApplyForm.jsp"; 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "오류가 발생했습니다: " + e.getMessage());
            return "/book/BookApplyForm.jsp";
        }
        
    }
}