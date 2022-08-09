package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "{index}: TYPE of ingredient: {0}, name of ingredient: {1}, price of bun: {2}")
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {SAUCE, "Common sauce", 100f},
                {FILLING, "Common filling", 100f},
                {null, "Just null type", 100f},
                {SAUCE, "Sauce with really big name Sauce with really big name Sauce with really big name", 100f},
                {SAUCE, "", 100f},
                {SAUCE, null, 100f},
                {SAUCE, "Common sauce", -100f},
                {SAUCE, "Common sauce", 0.0000001f},
                {SAUCE, "Common sauce", 1000000f},
        };
    }

    @Test
    public void getTypeReturnsCorrectType() {
        ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        assertEquals("getType returns incorrect type", actualType, type);
    }

    @Test
    public void getNameReturnsCorrectName() {
        ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        assertEquals("getName returns incorrect name", actualName, name);
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        assertEquals("getPrice returns incorrect price", price, actualPrice, 0.00001f);
    }
}
