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
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.cause.entity.damage.source.EntityDamageSource;
import org.spongepowered.api.event.entity.DestructEntityEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextFormat;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.world.World;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Optional;
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
        Player player = (Player)event.getCause().first(Player.class).get();
        Optional<World> worldOpt = Sponge.getGame().getServer().getWorld("world");
        if (worldOpt.isPresent()) {
          Sponge.getGame().getServer().getBroadcastSink().sendMessage(Texts.of(new Object[] { TextColors.GOLD, player + "has dug up some iron" }));
        }
      }
      if (block.getType().equals(BlockTypes.GOLD_ORE))
      {
        if (!event.getCause().first(Player.class).isPresent()) {
          return;
        }
        Player player = (Player)event.getCause().first(Player.class).get();
        Optional<World> worldOpt = Sponge.getGame().getServer().getWorld("world");
        if (worldOpt.isPresent()) {
          Sponge.getGame().getServer().getBroadcastSink().sendMessage(Texts.of(new Object[] { TextColors.GOLD, player + "has dug up some gold" }));
        }
      }
      if (block.getType().equals(BlockTypes.DIAMOND_ORE))
      {
        if (!event.getCause().first(Player.class).isPresent()) {
          return;
        }
        Player player = (Player)event.getCause().first(Player.class).get();
        String player2 = player.getName().toString();
        Sponge.getCommandDispatcher().process(player, "oppd Diamond");
        Sponge.getCommandDispatcher().process(player, "opps Diamond");
        Sponge.getGame().getServer().getBroadcastSink().sendMessage(Texts.of(new Object[] { new TextFormat(TextStyles.UNDERLINE, TextColors.AQUA), TextActions.runCommand("/opp Diamond"), player2 + "has dug up a Diamond" }));
      }
    }
  }
}