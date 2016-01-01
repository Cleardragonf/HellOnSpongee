package me.Cleardragonf.HOS.Portal;


import me.Cleardragonf.HOS.MainClass;
import org.spongepowered.api.command.CommandCallable;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;

import java.util.List;
import java.util.Optional;


public class RemovePortal implements CommandCallable {
    
    public CommandResult process(CommandSource commandSource, String s) throws CommandException {
        if(commandSource.hasPermission("HOS.Admin")) {
            PortalManager portalManager = MainClass.getPortalManager();

            String[] args = s.split("\\s+");
            String portalName = args[0];

            portalManager.removePortal(portalName);

            MainClass.savePortal();
        } else {
        }

        return CommandResult.success();
    }

    
    public List<String> getSuggestions(CommandSource commandSource, String s) throws CommandException {
        return null;
    }

    
    public boolean testPermission(CommandSource commandSource) {
        return false;
    }

    
    public Optional<Text> getShortDescription(CommandSource commandSource) {
        Text message = Texts.of("Removes warp. Admin command");
        return Optional.of(message);
    }

    
    public Optional<Text> getHelp(CommandSource commandSource) {
        return null;
    }

    
    public Text getUsage(CommandSource commandSource) {
        Text message = Texts.of("/removewarp [name]");
        return message;
    }
}