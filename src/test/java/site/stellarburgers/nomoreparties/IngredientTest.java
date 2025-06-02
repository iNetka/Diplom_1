package site.stellarburgers.nomoreparties;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void createNewInstance() {
        ingredient = new Ingredient(IngredientType.SAUCE, "chili", 300);
    }

    @Test
    public void getName() {
        String expected = "chili";
        String actual = ingredient.getName();

        assertEquals("Неверное название", expected, actual);
    }

    @Test
    public void getPrice() {
        float expected = 300;
        float actual = ingredient.getPrice();

        assertEquals("Неверная цена", expected, actual, 0);
    }
}