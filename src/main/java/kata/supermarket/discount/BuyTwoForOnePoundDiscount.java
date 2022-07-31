package kata.supermarket.discount;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;

public class BuyTwoForOnePoundDiscount implements Discount{

    /*
      Logic needs more working, since here I am assuming the list of products would have just 2 items.
      Perhaps I could use a similar logic as the one used on the BuyOneGetOneDiscount class
     */
    @Override
    public BigDecimal giveDiscount(List<Item> items) {
        if (items.size() == 2) {
            return items.stream()
                    .map(Item::price)
                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                    .subtract(BigDecimal.ONE);
        }

        return BigDecimal.ONE;
    }
}
