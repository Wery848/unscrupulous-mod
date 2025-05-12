package io.github.Wery848.unscrupulous.events;

import io.github.Wery848.unscrupulous.UnscrupulousMod;
import io.github.Wery848.unscrupulous.attached_data.SensusStat;
import io.github.Wery848.unscrupulous.item.ModItems;
import io.github.Wery848.unscrupulous.item.ModPotions;
import net.minecraft.network.chat.Component;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.GameType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@EventBusSubscriber(modid = UnscrupulousMod.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    @SubscribeEvent
    public static void onLivingDeathEvent(LivingDeathEvent event) {
        if(event.getEntity() instanceof Player) {
            // If a player dies, his Sensus is checked,
            // if his Sensus is 0 or lower, the player is set to spectator mode
            Player player = (Player) event.getEntity();
            if(player.getData(SensusStat.SENSUS) <= 0) {
                PlayerList playerlist = player.getServer().getPlayerList();
                playerlist.getPlayer(player.getUUID()).setGameMode(GameType.SPECTATOR);
                player.getServer().sendSystemMessage(Component.literal("Hey there, you should be in spectator mode now."));
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        // If a player joins for the first time, the player's Sensus is set to a full 20.
        Player player = event.getEntity();
        if(!player.hasData(SensusStat.JOINED)) {
            player.getData(SensusStat.SENSUS);
            player.setData(SensusStat.SENSUS, 20);
            player.setData(SensusStat.JOINED, 1);
            player.getServer().sendSystemMessage(Component.literal("First join for you, Sensus is 20"));
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        // Should hopefully, copy a player sensus stat on death...
        if(event.isWasDeath()) {
            if (event.getOriginal().hasData(SensusStat.SENSUS)) {
                event.getEntity().setData(SensusStat.SENSUS, event.getOriginal().getData(SensusStat.SENSUS));
            }
            if (event.getOriginal().hasData(SensusStat.JOINED)) {
                event.getEntity().setData(SensusStat.JOINED, event.getOriginal().getData(SensusStat.JOINED));
            }
        }
    }

    // Brewing Recipe for Sensus Fire Potion
    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(ModPotions.SENSUS_SOLUTION, ModItems.BOTTLED_FLAME.get(), ModPotions.SENSUS_POTION);
        builder.addMix(Potions.WATER, ModItems.REFINED_SENSUS.get(), ModPotions.SENSUS_SOLUTION);
    }
}
