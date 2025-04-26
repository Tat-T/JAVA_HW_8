package shop;

import org.example.shop.Order;
import org.example.shop.Product;
import org.example.shop.Shop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {

    @Test
    public void testAddProductToCatalog() {
        Shop shop = new Shop();
        Product product = new Product("Телевизор", 800.0);
        shop.addProductToCatalog(product);
        assertTrue(shop.getCatalog().contains(product));
    }

    @Test
    public void testCreateOrderAndAddProducts() {
        Shop shop = new Shop();
        Product p1 = new Product("Книга", 30.0);
        Product p2 = new Product("Игрушка", 20.0);

        Order order = shop.createOrder();
        order.addProduct(p1);
        order.addProduct(p2);

        assertEquals(2, order.getProducts().size());
        assertEquals(50.0, order.calculateTotal(), 0.001);
    }

    @Test
    public void testProductWithNegativePrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Product("Плохой товар", -100.0);
        });
        assertEquals("Цена должна быть положительной!", exception.getMessage());
    }
}

