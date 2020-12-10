package net.sperly.focuscraft.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CrystalBlock extends BlockBase{


    public CrystalBlock() {
        super(Properties.create(Material.ROCK)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.GLASS)
                .harvestLevel(1)
                .hardnessAndResistance(4.0f, 6.0f)
                .setRequiresTool());
    }
}
