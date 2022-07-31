package kata.supermarket.discount;

import kata.supermarket.Item;
import kata.supermarket.ItemByWeight;
import kata.supermarket.WeighedProduct;

import java.math.BigDecimal;
import java.util.List;

public class BuyOneKileForHalfPriceDiscount implements Discount{
    @Override
    public BigDecimal giveDiscount(List<Item> items) {

        BigDecimal discount = BigDecimal.ZERO;

        for (Item item : items) {
            /*
               Logic needs more working, since it will currently work only if item is 1 Kilo
             */
            if (item instanceof ItemByWeight && ((ItemByWeight) item).getWeightInKilos().compareTo(BigDecimal.ONE) == 0) {
                discount = discount.add(new BigDecimal(String.valueOf(item.price().divide(new BigDecimal("2")))));
            }
        }
        return discount;
    }
}
