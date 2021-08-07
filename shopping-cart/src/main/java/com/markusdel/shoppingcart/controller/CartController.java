package com.markusdel.shoppingcart.controller;

import com.markusdel.shoppingcart.model.Cart;
import com.markusdel.shoppingcart.model.Item;
import com.markusdel.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository repository;

    @PostMapping("/{id}")
    public Cart addItem(@PathVariable Integer id, @RequestBody Item item){
        Optional<Cart> savedCart = repository.findById(id);
        Cart cart;
        if (savedCart.equals(Optional.empty())) {
            cart = new Cart(id);
        } else {
            cart = savedCart.get();
        }
        cart.getItems().add(item);
        return repository.save(cart);
    }

    @GetMapping("/{id}")
    public Optional<Cart> findById(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clear(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
