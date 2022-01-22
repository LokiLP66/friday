package de.lokilp66.friday.listener.inventory;

import de.lokilp66.friday.utils.FileConfig;
import de.lokilp66.friday.utils.ItemBuilder;
import de.lokilp66.friday.utils.LocationUtils;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.event.Listener;

import java.util.Objects;

public class Navigator implements Listener
{
    private final Inventory navigatorInventory;
    final FileConfig spawns = new FileConfig("locations.yml");

    public Navigator(int rows) {
        this.navigatorInventory =  Bukkit.createInventory(null, (rows * 9), "§6§oNavigator");
        this.navigatorInventory.setItem(4, new ItemBuilder(Material.NETHERITE_AXE, 1).setName("Manhunt").setLore("This is Manhunt").toItemStack());
        this.navigatorInventory.setItem(3, new ItemBuilder(Material.DIAMOND_BLOCK, 1).setName("Lobby").setLore("This is the Lobby").toItemStack());
    }

    @EventHandler
    private void onInteract(final PlayerInteractEvent event) {
        final ItemStack item = event.getItem();
        if (item == null) {
            return;
        }
        if (item.getType() == Material.NETHER_STAR) {
            event.getPlayer().openInventory(this.navigatorInventory);
            event.setCancelled(true);
        }
    }

    @EventHandler
    private void onItemClick(InventoryClickEvent event) {
        if (Objects.equals(event.getClickedInventory(), this.navigatorInventory)) {
            event.setCancelled(true);

            if (event.getCurrentItem() == null) return;

            //Manhunt
            if (event.getCurrentItem().getType() == Material.NETHERITE_AXE) {
                final Player player = (Player) event.getWhoClicked();
                LocationUtils.teleport(player, LocationUtils.str2loc(spawns.getString("manhunt")));
            }
            //lobby
            if (event.getCurrentItem().getType() == Material.DIAMOND_BLOCK) {
                final Player player = (Player) event.getWhoClicked();
                LocationUtils.teleport(player, LocationUtils.str2loc(spawns.getString("spawn")));
            }
        }
    }

}

