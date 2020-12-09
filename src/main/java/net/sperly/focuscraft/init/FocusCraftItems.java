package net.sperly.focuscraft.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sperly.focuscraft.FocusCraft;
import net.sperly.focuscraft.blocks.BlockItemBase;
import net.sperly.focuscraft.items.Crystal;
import net.sperly.focuscraft.items.FocusLensStone;
import net.sperly.focuscraft.items.FocusLensWood;
import net.sperly.focuscraft.items.LensHolder;

public class FocusCraftItems {

    public static void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Register
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FocusCraft.MOD_ID);

    //Items
    public static final RegistryObject<Item> CRYSTAL = ITEMS.register("crystal", () -> new Crystal());
    public static final RegistryObject<Item> LENS_HOLDER = ITEMS.register("lens_holder", () -> new LensHolder());
    public static final RegistryObject<Item> LENS_WOOD = ITEMS.register("lens_wood", () -> new FocusLensWood());
    public static final RegistryObject<Item> LENS_STONE = ITEMS.register("lens_stone", () -> new FocusLensStone());

    //BlockItems
    public static final RegistryObject<Item> FOCUS_TABLE_WOOD_ITEM = ITEMS.register("focus_table_wood", () -> new BlockItemBase(FocusCraftBlocks.FOCUS_TABLE_WOOD.get()));
    public static final RegistryObject<Item> FOCUS_TABLE_STONE_ITEM = ITEMS.register("focus_table_stone", () -> new BlockItemBase(FocusCraftBlocks.FOCUS_TABLE_STONE.get()));
    public static final RegistryObject<Item> CRYSTAL_ORE_ITEM = ITEMS.register("crystal_ore", () -> new BlockItemBase(FocusCraftBlocks.CRYSTAL_ORE.get()));
    public static final RegistryObject<Item> CRYSTAL_BLOCK_ITEM = ITEMS.register("crystal_block", () -> new BlockItemBase(FocusCraftBlocks.CRYSTAL_BLOCK.get()));

}
