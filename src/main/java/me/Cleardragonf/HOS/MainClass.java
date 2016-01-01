package me.Cleardragonf.HOS;

import com.google.gson.Gson;
import com.google.inject.Inject;
import me.Cleardragonf.HOS.Portal.Portal;
import me.Cleardragonf.HOS.Portal.PortalManager;
import me.Cleardragonf.HOS.Portal.RemovePortal;
import me.Cleardragonf.HOS.Portal.SetPortal;
import me.Flibio.EconomyLite.API.EconomyLiteAPI;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.cause.entity.damage.source.EntityDamageSource;
import org.spongepowered.api.event.entity.DestructEntityEvent;
import org.spongepowered.api.event.entity.SpawnEntityEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextFormat;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;

@Plugin(id="HellOnSpongee", name="Hell On Spongee", version="0.0.1-SNAPSHOT", dependencies="required-after:EconomyLite")
public class MainClass
{
    
    /**/
    public static final String FILE_LOCATION = "mods/HellOnSpoangee/portals.dat";
    public static final String NAME = "[HOS]";
    private static PortalManager portalManager;

@Inject
  private Logger logger;
  @Inject
  @DefaultConfig(sharedRoot=false)
  private File configFile;
  @Inject
  @DefaultConfig(sharedRoot=false)
  ConfigurationLoader<CommentedConfigurationNode> configManager;
  public EconomyLiteAPI economy;
  @Inject
  Game game;
  
  @Inject
  private void setLogger(Logger logger)
  {
    this.logger = logger;
  }
  
  public Logger getLogger()
  {
    return this.logger;
  }
  
