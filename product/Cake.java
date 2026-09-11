package product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Cake{
    private final String flavor;
    private final int layers;
    private final String frosting;
    private final List<String> toppings;
    private final String message;

    public Cake(String flavor, int layers, String frosting, List<String> toppings, String message) {
        this.flavor = flavor;
        this.layers = layers;
        this.frosting = frosting;
        this.toppings = new ArrayList<>(toppings);
        this.message = message;
    }

    public String getFlavor(){ return flavor; }
    public int getLayers(){ return layers; }
    public String getFrosting(){return frosting; }
    public List<String> getToppings(){ return Collections.unmodifiableList(toppings);}

    @Override
    public String toString() {
        return "product.Cake {" +
                "\n  Flavor: '" + flavor + '\'' +
                "\n  Layers: " + layers +
                "\n  Frosting: '" + frosting + '\'' +
                "\n  Toppings: " + toppings +
                "\n  Writing: '" + (message.isEmpty() ? "None" : message) + '\'' +
                "\n}";
    }
}