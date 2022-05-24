package betterpizza;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * A class for the cheese pizza.
 */
public class CheesePizza extends AlaCartePizza {

  /**
   * Create a cheese pizza.
   *
   * @param size  the size of this pizza
   * @param crust the crust of this pizza
   */
  public CheesePizza(Size size, Crust crust) {
    super(size, crust);
    this.toppings.put(ToppingName.Cheese, ToppingPortion.Full);
    this.toppings.put(ToppingName.Sauce, ToppingPortion.Full);
  }

  protected CheesePizza(CheesePizzaBuilder builder) {
    super(builder.size, builder.crust);
    this.toppings = builder.toppings;
  }

  /**
   * creates a CheesePizzaBuilder to build a pizza.
   */
  public static class CheesePizzaBuilder extends PizzaBuilder<CheesePizzaBuilder> {

    /**
     * adds a topping for the pizza.
     *
     * @param name    the name of the pizza topping
     * @param portion the portion of the pizza topping
     * @return the cheesePizzaBuilder
     */
    public CheesePizzaBuilder addTopping(ToppingName name, ToppingPortion portion) {
      returnBuilder().toppings.put(name, portion);
      return this.returnBuilder();
    }

    /**
     * Returns the cheesePizzaBuilder.
     */
    protected CheesePizzaBuilder returnBuilder() {
      return this;
    }

    /**
     * Remove cheese from Cheese pizza.
     *
     * @return the cheesePizzaBuilder
     */
    public CheesePizzaBuilder noCheese() {
      returnBuilder().toppings.remove(ToppingName.Cheese, ToppingPortion.Full);
      return this.returnBuilder();
    }

    /**
     * Pizza with only cheese on the left.
     *
     * @return the CheesePizzaBuilder
     */
    public CheesePizzaBuilder leftHalfCheese() {
      this.toppings.replace(ToppingName.Cheese, ToppingPortion.LeftHalf);
      return this.returnBuilder();
    }

    /**
     * Pizza with only cheese on the left.
     *
     * @return the CheesePizzaBuilder
     */
    public CheesePizzaBuilder rightHalfCheese() {
      this.toppings.replace(ToppingName.Cheese, ToppingPortion.RightHalf);
      return this.returnBuilder();
    }

    /**
     * Builds the CheesePizza using the CheesePizzaBuilder.
     *
     * @return the cheesePizza
     */
    public CheesePizza build() throws IllegalStateException {
      if (this.size == null || this.crust == null) {
        throw new IllegalStateException("Must specify size.");
      }
      return new CheesePizza(this);
    }

    /**
     * adds the crust to the builder.
     * @param crust : the type of crush
     * @return CheesePizzaBuilder
     */
    public CheesePizzaBuilder crust(Crust crust) {
      this.crust = crust;
      return returnBuilder();
    }

    /**
     * adds the size to the builder.
     * @param size : the size of the pizza
     * @return CheesePizzaBuilder
     */
    public CheesePizzaBuilder size(Size size) {
      this.size = size;
      return returnBuilder();
    }
  }
}
