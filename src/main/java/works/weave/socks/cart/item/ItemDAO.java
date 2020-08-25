package works.weave.socks.cart.item;

import works.weave.socks.cart.entities.Item;

import java.util.HashMap;
import java.util.Map;

public interface ItemDAO {
    Item save(Item item);

    void destroy(Item item);

    Item findOne(String id);
}
