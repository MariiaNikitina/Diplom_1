package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][]{
                {"Common bun", 100f},
                {"Bun with really big name Bun with really big name Bun with really big name Bun with really big name", 100f},
                {null, 100f},
                {"", 100f},
                {"Common bun", -100f},
                {"Common bun", 10000000f},
                {"Common bun", 0.000001f},
        };
    }

    @Test
    public void getNameReturnsCorrectName() {
        bun = new Bun(name, price);
        String actualName = bun.getName();
        assertEquals("getName returns incorrect name", name, actualName);
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        assertEquals("getPrice returns incorrect price", price, actualPrice, 0.001);
    }
}
