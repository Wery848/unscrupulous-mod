package io.github.Wery848.unscrupulous.attached_data;

import io.github.Wery848.unscrupulous.UnscrupulousMod;
import com.mojang.serialization.Codec;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class SensusStat {
    // Create the DeferredRegister for attachment types
    private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, UnscrupulousMod.MODID);

    public static final Supplier<AttachmentType<Integer>> JOINED = ATTACHMENT_TYPES.register(
            "joined", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );

    public static final Supplier<AttachmentType<Integer>> SENSUS = ATTACHMENT_TYPES.register(
            "sensus", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );

    private static final Supplier<AttachmentType<Integer>> SENSUS_COOLDOWN = ATTACHMENT_TYPES.register(
            "sensus_cooldown", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );

    public static void register(IEventBus eventBus) {
        ATTACHMENT_TYPES.register(eventBus);
    }

    public static void changePlayerSensus(Player player, int amount) {
        int cooldown = player.getData(SENSUS_COOLDOWN); // Default is 0
        if(cooldown < player.tickCount) {
            player.setData(SENSUS_COOLDOWN, player.tickCount + 20); // 20 = 1 sec
            player.setData(SENSUS, player.getData(SENSUS) + amount);
            //player.getServer().sendSystemMessage(Component.literal("player sensus changed"));
        }
    }


}
