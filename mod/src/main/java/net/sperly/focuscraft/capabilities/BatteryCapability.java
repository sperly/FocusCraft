package net.sperly.focuscraft.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class BatteryCapability extends CapabilityProvider implements ICapabilitySerializable<CompoundNBT> {
    public BatteryCapability(Class baseClass) {
        super(baseClass);
    }

    private static final String USES_TAG = "uses";

    @Override
    public LazyOptional<ItemStackHandler> getCapability(Capability cap, Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return LazyOptional.of(() -> this.inventory);
        return super.getCapability(cap, side);
    }


    @Override
    public CompoundNBT serializeNBT() {

        CompoundNBT nbt = new CompoundNBT();
        nbt.put(INVENTORY_TAG, this.inventory.serializeNBT());

        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.inventory.deserializeNBT(nbt);
    }
}