package de.lokilp66.friday.utils;

import java.io.IOException;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileConfig extends YamlConfiguration
{
    private String path;

    public FileConfig(final String folder, final String filename) {
        this.path = "plugins/" + folder + "/" + filename;
        try {
            this.load(this.path);
        }
        catch (InvalidConfigurationException | IOException ex) {
            ex.printStackTrace();
        }
    }

    public FileConfig(final String filename) {
        this("friday", filename);
    }

    public void saveConfig() {
        try {
            this.save(this.path);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}