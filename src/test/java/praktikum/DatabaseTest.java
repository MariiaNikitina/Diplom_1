package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class DatabaseTest {
    Database database = new Database();

    @Test
    public void availableBunsReturnsNotNullResult() {
        Assert.assertNotNull("availableBuns doesn't return anything", database.availableBuns());
    }

    @Test
    public void availableBunsReturnsCorrectType() {
        assertThat("availableBuns doesn't return Buns type", database.availableBuns().get(0), instanceOf(Bun.class));
    }

    @Test
    public void availableIngredientsReturnsNotNullResult() {
        Assert.assertNotNull("availableIngredients doesn't return anything", database.availableIngredients());
    }

    @Test
    public void availableIngredientsReturnsCorrectType() {
        assertThat("availableIngredients doesn't return Ingredients type", database.availableIngredients().get(0), instanceOf(Ingredient.class));
    }
}
