package uk.co.oathompsonjones.ryso.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import uk.co.oathompsonjones.ryso.RYSOBlocks;
import uk.co.oathompsonjones.ryso.RYSOItems;
import uk.co.oathompsonjones.ryso.SocksItem;

import java.util.List;
import java.util.function.Consumer;

public class RYSOAdvancementProvider extends FabricAdvancementProvider {

    public RYSOAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    private static String id(String path) {
        return "ryso:" + path;
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        List<SocksItem> allSocks = RYSOItems.SOCKS_ITEMS;
        List<SocksItem> functionalSocks = RYSOItems.SOCKS_ITEMS.stream().filter(sock -> sock.getDepth() > 0).toList();
        List<SocksItem> upgradedSocks = RYSOItems.SOCKS_ITEMS.stream().filter(sock -> sock.getDepth() > 1).toList();

        Advancement root = Advancement.Builder
                .create()
                .display(new ItemStack(RYSOItems.SOCKS),
                        Text.literal("Rock Your Socks Off"),
                        Text.literal("The start of your sock journey..."),
                        new Identifier("minecraft", "textures/block/white_wool.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("impossible", InventoryChangedCriterion.Conditions.items(RYSOItems.SOCKS))
                .requirements(new String[][] { { "impossible" } })
                .build(consumer, id("root"));

        // Warden Antenna
        Advancement wardenAntenna = Advancement.Builder
                .create()
                .parent(root)
                .display(new ItemStack(RYSOBlocks.WARDEN_ANTENNA),
                        Text.literal("Break the Silence"),
                        Text.literal("Relieve the Warden of its antenna."),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        true
                )
                .criterion("warden_antenna", InventoryChangedCriterion.Conditions.items(RYSOBlocks.WARDEN_ANTENNA))
                .build(
                        consumer,
                        id("warden_antenna")
                );

        // First Socks
        var firstSocksHelper = Advancement.Builder.create().parent(root).display(new ItemStack(RYSOItems.SOCKS),
                Text.literal("Baby Steps"),
                Text.literal("Your first pair of socks, mum would be proud!"),
                null,
                AdvancementFrame.TASK,
                true,
                true,
                false
        );

        for (SocksItem socks : allSocks)
            firstSocksHelper = firstSocksHelper.criterion(socks.getName().toString(),
                    InventoryChangedCriterion.Conditions.items(socks)
            );

        Advancement firstSocks = firstSocksHelper.requirements(new String[][] {
                allSocks.stream().map(sock -> sock.getName().toString()).toArray(String[]::new)
        }).build(consumer, id("first_socks"));

        // First Functional Socks
        var firstFunctionalSocksHelper = Advancement.Builder
                .create()
                .parent(firstSocks)
                .display(new ItemStack(RYSOItems.BLUE_SOCKS),
                        Text.literal("Double Socked Up"),
                        Text.literal("Now you've got your big boy socks on!"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                );

        for (SocksItem socks : functionalSocks)
            firstFunctionalSocksHelper = firstFunctionalSocksHelper.criterion(socks.getName().toString(),
                    InventoryChangedCriterion.Conditions.items(socks)
            );

        Advancement firstFunctionalSocks = firstFunctionalSocksHelper.requirements(new String[][] {
                functionalSocks.stream().map(sock -> sock.getName().toString()).toArray(String[]::new)
        }).build(consumer, id("first_functional_socks"));

        // First Upgraded Socks
        /*var firstUpgradedSocksHelper = Advancement.Builder.create().parent(firstFunctionalSocks).display(new ItemStack(
                        RYSOItems.CHRISTMAS_SOCKS),
                Text.literal("These Socks Rock!"),
                Text.literal("You're wearing three layers of socks, how can you walk?"),
                null,
                AdvancementFrame.TASK,
                true,
                true,
                false
        );

        for (SocksItem socks : upgradedSocks)
            firstUpgradedSocksHelper = firstUpgradedSocksHelper.criterion(socks.getName().toString(),
                    InventoryChangedCriterion.Conditions.items(socks)
            );

        Advancement firstUpgradedSocks = firstUpgradedSocksHelper.requirements(new String[][] {
                upgradedSocks.stream().map(sock -> sock.getName().toString()).toArray(String[]::new)
        }).build(consumer, id("first_upgraded_socks"));*/

        // All Socks
        var allSocksHelper = Advancement.Builder
                .create()
                .parent(firstFunctionalSocks)
                .display(new ItemStack(RYSOItems.RAINBOW_SOCKS),
                        Text.literal("A Sock for Every Occasion"),
                        Text.literal("Make every type of sock, you sock hoarder!"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                );

        for (SocksItem socks : allSocks)
            allSocksHelper = allSocksHelper.criterion(socks.getName().toString(),
                    InventoryChangedCriterion.Conditions.items(socks)
            );

        allSocksHelper.requirements(allSocks
                .stream()
                .map(sock -> new String[] { sock.getName().toString() })
                .toArray(String[][]::new)).build(consumer, id("all_socks"));
    }
}