package betterpizza;

import java.util.HashMap;
import java.util.Map;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * Abstract class to for all PizzaBuilders.
 *
 * @param <T> : the type of pizzaBuilder
 */
public abstract class PizzaBuilder<T extends PizzaBuilder<T>> {

  protected Crust crust;
  protected Size size;
  protected Map<ToppingName, ToppingPortion> toppings;

  /**
   * constructs a pizzaBuilder based on the type of Pizzabuilder.
   */
  protected PizzaBuilder() {
    this.crust = null;
    this.size = null;
    this.toppings = new HashMap<>();
    if (this instanceof CheesePizza.CheesePizzaBuilder) {
      this.toppings.put(ToppingName.Cheese, ToppingPortion.Full);
      this.toppings.put(ToppingName.Sauce, ToppingPortion.Full);
    } else if (this instanceof VeggiePizza.VeggiePizzaBuilder) {
      this.toppings.put(ToppingName.Cheese, ToppingPortion.Full);
      this.toppings.put(ToppingName.Sauce, ToppingPortion.Full);
      this.toppings.put(ToppingName.BlackOlive, ToppingPortion.Full);
      this.toppings.put(ToppingName.GreenPepper, ToppingPortion.Full);
      this.toppings.put(ToppingName.Onion, ToppingPortion.Full);
      this.toppings.put(ToppingName.Jalapeno, ToppingPortion.Full);
      this.toppings.put(ToppingName.Tomato, ToppingPortion.Full);
    }
  }

  /**
   * returns the given Builder.
   *
   * @return the builder for its respective class
   */
  protected abstract T returnBuilder();
}
