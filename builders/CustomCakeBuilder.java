package builders;
import product.Cake;
import java.util.ArrayList;
import java.util.List;

public class CustomCakeBuilder implements CakeBuilder {
    private static final int MIN_LAYERS = 1;
    private static final int MAX_LAYERS = 10;

    private String flavor;
    private int layers = 1;
    private String frosting;
    private final List<String> toppings = new ArrayList<>();
    private String message = "";


    @Override
    public CakeBuilder setFlavor(String flavor) {
        if (flavor == null || flavor.isBlank()) {
            throw new IllegalArgumentException("Flavor cannot be empty.");
        }
        this.flavor = flavor;
        return this;
    }

    @Override
    public CakeBuilder setLayers(int layers) {
        if (layers < MIN_LAYERS || layers > MAX_LAYERS) {
            throw new IllegalArgumentException("Layers must be between " + MIN_LAYERS + " and " + MAX_LAYERS);
        }
        this.layers = layers;
        return this;
    }

    @Override
    public CakeBuilder setFrosting(String frosting) {
        if (frosting == null || frosting.isBlank()) {
            throw new IllegalArgumentException("Frosting cannot be empty.");
        }
        this.frosting = frosting;
        return this;
    }

    @Override
    public CakeBuilder addTopping(String topping) {
        if (topping != null && !topping.isBlank()) {
            this.toppings.add(topping);
        }
        return this;
    }

    @Override
    public CakeBuilder setMessage(String message) {
        this.message = message != null ? message : "";
        return this;
    }

    @Override
    public Cake build() {
        validateCakeState();
        return new Cake(flavor, layers, frosting, toppings, message);
    }

    private void validateCakeState() {
        if (layers > 3 && toppings.isEmpty()) {
            throw new IllegalStateException("Tall cakes with more than 3 layers require at least one structural topping/anchor.");
        }
        if (flavor == null || frosting == null) {
            throw new IllegalStateException("Custom cake requires both flavor and frosting to be specified.");
        }
    }
}
