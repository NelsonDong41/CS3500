package betterpizza;

import java.util.HashMap;
import java.util.Map;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * This class represents an ala carte pizza (i.e. a pizza that can
 * have an arbitrary number of ingredients.
 */
public class AlaCartePizza implements ObservablePizza {
  protected Crust crust;
  protected Size size;
  protected Map<ToppingName, ToppingPortion> toppings;

  /**
   * Creates an AlaCartePizza.
   * @param size : size of the pizza
   * @param crust : Type of crust
   */
  public AlaCartePizza(Size size, Crust crust)  throws IllegalArgumentException {
    if ( size == null || crust == null) {
      throw new IllegalStateException("null parameters)");
    }
    this.crust = crust;
    this.size = size;
    this.toppings = new HashMap<ToppingName, ToppingPortion>();
  }

  /**
   * Creates an AlaCartePizza.
   * @param size : size of the pizza
   * @param crust : type of crust
   * @param toppings : toppings on the pizza
   * @throws IllegalArgumentException : throws exception if any of these are null
   */
  protected AlaCartePizza(Size size,
                          Crust crust,
                          Map<ToppingName, ToppingPortion> toppings)
          throws IllegalArgumentException {
    if (size == null || crust == null || toppings == null) {
      throw new IllegalArgumentException("null parameters");
    }
    this.size = size;
    this.crust = crust;
    this.toppings = toppings;
  }

  /**
   * creates an AlacartePizza.
   * @param builder : AlacartePizzaBuilder
   */
  protected AlaCartePizza(AlaCartePizzaBuilder builder) {
    this.size = builder.size;
    this.crust = builder.crust;
    this.toppings = builder.toppings;
  }

  /**
   * creates a AlacartePizzaBuilder to build a pizza.
   */
  public static class AlaCartePizzaBuilder extends PizzaBuilder<AlaCartePizzaBuilder> {

    /**
     * Builds the pizza with the builder.
     * @return an AlacartePizza with the builder's parameters
     * @throws IllegalArgumentException if size is null or crust is null
     */

    public AlaCartePizza build() throws IllegalArgumentException {
      if ( this.size == null || this.crust == null ) {
        throw new IllegalStateException("Parameters are null");
      }
      return new AlaCartePizza(this);
    }

    /**
     * returns the builder.
     * @return ALacartePizzaBuilder
     */
    @Override
    protected AlaCartePizzaBuilder returnBuilder() {
      return this;
    }

    /**
     * adds the topping and returns the builder.
     * @param name : Topping name
     * @param portion : topping portion
     * @return : the builder
     */
    public AlaCartePizzaBuilder addTopping(ToppingName name, ToppingPortion portion) {
      this.toppings.put(name, portion);
      return this.returnBuilder();
    }

    /**
     * adds the crust to the builder.
     * @param crust : the type of crush
     * @return AlaCartePizzaBuilder
     */
    public AlaCartePizzaBuilder crust(Crust crust) {
      this.crust = crust;
      return returnBuilder();
    }

    /**
     * adds the size to the builder.
     * @param size : the size of the pizza
     * @return AlaCartePizzaBuilder
     */
    public AlaCartePizzaBuilder size(Size size) {
      this.size = size;
      return returnBuilder();
    }
  }

  /**
   * determines if the pizza has the given topping.
   * @param name the name of the topping
   * @return the portion of the topping
   */
  @Override
  public ToppingPortion hasTopping(ToppingName name) {
    return this.toppings.getOrDefault(name, null);
  }

  /**
   * returns the cost of the pizza.
   * @return a double of the cost of the pizza
   */
  @Override
  public double cost() {
    double cost = 0.0;
    for (Map.Entry<ToppingName, ToppingPortion> item : this.toppings.entrySet()) {
      cost += item.getKey().getCost() * item.getValue().getCostMultiplier();
    }
    return cost + this.size.getBaseCost();
  }
}
