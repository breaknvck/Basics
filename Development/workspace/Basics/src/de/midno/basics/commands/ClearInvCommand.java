package de.midno.basics.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.midno.basics.main.Main;

public class ClearInvCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			
			try {
			
				if (player.hasPermission("basics.clear")) {
					
					if (args.length == 0) {
						
						player.getInventory().clear();
						player.sendMessage(Main.prefix + "§aDu hast dein Inventar geleert");
						
					} else if (args.length == 1) {
						
						Player target = Bukkit.getPlayer(args[0]);
						
						if (player.getName() == target.getName()) {
						
							target.getInventory().clear();
							player.sendMessage(Main.prefix + "§aDu hast dein Inventar geleert");
						
						} else if (player.getName() != target.getName()) {
							
							target.getInventory().clear();
							target.sendMessage(Main.prefix + "§aDein Inventar wurde geleert");
							player.sendMessage(Main.prefix + "§aDu hast das Inventar von §e" + target.getName() + "§a geleert.");
							
						}
						
					} else player.sendMessage(Main.prefix + "§cBitte benutze §6/clear §7(§e<SPIELER>§7)");
					
				} else player.sendMessage(Main.noPerms);
				
			} catch (Exception exc5) {
				
				player.sendMessage(Main.prefix + "§cFehler. Hast du alles richtig geschrieben?");
				
			}
			
		}
		
		return false;
	}

}
