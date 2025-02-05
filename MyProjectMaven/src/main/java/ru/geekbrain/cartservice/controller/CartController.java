package ru.geekbrain.cartservice.controller;


import ru.geekbrain.cartservice.model.Cart;
import ru.geekbrain.cartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable String userId) {
        return cartRepository.findById(userId).orElse(new Cart());
    }

    @PostMapping("/{userId}/add/{productId}")
    public Cart addToCart(@PathVariable String userId, @PathVariable Long productId) {
        Cart cart = cartRepository.findById(userId).orElse(new Cart());
        cart.setUserId(userId);

        cart.getProducts().put(productId, cart.getProducts().getOrDefault(productId, 0) + 1);

        return cartRepository.save(cart);
    }

    @DeleteMapping("/{userId}/remove/{productId}")
    public Cart removeFromCart(@PathVariable String userId, @PathVariable Long productId) {
        Cart cart = cartRepository.findById(userId).orElse(new Cart());
        cart.getProducts().remove(productId);

        return cartRepository.save(cart);
    }
}