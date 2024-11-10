package model.domain;

public class BookEntity {
	private int bookId;
    private String bookTitle;
    private String category;
    private String author;
    private String publisher;
    private String publishedDate;
    private String description;
    private String bookImg;
    
	public BookEntity() { }
	
	// 소속 대학, 사용감도 추가하면 어떨지?
	public BookEntity(int bookId, String bookTitle, String category, String author, String publisher, String publishedDate, String description, String bookImg) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.category = category;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.description = description;
		this.bookImg = bookImg;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBookImg() {
		return bookImg;
	}

	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}
	
	
}