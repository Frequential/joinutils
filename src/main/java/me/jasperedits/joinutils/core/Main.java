package me.jasperedits.joinutils.core;


import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.jasperedits.joinutils.events.EVENTSJoin;

public class Main extends JavaPlugin {

	private static Main instance;

	public void onEnable() {
		saveDefaultConfig();
		instance = this;

		getServer().getConsoleSender().sendMessage("\n§8§m-------------------------------------------"
				+ "\n\n§aJoinUtils enabled.\n\n"
				+ "§8§m-------------------------------------------");
		getCommand("spawn").setExecutor(new me.jasperedits.joinutils.commands.CMDSpawn());
		getCommand("jureload").setExecutor(new me.jasperedits.joinutils.commands.CMDReload());
		getServer().getPluginManager().registerEvents(new EVENTSJoin(), this);
	}

	public void onDisable() {
		getServer().getConsoleSender().sendMessage("\n§8§m-------------------------------------------"
				+ "\n\n§aJoinUtils disabled.\n\n"
				+ "§8§m-------------------------------------------");
	}

	public static Main getInstance() {
		return instance;
	}

	public static String c(String c) {
		return ChatColor.translateAlternateColorCodes('&', c);
	}
	
    public static void sendMessageFromConfig(CommandSender p, String node) { 
        node = "messages."+node;
        FileConfiguration config = getInstance().getConfig();
        if (config.getString(node).equals("0"))
          return;

        p.sendMessage(c(config.getString(node)));
      }
}
