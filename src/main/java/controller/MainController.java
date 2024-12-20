package controller;

import model.dto.BookDTO;
import model.dao.BookDAO;
import model.domain.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MainController {
    private final BookDAO bookDAO = new BookDAO();

    public String loadMainPage(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        
        // 로그인된 사용자 정보 가져오기
        String username = (String) session.getAttribute("loggedInUser");
        if (username != null) {
            request.setAttribute("username", username);
        }

        // 추천 도서 목록 불러오기
        List<BookDTO> recommendedBooks = bookDAO.getRecommendedBooks();
        request.setAttribute("recommendedBooks", recommendedBooks);

        // Main 페이지로 이동
        return "/WEB-INF/Main.jsp";
    }

    public String searchBooks(HttpServletRequest request, HttpServletResponse response) {
        String query = request.getParameter("query");

        if (query == null || query.trim().isEmpty()) {
            request.setAttribute("error", "검색어를 입력해주세요.");
            return "/WEB-INF/user/Main.jsp"; // 에러 메시지와 함께 메인 페이지로 이동
        }

        // 검색 결과 가져오기
        List<Book> searchResults = bookDAO.searchBook(query);
        request.setAttribute("searchResults", searchResults);

        // 검색 결과를 표시하는 페이지로 이동
        return "/WEB-INF/book/SearchResults.jsp";
    }
}
