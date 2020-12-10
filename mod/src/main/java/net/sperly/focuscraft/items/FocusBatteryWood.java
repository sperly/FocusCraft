package net.sperly.focuscraft.items;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.sperly.focuscraft.capabilities.BatteryCapability;
import org.lwjgl.system.CallbackI;

public class FocusBatteryWood extends ItemBase{

    public FocusBatteryWood()
    {
        super(1, 3);

        ItemStack stack = new ItemStack(this);
        CompoundNBT compoundNBT = stack.getOrCreateTag();
        compoundNBT.putByte("type", (byte)1);
        compoundNBT.putInt("value", 5);
        stack.setTag(compoundNBT);
        
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
        return new BatteryCapability(this.getClass());
    }
}
