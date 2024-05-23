package com.project.ecommerceapp.controller;


import com.project.ecommerceapp.model.Cart;
import com.project.ecommerceapp.model.CartItem;
import com.project.ecommerceapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable Long id) {
        return cartService.getCartById(id);
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.saveCart(cart);
    }

    @PutMapping("/{id}")
    public Cart updateCart(@PathVariable Long id, @RequestBody Cart cart) {
        cart.setId(id);
        return cartService.saveCart(cart);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
    }

    @PostMapping("/{cartId}/items")
    public CartItem addCartItem(@PathVariable Long cartId, @RequestBody CartItem cartItem) {
        Cart cart = cartService.getCartById(cartId);
        cartItem.setCart(cart);
        return cartService.saveCartItem(cartItem);
    }

    @PutMapping("/items/{itemId}")
    public CartItem updateCartItem(@PathVariable Long itemId, @RequestBody CartItem cartItem) {
        cartItem.setId(itemId);
        return cartService.saveCartItem(cartItem);
    }

    @DeleteMapping("/items/{itemId}")
    public void deleteCartItem(@PathVariable Long itemId) {
        cartService.deleteCartItem(itemId);
    }

    @GetMapping("/{cartId}/items")
    public List<CartItem> getCartItems(@PathVariable Long cartId) {
        return cartService.getCartItemsByCartId(cartId);
    }
}
