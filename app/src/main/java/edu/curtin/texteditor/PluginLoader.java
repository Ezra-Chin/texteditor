package edu.curtin.texteditor;

import edu.curtin.texteditor.api.Plugin;
import edu.curtin.texteditor.api.PluginService;
import groovy.lang.GroovyRuntimeException;
import groovy.lang.GroovyShell;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import org.antlr.v4.parse.ANTLRParser.id_return;

public class PluginLoader {
    private PluginService api;
    private final List<String> loadedNames = new ArrayList<>();

    public PluginLoader(PluginService api) {
        this.api = api;
    }

    public List<String> getLoadedNames() {
        return List.copyOf(loadedNames);
    }

    public void loadByClassName(String className) {
        try {
            startPlugin(Class.forName(className));
        } catch (ReflectiveOperationException e) {
            System.out.println("Failed to load plugin: " + e.getMessage());
        }
    }

    //cannot clsoe cz plugin still need use its class
    @SuppressWarnings("PMD.CloseResource")
    public boolean loadJar(File jarFile) {

        try{
            String className = readMainClass(jarFile);
            if(className == null){
                return false;
            }
            URLClassLoader classLoader = new URLClassLoader(new URL[] {jarFile.toURI().toURL()}, PluginLoader.class.getClassLoader());
            startPlugin(Class.forName(className, true, classLoader));
            return true;
        }catch(IOException | ReflectiveOperationException | ClassCastException e ){
            return false;
        }

    }

    public boolean loadScript(File scriptFile) {
        try {
            String code = Files.readString(scriptFile.toPath());
            GroovyShell shell = new GroovyShell();
            shell.setVariable("app", api);
            shell.evaluate(code);
            loadedNames.add(scriptFile.getName());
            return true;
        } catch (IOException e) {
            System.out.println("Failed to load plugin JAR: " + e.getMessage());
            return false;

        }
    }

    private String readMainClass(File jarFile) {
        try (JarFile jar = new JarFile(jarFile)) {
            Manifest manifest = jar.getManifest();
            String className = (manifest == null) ? null
                    : manifest.getMainAttributes().getValue("TextEditor-Plugin-Main-Class");
            if (className == null) {
                return null;
            }

            return className;
        } catch (IOException e) {
            return null;

        }
    }

    private void startPlugin(Class<?> cls) {
        try {
            Plugin plugin = (Plugin) cls.getConstructor().newInstance();
            plugin.start(api);
            loadedNames.add(cls.getName());
        } catch (ReflectiveOperationException | ClassCastException e) {
            System.out.println("Cannot start plugin");

        }
    }

}
