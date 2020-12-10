package net.sperly.focuscraft;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.sperly.focuscraft.init.FocusCraftBlocks;
import net.sperly.focuscraft.init.FocusCraftItems;
import net.sperly.focuscraft.world.gen.FocusCraftOreGen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FocusCraft.MOD_ID)
public class FocusCraft
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "focuscraft";

    public FocusCraft() {
        LOGGER.info("Initializing FocusCraft");

        final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::setup);

        FocusCraftBlocks.init();
        FocusCraftItems.init();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Prepare ore generation");
        FocusCraftOreGen.generateOre();
    }

    public static final ItemGroup TAB = new ItemGroup("focuscraftTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(FocusCraftBlocks.FOCUS_TABLE_WOOD.get());
        }
    };
}
