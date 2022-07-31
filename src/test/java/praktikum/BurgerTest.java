package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;


public class BurgerTest {
    private Burger burger;

    @Before
    public void init() {
        burger = new Burger();
    }

    @Mock
    Bun bun = new Bun("black bun", 100);
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "dinosaur", 200);

    @Test
    public void setBunsSetsCorrectValue() {
        burger.setBuns(bun);
        assertEquals("Incorrect bun was set", bun, burger.bun);
    }

    @Test
    public void addIngredientCheckIngredientsCount() {
        int expected = 1;
        burger.addIngredient(ingredient);
        assertEquals("The count is wrong after adding ingredient", burger.ingredients.size(), expected);
    }

    @Test
    public void addIngredientsLastIngredientCorrect() {
        burger.addIngredient(ingredient);
        assertEquals("The last ingredient is wrong after adding ingredient", burger.ingredients.get(burger.ingredients.size() - 1), ingredient);
    }

    @Test
    public void removeIngredientCheckIngredientCount() {
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient2);
        int expected = 1;
        burger.removeIngredient(1);
        assertEquals("The count is wrong after removing ingredient", burger.ingredients.size(), expected);
    }

    @Test
    public void removeIngredientLastRemove() {
        burger.ingredients.add(ingredient);
        int expected = 0;
        burger.removeIngredient(0);
        assertEquals("Something left in ingredients after removing the last one", expected, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTwoIngredients() {
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Cannot find the moved ingredient at the correct place", burger.ingredients.get(1), ingredient);
    }

    @Test
    public void moveIngredientLastIngredient() {
        burger.ingredients.add(ingredient);
        try {
            burger.moveIngredient(0, 1);
        } catch (Exception ex) {
            System.out.println("Moving cannot be established. The burger has less then two ingredients");
        }
    }

    @Test
    public void getPriceCheck() {
        burger.bun = bun;
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient2);
        float expected = 500f;
        float actual = burger.getPrice();
        assertEquals("The expected price isn't equal to getPrice()", expected, actual, 0.001f);
    }

    @Test
    public void getReceiptTheBunAtTheTop() {
        burger.bun = bun;
        assertThat("The burger in receipt doesn't have a bun at the top", burger.getReceipt(), startsWith(String.format("(==== %s ====)%n",
                burger.bun.name)));
    }

    @Test
    public void getReceiptTheCorrectPriceAtTheBottom() {
        burger.bun = bun;
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient2);
        float fullPrice = 500f;
        assertThat("The price in receipt isn't equal to real price", burger.getReceipt(), endsWith(String.format("%nPrice: %f%n", fullPrice)));
    }

    @Test
    public void getReceiptExceptionWhenNoBurger() {
        try {
            burger.getReceipt();
        } catch (NullPointerException ex) {
            System.out.println("Cannot print the receipt. There are no buns and ingredients in burger yet");
        }
    }
}
