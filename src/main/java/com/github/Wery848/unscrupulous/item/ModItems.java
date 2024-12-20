package com.github.Wery848.unscrupulous.item;

import com.github.Wery848.unscrupulous.UnscrupulousMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    // Deferred Register for items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UnscrupulousMod.MODID);

    // New & Improved - 12/3/24
    public static final DeferredItem<Item> SOUL_STONE = createItemWithProps("soul_stone", new Item.Properties());

    // Register method for items
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    // Utility Methods
    // Register Item (adds default resource key)
    public static DeferredItem<Item> createItemWithProps(String name, Item.Properties itemProps) {
        return ITEMS.register(name,
                () -> new Item(itemProps.setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(UnscrupulousMod.MODID, name)))));
    }

}
