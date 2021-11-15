package com.hwan.yaksa.cart;

import com.hwan.yaksa.authLogin.dto.SessionUser;
import com.hwan.yaksa.domain.Cart;
import com.hwan.yaksa.domain.CartItem;
import com.hwan.yaksa.domain.Item;
import com.hwan.yaksa.domain.user.Account;
import com.hwan.yaksa.formLogin.AccountRepository;
import com.hwan.yaksa.item.ItemDto;
import com.hwan.yaksa.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;
    private final AccountRepository accountRepository;
    private final CartItemRepository cartItemRepository;
    @Override
    public void addCartItem(SessionUser sessionUser, ItemDto itemDto){
        Account account = accountRepository.findByEmail(sessionUser.getEmail()).get();
        Optional<Cart> optionalCart = Optional.ofNullable(account.getCart());

        Cart cart = optionalCart.orElse(new Cart());
        Item item = itemRepository.getById(itemDto.getId());

        CartItem cartItem = CartItem.createCartItem(item,1);
        cartItemRepository.save(cartItem);
        cart.addCartItem(cartItem);
        account.addCart(cart);
        cartRepository.save(cart);

    }

    @Override
    public CartResponseDto getCart(SessionUser sessionuser){
        Account account = accountRepository.findByEmail(sessionuser.getEmail()).get();
        Cart cart = account.getCart();

        CartResponseDto cartResponseDto = CartResponseDto.builder().id(cart.getId())
                                        .account(cart.getAccount())
                                        .build();

        for(CartItem cartItem:cart.getCartItems()){
            cartResponseDto.getCartItems().add(cartItem);
        }

        return cartResponseDto;
    }
}
