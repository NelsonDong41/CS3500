package betterpizza;

import org.junit.Before;
import org.junit.Test;
import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

import static org.junit.Assert.assertEquals;

/**
 * The test class for better pizzas.
 */
public class BetterPizzaTest {
  private ObservablePizza alacarte;
  private ObservablePizza cheese;
  private ObservablePizza halfCheese;
  private ObservablePizza otherHalfCheese;
  private ObservablePizza cheeseMediumStuffed;
  private ObservablePizza veggieThinLarge;

  @Before
  public void setup() {
    alacarte = new betterpizza.AlaCartePizza.AlaCartePizzaBuilder()
            .crust(Crust.Classic)
            .size(Size.Medium)
            .addTopping(ToppingName.Cheese, ToppingPortion.Full)
            .addTopping(ToppingName.Sauce, ToppingPortion.Full)
            .addTopping(ToppingName.GreenPepper, ToppingPortion.Full)
            .addTopping(ToppingName.Onion, ToppingPortion.Full)
            .addTopping(ToppingName.Jalapeno, ToppingPortion.LeftHalf)
            .build();
    cheese = new CheesePizza.CheesePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Large)
            .build();

    halfCheese = new CheesePizza.CheesePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Large)
            .addTopping(ToppingName.Cheese,ToppingPortion.LeftHalf)
            .build();

    otherHalfCheese = new CheesePizza.CheesePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Large)
            .addTopping(ToppingName.Cheese,ToppingPortion.RightHalf)
            .build();

    cheeseMediumStuffed = new CheesePizza.CheesePizzaBuilder()
            .crust(Crust.Stuffed)
            .size(Size.Medium)
            .build();

    veggieThinLarge = new VeggiePizza.VeggiePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Large)
            .build();

  }

  @Test
  public void testCost() {
    assertEquals(8.25, alacarte.cost(),0.01);
    assertEquals(9.0, cheese.cost(),0.01);
    assertEquals(7.0, cheeseMediumStuffed.cost(),0.01);
    assertEquals(11.5, veggieThinLarge.cost(),0.01);
    assertEquals(8.5, halfCheese.cost(),0.01);
    assertEquals(8.5, otherHalfCheese.cost(), 0.01);
  }
}








