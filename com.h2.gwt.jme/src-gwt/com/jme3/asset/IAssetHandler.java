package com.jme3.asset;

public interface IAssetHandler {

    public void addLoader(Class<? extends AssetLoader> loader, String[] extensions);

    public void addLocator(Class<? extends AssetLocator> locatorClass, String rootPath);

    public void removeLocator(Class<? extends AssetLocator> clazz, String rootPath);

    public int getLocatorCount();

    public AssetInfo tryLocate(AssetKey<?> key);

    public AssetProcessor getProcessor(Class<? extends AssetProcessor> processorType);

    public void removeLoader(Class<? extends AssetLoader> loaderClass);
    
    public AssetLoader aquireLoader(AssetKey<?> key);

}
