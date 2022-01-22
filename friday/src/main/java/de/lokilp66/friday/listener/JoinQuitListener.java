package de.lokilp66.friday.listener;

import de.lokilp66.friday.utils.ItemBuilder;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;

public class JoinQuitListener implements Listener
{
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.performCommand("spawn");

        ItemStack navi = new  ItemBuilder(Material.NETHER_STAR, 1).setName("§6§oNavigator").toItemStack();
        player.getInventory().setItem(8, navi);

        player.setDisplayName("§4Owner§r: " + player.getDisplayName());
        player.setCustomName("§4Owner§r: " + player.getDisplayName());
        player.setPlayerListName(player.getDisplayName());
        event.setJoinMessage("§3Friday: §7" + player.getDisplayName() + " ist dem Server beigetreten!");
    }

    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        event.setQuitMessage("§3Friday: §7" + player.getDisplayName() + " hat den Server verlassen!");
    }
}
