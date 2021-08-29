package de.midno.basics.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.midno.basics.main.Main;

public class MsgCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		String msgPrefix = "§cNachricht§8: ";
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			
			try {
			
			if (player.hasPermission("basics.msg")) {
				
				if (args.length == 0 || args.length == 1) {
					
					player.sendMessage(Main.prefix + "§cBitte benutze §6/msg §e<SPIELER> <MESSAGE>");
					
				} else if (args.length >= 2) {
					
					Player target = Bukkit.getPlayer(args[0]);
					
					String message = "";
					
					for(int i = 1; i != args.length; i++)

	                    message += args[i] + " ";
					
					if (player.getName() != target.getName()) {
						
						target.sendMessage(msgPrefix + "§d" + player.getName() + " §7» §eDir§7: §f§o" + message);
						player.sendMessage(msgPrefix + "§dDu §7» §e" + player.getName() + "§7:§f§o " + message);
					
					} else if (player.getName() == target.getName()) {
						
						player.sendMessage(Main.prefix + "§cDu kannst dir selbst keine Nachrichten schicken.");
						
					}
					
				} else player.sendMessage(Main.prefix + "§cBitte benutze §6/msg §e<SPIELER> <MESSAGE>");
				
			} else player.sendMessage(Main.noPerms);
			
			} catch (Exception missingPlayer) {
				
				player.sendMessage(Main.prefix + "§cSpieler nicht gefunden.");
				
			}
		}
			
		
		return false;
	}

}
