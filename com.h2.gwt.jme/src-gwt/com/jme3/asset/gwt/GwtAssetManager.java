/*
 * Copyright (c) 2009-2010 jMonkeyEngine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.jme3.asset.gwt;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jme3.asset.AssetConfig;
import com.jme3.asset.AssetEventListener;
import com.jme3.asset.AssetInfo;
import com.jme3.asset.AssetKey;
import com.jme3.asset.AssetLoadException;
import com.jme3.asset.AssetLoader;
import com.jme3.asset.AssetLocator;
import com.jme3.asset.AssetManager;
import com.jme3.asset.AssetNotFoundException;
import com.jme3.asset.AssetProcessor;
import com.jme3.asset.CloneableSmartAsset;
import com.jme3.asset.IAssetHandler;
import com.jme3.asset.MaterialKey;
import com.jme3.asset.ModelKey;
import com.jme3.asset.TextureKey;
import com.jme3.audio.AudioData;
import com.jme3.audio.AudioKey;
import com.jme3.font.BitmapFont;
import com.jme3.material.Material;
import com.jme3.scene.Spatial;
import com.jme3.shader.Shader;
import com.jme3.shader.ShaderKey;
import com.jme3.texture.Texture;

/**
 * <code>AssetManager</code> is the primary method for managing and loading
 * assets inside jME.
 *
 */
public class GwtAssetManager implements AssetManager {

    private static final Logger logger = Logger.getLogger(AssetManager.class.getName());

    private final Map<AssetKey<?>, Object> cache = new HashMap<AssetKey<?>, Object>();
    private final IAssetHandler handler = new GwtImplHandler(this);

    private List<AssetEventListener> eventListeners =
            new ArrayList<AssetEventListener>();

//    private final ThreadingManager threadingMan = new ThreadingManager(this);
//    private final Set<AssetKey> alreadyLoadingSet = new HashSet<AssetKey>();

    public GwtAssetManager() {
        this(null);
    }

    public GwtAssetManager(URL configFile) {
        if (configFile != null){
            InputStream stream = null;
            try{
                AssetConfig cfg = new AssetConfig(this);
                stream = configFile.openStream();
                cfg.loadText(stream);
            }catch (IOException ex){
                logger.log(Level.SEVERE, "Failed to load asset config", ex);
            }finally{
                if (stream != null)
                    try{
                        stream.close();
                    }catch (IOException ex){
                    }
            }
        }
        logger.info("GwtAssetManager created.");
    }

    public void setAssetEventListener(AssetEventListener listener){
        eventListeners.clear();
        eventListeners.add(listener);
    }

    public void registerLoader(Class<? extends AssetLoader> loader, String ... extensions){
        handler.addLoader(loader, extensions);
        if (logger.isLoggable(Level.FINER)){
            logger.log(Level.FINER, "Registered loader: {0} for extensions {1}",
              new Object[]{loader.getName(), Arrays.toString(extensions)});
        }
    }

    public void registerLoader(String clsName, String ... extensions){
//        Class<? extends AssetLoader> clazz = null;
//        try{
//            clazz = (Class<? extends AssetLoader>) Class.forName(clsName);
//        }catch (ClassNotFoundException ex){
//            logger.log(Level.WARNING, "Failed to find loader: "+clsName, ex);
//        }catch (NoClassDefFoundError ex){
//            logger.log(Level.WARNING, "Failed to find loader: "+clsName, ex);
//        }
//        if (clazz != null){
//            registerLoader(clazz, extensions);
//        }
        throw new RuntimeException("Method not implemented.");
    }

    public void registerLocator(String rootPath, Class<? extends AssetLocator> locatorClass){
        handler.addLocator(locatorClass, rootPath);
        if (logger.isLoggable(Level.FINER)){
            logger.log(Level.FINER, "Registered locator: {0}",
                    locatorClass.getName());
        }
    }

    public void registerLocator(String rootPath, String clsName){
//        Class<? extends AssetLocator> clazz = null;
//        try{
//            clazz = (Class<? extends AssetLocator>) Class.forName(clsName);
//        }catch (ClassNotFoundException ex){
//            logger.log(Level.WARNING, "Failed to find locator: "+clsName, ex);
//        }catch (NoClassDefFoundError ex){
//            logger.log(Level.WARNING, "Failed to find loader: "+clsName, ex);
//        }
//        if (clazz != null){
//            registerLocator(rootPath, clazz);
//        }
        throw new RuntimeException("Method not implemented.");
    }
    
    public void unregisterLocator(String rootPath, Class<? extends AssetLocator> clazz){
        handler.removeLocator(clazz, rootPath);
        if (logger.isLoggable(Level.FINER)){
            logger.log(Level.FINER, "Unregistered locator: {0}",
                    clazz.getName());
        }
    }

    public void clearCache(){
        cache.clear();
    }

    /**
     * Delete an asset from the cache, returns true if it was deleted
     * successfully.
     * <br/><br/>
     * <font color="red">Thread-safe.</font>
     */
    public boolean deleteFromCache(AssetKey<?> key){
        cache.remove(key);
        return true;
    }

    /**
     * Adds a resource to the cache.
     * <br/><br/>
     * <font color="red">Thread-safe.</font>
     */
    public void addToCache(AssetKey<?> key, Object asset){
        cache.put(key, asset);
    }

    public AssetInfo locateAsset(AssetKey<?> key){
        if (handler.getLocatorCount() == 0){
            logger.warning("There are no locators currently"+
                           " registered. Use AssetManager."+
                           "registerLocator() to register a"+
                           " locator.");
            return null;
        }

        AssetInfo info = handler.tryLocate(key);
        if (info == null){
            logger.log(Level.WARNING, "Cannot locate resource: {0}", key);
        }

        return info;
    }

