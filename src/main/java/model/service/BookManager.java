package model.service;

import model.domain.Book;

import java.sql.SQLException;
import java.util.List;
import model.dao.BookDAO;

public class BookManager {
    private static BookManager bookMgr = new BookManager();
    private BookDAO bookDAO;
    
    private BookManager() {
        try {
            bookDAO = new BookDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static BookManager getInstance() {
        return bookMgr;
    }
    
    public int createBook(Book book) throws SQLException {
        return bookDAO.create(book);
    }
    
    public int updateBook(Book book) throws SQLException {
        return bookDAO.update(book);
    }
    
    public int deleteBook(String bookId) throws SQLException {
        return bookDAO.delete(bookId);
    }
    
    public List<Book> findBookList() {
        return bookDAO.getBookList();
    }
    
    public List<Book> findPurchasedBookList(int customerId) {
        return bookDAO.getPurchasedBookList(customerId);
    }
    
    public List<Book> findSoldBookList(int customerId) {
        return bookDAO.getSoldBookList(customerId);
    }
    
    public Book getBookDetail(int bookId) {
        return bookDAO.getBookInfo(bookId);
    }
}