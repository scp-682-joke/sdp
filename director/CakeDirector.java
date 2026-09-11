package director;
import builders.PresetCakeBuilder;
import product.Cake;
public class CakeDirector {
    public Cake makeBirthdayCake(PresetCakeBuilder builder, String name){
        return builder.setFlavor("Chocolate")
                .setLayers(3)
                .setFrosting("Fudge")
                .addTopping("Sprinkles")
                .addTopping("Candles")
                .setMessage("Happy Birthday, " + name + "!")
                .build();
    }
    public Cake makeWeddingCake(PresetCakeBuilder builder){
        return builder.setFlavor("Red Velvet")
                .setLayers(5)
                .setFrosting("Vanilla Cream")
                .addTopping("Edible Pearls")
                .addTopping("Edible Red Roses")
                .addTopping("Edible White Roses")
                .build();
    }
}
