package builders;
//thats abstarct builder

import product.Cake;

public interface CakeBuilder {
    CakeBuilder setFlavor(String flavor);
    CakeBuilder setLayers(int layers);
    CakeBuilder setFrosting(String frosting);
    CakeBuilder addTopping(String topping);
    CakeBuilder setMessage(String message);
    Cake build();
}
