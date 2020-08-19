package works.weave.socks.cart.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import works.weave.socks.cart.entities.Cart;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, String> {
    List<Cart> findByCustomerId(@Param("custId") String id);
}