    /**
     * <font color="red">Thread-safe.</font>
     *
     * @param <T>
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T loadAsset(AssetKey<T> key) {
        if (key == null)
            throw new IllegalArgumentException("key cannot be null");
        
        for (AssetEventListener listener : eventListeners){
            listener.assetRequested(key);
        }

        Object obj;
        AssetInfo info = handler.tryLocate(key);
        if (info == null){
            throw new AssetNotFoundException(key.toString());
        }

        AssetLoader loader = handler.aquireLoader(key);
        AssetProcessor proc = handler.getProcessor(key.getProcessorType());
        
        try {
            obj = loader.load(info);
        } catch (IOException ex) {
            throw new AssetLoadException("An exception has occured while loading asset: " + key, ex);
        }
        if (obj == null){
            throw new AssetLoadException("Error occured while loading asset \"" + key + "\" using" + loader.getClass().getName());
        }else{
            if (logger.isLoggable(Level.FINER)){
                logger.log(Level.FINER, "Loaded {0} with {1}",
                        new Object[]{key, loader.getClass().getName()});
            }
            
            if (proc != null) {
                obj = proc.postProcess(key, obj);
            }
            
            for (AssetEventListener listener : eventListeners){
                listener.assetLoaded(key);
            }
        }
        
        T clone = (T) obj;
        if (clone instanceof CloneableSmartAsset){
            if (proc == null){
                throw new IllegalStateException("Asset implements "
                        + "CloneableSmartAsset but doesn't "
                        + "have processor to handle cloning");
            }else{
                clone = (T) proc.createClone(obj);
//                if (cache != null && clone != obj){
//                    cache.registerAssetClone(key, clone);
//                } else{
//                    throw new IllegalStateException("Asset implements "
//                        + "CloneableSmartAsset but doesn't have cache or "
//                        + "was not cloned");
//                }
            }
        }
        
        return clone;
    }

    public Object loadAsset(String name){
        return loadAsset(new AssetKey(name));
    }

    /**
     * Loads a texture.
     *
     * @return
     */
    public Texture loadTexture(TextureKey key){
        return (Texture) loadAsset(key);
    }

    public Material loadMaterial(String name){
        return (Material) loadAsset(new MaterialKey(name));
    }

    /**
     * Loads a texture.
     *
     * @param name
     * @param generateMipmaps Enable if applying texture to 3D objects, disable
     * for GUI/HUD elements.
     * @return
     */
    public Texture loadTexture(String name, boolean generateMipmaps){
        TextureKey key = new TextureKey(name, true);
        key.setGenerateMips(generateMipmaps);
        key.setAsCube(false);
        return loadTexture(key);
    }

    public Texture loadTexture(String name, boolean generateMipmaps, boolean flipY, boolean asCube, int aniso){
        TextureKey key = new TextureKey(name, flipY);
        key.setGenerateMips(generateMipmaps);
        key.setAsCube(asCube);
        key.setAnisotropy(aniso);
        return loadTexture(key);
    }

    public Texture loadTexture(String name){
        return loadTexture(name, true);
    }

    public AudioData loadAudio(AudioKey key){
        return (AudioData) loadAsset(key);
    }

    public AudioData loadAudio(String name){
        return loadAudio(new AudioKey(name, false));
    }

    /**
     * Loads a bitmap font with the given name.
     *
     * @param name
     * @return
     */
    public BitmapFont loadFont(String name){
        return (BitmapFont) loadAsset(new AssetKey(name));
    }

    public InputStream loadGLSLLibrary(AssetKey key){
        return (InputStream) loadAsset(key);
    }

    /**
     * Load a vertex/fragment shader combo.
     *
     * @param key
     * @return
     */
    public Shader loadShader(ShaderKey key){
        // cache abuse in method
        // that doesn't use loaders/locators
        Shader s = (Shader) cache.get(key);
        if (s == null) {
            String vertName = key.getVertName();
            String fragName = key.getFragName();

            String vertSource = (String) loadAsset(new AssetKey(vertName));
            String fragSource = (String) loadAsset(new AssetKey(fragName));

            s = new Shader(key.getLanguage());
            s.addSource(Shader.ShaderType.Vertex,   vertName, vertSource, key.getDefines().getCompiled());
            s.addSource(Shader.ShaderType.Fragment, fragName, fragSource, key.getDefines().getCompiled());

            cache.put(key, s);
        }
        return s;
    }

    public Spatial loadModel(ModelKey key){
        return (Spatial) loadAsset(key);
    }

    /**
     * Load a model.
     *
     * @param name
     * @return
     */
    public Spatial loadModel(String name){
        return loadModel(new ModelKey(name));
    }

    @Override
    public void addClassLoader(ClassLoader loader) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeClassLoader(ClassLoader loader) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<ClassLoader> getClassLoaders() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void unregisterLoader(Class<? extends AssetLoader> loaderClass) {
        handler.removeLoader(loaderClass);
        if (logger.isLoggable(Level.FINER)){
            logger.log(Level.FINER, "Unregistered loader: {0}",
                    loaderClass.getName());
        }
    }

    @Override
    public void addAssetEventListener(AssetEventListener listener) {
        eventListeners.add(listener);
    }

    @Override
    public void removeAssetEventListener(AssetEventListener listener) {
        eventListeners.remove(listener);
    }

    @Override
    public void clearAssetEventListeners() {
        eventListeners.clear();
    }
    
}
