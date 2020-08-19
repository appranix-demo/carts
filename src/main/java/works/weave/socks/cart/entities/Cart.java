package works.weave.socks.cart.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @NotNull
    public String customerId; // Public instead of getters/setters.

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Convert(converter = HashMapConverter.class)
    private List<Item> items = new ArrayList<>();

    public Cart(String customerId) {
        this.customerId = customerId;
    }

    public Cart() {
        this(null);
    }

    public List<Item> contents() {
        return items;
    }

    public Cart add(Item item) {
        items.add(item);
        return this;
    }

    public Cart remove(Item item) {
        items.remove(item);
        return this;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (customerId != null ? !customerId.equals(cart.customerId) : cart.customerId != null) return false;
        if (id != null ? !id.equals(cart.id) : cart.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
