package model.domain;

import java.util.Date;

public class BookApplicant {
    private int bookApplyId;
    private int bookId;
    private int customerId;
    private String name;
    private String email;
    private Date applicationDate;
    private String desiredPrice;
    private String desiredLocation;
    private String description;
    
    public BookApplicant(int bookId, int customerId, String name, String email, Date applicationDate,
            String desiredPrice, String desiredLocation, String description) {
        super();
        this.bookId = bookId;
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.applicationDate = applicationDate;
        this.desiredPrice = desiredPrice;
        this.desiredLocation = desiredLocation;
        this.description = description;
    }

    public BookApplicant(int bookApplyId, int bookId, int customerId, Date applicationDate, String desiredPrice,
            String desiredLocation, String description) {
        super();
        this.bookApplyId = bookApplyId;
        this.bookId = bookId;
        this.customerId = customerId;
        this.applicationDate = applicationDate;
        this.desiredPrice = desiredPrice;
        this.desiredLocation = desiredLocation;
        this.description = description;
    }

    public int getBookApplyId() {
        return bookApplyId;
    }

    public void setBookApplyId(int bookApplyId) {
        this.bookApplyId = bookApplyId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getDesiredPrice() {
        return desiredPrice;
    }

    public void setDesiredPrice(String desiredPrice) {
        this.desiredPrice = desiredPrice;
    }

    public String getDesiredLocation() {
        return desiredLocation;
    }

    public void setDesiredLocation(String desiredLocation) {
        this.desiredLocation = desiredLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}