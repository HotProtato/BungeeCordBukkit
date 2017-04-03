package net.psychz.gga.bungee;

import java.io.File;
import net.md_5.bungee.api.plugin.Plugin;
import net.psychz.gga.GGA;

public class BungeeSide extends Plugin {

    @Override
    public void onEnable() {

        if (!GGA.init(getLogger(), new File("gga.conf"), getDescription().getVersion())) {
            GGA.enable = false;
            return;
        }

        getProxy().getPluginManager().registerListener(this, new HandshakeListener());

    }

}
