package fr.lamdis.dontuseegg;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SpawnEggMeta;

public class DontUseEggListerners implements Listener {
	
	private DontUseEgg main;
	
	public DontUseEggListerners(DontUseEgg dontUseEgg) {
		this.main = dontUseEgg;
	}

	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack it = event.getItem();
		Boolean cancelMess = main.getConfig().getBoolean("message.canceled");
		
		if(it == null) return;
		
		if(main.getConfig().getBoolean("exception.on-spawner") == true) {
			Block block = event.getClickedBlock();
			if(block != null) {
				if(block.getType() == Material.SPAWNER) {
					return;
				}
			}
		}
		
		ItemMeta meta = it.getItemMeta();
        if (meta instanceof SpawnEggMeta) {
        	if(action == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
				if(cancelMess == true) {
					player.sendMessage(main.getConfig().getString("message.cancel-message".replace("&", "§")));
				}
			}
			if(action == Action.RIGHT_CLICK_BLOCK) {
				event.setCancelled(true);
				if(cancelMess == true) {
					player.sendMessage(main.getConfig().getString("message.cancel-message".replace("&", "§")));
				}
			}
		}
	}
}
