package de.midno.basics.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.midno.basics.main.Main;

public class GameModeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			
			String creative = "creative";
			String survival = "survival";
			String spectator = "spectator";
			String adventure = "adventure";
			String creative1 = "1";
			String survival1 = "0";
			String spectator1 = "3";
			String adventure1 = "2";
			
			try {
			
				if (player.hasPermission("basics.gamemode")) {
				
					if (args.length == 0) {
						
						player.sendMessage(Main.prefix + "§cBitte benutze §6/gm §e<GAMEMODE> §7(§e<SPIELER>§7)");
						
					} else if (args.length == 1) {
						
						if (args[0].equalsIgnoreCase(creative) || args[0].equalsIgnoreCase(creative1)) {
							
							player.setGameMode(GameMode.CREATIVE);
							player.sendMessage(Main.prefix + "§aDu bist jetzt im §eKreativmodus.");
							
						} else if (args[0].equalsIgnoreCase(survival) || args[0].equalsIgnoreCase(survival1)) {
							
							player.setGameMode(GameMode.SURVIVAL);
							player.sendMessage(Main.prefix + "§aDu bist jetzt im §eSurvivalmodus.");
							
						} else if (args[0].equalsIgnoreCase(spectator) || args[0].equalsIgnoreCase(spectator1)) {
							
							player.setGameMode(GameMode.SPECTATOR);
							player.sendMessage(Main.prefix + "§aDu bist jetzt im §eZuschauermodus.");
							
						} else if (args[0].equalsIgnoreCase(adventure) || args[0].equalsIgnoreCase(adventure1)) {
							
							player.setGameMode(GameMode.ADVENTURE);
							player.sendMessage(Main.prefix + "§aDu bist jetzt im §eAbenteuermodus.");
							
						} else {
							
							player.sendMessage(Main.prefix + "§cBitte benutze §6/gm §e<GAMEMODE> §7(§e<SPIELER>§7)");
							
						}
						
					} else if (args.length == 2) {
						
						if (args[0].equalsIgnoreCase(creative) || args[0].equalsIgnoreCase(creative1)) {
							
							Player target = Bukkit.getPlayer(args[1]);
							
							if (target.getName() != player.getName()) {
							
								target.setGameMode(GameMode.CREATIVE);
								target.sendMessage(Main.prefix + "§aDu bist jetzt im §eKreativmodus.");
								player.sendMessage(Main.prefix + "§aDu hast §e" + target.getName() + " §ain den §eKreativmodus §aversetzt.");
							
							} else if (target.getName() == player.getName()) {
								
								target.setGameMode(GameMode.CREATIVE);
								target.sendMessage(Main.prefix + "§aDu bist jetzt im §eKreativmodus.");
							}
							
						} else if (args[0].equalsIgnoreCase(survival) || args[0].equalsIgnoreCase(survival1)) {
							
							Player target = Bukkit.getPlayer(args[1]);
							
							if (target.getName() != player.getName()) {
							
								target.setGameMode(GameMode.SURVIVAL);
								target.sendMessage(Main.prefix + "§aDu bist jetzt im §eSurvivalmodus.");
								player.sendMessage(Main.prefix + "§aDu hast §e" + target.getName() + " §ain den §eSurvivalmodus §aversetzt.");
								
							} else if (target.getName() == player.getName()) {
								
								target.setGameMode(GameMode.SURVIVAL);
								target.sendMessage(Main.prefix + "§aDu bist jetzt im §eSurvivalmodus.");
								
							}
							
						} else if (args[0].equalsIgnoreCase(spectator) || args[0].equalsIgnoreCase(spectator1)) {
							
							Player target = Bukkit.getPlayer(args[1]);
							
							if (target.getName() != player.getName()) {
							
								target.setGameMode(GameMode.SPECTATOR);
								target.sendMessage(Main.prefix + "§aDu bist jetzt im §eZuschauermodus.");
								player.sendMessage(Main.prefix + "§aDu hast §e" + target.getName() + " §ain den §eZuschauermodus §aversetzt.");
							
							} else if (target.getName() == player.getName()) {
								
								target.setGameMode(GameMode.SPECTATOR);
								target.sendMessage(Main.prefix + "§aDu bist jetzt im §eZuschauermodus.");
								
							}
							
						} else if (args[0].equalsIgnoreCase(adventure) || args[0].equalsIgnoreCase(adventure1)) {
							
							Player target = Bukkit.getPlayer(args[1]);
							
							if (target.getName() != player.getName()) {
							
								target.setGameMode(GameMode.ADVENTURE);
								target.sendMessage(Main.prefix + "§aDu bist jetzt im §eAbenteuermodus.");
								player.sendMessage(Main.prefix + "§aDu hast §e" + target.getName() + " §ain den §eAbenteuermodus §aversetzt.");
							
							} else if (target.getName() == player.getName()) {
								
								target.setGameMode(GameMode.ADVENTURE);
								target.sendMessage(Main.prefix + "§aDu bist jetzt im §eAbenteuermodus.");
								
							}
							
						} else {
							
							player.sendMessage(Main.prefix + "§cBitte benutze §6/gm §e<GAMEMODE> §7(§e<SPIELER>§7)");
							
						}
					
					} else {
					
						player.sendMessage(Main.prefix + "§cZu viele Argumente.");
					
					}
				
				} else player.sendMessage(Main.noPerms);
				
			} catch (Exception exc3) {
				
				player.sendMessage(Main.prefix + "§cFehler. Hast du alles richtig geschrieben?");
				
			}
		}
		
		return false;
	}

}
