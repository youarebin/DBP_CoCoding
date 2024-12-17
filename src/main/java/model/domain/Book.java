package model.domain;

import java.util.Date;

public class Book {
    private int bookId;
    private String bookTitle;
    private String category;
    private String author;
    private String publisher;
    private Date publishedDate;
    private String bookImg;
    private int customerId;
    private String desiredLocation;
    private String desiredPrice;
    private String usagePeriod;
    
    public Book() { }
    
    public Book(int bookId, String bookTitle, String category, String author, String publisher,
            Date publishedDate, String bookImg, int customerId, String desiredLocation, String desiredPrice,
            String usagePeriod) {
        super();
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.category = category;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.bookImg = bookImg;
        this.customerId = customerId;
        this.desiredLocation = desiredLocation;
        this.desiredPrice = desiredPrice;
        this.usagePeriod = usagePeriod;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public String getDesiredLocation() {
        return desiredLocation;
    }

    public void setDesiredLocation(String desiredLocation) {
        this.desiredLocation = desiredLocation;
    }

    public String getDesiredPrice() {
        return desiredPrice;
    }

    public void setDesiredPrice(String desiredPrice) {
        this.desiredPrice = desiredPrice;
    }

    public String getUsagePeriod() {
        return usagePeriod;
    }

    public void setUsagePeriod(String usagePeriod) {
        this.usagePeriod = usagePeriod;
    }
    
    
    
    
}