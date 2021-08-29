package de.midno.basics.commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.midno.basics.main.Main;

public class UnbanCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
		
			player.sendMessage(Main.prefix + "§e" + args[0] + " §cwurde entbannt.");
		}
		
		Bukkit.getBanList(BanList.Type.NAME).pardon(args[0]);
		
		return false;
	}

}
