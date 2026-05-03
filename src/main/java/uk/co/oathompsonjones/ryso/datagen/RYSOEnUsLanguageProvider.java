package uk.co.oathompsonjones.ryso.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import uk.co.oathompsonjones.ryso.RYSO;
import uk.co.oathompsonjones.ryso.RYSOBlocks;
import uk.co.oathompsonjones.ryso.RYSOItems;
import uk.co.oathompsonjones.ryso.RYSOStatusEffects;

public class RYSOEnUsLanguageProvider extends FabricLanguageProvider {
    public RYSOEnUsLanguageProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    public static String format(String str) {
        return toTitleCase(str.replace("_", " "));
    }

    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty())
            return str;

        String[]      words     = str.split(" ");
        StringBuilder titleCase = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty())
                titleCase.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(
                        " ");
        }
        return titleCase.toString().trim();
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        for (Block block : RYSOBlocks.BLOCKS)
            translationBuilder.add(block, format(block.getTranslationKey().replace("block." + RYSO.MOD_ID + ".", "")));
        for (Item item : RYSOItems.ITEMS)
            translationBuilder.add(item, format(item.getTranslationKey().replace("item." + RYSO.MOD_ID + ".", "")));
        for (StatusEffect effect : RYSOStatusEffects.EFFECTS)
            translationBuilder.add(
                    effect,
                    format(effect.getTranslationKey().replace("effect." + RYSO.MOD_ID + ".", ""))
            );
    }
}

