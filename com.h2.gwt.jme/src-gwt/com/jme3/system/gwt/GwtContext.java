package com.jme3.system.gwt;

import com.jme3.renderer.Renderer;
import com.jme3.system.AppSettings;
import com.jme3.system.JmeContext;
import com.jme3.system.SystemListener;
import com.jme3.system.Timer;

public abstract class GwtContext implements JmeContext {
    
    protected Boolean created = false;
    protected Boolean renderable = false;
    protected final Object createdLock = new Object();

    protected AppSettings settings = new AppSettings(true);
    protected Renderer renderer;
    protected Timer timer;
    protected SystemListener listener;
    
    ////
    ////

    public void internalDestroy(){
        renderer = null;
        timer = null;
        renderable = false;
        created = false;
    }
    
    public boolean isCreated(){
        return created;
    }
    
    public boolean isRenderable(){
        return renderable;
    }

    public void setSettings(AppSettings settings) {
        this.settings.copyFrom(settings);
    }

    public AppSettings getSettings(){
        return settings;
    }

    public Renderer getRenderer() {
        return renderer;
    }
    
    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    public Timer getTimer() {
        return timer;
    }
    
    public void setSystemListener(SystemListener listener){
        this.listener = listener;
    }

}
