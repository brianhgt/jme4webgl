package com.jme3.system.gwt;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;

import com.jme3.asset.AssetManager;
import com.jme3.asset.gwt.GwtAssetManager;
import com.jme3.audio.AudioRenderer;
import com.jme3.audio.gwt.GwtAudioRenderer;
import com.jme3.system.AppSettings;
import com.jme3.system.JmeContext;
import com.jme3.system.JmeContext.Type;
import com.jme3.system.JmeSystemDelegate;
import com.jme3.system.Platform;

public class JmeGwtSystem extends JmeSystemDelegate {

    @Override
    public AssetManager newAssetManager(URL configFile) {
        logger.log(Level.INFO, "Creating asset manager with config {0}", configFile);
        return new GwtAssetManager(configFile);
    }

    @Override
    public AssetManager newAssetManager() {
        logger.log(Level.INFO, "Creating asset manager with default config");
        return new GwtAssetManager();
    }

    @Override
    public boolean showSettingsDialog(AppSettings sourceSettings, boolean loadFromRegistry) {
        return true;
    }
    
    public InputStream getResourceAsStream(String name) {
        return null;
    }
    
    public URL getResource(String name) {
        return null;
    }

    @Override
    public JmeContext newContext(AppSettings settings, Type contextType) {
        initialize(settings);
        
//        Canvas webGLCanvas = Canvas.createIfSupported();
//        webGLCanvas.setCoordinateSpaceHeight(500);
//        webGLCanvas.setCoordinateSpaceWidth(500);
//        GLGwtContextImpl glContext = (GLGwtContextImpl) webGLCanvas
//              .getContext("experimental-webgl");
//        if (glContext == null) {
//           Window.alert("Sorry, Your Browser doesn't support WebGL!");
//        }
////        glContext.viewport(0, 0, 500, 500);
//        
//        RootPanel root = RootPanel.get("demo");
//        root.add(webGLCanvas);
//        webGLCanvas.setFocus(true);
//        
//        
//        final GwtRenderer renderer = new GwtRenderer();
//        renderer.setContext(glContext);
//        renderer.setCanvas(webGLCanvas);
        
        GwtDisplay jmeContext = new GwtDisplay();
//        jmeContext.setRenderer(renderer);
        
        return jmeContext;
    }

    @Override
    public AudioRenderer newAudioRenderer(AppSettings settings) {
        return new GwtAudioRenderer();
    }

    @Override
    public void initialize(AppSettings settings) {
        if (initialized) {
            return;
        }

        initialized = true;
//        try {
//            JmeFormatter formatter = new JmeFormatter();
//            Handler consoleHandler = new AndroidLogHandler();
//            consoleHandler.setFormatter(formatter);
//            
//            Logger log = Logger.getLogger("");
//            for (Handler h : log.getHandlers()) {
//                log.removeHandler(h);
//            }
//            log.addHandler(consoleHandler);
//            Logger log = Logger.getLogger(JmeGwtSystem.class.getName());
//            boolean bIsLogFormatSet = false;
//            do {
//                log.setLevel(Level.ALL);
//                if (log.getHandlers().length == 0) {
//                    log = log.getParent();
//                    if (log != null) {
//                        for (Handler h : log.getHandlers()) {
//                            h.setFormatter(new JmeFormatter());
//                            h.setLevel(Level.ALL);
//                            bIsLogFormatSet = true;
//                        }
//                    }
//                }
//            } while (log != null && !bIsLogFormatSet);
//        } catch (SecurityException ex) {
//            logger.log(Level.SEVERE, "Security error in creating log file", ex);
//        }
//        logger.log(Level.INFO, "Running on {0}", getFullName());
    }

    @Override
    public Platform getPlatform() {
        return Platform.WEB;
    }

    @Override
    public synchronized File getStorageFolder() {
        return null;
    }
}
