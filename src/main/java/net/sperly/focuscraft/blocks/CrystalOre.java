package net.sperly.focuscraft.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;

public class CrystalOre extends BlockBase{

    public CrystalOre() {
        super(Properties.create(Material.ROCK)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .hardnessAndResistance(5.0f, 6.0f)
                .setRequiresTool());
        this.setDefaultState(
                this.stateContainer.getBaseState()
                        .with(FACING, Direction.NORTH));
    }
}
