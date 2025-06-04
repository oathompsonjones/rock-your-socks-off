package uk.co.oathompsonjones;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Arrays;
import java.util.List;

public class RYSOBlocks {
    public static final Block WARDEN_ANTENNA = register(new WardenAntennaBlock(),
                                                        "warden_antenna",
                                                        new Item.Settings().rarity(Rarity.RARE)
    );

    public static final List<Block> BLOCKS = Arrays
            .stream(RYSOBlocks.class.getDeclaredFields())
            .filter(field -> field.getType() == Block.class)
            .map(field -> {
                try {
                    return (Block) field.get(null);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to access block field: " + field.getName(), e);
                }
            })
            .toList();

    public static Block register(Block block, String name, Item.Settings itemSettings) {
        return register(block, name, true, itemSettings);
    }

    public static Block register(Block block, String name, boolean shouldRegisterItem, Item.Settings itemSettings) {
        Identifier id = new Identifier(RYSO.MOD_ID, name);
        if (shouldRegisterItem)
            Registry.register(Registries.ITEM, id, new BlockItem(block, itemSettings));
        return Registry.register(Registries.BLOCK, id, block);
    }

    public static void initialize() {
        for (var block : BLOCKS)
            ItemGroupEvents.modifyEntriesEvent(RYSOItems.ITEM_GROUP).register((group) -> group.add(block.asItem()));
    }

    private static class WardenAntennaBlock extends FacingBlock {
        public WardenAntennaBlock() {
            super(AbstractBlock.Settings.create().sounds(BlockSoundGroup.SCULK_SENSOR).noCollision().nonOpaque());
        }

        @Override
        public BlockState getPlacementState(ItemPlacementContext ctx) {
            Direction side = ctx.getSide();
            if (side == Direction.UP || side == Direction.DOWN)
                return null;

            return this.getDefaultState().with(FACING, side);
        }

        @Override
        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
            builder.add(FACING);
        }

        @Override
        public void neighborUpdate(
                BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify
        ) {
            super.neighborUpdate(state, world, pos, block, fromPos, notify);
            Direction facing     = state.get(FACING);
            BlockPos  supportPos = pos.offset(facing.getOpposite());
            if (!world.getBlockState(supportPos).isSolidBlock(world, supportPos))
                world.breakBlock(pos, true);
        }

        @Override
        public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
            Direction facing      = state.get(FACING);
            BlockPos  attachedPos = pos.offset(facing.getOpposite());
            return world.getBlockState(attachedPos).isSideSolidFullSquare(world, attachedPos, facing);
        }

        @Override
        public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
            return switch (state.get(FACING)) {
                case NORTH -> Block.createCuboidShape(7, 3, 6, 9, 13, 16);
                case SOUTH -> Block.createCuboidShape(7, 3, 0, 9, 13, 10);
                case WEST -> Block.createCuboidShape(6, 3, 7, 16, 13, 9);
                case EAST -> Block.createCuboidShape(0, 3, 7, 10, 13, 9);
                default -> VoxelShapes.fullCube();
            };
        }
    }
}
