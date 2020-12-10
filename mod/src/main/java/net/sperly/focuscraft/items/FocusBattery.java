package net.sperly.focuscraft.items;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.Optional;

public class FocusBattery extends ItemBase{

    public static final String NBT_TAG_NAME_TYPE = "type";
    public static final String NBT_TAG_NAME_USES = "uses";
    protected final int usages = 0;
    protected final String name = "";

    public FocusBattery() {
        super(1);

    }

    public void updateUsagesIntoNBT(ItemStack stack)
    {
        CompoundNBT compoundNBT = stack.getTag();
        compoundNBT.putInt(NBT_TAG_NAME_USES, usages);
    }

    public void setType(ItemStack stack, EnumBatteryTypes type)
    {

    }

    @Override
    public String getTranslationKey(ItemStack stack)
    {
        EnumBatteryTypes type = getTypeFromStack(stack);
        return super.getTranslationKey(stack) + "." + type.getString();
    }

    @Override
    public ITextComponent getDisplayName(ItemStack stack)
    {
        String fullnessText = String.valueOf(getUsesLeft(stack.getTag()));
        return new TranslationTextComponent(this.getTranslationKey(stack), fullnessText);
        // the entry in the lang file contains a %s which inserts our fullnessText into the description
    }


    public static EnumBatteryTypes getTypeFromStack(ItemStack stack)
    {
        CompoundNBT compoundNBT = stack.getTag();
        return getType(compoundNBT);
    }

    public static EnumBatteryTypes getType(CompoundNBT compoundNBT)
    {
        byte typeID = 0;  // default in case of error
        if (compoundNBT != null && compoundNBT.contains(NBT_TAG_NAME_TYPE)) {
            typeID = compoundNBT.getByte(NBT_TAG_NAME_TYPE);
        }
        return EnumBatteryTypes.getTypeFromID(typeID);
    }

    public static int getUsesLeft(CompoundNBT compoundNBT)
    {
        int uses = 0;
        if (compoundNBT != null && compoundNBT.contains(NBT_TAG_NAME_USES)) {
            uses = compoundNBT.getByte(NBT_TAG_NAME_USES);
        }
        return uses;
    }

    public enum EnumBatteryTypes implements IStringSerializable {
        WOOD(0, "wood", 3),
        STONE(1, "stone", 5),
        IRON(2, "iron", 9),
        DIAMOND(3, "diamond", 15),
        CRYSTAL(3, "crystal", 25);

        @Override
        public String toString() {
            return this.name;
        }

        @Override
        public String getString() {
            return this.name;
        }

        public int getMaxUsages() {
            return usages;
        }

        private final byte type;
        private final String name;
        private final int usages;

        EnumBatteryTypes(int i_type, String i_name, int i_usages) {
            this.type = (byte) i_type;
            this.name = i_name;
            this.usages = i_usages;
        }

        private static EnumBatteryTypes getTypeFromID(byte ID) {
            for (EnumBatteryTypes type : EnumBatteryTypes.values()) {
                if (type.type == ID) return type;
            }
            return null;
        }
    }
}
