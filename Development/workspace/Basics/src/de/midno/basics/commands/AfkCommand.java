package de.midno.basics.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AfkCommand implements CommandExecutor {
	
	public static boolean afk1 = false;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
						
			if (player.hasPermission("basics.afk") && afk1 == false) {
				
				afk1 = true;
				Bukkit.broadcastMessage("§8- §9" + player.getName() + " §7ist AFK.");
				
			}
			
		}
		
		return false;
}
}
