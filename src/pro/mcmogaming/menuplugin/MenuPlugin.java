package pro.mcmogaming.menuplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MenuPlugin extends JavaPlugin implements CommandExecutor{
	
	@Override
	public void onEnable() {
	
		this.getConfig().addDefault("Shop page name", "menuplugin");
		this.getConfig().options().copyDefaults();
		this.saveConfig();
		
		this.getCommand("menu").setExecutor((CommandExecutor)new MenuPlugin());
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		
		super.onDisable();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = (Player)sender;
		
		if(sender instanceof Player) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "sudo " + player.getName() + " shop " + this.getConfig().getString("Shop page name"));
		}
		
		
		
		return true;
	}
	

}
