package com.hcr.swd392g3.project.controller;

import com.hcr.swd392g3.project.dto.MenuDTO;
import com.hcr.swd392g3.project.dto.TableDTO;
import com.hcr.swd392g3.project.entity.Cart;
import com.hcr.swd392g3.project.entity.CartItem;
import com.hcr.swd392g3.project.entity.Menu;
import com.hcr.swd392g3.project.entity.Table;
import com.hcr.swd392g3.project.service.IService.ICartService;
import com.hcr.swd392g3.project.service.IService.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;
//href="#!"
@RestController
@RequestMapping(path = "cart")
public class CartController {

    @Autowired
    HttpSession session;
    
    @Autowired
    ICartService cartService;
    
    @Autowired
    IMenuService menuService;


    @GetMapping("")
  public ModelAndView viewCart(Model model) {
      return new ModelAndView("cartpage");
  }
    
    
//    public Cart getCart(HttpSession session) {
//
//        Cart cart = (Cart) session.getAttribute("cart");
//        return cart;
//
//    }
//
//    public CartController(IMenuService menuService) {
//
//        this.menuService = menuService;
//    }
//
//
    @GetMapping("carts")
    public ResponseEntity<?> getAllCarts() {

//        Cart cart = new Cart();
//        cart.addItem(new CartItem(menuService.getMenuAllByID(1),1,1));
//        cart.addItem(new CartItem(menuService.getMenuAllByID(2),2,2));
//        cart.addItem(new CartItem(menuService.getMenuAllByID(3),3,3));
//        session.setAttribute("cart", cart);
        Cart cart = (Cart) session.getAttribute("cart");
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

    @PostMapping("addtocart/{id}")
    private ResponseEntity<?> addToCart(@PathVariable("id") int id) {
System.out.println(id);
        Cart cart = null;
        Object o = session.getAttribute("cart");
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }

        MenuDTO menu = menuService.getMenuByID(id);
        CartItem t = new CartItem(menu, 1, menu.getUnitPrice());
        cart.addItem(t);

//        List<CartItem> list = cart.getItems();
//        session.setAttribute("cart", cart);
//        session.setAttribute("size", list.size());
//        session.setAttribute("total", cart.getTotalMoney());
        session.setAttribute("cart",cart);
        return new ResponseEntity<CartItem>( t , HttpStatus.OK);
    }
    
 // insert table
    //@modelatribute use for content-type mutipart/form-data
    @PutMapping(value = "/updatecart")
    public ResponseEntity<?> updateCart (  @RequestBody CartItem cartItem){
    	Cart cart = (Cart) session.getAttribute("cart");
    	CartItem newItem = cartItem;
    	if(cartItem.getQuantity() == 0) {
        	cart.removeItem(cartItem.getMenuDTO().getMenuID());
    	}else {
    		newItem=cart.getItemById(cartItem.getMenuDTO().getMenuID());
        	cart.setQuantityById(cartItem.getMenuDTO().getMenuID() ,cartItem.getQuantity());
    	}
    	session.setAttribute("cart",cart);
    	return new ResponseEntity<CartItem>(  newItem, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/deletecart/{id}")
	public void deleteTable(@PathVariable("id") int id) {
    	Cart cart = (Cart) session.getAttribute("cart");
    	cart.removeItem(id);
    	session.setAttribute("cart",cart);
	}
    
//
//
//    @PostMapping("/removeItem")
//    public String removeItem( @RequestParam int itemId,Model model) {
//
//        Cart cart = (Cart)session.getAttribute("cart");
//
//        // Tìm và xóa item ra khỏi danh sách
//        cart.removeItem(itemId);
//
//        session.setAttribute("cart", cart);
//
//        return viewCart(model);
//    }

}
