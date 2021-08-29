package de.midno.basics.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.help.HelpTopic;

import de.midno.basics.commands.AfkCommand;
import de.midno.basics.main.Main;

public class Events implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent joinevent) {
		
		joinevent.setJoinMessage("§7[§a+§7] §a" + joinevent.getPlayer().getName());
		
	}
	
	@EventHandler
	public void onJoinGameMode(PlayerJoinEvent gamemodeevent) {
		
		Player player = gamemodeevent.getPlayer();
		player.setGameMode(GameMode.CREATIVE);
		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent quitevent) {
		
		quitevent.setQuitMessage("§7[§c-§7] §c" + quitevent.getPlayer().getName());
		
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent deathevent) {
		
		deathevent.setDeathMessage("");
		
	}
	
	@EventHandler
	public void onAchievement(PlayerAchievementAwardedEvent achevent) {
		
		achevent.setCancelled(true);
		
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();
            String cmd = event.getMessage().split(" ")[0];
            HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
            if (topic == null) {
                player.sendMessage(Main.prefix + "§e" + cmd + " §cgibt es nicht. Hast du es richtig geschrieben?");
                event.setCancelled(true);
            }
        }
	}
	
	@EventHandler
	public void onAfkMove(PlayerMoveEvent e) {
		
		Player player = e.getPlayer();	
	
		if (AfkCommand.afk1 == true) {
			
			Bukkit.broadcastMessage("§8- §9" + player.getName() + "§7 ist nicht mehr AFK.");
			AfkCommand.afk1 = false;	
		}
		
	}
	
}
