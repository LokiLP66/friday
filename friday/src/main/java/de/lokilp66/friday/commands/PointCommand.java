package de.lokilp66.friday.commands;

import de.lokilp66.friday.utils.FileConfig;
import de.lokilp66.friday.utils.LocationUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PointCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player player = (Player)sender;
        final FileConfig spawns = new FileConfig("locations.yml");
        if (spawns.contains(args[0].toString())) {
            LocationUtils.teleport(player, LocationUtils.str2loc(spawns.getString(args[0].toString())));
        }
        else {
            player.sendMessage("§3Friday§7: §cEs wurde kein Point Namens " + args[0].toString() + " gefunden");
        }
        return true;
    }
}
