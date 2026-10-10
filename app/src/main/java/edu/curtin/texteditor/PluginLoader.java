package edu.curtin.texteditor;

import java.net.URLClassLoader;
import edu.curtin.texteditor.api.PluginService;
import groovy.lang.GroovyShell;
import java.nio.file.Files;
import java.nio.file.Path;
import edu.curtin.texteditor.api.Plugin;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.jar.JarFile;

public class PluginLoader {
    public String manifest = "TextEditor-Plugin-Main-Class";
    private PluginService api;

    public PluginLoader(PluginService api) {
        this.api = api;
    }

    public Plugin loadPlugin(String pluginJarFile) {

        try {
            String pluginClassName;

            try (JarFile jar = new JarFile(pluginJarFile)) {
                pluginClassName = jar.getManifest()
                        .getMainAttributes()
                        .getValue(manifest);
            }
            ClassLoader classLoader = new URLClassLoader(new URL[] {
                    new File(pluginJarFile).toURI().toURL()
            },
                    PluginLoader.class.getClassLoader());

            Class<?> cls = Class.forName(pluginClassName, true, classLoader);
            Plugin plugin = (Plugin) cls.getConstructor().newInstance();
            return plugin;

        } catch (ReflectiveOperationException | ClassCastException | IOException e) {
            System.out.println("Plugin Jar not found: " + pluginJarFile);
            return null;
        }

    }

    public boolean loadScript(File file) {
        try {
            String scriptCode = Files.readString(file.toPath());
            GroovyShell shell = new GroovyShell();
            shell.setVariable("app", api);
            shell.evaluate(scriptCode);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public boolean loadJar(File file ){
            Plugin plugin = loadPlugin(file.getPath());
            if (plugin == null){
                return false;
            }
            return true;


    }


}
