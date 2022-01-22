package de.lokilp66.friday;

import de.lokilp66.friday.commands.DoubleInvCommand;
import de.lokilp66.friday.commands.PointCommand;
import de.lokilp66.friday.commands.SetPointCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.command.CommandExecutor;
import de.lokilp66.friday.commands.SpawnCommand;
import de.lokilp66.friday.listener.inventory.Navigator;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import de.lokilp66.friday.listener.JoinQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Friday extends JavaPlugin
{
    public static String PREFIX;
    public static Friday INSTANCE;

    public Friday() {
        Friday.INSTANCE = this;
    }

    @Override
    public void onEnable() {
        this.register();
        this.log("Hello I am Friday a Minecraft Bot/Plugin.");
    }

    @Override
    public void onDisable() {
        this.log("Bye!");
    }

    public void log(final String text) {
        Bukkit.getConsoleSender().sendMessage(Friday.PREFIX + text);
    }

    private void register() {
        final PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents((Listener)new JoinQuitListener(), (Plugin)this);
        pluginManager.registerEvents((Listener)new Navigator(1), (Plugin)this);

        Bukkit.getPluginCommand("spawn").setExecutor((CommandExecutor)new SpawnCommand());
        Bukkit.getPluginCommand("setpoint").setExecutor((CommandExecutor)new SetPointCommand());
        Bukkit.getPluginCommand("point").setExecutor((CommandExecutor)new PointCommand());
        Bukkit.getPluginCommand("dinv").setExecutor((CommandExecutor)new DoubleInvCommand());
    }

    static {
        Friday.PREFIX = "§3Friday: §7";
    }
}