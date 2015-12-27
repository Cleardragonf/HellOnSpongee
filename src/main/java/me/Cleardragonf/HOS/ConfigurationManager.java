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