package ru.geekbrains.happy.market.services;



import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.happy.market.model.Cart;
import ru.geekbrains.happy.market.model.CartItem;
import ru.geekbrains.happy.market.model.Product;
import ru.geekbrains.happy.market.repositories.CartRepository;

import java.util.Optional;
import java.util.UUID;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CartServiceTest {

    CartService cartService;
    private Cart cart;
    private CartRepository cartRepository;
    private ProductService productService;

    @Before
    public void setUp() throws Exception {
        // создаем объект-заглушку
        CartRepository cartRepository = mock(CartRepository.class);
        ProductService productService = mock(ProductService.class);
        cartService = new CartService(cartRepository,productService);

        // задаем нужное поведение объекта-заглушки
        when(cartRepository.findById(any(UUID.class))).thenReturn(java.util.Optional.of(any(Cart.class)));

    }


    @Test
    void findById() {
        Optional<Cart> cart = cartService.findById(UUID.randomUUID());
        Mockito.verify(cartRepository, times(1)).findById(any(UUID.class));

    }
}