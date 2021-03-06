package de.midno.basics.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.midno.basics.main.Main;

public class DayCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if (player.hasPermission("basics.day")) {
				
				player.getWorld().setTime(0);
				player.getWorld().setGameRuleValue("doDayLightCycle", "false");
				
				player.sendMessage(Main.prefix + "?aJetzt ist es ?eTag");
				
			} else player.sendMessage(Main.noPerms);
			
		}
		
		return false;
	}

}
