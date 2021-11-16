package com.hwan.yaksa.cart;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class CartServiceImplTest {
//
//    @Autowired
//    CartRepository cartRepository;
//    @Autowired
//    AccountRepository accountRepository;
//    @Autowired
//    ItemRepository itemRepository;
//    @Autowired
//    CartService cartService;
//
//    @Test
//    public void 카트확인(){
//        //given
//        Account account = Account.builder().email("hello").name("임꺽정").role(Role.GUEST).build();
//        Cart cart = new Cart();
//        account.addCart(cart);
//
//        //when
//        accountRepository.save(account);
//        cartRepository.save(cart);
//
//        //then
//        Cart cart1=cartRepository.findByAccount(account).get();
//        assertEquals(cart,cart1);
//    }
//
//
//    @Test
//    public void 카트생성확인(){
//        Account account = Account.builder().email("hwange").name("dfdf").role(Role.GUEST).build();
//        accountRepository.save(account);
//        Item item = Item.builder()
//                .name("dfdf")
//                .count(1)
//                .price(1)
//                .build();
//        itemRepository.save(item);
//        ItemDto itemDto = ItemDto.builder()
//                .name("dfdf")
//                .id(item.getId())
//                .count(1)
//                .price(1)
//                .build();
//
//        SessionUser sessionUser = new SessionUser();
//        sessionUser.setEmail(account.getEmail());
//        sessionUser.setName(account.getName());
//
//        cartService.addCartItem(sessionUser,itemDto);
//
//        item = itemRepository.findById(item.getId()).get();
//        account = accountRepository.findByEmail("hwange").get();
//        assertNotNull(account.getCart());
//        assertNotNull(item.getCartItems().get(0));
//        assertNotNull(account.getCart().getCartItems().get(0));
//    }
}