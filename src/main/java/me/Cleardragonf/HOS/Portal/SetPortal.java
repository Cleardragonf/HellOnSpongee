package me.Cleardragonf.HOS.Portal;

import me.Cleardragonf.HOS.MainClass;
import org.spongepowered.api.command.CommandCallable;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.Optional;

public class SetPortal implements CommandCallable {
    @Override
    public CommandResult process(CommandSource commandSource, String s) throws CommandException {
        if (commandSource instanceof Player) {
            Player player = (Player) commandSource;

            if(player.hasPermission("HOS.Admin")) {
                String[] args = s.split("\\s+");
                String portalName = args[0];

                PortalManager warpsManager = MainClass.getPortalManager();
                org.spongepowered.api.world.Location<World> location = player.getLocation();
                warpsManager.setPortal(portalName, location);

                MainClass.savePortal();
            } else {
            }
        } else {
        }

        return CommandResult.success();
    }

    @Override
    public List<String> getSuggestions(CommandSource commandSource, String s) throws CommandException {
        return null;
    }

    @Override
    public boolean testPermission(CommandSource commandSource) {
        return false;
    }

    @Override
    public Optional<Text> getShortDescription(CommandSource commandSource) {
        Text message = Texts.of("Set Portal. Admin command");
        return Optional.of(message);
    }

    @Override
    public Optional<Text> getHelp(CommandSource commandSource) {
        return null;
    }

    @Override
    public Text getUsage(CommandSource commandSource) {
        Text message = Texts.of("/setwarp [name]");
        return message;
    }
}