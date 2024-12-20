package controller;

import model.dao.UserDAO;
import model.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/user/register")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50   // 50MB
)
public class RegisterUserController extends HttpServlet {
    private static final String UPLOAD_DIR = "profile_images";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 폼 데이터 가져오기
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String nickname = request.getParameter("nickname");
        String account = request.getParameter("account");

        // 프로필 이미지 처리
        Part filePart = request.getPart("profileImage");
        String fileName = getFileName(filePart);
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;

        // 업로드 디렉토리 생성
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // 파일 저장
        if (fileName != null && !fileName.isEmpty()) {
            filePart.write(uploadPath + File.separator + fileName);
        }

        // 저장된 프로필 이미지 경로
        String profileImagePath = UPLOAD_DIR + "/" + fileName;

        // DTO 객체 생성
        UserDTO user = new UserDTO();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phone);
        user.setNickname(nickname);
        user.setAccount(account);
        user.setProfileImage(profileImagePath);

        // DAO 호출
        UserDAO userDAO = new UserDAO();
        try {
            boolean isRegistered = userDAO.create(user);

            // 처리 결과에 따른 리다이렉트
            if (isRegistered) {
                response.sendRedirect("../../my_page/Main.jsp?success=register");
            } else {
                response.sendRedirect("Register.jsp?error=true");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Register.jsp?error=exception");
        }
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
    }
}
