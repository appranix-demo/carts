package works.weave.socks.cart.item;

import org.slf4j.Logger;
import works.weave.socks.cart.entities.Item;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.slf4j.LoggerFactory.getLogger;

public class FoundItem implements Supplier<Item> {
    private final Logger LOG = getLogger(getClass());
    private final List<Item> items;
    private final Item item;

    public FoundItem(List<Item> items, Item item) {
        this.items = items;
        this.item = item;
    }

    @Override
    public Item get() {
        return items.stream()
                .filter(item1 -> item1.getItemId().equals(item.getItemId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot find item in cart"));
    }

    public boolean hasItem() {
        boolean present = items.stream()
                .filter(item1 -> item1.getItemId().equals(item.getItemId()))
                .findFirst()
                .isPresent();
        LOG.info((present ? "Found" : "Didn't find") + " item: " + item + ", in: " + items);
        return present;
    }
}
