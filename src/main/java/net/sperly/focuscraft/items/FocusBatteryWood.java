package net.sperly.focuscraft.items;

import net.minecraft.item.ItemStack;

public class FocusBatteryWood extends FocusBattery{
    public FocusBatteryWood() {
        super(BatteryType.WOOD);
        ItemStack subItemStack = new ItemStack(this, 1);
        setType(subItemStack, BatteryType.WOOD);
        setUses(subItemStack, BatteryType.WOOD);
    }
}
