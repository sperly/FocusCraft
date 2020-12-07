package net.sperly.focuscraft.init;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sperly.focuscraft.FocusCraft;
import net.sperly.focuscraft.blocks.CrystalBlock;
import net.sperly.focuscraft.blocks.CrystalOre;
import net.sperly.focuscraft.blocks.FocusTableStone;
import net.sperly.focuscraft.blocks.FocusTableWood;

public class FocusCraftBlocks {

    public static void init()
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FocusCraft.MOD_ID);


    //Blocks
    public static final RegistryObject<Block> FOCUS_TABLE_WOOD = BLOCKS.register("focus_table_wood", () -> new FocusTableWood());
    public static final RegistryObject<Block> FOCUS_TABLE_STONE = BLOCKS.register("focus_table_stone", () -> new FocusTableStone());
    public static final RegistryObject<Block> CRYSTAL_ORE = BLOCKS.register("crystal_ore", () -> new CrystalOre());
    public static final RegistryObject<Block> CRYSTAL_BLOCK = BLOCKS.register("crystal_block", () -> new CrystalBlock());}
