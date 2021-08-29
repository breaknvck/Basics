package de.midno.basics.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.midno.basics.main.Main;

public class HealCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			
			try {
				
				if (player.hasPermission("basics.heal")) {
					
					if (args.length == 0) {
					
						player.setHealth(20);
						player.setFoodLevel(20);
						player.sendMessage(Main.prefix + "§aDu wurdest geheilt.");
						
					} else if (args.length == 1) {
						
						Player target = Bukkit.getPlayer(args[0]);
						
						if (player.getName() != target.getName()) {
						
							target.setHealth(20);
							target.setFoodLevel(20);
							target.sendMessage(Main.prefix + "§aDu wurdest geheilt.");
							player.sendMessage(Main.prefix + "§aDu hast §e" + target.getName() + "§a geheilt.");
						
						} else if (player.getName() == target.getName()) {
							
							target.setHealth(20);
							target.setFoodLevel(20);
							player.sendMessage(Main.prefix + "§aDu hast dich geheilt.");
							
						}
						
					} else
						player.sendMessage(Main.prefix + "§cZu viele Argumente.");
					
				} else player.sendMessage(Main.noPerms);
				
			} catch (Exception exc2) {
				
				player.sendMessage(Main.prefix + "§cFehler. Hast du alles richtig geschrieben?");
				
			}
		} else sender.sendMessage(Main.prefix + "Nur Spieler können diesen Befehl ausführen.");
		
		
		return false;
	}

	
	
}
