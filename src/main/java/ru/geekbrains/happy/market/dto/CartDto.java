package ru.geekbrains.happy.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.happy.market.model.Cart;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class CartDto {
    private List<CartItemDto> items;
    private int totalPrice;

    public CartDto(Cart cart) {
        this.totalPrice = cart.getPrice();
        this.items = cart.getItems().stream().map(CartItemDto::new).collect(Collectors.toList());
    }
}
