package de.midno.basics.main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.midno.basics.commands.AfkCommand;
import de.midno.basics.commands.BanCommand;
import de.midno.basics.commands.CalcCommand;
import de.midno.basics.commands.ClearInvCommand;
import de.midno.basics.commands.DayCommand;
import de.midno.basics.commands.FlySpeedCommand;
import de.midno.basics.commands.GameModeCommand;
import de.midno.basics.commands.GiveCommand;
import de.midno.basics.commands.HealCommand;
import de.midno.basics.commands.IdCommand;
import de.midno.basics.commands.KickCommand;
import de.midno.basics.commands.MsgCommand;
import de.midno.basics.commands.NightCommand;
import de.midno.basics.commands.RainCommand;
import de.midno.basics.commands.RanksCommand;
import de.midno.basics.commands.SunCommand;
import de.midno.basics.commands.TeleportCommand;
import de.midno.basics.commands.TopCommand;
import de.midno.basics.commands.UnbanCommand;
import de.midno.basics.commands.WalkSpeedCommand;
import de.midno.basics.events.Events;
import net.minecraft.server.v1_8_R3.MinecraftServer;

public class Main extends JavaPlugin implements Listener {
	
	public static String prefix = "§8| §6§lKISO§7 » ";
	public static String prefix2 = "§eKiso§7-§eBasics ";
	public static String noPerms = "§8| §6§lKISO§7 » §cDazu hast du keine Rechte!";
	public static String error = "§8| §6§lKISO§7 » §cFehler. Hast du alles richtig geschrieben?";
	
	@Override
	public void onEnable() {
		
		Bukkit.getConsoleSender().sendMessage(prefix + prefix2 + "§ewerden geladen...");
		setMotd("§6§lKiso §a§lBauserver");
		
		try {
			
			register();
			
		} catch (Exception exc) {
			
			Bukkit.getConsoleSender().sendMessage(prefix + prefix2 + "§chat einen Fehler!");
			
			return;
		}
		
		Bukkit.getConsoleSender().sendMessage(prefix + prefix2 + "§awurde erfolgreich geladen!");
		
	}
	
	public void onDisable() {
		
		Bukkit.getConsoleSender().sendMessage(prefix + prefix2 + "§awurde gestoppt!");
		
	}
	
	public void register() {
		
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("teleport").setExecutor(new TeleportCommand());
		getCommand("gamemode").setExecutor(new GameModeCommand());
		getCommand("give").setExecutor(new GiveCommand());
		getCommand("clear").setExecutor(new ClearInvCommand());
		getCommand("fspeed").setExecutor(new FlySpeedCommand());
		getCommand("wspeed").setExecutor(new WalkSpeedCommand());
		getCommand("itemid").setExecutor(new IdCommand());
		getCommand("top").setExecutor(new TopCommand());
		getCommand("sun").setExecutor(new SunCommand());
		getCommand("rain").setExecutor(new RainCommand());
		getCommand("day").setExecutor(new DayCommand());
		getCommand("night").setExecutor(new NightCommand());
		getCommand("msg").setExecutor(new MsgCommand());
		getCommand("afk").setExecutor(new AfkCommand());
		getCommand("kick").setExecutor(new KickCommand());
		getCommand("ban").setExecutor(new BanCommand());
		getCommand("unban").setExecutor(new UnbanCommand());
		getCommand("ranks").setExecutor(new RanksCommand());
		getCommand("calc").setExecutor(new CalcCommand());
		
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new Events(), this);
		pluginManager.registerEvents(new RanksCommand(), this);
		getServer().getPluginManager().registerEvents(this, this);
		
	}
	
	public void setMotd(final String motd){

		MinecraftServer.getServer().setMotd(motd);
		MinecraftServer.getServer().getPropertyManager().setProperty("motd", motd);
		MinecraftServer.getServer().getPropertyManager().savePropertiesFile();

	}

}