  @Listener
  public void onSpawnEntity(SpawnEntityEvent event) {
      for (EntitySnapshot entitySnapshot : event.getEntitySnapshots()) {
          if (entitySnapshot.getType().equals(EntityTypes.BLAZE)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Blaze", "Blaze#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Blaze", "Blaze%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.BLAZE, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.CAVE_SPIDER)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "CaveSpider", "CaveSpider#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "CaveSpider", "CaveSpider%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.CAVE_SPIDER, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.CHICKEN)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();                  
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Chicken", "Chicken#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <=(ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Chicken", "Chicken%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.CHICKEN, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.COW)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();            
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Cow", "Cow#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Cow", "Cow%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.COW, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.CREEPER)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Creeper", "Creeper#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Creeper", "Creeper%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.CREEPER, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.ENDER_DRAGON)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "EnderDragon", "EnderDragon#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "EnderDragon", "EnderDragon%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.ENDER_DRAGON, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.ENDERMAN)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Enderman", "Enderman#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Enderman", "Enderman%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.ENDERMAN, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.GHAST)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Ghast", "Ghast#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Ghast", "Ghast%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.GHAST, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.GIANT)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Giant", "Giant#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Giant", "Giant%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.GIANT, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.GUARDIAN)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Guardian", "Guardian#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Guardian", "Guardian%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.GUARDIAN, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.HORSE)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Horse", "Horse#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Horse", "Horse%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.HORSE, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.IRON_GOLEM)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "IronGolemn", "IronGolemn#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "IronGolemn", "IronGolemn%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.IRON_GOLEM, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.MAGMA_CUBE)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "MagmaCube", "MagmaCube#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "MagmaCube", "MagmaCube%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.MAGMA_CUBE, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.MUSHROOM_COW)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "MushroomCow", "MushroomCow#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "MushroomCow", "MushroomCow%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.MUSHROOM_COW, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.OCELOT)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Ocelot", "Ocelot#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Ocelot", "Ocelot%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.OCELOT, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.PIG)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Pig", "Pig#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Pig", "Pig%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.PIG, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.PIG_ZOMBIE)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "PigZombie", "PigZombie#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "PigZombie", "PigZombie%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.PIG_ZOMBIE, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.RABBIT)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Rabbit", "Rabbit#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Rabbit", "Rabbit%").getInt())){                 
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.RABBIT, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.SHEEP)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Sheep", "Sheep#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Sheep", "Sheep%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.SHEEP, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.SKELETON)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Skeleton", "Skeleton#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Skeleton", "Skeleton%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.SKELETON, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.SLIME)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Slime", "Slime#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Slime", "Slime%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.SLIME, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.SNOWMAN)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Snowman", "Snowman#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Snowman", "Snowman%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.SNOWMAN, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.SPIDER)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Spider", "Spider#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Spider", "Spider%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.SPIDER, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.SQUID)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Squid", "Squid#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Squid", "Squid%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.SQUID, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.WITCH)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Witch", "Withc#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Witch", "Witch%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.WITCH, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.WITHER)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Wither", "Wither#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Witehr", "Wither%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.WITHER, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.WOLF)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Wolf", "Wolf#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Wolf", "Wolf%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.WOLF, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
          if (entitySnapshot.getType().equals(EntityTypes.ZOMBIE)) {
              Optional<Location<World>> location = entitySnapshot.getLocation();
              if (location.isPresent()) {
                  World world = location.get().getExtent();
                  for (int i = 0; i < (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Zombie", "Zombie#").getInt()); i++) { // Do this 5 times
                      Random roll = new Random();
                      int answer = roll.nextInt(100)+1;
                      if (answer <= (ConfigurationManager.getInstance().getConfig().getNode("Spawning!", "Zombie", "Zombie%").getInt())){
                          Optional<Entity> newCreeper = world.createEntity(EntityTypes.ZOMBIE, location.get().getPosition());
                          if (newCreeper.isPresent()) {
                              event.getEntities().add(newCreeper.get());
                          }
                      }
                  }
              }

          }
      }
  }  

@Listener
  public void enable(GameStartingServerEvent event)
  {
    ConfigurationManager.getInstance().setup(this.configFile, this.configManager);
  }
  
  @Listener
  public void onServerInitialize(GameInitializationEvent event)
  {
    Optional<EconomyLiteAPI> economyAPI = Sponge.getGame().getServiceManager().provide(EconomyLiteAPI.class);
    if (economyAPI.isPresent()) {
      this.economy = ((EconomyLiteAPI)economyAPI.get());
    } else {
      this.logger.warning("Error enabling EconomyLiteAPI!");
    }
    
    /**/
    portalManager = loadPortal();

    // Register menger command
    Sponge.getCommandDispatcher().register(this, new Portal(), "opp");
    Sponge.getCommandDispatcher().register(this, new SetPortal(), "opps");
    Sponge.getCommandDispatcher().register(this, new RemovePortal(), "oppd");
    
  }
  
  /**/
  public static PortalManager getPortalManager() {
      return portalManager;
  }

  @SuppressWarnings("resource")
public static void savePortal() {
      File file = new File(FILE_LOCATION);

      File directory = new File("mods/warpl");
      directory.mkdirs();

      try {
          file.createNewFile();
      } catch (IOException e) {
          e.printStackTrace();
      }

      try {
          FileOutputStream fileOutputStream = new FileOutputStream(file);
          PrintStream printStream = new PrintStream(fileOutputStream);
          printStream.println(portalManager.toJson());
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  @SuppressWarnings({"deprecation", "resource"})
public static PortalManager loadPortal() {
      PortalManager portalManager1 = new PortalManager();

      File file = new File(FILE_LOCATION);

      try {
          FileInputStream fileInputStream = new FileInputStream(file);
          DataInputStream printStream = new DataInputStream(fileInputStream);

          String data = printStream.readLine();

          Gson gson = new Gson();

          PortalManager portalManager2 = gson.fromJson(data, PortalManager.class);

          portalManager1.setLocations(portalManager2.getPortal());
      } catch (Exception e) {
          e.printStackTrace();
      }

      return portalManager1;
  }
  /**/
  
  @Listener
  public void onDestructEntityEvent(DestructEntityEvent.Death event, @First EntityDamageSource src)
  {
    Entity killer = src.getSource();
    if ((killer instanceof Player))
    {
      Player player = (Player)killer;
      String player2 = player.getUniqueId().toString();
      if (event.getTargetEntity().getType().equals(EntityTypes.CHICKEN))
      {
        player.sendMessage(Texts.of("You Killed a Chicken & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Chicken" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.COW))
      {
        player.sendMessage(Texts.of("You Killed a Cow & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Cow" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.MUSHROOM_COW))
      {
        player.sendMessage(Texts.of("You Killed a Mushroom Cow some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "MushroomCow" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.PIG))
      {
        player.sendMessage(Texts.of("You Killed a Pig & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Pig" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.RABBIT))
      {
        player.sendMessage(Texts.of("You Killed a Rabbit & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Rabbit" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.SHEEP))
      {
        player.sendMessage(Texts.of("You Killed a Sheep & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Sheep" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.BAT))
      {
        player.sendMessage(Texts.of("You Killed a Bat & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Bat" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.BLAZE))
      {
        player.sendMessage(Texts.of("You Killed a Blaze & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Blaze" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.CAVE_SPIDER))
      {
        player.sendMessage(Texts.of("You Killed a CaveSpider & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "CaveSpider" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.CREEPER))
      {
        player.sendMessage(Texts.of("You Killed a Creeper & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Creeper" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.ENDER_DRAGON))
      {
        player.sendMessage(Texts.of("You Killed a EnderDragon & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "EnderDragon" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.ENDERMAN))
      {
        player.sendMessage(Texts.of("You Killed a Enderman & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Enderman" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.GHAST))
      {
        player.sendMessage(Texts.of("You Killed a Ghast & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Ghast" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.GIANT))
      {
        player.sendMessage(Texts.of("You Killed a Giant & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Giant" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.GUARDIAN))
      {
        player.sendMessage(Texts.of("You Killed a Guardian & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Guardian" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.HORSE))
      {
        player.sendMessage(Texts.of("You Killed a Horse & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Horse" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.HUMAN))
      {
        player.sendMessage(Texts.of("You Killed a Human & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Human" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.IRON_GOLEM))
      {
        player.sendMessage(Texts.of("You Killed a IronGolem & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "IronGolem" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.MAGMA_CUBE))
      {
        player.sendMessage(Texts.of("You Killed a MagmaCube & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "MagmaCube" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.OCELOT))
      {
        player.sendMessage(Texts.of("You Killed a Ocelot & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Ocelot" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.PIG_ZOMBIE))
      {
        player.sendMessage(Texts.of("You Killed a PigZombie & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "PigZombie" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.PLAYER))
      {
        player.sendMessage(Texts.of("You Killed a Player & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Player" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.SILVERFISH))
      {
        player.sendMessage(Texts.of("You Killed a SilverFish & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "SilverFish" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.SKELETON))
      {
        player.sendMessage(Texts.of("You Killed a Skeleton & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Skeleton" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.SLIME))
      {
        player.sendMessage(Texts.of("You Killed a Slime & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Slime" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.SNOWMAN))
      {
        player.sendMessage(Texts.of("You Killed a Snowman & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Snowman" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.SPIDER))
      {
        player.sendMessage(Texts.of("You Killed a Spider & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Spider" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.SQUID))
      {
        player.sendMessage(Texts.of("You Killed a Squid & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Squid" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.VILLAGER))
      {
        player.sendMessage(Texts.of("You Killed a Villager & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Villager" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.WITCH))
      {
        player.sendMessage(Texts.of("You Killed a Witch & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Witch" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.WITHER))
      {
        player.sendMessage(Texts.of("You Killed a Wither & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Wither" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.WOLF))
      {
        player.sendMessage(Texts.of("You Killed a Wolf & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Wolf" }).getInt());
      }
      if (event.getTargetEntity().getType().equals(EntityTypes.ZOMBIE))
      {
        player.sendMessage(Texts.of("You Killed a Zombie & earned some Money"));
        this.economy.getPlayerAPI().addCurrency(player2, ConfigurationManager.getInstance().getConfig().getNode(new Object[] { "Pay_4_Kills", "Zombie" }).getInt());
      }
    }
  }  
  @Listener
  public void Destroy(ChangeBlockEvent.Break event)
  {
    for (Transaction<BlockSnapshot> transaction : event.getTransactions())
    {
      BlockSnapshot blockSnapshot = (BlockSnapshot)transaction.getOriginal();
      BlockState block = blockSnapshot.getState();
      if (block.getType().equals(BlockTypes.SEA_LANTERN))
      {
        if (!event.getCause().first(Player.class).isPresent()) {
          return;
        }
        Player player = (Player)event.getCause().first(Player.class).get();
        Optional<World> worldOpt = Sponge.getGame().getServer().getWorld("world");
        if (worldOpt.isPresent())
        {
          World w = (World)worldOpt.get();
          player.setLocationSafely(w.getSpawnLocation());
        }
      }
      if (block.getType().equals(BlockTypes.DIRT))
      {
        if (!event.getCause().first(Player.class).isPresent()) {
          return;
        }
        Player player = (Player)event.getCause().first(Player.class).get();
        Optional<World> worldOpt = Sponge.getGame().getServer().getWorld("world");
        if (worldOpt.isPresent()) {
          player.sendMessage(Texts.of("Ha you Dirty Man"));
        }
      }
      if (block.getType().equals(BlockTypes.GRASS))
      {
        if (!event.getCause().first(Player.class).isPresent()) {
          return;
        }
        Player player = (Player)event.getCause().first(Player.class).get();
        Optional<World> worldOpt = Sponge.getGame().getServer().getWorld("world");
        if (worldOpt.isPresent()) {
          player.sendMessage(Texts.of("Why Must it Be Grass Stains!"));
        }
      }
      if (block.getType().equals(BlockTypes.IRON_ORE))
      {
          if (!event.getCause().first(Player.class).isPresent()) {
              return;
            }
            if (ConfigurationManager.getInstance().getConfig().getNode("Portals", "IronLocation").equals("true")){
                Player player = (Player)event.getCause().first(Player.class).get();
                String player2 = player.getName().toString();
                Sponge.getCommandDispatcher().process(player, "oppd Iron");
                Sponge.getCommandDispatcher().process(player, "opps Iron");
                Sponge.getGame().getServer().getBroadcastSink().sendMessage(Texts.of(new Object[] { new TextFormat(TextStyles.UNDERLINE, TextColors.AQUA), TextActions.runCommand("/opp Iron"), player2 + "has found some Iron" }));
            } else
                if (!ConfigurationManager.getInstance().getConfig().getNode("Portals", "IronLocation").equals("true")){
                    return;
                }
          }
      if (block.getType().equals(BlockTypes.GOLD_ORE))
      {
        if (!event.getCause().first(Player.class).isPresent()) {
            return;
          }
          if (ConfigurationManager.getInstance().getConfig().getNode("Portals", "GoldLocation").equals("true")){
              Player player = (Player)event.getCause().first(Player.class).get();
              String player2 = player.getName().toString();
              Sponge.getCommandDispatcher().process(player, "oppd Gold");
              Sponge.getCommandDispatcher().process(player, "opps Gold");
              Sponge.getGame().getServer().getBroadcastSink().sendMessage(Texts.of(new Object[] { new TextFormat(TextStyles.UNDERLINE, TextColors.AQUA), TextActions.runCommand("/opp Gold"), player2 + "has struck some Gold" }));
          } else
              if (!ConfigurationManager.getInstance().getConfig().getNode("Portals", "GoldLocation").equals("true")){
                  return;
              }
        }
      if (block.getType().equals(BlockTypes.DIAMOND_ORE))
      {
        if (!event.getCause().first(Player.class).isPresent()) {
          return;
        }
        if (ConfigurationManager.getInstance().getConfig().getNode("Portals", "DiamondLocation").equals("true")){
            Player player = (Player)event.getCause().first(Player.class).get();
            String player2 = player.getName().toString();
            Sponge.getCommandDispatcher().process(player, "oppd Diamond");
            Sponge.getCommandDispatcher().process(player, "opps Diamond");
            Sponge.getGame().getServer().getBroadcastSink().sendMessage(Texts.of(new Object[] { new TextFormat(TextStyles.UNDERLINE, TextColors.AQUA), TextActions.runCommand("/opp Diamond"), player2 + "has dug up a Diamond" }));
        } else
            if (!ConfigurationManager.getInstance().getConfig().getNode("Portals", "DiamondLocation").equals("true")){
                return;
            }
      }
    }
  }
}