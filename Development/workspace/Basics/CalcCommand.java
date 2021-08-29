package de.midno.basics.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.midno.basics.main.Main;

public class CalcCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			
				Player player = (Player) sender;
				
				try {
				
					if (player.hasPermission("basics.calc")) {
					
						if (args.length != 3) {
							
							player.sendMessage(Main.prefix + "§cBitte benutze nur §e2 Zahlen §cund §e+ - * /");
							player.sendMessage(Main.prefix + "§cBeispiel: §6/calc §e2 * 2");
							
						}
						
						else if (args.length == 3) {
							
							byte a = Byte.valueOf(args[0]);
							String o = String.valueOf(args[1]);
							byte b = Byte.valueOf(args[2]);
							
							if (o.equalsIgnoreCase("+")) {
								int c = a + b;
								player.sendMessage(Main.prefix + "§e" + String.valueOf(c));
							}
							else if (o.equalsIgnoreCase("-")) {
								int c = a - b;
								player.sendMessage(Main.prefix + "§e" + String.valueOf(c));
							}
							else if (o.equalsIgnoreCase("*")) {
								int c = a * b;
								player.sendMessage(Main.prefix + "§e" + String.valueOf(c));
							}
							else if (o.equalsIgnoreCase("/")) {
								int c = a / b;
								player.sendMessage(Main.prefix + "§e" + String.valueOf(c));
								
							} else player.sendMessage(Main.prefix + "§cBitte benutze nur §e+§7, §e-§7, §e*§7, §e/§7§c. Beispiel: §6/calc §e2 * 2");
					
						}
					} else player.sendMessage(Main.noPerms);
			
				} catch (Exception excAdd) {
				
			}
		}
		
		return false;
	}

}
