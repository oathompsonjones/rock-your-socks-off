package uk.co.oathompsonjones.ryso.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class RYSOTrinketsEntityProvider implements DataProvider {
    private final FabricDataOutput output;

    public RYSOTrinketsEntityProvider(FabricDataOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        JsonObject json = new JsonObject();

        JsonArray entities = new JsonArray();
        entities.add("player");

        JsonArray slots = new JsonArray();
        slots.add("feet/shoes");

        json.add("entities", entities);
        json.add("slots", slots);

        return DataProvider.writeToPath(
                writer,
                json,
                output
                        .getResolver(DataOutput.OutputType.DATA_PACK, "trinkets/entities")
                        .resolveJson(new Identifier("", "ryso"))
        );
    }

    @Override
    public String getName() {
        return "RYSO Trinkets Entity Data";
    }
}