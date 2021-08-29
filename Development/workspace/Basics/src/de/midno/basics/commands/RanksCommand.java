package de.midno.basics.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class RanksCommand implements CommandExecutor, Listener {
	
	public static byte b1 = 6;
	public static byte b2 = 7;
	public static byte b3 = 5;
	public static byte b4 = 4;
	
	String ranks = "§cBauränge";
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if (player.hasPermission("basics.ranks")) {
				
				
				
				ItemStack i1 = new ItemStack(Material.RED_ROSE, 1, b1);
				ItemStack i2 = new ItemStack(Material.RED_ROSE, 1, b2);
				ItemStack i3 = new ItemStack(Material.RED_ROSE, 1, b3);
				ItemStack i4 = new ItemStack(Material.RED_ROSE, 1, b4);
				
				ItemMeta i1meta = i1.getItemMeta();
				i1meta.setDisplayName("§fBuilder §8(§7Klick§8)");
				i1.setItemMeta(i1meta);
				
				ItemMeta i2meta = i2.getItemMeta();
				i2meta.setDisplayName("§dErfahrener §8(§7Klick§8)");
				i2.setItemMeta(i2meta);
				
				ItemMeta i3meta = i3.getItemMeta();
				i3meta.setDisplayName("§6Künstler §8(§7Klick§8)");
				i3.setItemMeta(i3meta);
				
				ItemMeta i4meta = i4.getItemMeta();
				i4meta.setDisplayName("§cMeister §8(§7Klick§8)");
				i4.setItemMeta(i4meta);
				
				Inventory inv = Bukkit.createInventory(null,  9*1, ranks);
				inv.setItem(1, i1);
				inv.setItem(3, i2);
				inv.setItem(5, i3);
				inv.setItem(7, i4);
				player.openInventory(inv);
				
			}
			
		}
		
		return false;
	}
	
	@EventHandler
    public void onMenuClick(InventoryClickEvent e) {

		Player player = (Player) e.getWhoClicked();
		
        if (e.getView().getTitle().equals(ranks)) {
        	
            e.setCancelled(true);
            
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fBuilder §8(§7Klick§8)")) {
            	
            	player.closeInventory();
            	player.sendMessage("§7§m--------------------------");
            	player.sendMessage("     §fBuilder §7Baurang");
            	player.sendMessage("");
            	player.sendMessage(" §fVorraussetzungen:");
            	player.sendMessage("");
            	player.sendMessage(" §7- §e100x100 Plot");
            	player.sendMessage(" §7- §e1 Gebäude");
            	player.sendMessage(" §7- §eLandschaft, 1 Baum");
            	player.sendMessage("§7§m--------------------------");
            	
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dErfahrener §8(§7Klick§8)")) {
            	
            	player.closeInventory();
            	player.sendMessage("§7§m--------------------------");
            	player.sendMessage("     §dErfahrener §7Baurang");
            	player.sendMessage("");
            	player.sendMessage(" §fVorraussetzungen:");
            	player.sendMessage("");
            	player.sendMessage(" §7- §fBuilder §7Baurang");
            	player.sendMessage(" §7- §e100x100 Plot");
            	player.sendMessage(" §7- §e1 großes Gebäude, Details");
            	player.sendMessage(" §7- §eLandschaft, Bäume");
            	player.sendMessage("§7§m--------------------------");
            	
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Künstler §8(§7Klick§8)")) {
            	
            	player.closeInventory();
            	player.sendMessage("§7§m--------------------------");
            	player.sendMessage("     §6Künstler §7Baurang");
            	player.sendMessage("");
            	player.sendMessage(" §fVorraussetzungen:");
            	player.sendMessage("");
            	player.sendMessage(" §7- §dErfahrener §7Baurang");
            	player.sendMessage(" §7- §e100x100 Plot");
            	player.sendMessage(" §7- §e1 sehr großes Gebäude, schöne Details");
            	player.sendMessage(" §7- §eLandschaft, viele Bäume, Organics §8(§7Tiere, Pflanzen, etc.§8)");
            	player.sendMessage("§7§m--------------------------");
            	
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cMeister §8(§7Klick§8)")) {
            	
            	player.closeInventory();
            	player.sendMessage("§7§m--------------------------");
            	player.sendMessage("     §cMeister §7Baurang");
            	player.sendMessage("");
            	player.sendMessage(" §fVorraussetzungen:");
            	player.sendMessage("");
            	player.sendMessage(" §7- §6Künstler §7Baurang");
            	player.sendMessage(" §7- §e100x100 Plot");
            	player.sendMessage(" §7- §eKreativität & Professionalität");
            	player.sendMessage("§7§m--------------------------");
            	
            }
        }
    }
}
