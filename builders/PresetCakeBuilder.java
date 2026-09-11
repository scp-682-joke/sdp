package builders;

import product.Cake;

import java.util.ArrayList;
import java.util.List;

public class PresetCakeBuilder implements CakeBuilder {
    private String flavor = "Vanilla";
    private int layers = 2;
    private String frosting = "Whipped Cream";
    private final List<String> toppings = new ArrayList<>();
    private String message = "";

    @Override
    public CakeBuilder setFlavor(String flavor) {
        this.flavor = flavor;
        return this;
    }

    @Override
    public CakeBuilder setLayers(int layers) {
        this.layers = layers;
        return this;
    }

    @Override
    public CakeBuilder setFrosting(String frosting) {
        this.frosting = frosting;
        return this;
    }

    @Override
    public CakeBuilder addTopping(String topping) {
        this.toppings.add(topping);
        return this;
    }

    @Override
    public CakeBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public Cake build() {
        if (flavor == null || frosting == null) {
            throw new IllegalStateException("Preset cake must have both a flavor and frosting set.");
        }
        return new Cake(flavor, layers, frosting, toppings, message);
    }
}
