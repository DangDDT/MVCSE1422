package dangddt.cart;


import dangddt.book.BookDAO;
import dangddt.book.BookDTO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tamda
 */
public class CartObject implements Serializable{
    private Map<String, BookDTO> items;
    public CartObject() {
        
    }
    public Map<String, BookDTO> getItems() {
        return items;
    }
    
    public void addItemToCart(BookDTO dto){
        if (null == this.items){
            this.items = new HashMap<>();
        }
        int quantity = 1;
        if (this.items.containsKey(dto.getBookId())){
            quantity = items.get(dto.getBookId()).getQuantity() + 1;
            items.get(dto.getBookId()).setQuantity(quantity);
        } else{
            this.items.put(dto.getBookId(),dto);
        }
        this.items.put(dto.getBookId(),items.get(dto.getBookId()));
    }
    public void removeItemFromCart(BookDTO dto){
        if (this.items == null){
            return;
        }
        if (this.items.containsKey(dto.getBookId())){
            this.items.remove(dto.getBookId());
            if (this.items.isEmpty()){
                this.items = null;
            }
        }
    }
    public void decreaseQuantityItemFromCart(BookDTO dto){
        if (this.items == null){
            return;
        }
        if (this.items.containsKey(dto.getBookId())){
            int quantity = items.get(dto.getBookId()).getQuantity();
            items.get(dto.getBookId()).setQuantity(quantity--);
            items.put(dto.getBookId(), items.get(dto.getBookId()) );
            if (this.items.get(dto.getBookId()).getQuantity() == 0){
                items.remove(dto.getBookId());
            }
            if (this.items.isEmpty()){
                this.items = null;
            }
        }
    }

    public void increaseQuantityItemFromCart(BookDTO dto) {
        if (this.items == null){
            return;
        }
        if (this.items.containsKey(dto.getBookId())){
            int quantity = items.get(dto.getBookId()).getQuantity();
            items.get(dto.getBookId()).setQuantity(quantity++);
            items.put(dto.getBookId(), items.get(dto.getBookId()) );
            if (this.items.get(dto.getBookId()).getQuantity() == 0){
                items.remove(dto.getBookId());
            }
            if (this.items.isEmpty()){
                this.items = null;
            }
        }
    }
}
