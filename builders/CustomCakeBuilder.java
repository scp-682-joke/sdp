package builders;
import product.Cake;
import java.util.ArrayList;
import java.util.List;

public class CustomCakeBuilder implements CakeBuilder {
    @Override
    public CakeBuilder setFlavor(String flavor) {
        return this;
    }

    @Override
    public CakeBuilder setLayers(int layers) {
        return this;
    }

    @Override
    public CakeBuilder setFrosting(String frosting) {
        return this;
    }

    @Override
    public CakeBuilder addTopping(String topping) {
        return this;
    }

    @Override
    public CakeBuilder setMessage(String message) {
        return this;
    }

    @Override
    public Cake build() {
        return new Cake(flavor, layers, frosting, toppings, message);
    }
}
