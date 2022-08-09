package praktikum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class IngredientTypeTest {
    IngredientType ingredientType;
    @Test
    public void ingredientTypeCanReturnSauceType(){
        ingredientType= IngredientType.SAUCE;
        assertThat(ingredientType, equalTo(IngredientType.SAUCE));
    }
    @Test
    public void ingredientTypeCanReturnFillingType(){
        ingredientType= IngredientType.FILLING;
        assertThat(ingredientType, equalTo(IngredientType.FILLING));
    }
}
