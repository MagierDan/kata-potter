package katapotter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Basket {

    private final static double BOOK_PRICE = 8.0;

    private final Map<PotterBook, Long> potterBooks;

    private final Map<Integer, Double> reductions = new HashMap<Integer, Double>() {{
        put(1, 0.0);
        put(2, 0.05);
        put(3, 0.1);
        put(4, 0.2);
        put(5, 0.25);
    }};

    public Basket(List<PotterBook> potterBooks) {
        this.potterBooks = potterBooks.stream().collect(
                groupingBy(identity(), counting()));
    }

    public double calculatePrice() {
        int size = potterBooks.size();

        if (size == 1) {
            double price = Stream.of(PotterBook.values())
                    .filter(potterBooks::containsKey)
                    .mapToDouble(t -> BOOK_PRICE * potterBooks.get(t)).sum();
            return price;
        } else {
            return calculatePriceForDifferentBooks();
        }
    }

    private double calculatePriceForDifferentBooks() {
        int size = potterBooks.size();
        return (1 - reductions.get(size)) * size * BOOK_PRICE;
    }


}
