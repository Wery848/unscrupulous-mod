package com.github.Wery848.unscrupulous.item;

import com.github.Wery848.unscrupulous.UnscrupulousMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {
    // Deferred Register for items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UnscrupulousMod.MODID);

    // Item registries
    // Old Registry Style
//    public static final DeferredItem<Item> SOUL_STONE = ITEMS.register("soul_stone",
//            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(UnscrupulousMod.MODID, "soul_stone")))
//            ));

    // New & Improved - 12/3/24
    public static final DeferredItem<Item> SOUL_STONE = createItemWithProps("soul_stone", new Item.Properties());


    // Register method for items
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    // Utility Methods

    // Register Item (adds default resource key)
    private static DeferredItem<Item> createItemWithProps(String name, Item.Properties itemProps) {
        return ITEMS.register(name,
                () -> new Item(itemProps.setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(UnscrupulousMod.MODID, name)))));
    }
}
