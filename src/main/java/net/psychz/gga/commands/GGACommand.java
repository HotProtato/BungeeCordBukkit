package net.psychz.gga.commands;

import net.psychz.gga.GGA;
import net.psychz.gga.GGAProperties;
import net.psychz.gga.manager.AbstractSender;
import java.io.IOException;
import net.md_5.bungee.api.chat.TextComponent;

public class GGACommand {

    public static void onCommand(AbstractSender sender, String[] args) {

        if (args.length == 0) {
            TextComponent component = new TextComponent("Soon!");
            sender.sendMessage(component);
            return;
        }

        if (args.length > 0) {

            switch (args[0].toLowerCase()) {

                case "disable": {
                    if(!GGA.enable) {
                        sender.sendMessage("Plugin is already disabled?");
                    } else {
                        GGA.enable = false;
                        sender.sendMessage("Disabled.");
                    }
                }

                case "enable": {
                    if(!GGA.enable) {
                        GGA.enable = true;
                        sender.sendMessage("Enabled");
                    } else {
                        sender.sendMessage("Plugin is already enabled?");
                    }
                }

                case "reload": {
                    GGAProperties properties = GGA.getProperties();

                    try {
                        properties.reload();
                        sender.sendMessage("Config file reloaded successfuly.");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        sender.sendMessage("An error has occurred while attempting to load your properties file. Please check the console for the full stacktrace.");
                    }

                    break;
                }

            }

        }

    }

}
