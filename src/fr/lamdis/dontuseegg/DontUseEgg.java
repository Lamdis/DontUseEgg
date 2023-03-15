package fr.lamdis.dontuseegg;

import org.bukkit.plugin.java.JavaPlugin;

public class DontUseEgg extends JavaPlugin {
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		System.out.println("DontUseEgg c'est demarre avec succes !");
		getServer().getPluginManager().registerEvents(new DontUseEggListerners(this), this);
	}
	@Override
	public void onDisable() {
		System.out.println("DontUseEgg c'est eteint avec succes !");
		
	}

}
