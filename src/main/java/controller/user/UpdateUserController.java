package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.text.SimpleDateFormat;

import controller.Controller;
import model.dao.UserDAO;
import model.domain.User;


public class UpdateUserController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        if(request.getMethod().equals("GET")) {
            String customerId = (String) request.getSession().getAttribute("customerId");
            
            // DB에서 사용자 정보 가져오기
            UserDAO userDAO = new UserDAO();
            User user = userDAO.findUser(customerId);
            
            
            request.setAttribute("user", user);
            
            return "/my_page/MyPgEdit.jsp";
        }
        
        //POST
         User updateUser = new User(
                 request.getParameter("userId"),
                 request.getParameter("password"),
                 request.getParameter("name"),
                 request.getParameter("email"),
                 request.getParameter("nickName"),
                 request.getParameter("account"),
                 request.getParameter("phoneNumber"),
                 request.getParameter("profileImage")
                 );
         
         return "redirect:/user/myPage";
    }
}