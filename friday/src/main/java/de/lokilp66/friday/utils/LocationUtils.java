package de.lokilp66.friday.utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class LocationUtils
{
    public static String loc2Str(final Location location) {
        String loc = "";
        loc = loc + location.getWorld().getName() + ";";
        loc = loc + location.getX() + ";";
        loc = loc + location.getY() + ";";
        loc = loc + location.getZ() + ";";
        loc = loc + location.getYaw() + ";";
        loc += location.getPitch();
        return loc;
    }

    public static Location str2loc(final String str) {
        final String[] args = str.split(";");
        return new Location(Bukkit.getWorld(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Float.parseFloat(args[4]), Float.parseFloat(args[5]));
    }

    public static void teleport(final Player player, final Location location) {
        player.teleport(location);
        player.playSound(location, Sound.ENTITY_ENDERMAN_TELEPORT, 0.2f, 1.2f);
    }
}
