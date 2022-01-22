package de.lokilp66.friday.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class DoubleInvCommand implements CommandExecutor {

    Inventory playerInventory;

    public void DoubleInv(int rows) {
        this.playerInventory =  Bukkit.createInventory(null, (rows * 9), "§6§oPlayer Inventory");
    }

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {

        Player player = (Player) sender;
        DoubleInv(5);
        player.openInventory(this.playerInventory);

        return true;
    }

}
