package me.Cleardragonf.HOS.Portal;

import me.Cleardragonf.HOS.MainClass;
import org.spongepowered.api.command.CommandCallable;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.Optional;

public class Portal implements CommandCallable {
    @Override
    public CommandResult process(CommandSource commandSource, String s) throws CommandException {
        if (commandSource instanceof Player) {
            Player player = (Player) commandSource;

            String[] args = s.split("\\s+");
            String portalName = args[0];

            PortalManager warpsManager = MainClass.getPortalManager();
            PortalLocation location = warpsManager.getPortal(portalName);

            if(location == null) {
            } else {
                /*--This here is the teleporter that allows individuals to teleport*/
                player.setLocation(new Location<World>(player.getLocation().getExtent(), location.x, location.y, location.z));
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
        Text message = Texts.of("Teleport to warp.");
        return Optional.of(message);
    }

    @Override
    public Optional<Text> getHelp(CommandSource commandSource) {
        return null;
    }

    @Override
    public Text getUsage(CommandSource commandSource) {
        Text message = Texts.of("/warp [warpname]");
        return message;
    }
}