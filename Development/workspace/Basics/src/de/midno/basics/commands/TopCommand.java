package de.midno.basics.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.midno.basics.main.Main;

public class TopCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if (player.hasPermission("basics.top")) {
				
				if (args.length == 0) {
					Block above = player.getWorld().getHighestBlockAt(player.getLocation());
					
					float pitch = player.getEyeLocation().getPitch();
					float yaw = player.getEyeLocation().getYaw();
					player.getEyeLocation().setPitch(pitch);
					player.getEyeLocation().setYaw(yaw);
					player.teleport(above.getLocation());
					
					double x = player.getLocation().getX();
					double y = player.getLocation().getY();
					double z = player.getLocation().getZ();
					
					World world = player.getWorld();
					
					Location loc = new Location(world, x, y, z, yaw, pitch);
					
					player.teleport(loc);
					player.sendMessage(Main.prefix + "§aDu wurdest nach oben teleportiert!");
					
				} else player.sendMessage(Main.prefix + "§cBitte benutze nur §6/top");
				
			} else player.sendMessage(Main.noPerms);
			
		}
		
		return false;
	}

}
