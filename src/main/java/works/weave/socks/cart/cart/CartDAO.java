package works.weave.socks.cart.cart;

import works.weave.socks.cart.entities.Cart;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CartDAO {
    void delete(Cart cart);

    Cart save(Cart cart);

    List<Cart> findByCustomerId(String customerId);
}
