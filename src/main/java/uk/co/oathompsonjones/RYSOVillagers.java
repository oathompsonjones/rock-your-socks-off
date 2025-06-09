package uk.co.oathompsonjones;

public class RYSOVillagers {
    /* TODO (2.0): public static final RegistryKey<PointOfInterestType> SOCKS_POI_KEY = poiKey("socks_poi");
    public static final PointOfInterestType              SOCKS_POI     = registerPoi("socks_poi", Blocks.FURNACE);

    public static final VillagerProfession SOCKS_TRADER = registerProfession("socks_trader", SOCKS_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION,
                                 new Identifier(RYSO.MOD_ID, name),
                                 new VillagerProfession(name,
                                                        entry -> entry.matchesKey(type),
                                                        entry -> entry.matchesKey(type),
                                                        ImmutableSet.of(),
                                                        ImmutableSet.of(),
                                                        SoundEvents.ENTITY_VILLAGER_WORK_FLETCHER
                                 )
        );
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(RYSO.MOD_ID, name), 1, 16, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(RYSO.MOD_ID, name));
    }

    public static void initialize() {
        // Level 1: 6 emeralds for socks AND 4 emeralds for 16 cookies OR 4 wool for 1 emerald
        TradeOfferHelper.registerVillagerOffers(SOCKS_TRADER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 6),
                                                             new ItemStack(RYSOItems.SOCKS),
                                                             8,
                                                             12,
                                                             0.075f
            ));
        });
        TradeOfferHelper.registerVillagerOffers(SOCKS_TRADER, 1, factories -> {
            factories.add((entity, random) -> {
                if (random.nextFloat() > 0.5)
                    return new TradeOffer(new ItemStack(Items.EMERALD, 4),
                                          new ItemStack(Items.COOKIE, 16),
                                          8,
                                          12,
                                          0.075f
                    );
                var allWool = Arrays
                        .stream(Items.class.getDeclaredFields())
                        .filter(field -> field.getType()
                                         == Item.class && field
                                                 .getName()
                                                 .endsWith("_WOOL"))
                        .map(field -> {
                            try {
                                return (Item) field.get(null);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException("Failed to access item field: " + field.getName(), e);
                            }
                        })
                        .toList();
                return new TradeOffer(new ItemStack(allWool.get(random.nextInt(allWool.size())), 4),
                                      new ItemStack(Items.EMERALD),
                                      8,
                                      12,
                                      0.075f
                );
            });
        });
        // Level 2: 10 emeralds for a cake AND 16 dyes for 1 emerald
        TradeOfferHelper.registerVillagerOffers(SOCKS_TRADER, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 10),
                                                             new ItemStack(Items.CAKE),
                                                             6,
                                                             12,
                                                             0.075f
            ));
        });
        TradeOfferHelper.registerVillagerOffers(SOCKS_TRADER, 2, factories -> {
            factories.add((entity, random) -> {
                var allDyes = Arrays
                        .stream(Items.class.getDeclaredFields())
                        .filter(field -> field.getType()
                                         == Item.class && field
                                                 .getName()
                                                 .endsWith("_DYE"))
                        .map(field -> {
                            try {
                                return (Item) field.get(null);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException("Failed to access item field: " + field.getName(), e);
                            }
                        })
                        .toList();
                return new TradeOffer(new ItemStack(allDyes.get(random.nextInt(allDyes.size())), 16),
                                      new ItemStack(Items.EMERALD),
                                      6,
                                      12,
                                      0.075f
                );
            });
        });
        // Level 3: 40 emeralds and 10 bones for a vertebra OR 40 emeralds and 10 rotten flesh for a cursed flesh
        TradeOfferHelper.registerVillagerOffers(SOCKS_TRADER, 3, factories -> {
            factories.add((entity, random) -> {
                if (random.nextFloat() > 0.5)
                    return new TradeOffer(new ItemStack(Items.EMERALD, 40),
                                          new ItemStack(Items.BONE, 10),
                                          new ItemStack(RYSOItems.VERTEBRA),
                                          4,
                                          12,
                                          0.075f
                    );
                return new TradeOffer(new ItemStack(Items.EMERALD, 40),
                                      new ItemStack(Items.ROTTEN_FLESH, 10),
                                      new ItemStack(RYSOItems.CURSED_FLESH),
                                      4,
                                      12,
                                      0.075f
                );
            });
        });
        // Level 4: 32 emeralds and blank socks for Grandmas Socks
        TradeOfferHelper.registerVillagerOffers(SOCKS_TRADER, 4, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 32),
                                                             new ItemStack(RYSOItems.SOCKS),
                                                             // TODO (2.0): Change this to Grandma's Socks
                                                             new ItemStack(RYSOItems.CHRISTMAS_SOCKS),
                                                             4,
                                                             12,
                                                             0.075f
            ));
        });
        // Level 5: 64 emeralds and blank socks for a pair of "coloured" socks
        TradeOfferHelper.registerVillagerOffers(SOCKS_TRADER, 5, factories -> {
            factories.add((entity, random) -> {
                var colouredSocks = List.of(RYSOItems.LIGHT_GRAY_SOCKS,
                                            RYSOItems.GRAY_SOCKS,
                                            RYSOItems.BLACK_SOCKS,
                                            RYSOItems.BROWN_SOCKS,
                                            RYSOItems.RED_SOCKS,
                                            RYSOItems.ORANGE_SOCKS,
                                            RYSOItems.YELLOW_SOCKS,
                                            RYSOItems.LIME_SOCKS,
                                            RYSOItems.GREEN_SOCKS,
                                            RYSOItems.CYAN_SOCKS,
                                            RYSOItems.LIGHT_BLUE_SOCKS,
                                            RYSOItems.BLUE_SOCKS,
                                            RYSOItems.PURPLE_SOCKS,
                                            RYSOItems.MAGENTA_SOCKS,
                                            RYSOItems.PINK_SOCKS
                );
                return new TradeOffer(new ItemStack(Items.EMERALD, 64),
                                      new ItemStack(RYSOItems.SOCKS),
                                      new ItemStack(colouredSocks.get(random.nextInt(colouredSocks.size()))),
                                      6,
                                      12,
                                      0.075f
                );
            });
        });
    } */
}
