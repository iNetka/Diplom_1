package site.stellarburgers.nomoreparties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BurgerParametrizedTest {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockSauce;
    private Ingredient mockFilling;

    private final String bunName;
    private final float bunPrice;

    public BurgerParametrizedTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Before
    public void setUp() {
        burger = new Burger();

        mockBun = mock(Bun.class);
        mockSauce = mock(Ingredient.class);
        mockFilling = mock(Ingredient.class);

        when(mockBun.getName()).thenReturn(bunName);
        when(mockBun.getPrice()).thenReturn(bunPrice);

        when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(mockSauce.getName()).thenReturn("chili");
        when(mockSauce.getPrice()).thenReturn(20.0f);

        when(mockFilling.getType()).thenReturn(IngredientType.FILLING);
        when(mockFilling.getName()).thenReturn("cheese");
        when(mockFilling.getPrice()).thenReturn(15.5f);
    }

    @Parameterized.Parameters(name = "{index}: Bun = {0}, Price = {1}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"original-free", 0.0f},
                {"original", 200.0f}
        });
    }

    @Test
    public void testBurgerPriceWithMockedBunAndIngredients() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        float expectedPrice = bunPrice * 2 + 20.0f + 15.5f;
        float actualPrice = burger.getPrice();

        assertEquals("Неверная цена бургера", expectedPrice, actualPrice, 0);
    }
}
