package com.hitchainapi.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    /**
     * Create an ItemBuilder with a specific item type.
     * @param material The material for the item.
     */
    public ItemBuilder(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = itemStack.getItemMeta();
    }

    /**
     * Set the name of the item.
     * @param name The name to set.
     * @return The current ItemBuilder instance.
     */
    public ItemBuilder setName(String name) {
        if (itemMeta != null) {
            itemMeta.setDisplayName(name);
        }
        return this;
    }

    /**
     * Add a lore to the item.
     * @param lore The lore to add.
     * @return The current ItemBuilder instance.
     */
    public ItemBuilder addLore(String lore) {
        if (itemMeta != null) {
            List<String> loreList = itemMeta.hasLore() ? itemMeta.getLore() : new ArrayList<>();
            loreList.add(lore);
            itemMeta.setLore(loreList);
        }
        return this;
    }

    /**
     * Set the lore of the item.
     * @param lore The list of lore lines to set.
     * @return The current ItemBuilder instance.
     */
    public ItemBuilder setLore(List<String> lore) {
        if (itemMeta != null) {
            itemMeta.setLore(lore);
        }
        return this;
    }

    /**
     * Set the item to be unbreakable.
     * @return The current ItemBuilder instance.
     */
    public ItemBuilder setUnbreakable() {
        if (itemMeta != null) {
            itemMeta.setUnbreakable(true);
        }
        return this;
    }

    /**
     * Set the item in the item stack.
     * @return The built ItemStack.
     */
    public ItemStack build() {
        if (itemMeta != null) {
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
}

