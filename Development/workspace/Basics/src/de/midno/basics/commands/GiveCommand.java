package de.midno.basics.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.midno.basics.main.Main;

public class GiveCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			
			try {
			
				if (player.hasPermission("basics.give")) {
					
					if (args.length == 0) {
						
						player.sendMessage(Main.prefix + "§cBitte benutze §6/item §e<ITEM>");
						
					} else if (args.length == 1) {
						
						Material itemType = Material.matchMaterial(args[0]);
						
						if (itemType == null) {
							
						    sender.sendMessage(Main.prefix + "§e" + args[0] + "§c gibt es nicht.");
						    
						    return true;
						    
						}
						
						ItemStack itemStack = new ItemStack(itemType);
						player.getInventory().addItem(itemStack);
						player.sendMessage(Main.prefix + "§e" + itemType + " §agegeben.");
						return true;
						
					} 
					
				}
				
			} catch (Exception exc4) {
				
				player.sendMessage(Main.prefix + "§cFehler. Hast du alles richtig geschrieben?");
				
			}
			
		}
		
		return false;
	}

}
