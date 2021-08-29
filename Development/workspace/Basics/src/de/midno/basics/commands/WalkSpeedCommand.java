package de.midno.basics.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.midno.basics.main.Main;

public class WalkSpeedCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if (player.hasPermission("basics.wspeed")) {
				
				if (args.length == 0) {
					
					player.sendMessage(Main.prefix + "§cBitte benutze §6/wspeed §e<1-10>");
					
				} else if (args.length == 1) {
				
					switch (args[0]) {
					
					case "1":
	
						player.setWalkSpeed(0.2F);
						player.sendMessage(Main.prefix + "§aWalk-Speed auf §e1 §agesetzt.");
						
						break;
					
					case "2":
	
						player.setWalkSpeed(0.2F);
						player.sendMessage(Main.prefix + "§aWalk-Speed auf §e2 §agesetzt.");
						
						break;
					
					case "3":
	
						player.setWalkSpeed(0.3F);
						player.sendMessage(Main.prefix + "§aWalk-Speed auf §e3 §agesetzt.");
						
						break;
						
					case "4":
	
						player.setWalkSpeed(0.4F);
						player.sendMessage(Main.prefix + "§aWalk-Speed auf §e4 §agesetzt.");
						
						break;
					
					case "5":
	
						player.setWalkSpeed(0.5F);
						player.sendMessage(Main.prefix + "§aWalk-Speed auf §e5 §agesetzt.");
						
						break;
					
					case "6":
	
						player.setWalkSpeed(0.6F);
						player.sendMessage(Main.prefix + "§aWalk-Speed auf §e6 §agesetzt.");
						
						break;
						
					case "7":
	
						player.setWalkSpeed(0.7F);
						player.sendMessage(Main.prefix + "§aWalk-Speed auf §e7 §agesetzt.");
						
						break;
					
					case "8":
	
						player.setFlySpeed(0.8F);
						player.sendMessage(Main.prefix + "§aFly-Speed auf §e8 §agesetzt.");
						
						break;
					
					case "9":
	
						player.setWalkSpeed(0.9F);
						player.sendMessage(Main.prefix + "§aWalk-Speed auf §e9 §agesetzt.");
						
						break;
						
					case "10":
						
						player.setWalkSpeed(1F);
						player.sendMessage(Main.prefix + "§aWalk-Speed auf §e10 §agesetzt.");
						
						break;
						
					default:
						
						player.sendMessage(Main.prefix + "§cBitte wähle eine Zahl zwischen 1-10.");
						
						break;
					}
				} else player.sendMessage(Main.prefix + "§cBitte benutze §6/wspeed §e<1-10>");
				
			}
			
		}
		
		return false;
	}

}
