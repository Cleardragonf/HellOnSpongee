package me.Cleardragonf.HOS;
 
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;

import java.io.File;
import java.io.IOException;
 
public class ConfigurationManager {
 
        private static ConfigurationManager instance = new ConfigurationManager();
       
        public static ConfigurationManager getInstance() {
                return instance;
        }
       
        private ConfigurationLoader<CommentedConfigurationNode> configLoader;
        private CommentedConfigurationNode config;
      
        public void setup(File configFile, ConfigurationLoader<CommentedConfigurationNode> configLoader) {
                this.configLoader = configLoader;
               
                if (!configFile.exists()) {
                        try {
                                configFile.createNewFile();
                                loadConfig();
                                config.getNode("Portals", "DiamondLocation").setComment("Teleport Players to Diamond finds? || yes = true | no = false").setValue("true");
                                config.getNode("Portals", "IronLocation").setComment("Teleport Players to Diamond finds? || yes = true | no = false").setValue("true");
                                config.getNode("Portals", "GoldLocation").setComment("Teleport Players to Diamond finds? || yes = true | no = false").setValue("true");
                                config.getNode("Pay_4_Kills").setComment("Change the ammount a player gets paid for killing a mob or other player");
                                config.getNode("Pay_4_Kills", "Chicken").setValue("5");
                                config.getNode("Pay_4_Kills", "Cow").setValue("5");
                                config.getNode("Pay_4_Kills", "MushroomCow").setValue("5");
                                config.getNode("Pay_4_Kills", "Pig").setValue("5");
                                config.getNode("Pay_4_Kills", "Rabbit").setValue("5");
                                config.getNode("Pay_4_Kills", "Sheep").setValue("5");
                                config.getNode("Pay_4_Kills", "Bat").setValue("5");
                                config.getNode("Pay_4_Kills", "Blaze").setValue("5");
                                config.getNode("Pay_4_Kills", "CaveSpider").setValue("5");
                                config.getNode("Pay_4_Kills", "Creeper").setValue("5");
                                config.getNode("Pay_4_Kills", "EnderDragon").setValue("5");
                                config.getNode("Pay_4_Kills", "Enderman").setValue("5");
                                config.getNode("Pay_4_Kills", "Ghast").setValue("5");
                                config.getNode("Pay_4_Kills", "Giant").setValue("5");
                                config.getNode("Pay_4_Kills", "Guardian").setValue("5");
                                config.getNode("Pay_4_Kills", "Horse").setValue("5");
                                config.getNode("Pay_4_Kills", "Human").setValue("5");
                                config.getNode("Pay_4_Kills", "IronGolem").setValue("5");
                                config.getNode("Pay_4_Kills", "MagmaCube").setValue("5");
                                config.getNode("Pay_4_Kills", "Ocelot").setValue("5");
                                config.getNode("Pay_4_Kills", "PigZombie").setValue("5");
                                config.getNode("Pay_4_Kills", "Player").setValue("5");
                                config.getNode("Pay_4_Kills", "SilverFish").setValue("5");
                                config.getNode("Pay_4_Kills", "Skeleton").setValue("5");
                                config.getNode("Pay_4_Kills", "Slime").setValue("5");
                                config.getNode("Pay_4_Kills", "Snowman").setValue("5");
                                config.getNode("Pay_4_Kills", "Spider").setValue("5");
                                config.getNode("Pay_4_Kills", "Squid").setValue("5");
                                config.getNode("Pay_4_Kills", "Villager").setValue("5");
                                config.getNode("Pay_4_Kills", "Witch").setValue("5");
                                config.getNode("Pay_4_Kills", "Wither").setValue("5");
                                config.getNode("Pay_4_Kills", "Wolf").setValue("5");
                                config.getNode("Pay_4_Kills", "Zombie").setValue("5");
                                config.getNode("Spawning!").setComment("This controls the number of Creatures that spawn and the percentile of those spawns.");
                                config.getNode("Spawning!", "Bat");
                                config.getNode("Spawning!", "Bat", "Bat#").setComment("Number of bats to attempt").setValue("1");
                                config.getNode("Spawning!", "Bat", "Bat%").setComment("Chances for each Bat's Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Blaze");
                                config.getNode("Spawning!", "Blaze", "Blaze#").setComment("Number of Blazes to Attempt").setValue("1");
                                config.getNode("Spawning!", "Blaze", "Blaze%").setComment("Chances for each Blazes Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "CaveSpider");
                                config.getNode("Spawning!", "CaveSpider", "CaveSpider#").setComment("Number of CaveSpider to attempt").setValue("1");
                                config.getNode("Spawning!", "CaveSpider", "CaveSpider%").setComment("Chances for each CaveSpider Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Chicken");
                                config.getNode("Spawning!", "Chicken", "Chicken#").setComment("Number of Chicken to attempt").setValue("1");
                                config.getNode("Spawning!", "Chicken", "Chicken%").setComment("Chances for each Chicken Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Cow");
                                config.getNode("Spawning!", "Cow", "Cow#").setComment("Number of Cow to attempt").setValue("1");
                                config.getNode("Spawning!", "Cow", "Cow%").setComment("Chances for each Cow Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Creeper");
                                config.getNode("Spawning!", "Creeper", "Creeper#").setComment("Number of Creeper to attempt").setValue("1");
                                config.getNode("Spawning!", "Creeper", "Creeper%").setComment("Chances for each Creeper Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "EnderDragon");
                                config.getNode("Spawning!", "EnderDragon", "EnderDragon#").setComment("Number of EnderDragon to attempt").setValue("1");
                                config.getNode("Spawning!", "EnderDragon", "EnderDragon%").setComment("Chances for each EnderDragon Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Enderman");                             
                                config.getNode("Spawning!", "Enderman", "Enderman#").setComment("Number of Enderman to attempt").setValue("1");
                                config.getNode("Spawning!", "Enderman", "Enderman%").setComment("Chances for each Enderman Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Ghast");
                                config.getNode("Spawning!", "Ghast", "Ghast#").setComment("Number of Ghast to attempt").setValue("1");
                                config.getNode("Spawning!", "Ghast", "Ghast%").setComment("Chances for each Ghast Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Giant");
                                config.getNode("Spawning!", "Giant", "Giant#").setComment("Number of Giant to attempt").setValue("1");
                                config.getNode("Spawning!", "Giant", "Giant%").setComment("Chances for each Giant Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Guardian");
                                config.getNode("Spawning!", "Guardian", "Guardian#").setComment("Number of Guardian to attempt").setValue("1");
                                config.getNode("Spawning!", "Guardian", "Guardian%").setComment("Chances for each Guardian Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Horse");
                                config.getNode("Spawning!", "Horse", "Horse#").setComment("Number of Horse to attempt").setValue("1");
                                config.getNode("Spawning!", "Horse", "Horse%").setComment("Chances for each Horse Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "IronGolemn");
                                config.getNode("Spawning!", "IronGolemn", "IronGolemn#").setComment("Number of IronGolemn to attempt").setValue("1");
                                config.getNode("Spawning!", "IronGolemn", "IronGolemn%").setComment("Chances for each IronGolemn Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "MagmaCube");
                                config.getNode("Spawning!", "MagmaCube", "MagmaCube#").setComment("Number of MagmaCube to attempt").setValue("1");
                                config.getNode("Spawning!", "MagmaCube", "MagmaCube%").setComment("Chances for each MagmaCube Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "MushroomCow");
                                config.getNode("Spawning!", "MushroomCow", "MushroomCow#").setComment("Number of MushroomCow to attempt").setValue("1");
                                config.getNode("Spawning!", "MushroomCow", "MushroomCow%").setComment("Chances for each MushroomCow Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Ocelot");
                                config.getNode("Spawning!", "Ocelot", "Ocelot#").setComment("Number of Ocelot to attempt").setValue("1");
                                config.getNode("Spawning!", "Ocelot", "Ocelot%").setComment("Chances for each Ocelot Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Pig");
                                config.getNode("Spawning!", "Pig", "Pig#").setComment("Number of Pig to attempt").setValue("1");
                                config.getNode("Spawning!", "Pig", "Pig%").setComment("Chances for each Pig Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "PigZombie");
                                config.getNode("Spawning!", "PigZombie", "PigZombie#").setComment("Number of PigZombie to attempt").setValue("1");
                                config.getNode("Spawning!", "PigZombie", "PigZombie%").setComment("Chances for each PigZombie Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Rabbit");
                                config.getNode("Spawning!", "Rabbit", "Rabbit#").setComment("Number of Rabit to attempt").setValue("1");
                                config.getNode("Spawning!", "Rabbit", "Rabbit%").setComment("Chances for each Rabit Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Sheep");
                                config.getNode("Spawning!", "Sheep", "Sheep#").setComment("Number of Sheep to attempt").setValue("1");
                                config.getNode("Spawning!", "Sheep", "Sheep%").setComment("Chances for each Sheep Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "SilverFish");
                                config.getNode("Spawning!", "SilverFish", "SilverFish#").setComment("Number of SilverFish to attempt").setValue("1");
                                config.getNode("Spawning!", "SilverFish", "SilverFish%").setComment("Chances for each SilverFish Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Skeleton");
                                config.getNode("Spawning!", "Skeleton", "Skeleton#").setComment("Number of Skeleton to attempt").setValue("1");
                                config.getNode("Spawning!", "Skeleton", "Skeleton%").setComment("Chances for each Skeleton Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Slime");
                                config.getNode("Spawning!", "Slime", "Slime#").setComment("Number of Slime to attempt").setValue("1");
                                config.getNode("Spawning!", "Slime", "Slime%").setComment("Chances for each Slime Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Snowman");
                                config.getNode("Spawning!", "Snowman", "Snowman#").setComment("Number of Snowman to attempt").setValue("1");
                                config.getNode("Spawning!", "Snowman", "Snowman%").setComment("Chances for each Snowman Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Spider");
                                config.getNode("Spawning!", "Spider", "Spider#").setComment("Number of Spider to attempt").setValue("1");
                                config.getNode("Spawning!", "Spider", "Spider%").setComment("Chances for each Spider Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Squid");
                                config.getNode("Spawning!", "Squid", "Squid#").setComment("Number of Squid to attempt").setValue("1");
                                config.getNode("Spawning!", "Squid", "Squid%").setComment("Chances for each Squid Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Witch");
                                config.getNode("Spawning!", "Witch", "Witch#").setComment("Number of Witch to attempt").setValue("1");
                                config.getNode("Spawning!", "Witch", "Witch%").setComment("Chances for each Witch Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Wither");
                                config.getNode("Spawning!", "Wither", "Wither#").setComment("Number of Wither to attempt").setValue("1");
                                config.getNode("Spawning!", "Wither", "Wither%").setComment("Chances for each Wither Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Wolf");
                                config.getNode("Spawning!", "Wolf", "Wolf#").setComment("Number of Wolf to attempt").setValue("1");                  
                                config.getNode("Spawning!", "Wolf", "Wolf%").setComment("Chances for each Wolf Spawn.  1-100%").setValue("75");
                                config.getNode("Spawning!", "Zombie");
                                config.getNode("Spawning!", "Zombie", "Zombie#").setComment("Number of Zombie to attempt").setValue("1");
                                config.getNode("Spawning!", "Zombie", "Zombie%").setComment("Chances for each Zombie Spawn.  1-100%").setValue("75");
                                saveConfig();
                        }
                       
                        catch (Exception e) {
                                e.printStackTrace();
                        }
                }
               
                else {
                        loadConfig();
                }
        }
       
        public CommentedConfigurationNode getConfig() {
                return config;
        }
       
        public void saveConfig() {
                try {
                        configLoader.save(config);
                }
               
                catch (IOException e) {
                        e.printStackTrace();
                }
        }
       
        public void loadConfig() {
                try {
                        config = configLoader.load();
                }
               
                catch (IOException e) {
                        e.printStackTrace();
                }
        }
}