package betterpizza;

import pizza.AlaCartePizza;
import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * A class for a vegetarian pizza.
 */
public class VeggiePizza extends AlaCartePizza {

  /**
   * Create a veggie pizza with all vegetarian toppings.
   *
   * @param size  the size of this pizza
   * @param crust the crust of this pizza
   */
  public VeggiePizza(Size size, Crust crust) {
    super(size, crust);
    this.toppings.put(ToppingName.Cheese, ToppingPortion.Full);
    this.toppings.put(ToppingName.Sauce, ToppingPortion.Full);
    this.toppings.put(ToppingName.BlackOlive, ToppingPortion.Full);
    this.toppings.put(ToppingName.GreenPepper, ToppingPortion.Full);
    this.toppings.put(ToppingName.Onion, ToppingPortion.Full);
    this.toppings.put(ToppingName.Jalapeno, ToppingPortion.Full);
    this.toppings.put(ToppingName.Tomato, ToppingPortion.Full);
  }


  protected VeggiePizza(VeggiePizzaBuilder builder) {
    super(builder.size, builder.crust);
    this.toppings = builder.toppings;
  }

  /**
   * class for a VeggiePizzaBuilder.
   */
  public static class VeggiePizzaBuilder extends PizzaBuilder<VeggiePizzaBuilder> {

    /**
     * returns a VeggiePizzaBuilder.
     *
     * @return a veggiePizzaBuilder
     */
    protected VeggiePizzaBuilder returnBuilder() {
      return this;
    }

    /**
     * Remove jalapeno from the pizza.
     *
     * @return VeggiePizzaBuilder
     */
    public VeggiePizzaBuilder noJalapeno() {
      this.toppings.remove(ToppingName.Jalapeno, ToppingPortion.Full);
      return this.returnBuilder();
    }

    /**
     * Remove tomato from the pizza.
     *
     * @return VeggiePizzaBuilder
     */
    public VeggiePizzaBuilder noTomato() {
      this.toppings.remove(ToppingName.Tomato, ToppingPortion.Full);
      return this.returnBuilder();
    }

    /**
     * Remove tomato from the pizza.
     *
     * @return VeggiePizzaBuilder
     */
    public VeggiePizzaBuilder noSauce() {
      this.toppings.remove(ToppingName.Sauce, ToppingPortion.Full);
      return this.returnBuilder();
    }

    /**
     * Builds the VeggiePizza from the builder.
     *
     * @return VeggiePizzaBuilder
     */
    public VeggiePizza build() throws IllegalStateException {
      if (this.size == null || this.crust == null) {
        throw new IllegalStateException("Must specify size.");
      }
      return new VeggiePizza(this);
    }

    /**
     * adds the crust to the builder.
     *
     * @param crust : the type of crush
     * @return VeggiePizzaBuilder
     */
    public VeggiePizzaBuilder crust(Crust crust) {
      this.crust = crust;
      return returnBuilder();
    }

    /**
     * adds the size to the builder.
     *
     * @param size : the size of the pizza
     * @return VeggiePizzaBuilder
     */
    public VeggiePizzaBuilder size(Size size) {
      this.size = size;
      return returnBuilder();
    }

    /**
     * adds the topping and returns the builder.
     *
     * @param name    : Topping name
     * @param portion : topping portion
     * @return : the builder
     */
    public VeggiePizzaBuilder addTopping(ToppingName name, ToppingPortion portion) {
      this.toppings.put(name, portion);
      return this.returnBuilder();
    }
  }
}
