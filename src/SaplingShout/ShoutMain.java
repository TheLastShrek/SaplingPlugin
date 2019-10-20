package SaplingShout;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ShoutMain extends JavaPlugin {
	@Override
	public void onEnable() {
		System.out.println("Sapling enabled and running");
		this.saveDefaultConfig();
		final FileConfiguration config = this.getConfig();
		config.addDefault("shouteffect", "&l");
		config.options().copyDefaults(true);
		saveConfig();
	}
	@Override
	public void onDisable() {
		System.out.println("Sapling has been disabled");
	}
	
	@Override
	public boolean onCommand(CommandSender sender,Command cmd,String label,String args[] ) {
		final FileConfiguration config = this.getConfig();
		if (cmd.getName().equalsIgnoreCase("shout")) {
		    if (sender instanceof Player) {
		    	String msg1 = "----------------------------------------------------";
		    	String part = "";
		    	for(int ctr = 0; ctr < args.length; ctr++) {
		    		part = String.format("%s %s", part, args[ctr]);
		    	}
			    String msg2 = String.format("%s shouts: %s%s", ((Player) sender).getDisplayName(), config.getString("shouteffect"), part);
			    Bukkit.broadcastMessage(msg1);
			    Bukkit.broadcastMessage(msg2);
			    Bukkit.broadcastMessage(msg1);
		    }
		    else {
		    	String msg1 = "----------------------------------------------------";
		    	String part = "";
		    	for(int ctr = 0; ctr < args.length; ctr++) {
		    		part = String.format("%s %s", part, args[ctr]);
		    	}
		    	String msg2 = String.format("The Console shouts: %s %s", config.getString("shouteffect"), part);
		    	Bukkit.broadcastMessage(msg1);
			    Bukkit.broadcastMessage(msg2);
			    Bukkit.broadcastMessage(msg1);
		    }
		
		return true;
		}
		else {return false;}
	}

}
