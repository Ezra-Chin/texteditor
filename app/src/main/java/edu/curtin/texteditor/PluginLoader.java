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

public class PluginLoader {
    private PluginService api;
    private List<String> loadedNames = new ArrayList<>();

    public PluginLoader(PluginService api) {
        this.api = api;
    }

    public List<String> getLoadedNames() {
        return List.copyOf(loadedNames);
    }

    public void loadByClassName(String className) {
        try {
            startPlugin(Class.forName(className));
        } catch (ReflectiveOperationException | ClassCastException e ) {

        }
    }

    public void loadJar(File jarFile) {
        try {
            String className = readMainClass(jarFile);
            ClassLoader classLoader = new URLClassLoader(
                new URL[] { jarFile.toURI().toURL() },
                PluginLoader.class.getClassLoader());
            startPlugin(Class.forName(className, true, classLoader));
        } catch (ReflectiveOperationException | IOException e) {

        }
    }
    public void loadScript(File scriptFile){
        try{
            String code = Files.readString(scriptFile.toPath());
            GroovyShell shell = new GroovyShell();
            shell.setVariable("app", api);
            shell.evaluate(code);
            loadedNames.add(scriptFile.getName());
        }catch(IOException e ){

        }
    }
    private String readMainClass(File jarFile) {
        try(JarFile jar = new JarFile(jarFile))
        {
            Manifest manifest = jar.getManifest();
            String className = (manifest == null) ? null
                : manifest.getMainAttributes().getValue("TextEditor-Plugin-Main-Class");
            if(className == null)
            {
                return null;
            }

            return className;
        }catch(IOException e ){
            return null;

        }
    }
    private void startPlugin(Class<?> cls ){
        try{
            Plugin plugin = (Plugin) cls.getConstructor().newInstance();
            plugin.start(api);
            loadedNames.add(cls.getName());
        }catch(ReflectiveOperationException | ClassCastException e ){

        }
    }
}
