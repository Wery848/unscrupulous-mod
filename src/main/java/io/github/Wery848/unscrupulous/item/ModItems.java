package io.github.Wery848.unscrupulous.item;

import io.github.Wery848.unscrupulous.UnscrupulousMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    // Deferred Register for items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UnscrupulousMod.MODID);

    // New & Improved - 12/3/24
    public static final DeferredItem<Item> UNREFINED_SENSUS = createItemWithProps("unrefined_sensus", new Item.Properties());
    public static final DeferredItem<Item> REFINED_SENSUS = createItemWithProps("refined_sensus", new Item.Properties());
    public static final DeferredItem<Item> BOTTLED_FLAME = createItemWithProps("bottled_flame", new Item.Properties());

    public static final DeferredItem<Item> SENSUS_APPLE = createItemWithProps("sensus_apple", new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(0.8f)
                    .alwaysEdible().build()
    ));

    public static final DeferredItem<Item> SENSUS = createItemWithProps("sensus_item", new Item.Properties().fireResistant());

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
