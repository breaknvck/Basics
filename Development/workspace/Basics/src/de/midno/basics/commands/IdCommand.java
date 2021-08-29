package de.midno.basics.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.midno.basics.main.Main;

public class IdCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if (player.hasPermission("basics.id")) {
				
				if (args.length == 0) {
					
					player.sendMessage(Main.prefix + "§e" + player.getItemInHand().getTypeId() + "§7:§e" + player.getItemInHand().getDurability());
				
				} else player.sendMessage(Main.prefix + "§cBitte benutze nur §6/id §coder §6/itemid");
			
			} else player.sendMessage(Main.noPerms);
		}
		return false;
	}

}
