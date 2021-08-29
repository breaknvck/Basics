package de.midno.basics.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.midno.basics.main.Main;

public class RainCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if (player.hasPermission("basics.rain")) {
				
				player.getWorld().setStorm(true);
				player.getWorld().setThundering(false);
				player.getWorld().setGameRuleValue("doWeatherCycle", "false");
				
				player.sendMessage(Main.prefix + "§aWetter umgestellt auf §eRegen");
				
			} else player.sendMessage(Main.noPerms);
			
		}
		
		return false;
	}

}
