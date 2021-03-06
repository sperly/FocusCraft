package net.sperly.focuscraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;

public class CrystalBlock extends BlockBase{
    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public CrystalBlock() {
        super(Properties.create(Material.ROCK)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.GLASS)
                .harvestLevel(1)
                .hardnessAndResistance(4.0f, 6.0f)
                .setRequiresTool());
        this.setDefaultState(
                this.stateContainer.getBaseState()
                        .with(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(FACING);
    }
}
