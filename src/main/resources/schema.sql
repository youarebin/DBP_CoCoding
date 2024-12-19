-- DROP SEQUENCES
DROP SEQUENCE seq_book_id;
DROP SEQUENCE seq_customer_id;
DROP SEQUENCE seq_book_apply_id;

-- CREATE SEQUENCES
CREATE SEQUENCE seq_book_id
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

CREATE SEQUENCE seq_customer_id
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

CREATE SEQUENCE seq_book_apply_id
    START WITH 1
    INCREMENT BY 1
    NOCACHE;
	
-- DROP TABLES (CASCADE CONSTRAINTS 포함)
DROP TABLE CUSTOMER CASCADE CONSTRAINTS PURGE;
DROP TABLE BOOK CASCADE CONSTRAINTS PURGE;
DROP TABLE BOOKAPPLICANT CASCADE CONSTRAINTS PURGE;

-- CREATE TABLE CUSTOMER
CREATE TABLE CUSTOMER (
    customerId      NUMBER PRIMARY KEY, 
    id              VARCHAR2(50) NOT NULL,
    password        VARCHAR2(100) NOT NULL,
    email           VARCHAR2(100) NOT NULL,
    name            VARCHAR2(50) NOT NULL,
    nickname        VARCHAR2(50),
    account         VARCHAR2(50),
    phoneNumber     VARCHAR2(15),
    profileImg      VARCHAR2(255)
);

-- CREATE TABLE BOOK
CREATE TABLE BOOK (
    bookId          NUMBER(38) PRIMARY KEY,
    bookTitle       VARCHAR2(20) NOT NULL,
    category        VARCHAR2(20) NOT NULL,
    author          VARCHAR2(20) NOT NULL,
    publisher       VARCHAR2(20) NOT NULL,
    publishedDate   DATE NOT NULL,
    bookImg         VARCHAR2(255) NOT NULL,
    customerId      NUMBER(38) NOT NULL,
    desiredLocation VARCHAR2(100) NOT NULL,
    desiredPrice    NUMBER(10) NOT NULL,
    usagePeriod     VARCHAR2(100) NOT NULL,
    CONSTRAINT fk_customer FOREIGN KEY (customerId) REFERENCES CUSTOMER(customerId)
);

-- CREATE TABLE BOOKAPPLICANT
CREATE TABLE BOOKAPPLICANT (
    bookApplyId     NUMBER(38) PRIMARY KEY,
    bookId          NUMBER(38) NOT NULL,
    customerId      NUMBER(38) NOT NULL,
    applicationDate DATE,
    desiredPrice    NUMBER(10),
    desiredLocation VARCHAR2(100),
    description     VARCHAR2(200),
    CONSTRAINT fk_book FOREIGN KEY (bookId) REFERENCES BOOK(bookId),
    CONSTRAINT fk_applicant FOREIGN KEY (customerId) REFERENCES CUSTOMER(customerId)
);

-- CREATE TRIGGERS
CREATE OR REPLACE TRIGGER trg_customer_id
BEFORE INSERT ON CUSTOMER
FOR EACH ROW
BEGIN
    :NEW.customerId := seq_customer_id.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER trg_book_id
BEFORE INSERT ON BOOK
FOR EACH ROW
BEGIN
    :NEW.bookId := seq_book_id.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER trg_bookapplicant_id
BEFORE INSERT ON BOOKAPPLICANT
FOR EACH ROW
BEGIN
    :NEW.bookApplyId := seq_book_apply_id.NEXTVAL;
END;
/