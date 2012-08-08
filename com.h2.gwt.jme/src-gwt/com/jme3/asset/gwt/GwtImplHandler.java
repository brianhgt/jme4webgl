package com.jme3.asset.gwt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.jme3.asset.AssetInfo;
import com.jme3.asset.AssetKey;
import com.jme3.asset.AssetLoader;
import com.jme3.asset.AssetLocator;
import com.jme3.asset.AssetManager;
import com.jme3.asset.AssetProcessor;
import com.jme3.asset.IAssetHandler;

public class GwtImplHandler implements IAssetHandler {
    
    private static final Logger logger = Logger.getLogger(
            GwtImplHandler.class.getName());
    
    private AssetManager assetManager;
    
    private List<Class<? extends AssetLocator>> locators =
            new ArrayList<Class<? extends AssetLocator>>();
    
    private Map<String, Class<? extends AssetLoader>> classToLoaders =
            new HashMap<String, Class<? extends AssetLoader>>();
    
    private Map<String, Class<? extends AssetLoader>> extensionToLoaders =
            new HashMap<String, Class<? extends AssetLoader>>();
    
    private Map<String, Class<? extends AssetProcessor>> classToProcessors =
            new HashMap<String, Class<? extends AssetProcessor>>();
    
    ////
    ////

    public GwtImplHandler() {
        //empty
    }
    
    public GwtImplHandler(AssetManager assetManager) {
        setAssetManager(assetManager);
    }

    @Override
    public void addLoader(Class<? extends AssetLoader> loader,
            String[] extensions) {
        
        //class
        getClassToLoaders().put(loader.getName(), loader);
        
        //extensions
        for (String extension : extensions){
            getExtensionToLoaders().put(extension, loader);
        }
    }

    @Override
    public void addLocator(Class<? extends AssetLocator> locatorClass,
            String rootPath) {
        getLocators().add(locatorClass);
    }

    @Override
    public void removeLocator(Class<? extends AssetLocator> clazz,
            String rootPath) {
        getLocators().remove(clazz);
    }

    @Override
    public int getLocatorCount() {
        return getLocators().size();
    }

    @Override
    public AssetInfo tryLocate(AssetKey<?> key) {
        if (getLocators() == null || getLocators().isEmpty()) {
            logger.warning("There are no locators currently"+
                            " registered. Use AssetManager."+
                            "registerLocator() to register a"+
                            " locator.");
            return null;
        }
        
        for (Class<? extends AssetLocator> locatorClz : getLocators()) {
            AssetLocator locator = GWT.create(locatorClz);
            AssetInfo info = locator.locate(assetManager, key);
            if (info != null) {
                return info;
            }
        }
        return null;
    }

    @Override
    public AssetProcessor getProcessor(
            Class<? extends AssetProcessor> processorType) {
        
        if (processorType == null) {
            return null;
        }
        AssetProcessor processor = GWT.create(
                getClassToProcessors().get(processorType));
        
        return processor;
    }

    @Override
    public AssetLoader aquireLoader(AssetKey<?> key) {
        if (!getExtensionToLoaders().containsKey(key.getExtension())) {
            logger.warning("There were no loaders found for: "
                    + key.getExtension());
            return null;
        }
        AssetLoader loader = GWT.create(
                getExtensionToLoaders().get(key.getExtension()));
        return loader;
    }

    @Override
    public void removeLoader(Class<? extends AssetLoader> loaderClass) {
        getClassToLoaders().remove(loaderClass);
        //FIXME remove loaders from extensions
    }
    
    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public Map<String, Class<? extends AssetLoader>> getClassToLoaders() {
        return classToLoaders;
    }

    public void setClassToLoaders(
            Map<String, Class<? extends AssetLoader>> classToLoaders) {
        this.classToLoaders = classToLoaders;
    }

    public Map<String, Class<? extends AssetLoader>> getExtensionToLoaders() {
        return extensionToLoaders;
    }

    public void setExtensionToLoaders(
            Map<String, Class<? extends AssetLoader>> extensionToLoaders) {
        this.extensionToLoaders = extensionToLoaders;
    }

    public Map<String, Class<? extends AssetProcessor>> getClassToProcessors() {
        return classToProcessors;
    }

    public void setClassToProcessors(
            Map<String, Class<? extends AssetProcessor>> classToProcessors) {
        this.classToProcessors = classToProcessors;
    }

    public List<Class<? extends AssetLocator>> getLocators() {
        return locators;
    }

    public void setLocators(List<Class<? extends AssetLocator>> locators) {
        this.locators = locators;
    }

}
