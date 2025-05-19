package io.github.Wery848.unscrupulous.attached_data;

import io.github.Wery848.unscrupulous.UnscrupulousMod;
import com.mojang.serialization.Codec;
import net.minecraft.network.chat.Component;
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

    public static final Supplier<AttachmentType<Integer>> SENSUS_COOLDOWN = ATTACHMENT_TYPES.register(
            "sensus_cooldown", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );

    public static void register(IEventBus eventBus) {
        ATTACHMENT_TYPES.register(eventBus);
    }

    public static boolean changePlayerSensusCooldown(Player player, int amount) {
        int cooldown = player.getData(SENSUS_COOLDOWN); // Default is 0
        if(playerHasSensus(player) && cooldown < player.tickCount) {
            player.setData(SENSUS_COOLDOWN, player.tickCount + 1); // 20 = 1 sec
            player.setData(SENSUS, player.getData(SENSUS) + amount);
            player.getServer().sendSystemMessage(Component.literal("Changed player sensus successfully"));
            return true;
        }
        return false;
    }

    public static boolean changePlayerSensus(Player player, int amount) {
        if(playerHasSensus(player)) {
            player.setData(SENSUS, player.getData(SENSUS) + amount);
            return true;
        }
        return false;
    }

    public static boolean sensusCooldownStatus(Player player) {
        if(player.getData(SENSUS_COOLDOWN) < player.tickCount) {
            return true;
        }
        return false;
    }

    public static boolean playerHasSensus(Player player) {
        return player.getData(SENSUS) > 0;
    }

}
