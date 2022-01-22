package de.lokilp66.friday.commands;

import de.lokilp66.friday.utils.LocationUtils;
import de.lokilp66.friday.utils.FileConfig;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class SetPointCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player player = (Player)sender;
        final FileConfig spawns = new FileConfig("locations.yml");
        if (player.hasPermission("de.lokilp66.friday.setpoint")) {
                spawns.set(args[0].toString(), (Object)LocationUtils.loc2Str(player.getLocation()));
                spawns.saveConfig();
                player.sendMessage("§3Friday§7: Point " + args[0] + " wurde auf §a" + player.getLocation());
                return true;
        }
        player.sendMessage("§3Friday§7: §cDu hast nicht die Berechtigung diesen Befehl auszufuehren.");
        return true;
    }
}


