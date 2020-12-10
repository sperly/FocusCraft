package net.sperly.focuscraft.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Optional;

public class FocusBattery extends ItemBase {

    public static final String NBT_TAG_NAME_TYPE= "type";
    public static final String NBT_TAG_NAME_USES = "uses";

    public int maxUses = 3;

    public FocusBattery(BatteryType type)
    {
        super(1);
        maxUses = type.getUses();
    }

    public static float getUsesPropertyOverride(ItemStack itemStack, @Nullable World world, @Nullable LivingEntity livingEntity)
    {
        BatteryType battery = getUses(itemStack);
        return battery.getPropertyOverrideValue();
    }

    public static BatteryType getType(ItemStack stack)
    {
        CompoundNBT compoundNBT = stack.getOrCreateTag();
        return BatteryType.fromNBT(compoundNBT, NBT_TAG_NAME_TYPE);
    }

    public static void setType(ItemStack stack, BatteryType battery)
    {
        CompoundNBT compoundNBT = stack.getOrCreateTag();
        battery.putIntoNBT(compoundNBT, NBT_TAG_NAME_TYPE
        );
    }

    public static BatteryType getUses(ItemStack stack)
    {
        CompoundNBT compoundNBT = stack.getOrCreateTag();
        return BatteryType.fromNBT(compoundNBT, NBT_TAG_NAME_USES);
    }

    public static void setUses(ItemStack stack, BatteryType battery)
    {
        CompoundNBT compoundNBT = stack.getOrCreateTag();
        battery.putIntoNBT(compoundNBT, NBT_TAG_NAME_USES);
    }

//    @Override
//    // Make a unique name for each flavour (lime, orange, etc) so we can name them individually
//    //  The fullness information is added separately in getItemStackDisplayName()
//    public String getTranslationKey(ItemStack stack)
//    {
//        BatteryType type = getType(stack);
//        return super.getTranslationKey(stack);
//    }

    @Override
    public ITextComponent getDisplayName(ItemStack stack)
    {
        String usesText = Integer.toString(getUses(stack).uses);
        return new TranslationTextComponent(this.getTranslationKey(stack), usesText);
        // the entry in the lang file contains a %s which inserts our fullnessText into the description
    }

    public enum BatteryType implements IStringSerializable
    {
        WOOD(0, "wood", 3),
        STONE(1, "stone", 5),
        IRON(2, "iron", 7),
        DIAMOND(3, "diamond", 9),
        CRYSTAL(4, "crystal", 64);

        public float getPropertyOverrideValue() {return nbtID;}

        public BatteryType decreaseUsesByOneStep() {
            if (nbtID ==0) return this;
            for (BatteryType battery : BatteryType.values()) {
                if (battery.nbtID == nbtID - 1) return battery;
            }
            return this;
        }

        @Override
        public String toString()
        {
            return this.name;
        }

        @Override
        public String getString() {return this.name;}

        public int getUses() {return this.uses;}

        public static BatteryType fromNBT(CompoundNBT compoundNBT, String tagname)
        {
            byte typeID = 0;  // default in case of error
            if (compoundNBT != null && compoundNBT.contains(tagname)) {
                typeID = compoundNBT.getByte(tagname);
            }
            Optional<BatteryType> type = getTypeFromID(typeID);
            return type.orElse(WOOD);
        }

        public void putIntoNBT(CompoundNBT compoundNBT, String tagname)
        {
            compoundNBT.putByte(tagname, nbtID);
        }

        private final byte nbtID;
        private final String name;
        private final int uses;

        BatteryType(int i_NBT_ID, String i_name, int i_uses)
        {
            this.nbtID = (byte)i_NBT_ID;
            this.name = i_name;
            this.uses = i_uses;
        }

        private static Optional<BatteryType> getTypeFromID(byte ID) {
            for (BatteryType flavour : BatteryType.values()) {
                if (flavour.nbtID == ID) return Optional.of(flavour);
            }
            return Optional.empty();
        }
    }

}
