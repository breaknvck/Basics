package de.midno.basics.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.midno.basics.main.Main;

public class SunCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if (player.hasPermission("basics.sun")) {
				
				player.getWorld().setStorm(false);
				player.getWorld().setThundering(false);
				player.getWorld().setGameRuleValue("doWeatherCycle", "false");
				
				player.sendMessage(Main.prefix + "§aWetter umgestellt auf §eSonne");
				
			} else player.sendMessage(Main.noPerms);
			
		}
		
		return false;
	}

}
