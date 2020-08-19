package works.weave.socks.cart.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import works.weave.socks.cart.entities.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, String> {
}

