package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.book.*;
import controller.user.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
        mappings.put("/", new ForwardController("index.jsp"));
        
        //user
        mappings.put("/user/updateUser", new UpdateUserController());
         //마이 페이지
        mappings.put("/user/myPage", new ForwardController("/my_page/MyPg.jsp"));
        
        //책 등록 폼 요청 request URI 추가
        mappings.put("/book/register/form", new ForwardController("/book/BookRegisterForm.jsp"));
        mappings.put("/book/register", new RegisterBookController());
        
        //책 신청 폼 요청 request URI 추가
        mappings.put("/book/apply/form", new ForwardController("/book/BookApplyForm.jsp"));
        mappings.put("/book/apply", new ApplyBookController());
        
        //책 리스트 페이지 request URI 추가
        mappings.put("/book/list", new ListBookController());
        
        //구매한 책 리스트 페이지
        mappings.put("/book/purchased/list", new PurchasedBookListController());
        
        //판매한 책 리스트 페이지
        mappings.put("/book/sold/list", new SoldBookListController());
        
        //책 상세 페이지
        mappings.put("/book/detail", new BookInfoController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}