package de.midno.basics.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.midno.basics.main.Main;

public class KickCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			
			try {
			
				if (player.hasPermission("basics.kick")) {
					
					if (args.length == 0) {
						
						player.sendMessage(Main.prefix + "§cBitte benutze §6/kick §e<SPIELER>");
						
					} else if (args.length == 1) {
						
						Player target = Bukkit.getPlayer(args[0]);
						Bukkit.broadcastMessage(Main.prefix + "§e" + target.getName() + " §cwurde vom Server gekickt.");
						target.kickPlayer("§cDu wurdest gekickt.");
						
					} else if (args.length == 2) {
						
						Player target = Bukkit.getPlayer(args[0]);
						String reason = args[1];
						
						Bukkit.broadcastMessage(Main.prefix + "§e" + target.getName() + " §cwurde vom Server gekickt. §8§o(§7§o" + reason + "§8§o)");
						target.kickPlayer("§cDu wurdest wegen §e" + reason + " §cgekickt.");
						
					} else player.sendMessage(Main.prefix + "§cBitte benutze §6/kick §e<SPIELER>");
					 
				} else player.sendMessage(Main.noPerms);
			
			} catch (Exception kickExc) {
			
			player.sendMessage(Main.prefix + "§cSpieler nicht gefunden.");
			
			}
		}
		
		return false;
	}

}
