package controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.Controller;
import model.service.BookManager;
import model.domain.Book;

public class RegisterBookController implements Controller {

    private static final String UPLOAD_DIR = "upload"; // 책 이미지 업로드 디렉토리

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BookManager bookMgr = BookManager.getInstance();

        try {
            // Book 객체 생성
            Book book = new Book();

            // 폼 파라미터로부터 책 정보 가져오기
            book.setBookTitle(request.getParameter("bookTitle"));
            book.setCategory(request.getParameter("category"));
            book.setAuthor(request.getParameter("author"));
            book.setPublisher(request.getParameter("publisher"));

            // publishedDate 문자열을 Date 타입으로 변환
            String publishedDateStr = request.getParameter("publishedDate");
            if (publishedDateStr != null && !publishedDateStr.isEmpty()) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date publishedDate = formatter.parse(publishedDateStr);
                book.setPublishedDate(publishedDate);
            }

            // 책 이미지 처리
            Part filePart = request.getPart("bookImg");
            String fileName = getFileName(filePart);
            String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;

            // 업로드 디렉토리 생성
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            // 파일 저장
            String bookImgPath = null;
            if (fileName != null && !fileName.isEmpty()) {
                filePart.write(uploadPath + File.separator + fileName);
                bookImgPath = fileName;
                book.setBookImg(bookImgPath); // Book 객체에 이미지 경로 설정
            }

            // 나머지 책 정보 설정
            book.setDesiredLocation(request.getParameter("desiredLocation"));
            book.setDesiredPrice(request.getParameter("desiredPrice"));
            book.setUsagePeriod(request.getParameter("usagePeriod"));

            // 책 등록
            int result = bookMgr.createBook(book);

            if (result > 0) { // 성공 시 마이페이지로 리다이렉트
                return "redirect:/user/myPage";
            } else { // 실패 시 등록 폼으로 돌아감
                request.setAttribute("error", "책 등록에 실패했습니다.");
                return "/book/BookRegisterForm.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "오류가 발생했습니다: " + e.getMessage());
            return "/book/BookRegisterForm.jsp";
        }
    }

    // 파일 이름을 추출하는 메서드
    private String getFileName(Part part) {
        String header = part.getHeader("content-disposition");
        for (String cd : header.split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf("\\") + 1); // 파일 경로 제외하고 파일명만 반환
            }
        }
        return null;
    }
}
