package me.Cleardragonf.HOS;


import com.google.inject.Inject;
import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.world.World;

import java.util.Optional;
import java.util.logging.Logger;

@Plugin(id = "Hell On Sponge", name = "Hell On Sponge", version = "Beta.1.0")


public class MainClass {
    
    @Inject
    private Logger logger;
    
    @Inject
    private void setLogger(Logger logger){
        this.logger = logger;
    }
    public Logger getLogger(){
        return logger;
    }
    @Inject 
    Game game;
    
    @Listener
    public void Destroy(ChangeBlockEvent.Break event) {
        for (Transaction<BlockSnapshot> transaction : event.getTransactions()) {
            BlockSnapshot blockSnapshot = transaction.getOriginal();
            BlockState block = blockSnapshot.getState();
            if (block.getType().equals(BlockTypes.SEA_LANTERN)) {
                if (!event.getCause().first(Player.class).isPresent()) {
                    return;
                }
                Player player = event.getCause().first(Player.class).get();
                Optional<World> worldOpt = Sponge.getGame().getServer().getWorld("world");
                if(worldOpt.isPresent()){
                    World w = worldOpt.get();
                    player.setLocationSafely(w.getSpawnLocation());
                }            
            }
            if (block.getType().equals(BlockTypes.DIRT)) {
                if (!event.getCause().first(Player.class).isPresent()) {
                    return;
                }
                Player player = event.getCause().first(Player.class).get();
                Optional<World> worldOpt = Sponge.getGame().getServer().getWorld("world");
                if(worldOpt.isPresent()){
                    player.sendMessage(Texts.of("Ha you Dirty Man"));
                }
            }
            if (block.getType().equals(BlockTypes.GRASS)) {
                if (!event.getCause().first(Player.class).isPresent()) {
                    return;
                }
                Player player = event.getCause().first(Player.class).get();
                Optional<World> worldOpt = Sponge.getGame().getServer().getWorld("world");
                if(worldOpt.isPresent()){
                    player.sendMessage(Texts.of("Why Must it Be Grass Stains!"));
                }
            }
            if (block.getType().equals(BlockTypes.IRON_ORE)) {
                if (!event.getCause().first(Player.class).isPresent()) {
                    return;
                }
                Player player = event.getCause().first(Player.class).get();
                Optional<World> worldOpt = Sponge.getGame().getServer().getWorld("world");
                if(worldOpt.isPresent()){
                    Sponge.getGame().getServer().getBroadcastSink().sendMessage(Texts.of(TextColors.GOLD, player + "has dug up some iron"));
                }
            }
            if (block.getType().equals(BlockTypes.GOLD_ORE)) {
                if (!event.getCause().first(Player.class).isPresent()) {
                    return;
                }
                Player player = event.getCause().first(Player.class).get();
                Optional<World> worldOpt = Sponge.getGame().getServer().getWorld("world");
                if(worldOpt.isPresent()){
                    Sponge.getGame().getServer().getBroadcastSink().sendMessage(Texts.of(TextColors.GOLD, player + "has dug up some gold"));
                }
            }
            if (block.getType().equals(BlockTypes.DIAMOND_ORE)) {
                if (!event.getCause().first(Player.class).isPresent()) {
                    return;
                }
                Player player = event.getCause().first(Player.class).get();
                Optional<World> worldOpt = Sponge.getGame().getServer().getWorld("world");
                if(worldOpt.isPresent()){
                    Sponge.getGame().getServer().getBroadcastSink().sendMessage(Texts.of(TextColors.GOLD, player + "has discovered some DIAMONDS!!!"));
                }
            }
        }       
    }
}
