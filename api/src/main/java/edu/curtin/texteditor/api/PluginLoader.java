package edu.curtin.texteditor.api;

import java.net.URLClassLoader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.jar.JarFile;

public class PluginLoader {
    public String manifest = "TextEditor-Plugin-Main-Class"; 
    private PluginService api;


    public PluginLoader(PluginService api){
        this.api = api;
    }
    public Plugin loadPlugin(String pluginJarFile){

        try{
            String pluginClassName = new JarFile(pluginJarFile).getManifest().getMainAttributes().getValue(manifest);
            ClassLoader classLoader = new URLClassLoader (new URL[]{
                 new File(pluginJarFile).toURI().toURL()
                }, 
                PluginLoader.class.getClassLoader());

            Class<?> cls = Class.forName(pluginClassName, true, classLoader);
            Plugin plugin = (Plugin) cls.getConstructor().newInstance();
            return plugin;

        }catch(ReflectiveOperationException | ClassCastException  | IOException e){
            System.out.println("Plugin Jar not found: " + pluginJarFile);
            return null;
        }


    }
}
