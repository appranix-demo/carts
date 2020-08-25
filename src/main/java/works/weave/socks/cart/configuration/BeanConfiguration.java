package works.weave.socks.cart.configuration;

import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import works.weave.socks.cart.cart.CartDAO;
import works.weave.socks.cart.entities.Cart;
import works.weave.socks.cart.entities.Item;
import works.weave.socks.cart.item.ItemDAO;
import works.weave.socks.cart.repositories.CartRepository;
import works.weave.socks.cart.repositories.ItemRepository;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Configuration
public class BeanConfiguration {
    private final Logger LOG = getLogger(getClass());

    @Bean
    public CartDAO cartDAO(CartRepository cartRepository) {
        return new CartDAO() {
            @Override
            public void delete(Cart cart) {
                LOG.info("Inside CartDAO delete method");
                cartRepository.delete(cart);
            }

            @Override
            public Cart save(Cart cart) {
                LOG.info("Inside CartDAO save method");
                return cartRepository.save(cart);
            }

            @Override
            public List<Cart> findByCustomerId(String customerId) {
                LOG.info("Inside CartDAO findByCustomerId method");
                return cartRepository.findByCustomerId(customerId);
            }
        };
    }

    @Bean
    public ItemDAO itemDAO(ItemRepository itemRepository) {
        return new ItemDAO() {
            @Override
            public Item save(Item item) {
                LOG.info("Inside ItemDAO save method. Item: " + item);
                return itemRepository.save(item);
            }

            @Override
            public void destroy(Item item) {
                LOG.info("Inside ItemDAO destroy method. Item: " + item);
                itemRepository.delete(item);
            }

            @Override
            public Item findOne(String id) {
                LOG.info("Inside ItemDAO findOne method Id: " + id);
                return itemRepository.findById(id).orElse(null);
            }
        };
    }
}
