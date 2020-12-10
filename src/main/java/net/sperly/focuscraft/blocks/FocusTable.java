package net.sperly.focuscraft.blocks;

import net.minecraft.block.HorizontalBlock;
import net.minecraft.state.DirectionProperty;


public class FocusTable extends BlockBase{

    protected static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public FocusTable(Properties properties) {
        super(properties.harvestLevel(0));
    }
}
