package de.midno.basics.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.midno.basics.main.Main;

public class TeleportCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			
			try {
			
				if (player.hasPermission("basics.teleport")) {
					
					if (args.length == 0) {
						
						player.sendMessage(Main.prefix + "§cBitte benutze §6/tp §e<SPIELER> §7(§e<SPIELER>§7)");
						
					} else if (args.length == 1) {
						
						Player target = Bukkit.getPlayer(args[0]);
						
						if (target.getName() != player.getName()) {
							
							player.teleport(target.getLocation());
						
							player.sendMessage(Main.prefix + "§aDu hast dich zu §e" + target.getName() + " §ateleportiert.");
						
						} else if (target.getName() == player.getName()) {
							
							player.sendMessage(Main.prefix + "§cDu kannst dich nicht zu dir selbst teleportieren.");
							
						}
						
					} else if (args.length == 2) {
						
						if (player.hasPermission("basics.teleport.others")) {
							
							Player target = Bukkit.getPlayer(args[0]);
							Player target1 = Bukkit.getPlayer(args[1]);
						
							if (target.getName() != target1.getName()) {
								
								target.teleport(target1.getLocation());
						
								target.sendMessage(Main.prefix + "§aDu wurdest zu §e" + target1.getName() + " §ateleportiert.");
								player.sendMessage(Main.prefix + "§aDu hast §e" + target.getName() + "§a zu §e" + target1.getName() + " §ateleportiert.");
								
							} else if (target.getName() == target1.getName()) {
								
								if (!(player.getName() == target1.getName()) || !(player.getName() == target.getName())) {
									
									player.sendMessage(Main.prefix + "§cDu kannst §e" + target.getName() + " §cnicht zu ihm/ihr selbst teleportieren.");
								
								} else if (player.getName() == target1.getName() || player.getName() == target.getName()) {
									
									player.sendMessage(Main.prefix + "§cDu kannst dich nicht zu dir selbst teleportieren.");
									
								}
								
							}
						
						} else player.sendMessage(Main.noPerms);
		
					} else {
						
						player.sendMessage(Main.prefix + "§cZu viele Argumente.");
						
					}
					
				} else player.sendMessage(Main.noPerms);
				
			} catch (Exception exc1) {
				
				player.sendMessage(Main.error);
				
			}
			
		} else sender.sendMessage(Main.prefix + "§cNur Spieler können diesen Befehl ausführen.");
		
		
		return false;
	}

	
	
}
