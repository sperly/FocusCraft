package net.sperly.focuscraft.items;

import net.minecraft.item.Item;

import net.sperly.focuscraft.FocusCraft;

public class ItemBase extends Item {
    public ItemBase(int stacksize) {
        super(new Item.Properties().group(FocusCraft.TAB).maxStackSize(stacksize));
    }

    public ItemBase() {
        super(new Item.Properties().group(FocusCraft.TAB));
    }
}
