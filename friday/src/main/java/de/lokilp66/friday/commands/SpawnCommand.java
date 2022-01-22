package de.lokilp66.friday.commands;

import de.lokilp66.friday.utils.LocationUtils;
import de.lokilp66.friday.utils.FileConfig;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class SpawnCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player player = (Player)sender;
        final FileConfig spawns = new FileConfig("locations.yml");
        if (!label.equalsIgnoreCase("setspawn")) {
            if (spawns.contains("spawn")) {
                LocationUtils.teleport(player, LocationUtils.str2loc(spawns.getString("spawn")));
            }
            else {
                player.sendMessage("§3Friday§7: §cEs wurde noch kein Spawnpoint gesetzt");
            }
            return true;
        }
        if (player.hasPermission("de.lokilp66.friday.setspawn")) {
            spawns.set("spawn", (Object)LocationUtils.loc2Str(player.getLocation()));
            spawns.saveConfig();
            player.sendMessage("§3Friday§7: Spawn wurde auf §a" + player.getLocation());
            return true;
        }
        player.sendMessage("§3Friday§7: §cDu hast nicht die Berechtigung diesen Befehl auszufuehren.");
        return true;
    }
}

