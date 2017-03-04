package katapotter;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {

    @Test
    public void one_book_costs_8() throws Exception {
        List<PotterBook> potterBook = Collections.singletonList(PotterBook.POTTER1);
        Basket basket = new Basket(potterBook);

        assertThat(basket.calculatePrice()).isEqualTo(8);
    }

    @Test
    public void two_different_books_cost_15_3() throws Exception {
        List<PotterBook> potterBooks = Arrays.asList(PotterBook.POTTER1, PotterBook.POTTER2);
        Basket basket = new Basket(potterBooks);

        assertThat(basket.calculatePrice()).isEqualTo(15.2);
    }

    @Test
    public void two_identical_books_cost_16() throws Exception {
        List<PotterBook> potterBooks = IntStream.range(0, 2).mapToObj(i -> PotterBook.POTTER1).collect(toList());
        Basket basket = new Basket(potterBooks);

        assertThat(basket.calculatePrice()).isEqualTo(16);
    }

    @Test
    public void three_identical_books_cost_24() throws Exception {
        List<PotterBook> potterBooks = IntStream.range(0, 3).mapToObj(i -> PotterBook.POTTER1).collect(toList());
        Basket basket = new Basket(potterBooks);

        assertThat(basket.calculatePrice()).isEqualTo(24);
    }

    @Test
    public void four_identical_books_cost_32() throws Exception {
        List<PotterBook> potterBooks = IntStream.range(0, 4).mapToObj(i -> PotterBook.POTTER1).collect(toList());
        Basket basket = new Basket(potterBooks);

        assertThat(basket.calculatePrice()).isEqualTo(32);
    }

    @Test
    public void five_identical_books_cost_40() throws Exception {
        List<PotterBook> potterBooks = IntStream.range(0, 5).mapToObj(i -> PotterBook.POTTER1).collect(toList());
        Basket basket = new Basket(potterBooks);

        assertThat(basket.calculatePrice()).isEqualTo(40);
    }

    @Test
    public void three_different_books_cost_21_6() throws Exception {
        List<PotterBook> potterBooks = Arrays.asList(PotterBook.POTTER1, PotterBook.POTTER2, PotterBook.POTTER3);
        Basket basket = new Basket(potterBooks);

        assertThat(basket.calculatePrice()).isEqualTo(21.6);
    }

    @Test
    public void four_different_books_cost_25_6() throws Exception {
        List<PotterBook> potterBooks = Arrays.asList(PotterBook.POTTER1, PotterBook.POTTER2, PotterBook.POTTER3, PotterBook.POTTER4);
        Basket basket = new Basket(potterBooks);

        assertThat(basket.calculatePrice()).isEqualTo(25.6);
    }
    
    @Test
    public void five_different_books_cost_30() throws Exception {
        List<PotterBook> potterBooks = Arrays.asList(PotterBook.POTTER1, PotterBook.POTTER2, PotterBook.POTTER3, PotterBook.POTTER4, PotterBook.POTTER5);
        Basket basket = new Basket(potterBooks);

        assertThat(basket.calculatePrice()).isEqualTo(30);
    }

    @Ignore
    @Test
    public void serveral_discounts() throws Exception {
        // assert_equal(8 + (8 * 2 * 0.95), price([0, 0, 1]))
        List<PotterBook> potterBooks = Arrays.asList(PotterBook.POTTER1, PotterBook.POTTER1, PotterBook.POTTER3);
        Basket basket = new Basket(potterBooks);

        assertThat(basket.calculatePrice()).isEqualTo(8.0 + (8.0 * 2.0 * 0.95));
    }
}
