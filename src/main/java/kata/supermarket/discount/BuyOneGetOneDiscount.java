package kata.supermarket.discount;

import kata.supermarket.Item;
import kata.supermarket.discount.Discount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuyOneGetOneDiscount implements Discount {
    @Override
    public BigDecimal giveDiscount(List<Item> items) {

        Map<BigDecimal, Integer> productsCount = new HashMap<>();

        /*
           Check how many items are there for each product.
           Here I am grouping the products by its price (if 2 products have the same price they are the same product)
           A correct way to do it would be to use a identifier field
        */
        for (Item item : items) {
            if (productsCount.containsKey(item.price())) {
                productsCount.put(item.price(), productsCount.get(item.price()).intValue() + 1);
            }
            else {
                productsCount.put(item.price(), 1);
            }
        }

        BigDecimal discount = BigDecimal.ZERO;

        for (BigDecimal totalProductPrice : productsCount.keySet()) {
            if (productsCount.get(totalProductPrice) > 2) {
                discount = new BigDecimal(productsCount.get(totalProductPrice) / 2)
                        .multiply(totalProductPrice)
                        .add(discount);
            } else if (productsCount.get(totalProductPrice) == 2) {
                discount = totalProductPrice;
            }
        }

        return discount;
    }
}
