/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangddt.book;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author tamda
 */
public class BookDTO implements Serializable{
    private String bookId;
    private String bookName;
    private float bookPrice;
    private String bookImg;
    private String bookDescription;

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public BookDTO() {
    }

    
    public BookDTO(String bookId, String bookName, float bookPrice, String bookImg, int quantity, String bookDescription) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookImg = bookImg;
        this.quantity = quantity;
        this.bookDescription= bookDescription;
    }
    public BookDTO(String bookId, String bookName, float bookPrice, String bookImg, int quantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookImg = bookImg;
        this.quantity = quantity;
    }
    /**
     * @return the bookId
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    /**
     * @return the bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName the bookName to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    /**
     * @return the bookPrice
     */
    public float getBookPrice() {
        return bookPrice;
    }

    /**
     * @param bookPrice the bookPrice to set
     */
    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    /**
     * @return the bookImg
     */
    public String getBookImg() {
        return bookImg;
    }

    /**
     * @param bookImg the bookImg to set
     */
    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    
}
