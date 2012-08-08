package com.jme3.system.gwt;

import java.util.logging.Logger;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.jme3.renderer.gwt.GLGwtContextImpl;
import com.jme3.renderer.gwt.GwtRenderer;
import com.jme3.system.AppSettings;
import com.jme3.system.NanoTimer;

public abstract class GwtAbstractDisplay extends GwtContext {
    
    private static final Logger logger =
            Logger.getLogger(GwtAbstractDisplay.class.getName());
    
    protected Boolean needClose = new Boolean(false);
    protected boolean wasActive = false;
    protected int frameRate = 0;
    protected boolean autoFlush = true;

    ////
    
    /**
     * Does LWJGL display initialization in the OpenGL thread
     */
    protected void initInThread(){
        try{
            

            // For canvas, this will create a pbuffer,
            // allowing us to query information.
            // When the canvas context becomes available, it will
            // be replaced seamlessly.
            createContext(settings);
//            printContextInitInfo();

            created = true;
        } catch (Exception ex){
//            try {
//                if (Display.isCreated())
//                    Display.destroy();
//            } catch (Exception ex2){
//                logger.log(Level.WARNING, null, ex2);
//            }

            listener.handleError("Failed to create display", ex);
            return; // if we failed to create display, do not continue
        }
        internalCreate();
        listener.initialize();
    }
    
    /**
     * Apply the settings, changing resolution, etc.
     * @param settings
     */
    protected abstract void createContext(AppSettings settings);
    
    /**
     * Destroy the context.
     */
    protected abstract void destroyContext();
    
    public void internalCreate() {
        timer = new NanoTimer();
        
//        synchronized (createdLock){
            created = true;
//            createdLock.notifyAll();
//        }
        
        if (renderable) {
            initContextFirstTime();
        }else{
            assert getType() == Type.Canvas;
        }
    }
    
    protected void initContextFirstTime() {
        
        Canvas webGLCanvas = Canvas.createIfSupported();
        webGLCanvas.setCoordinateSpaceHeight(500);
        webGLCanvas.setCoordinateSpaceWidth(500);
        GLGwtContextImpl glContext = (GLGwtContextImpl) webGLCanvas
              .getContext("experimental-webgl");
        if (glContext == null) {
           Window.alert("Sorry, Your Browser doesn't support WebGL!");
        }
//        glContext.viewport(0, 0, 500, 500);
        
        RootPanel root = RootPanel.get("demo");
        root.add(webGLCanvas);
        webGLCanvas.setFocus(true);
        
        GwtRenderer gwtRenderer = new GwtRenderer();
        gwtRenderer.setContext(glContext);
        gwtRenderer.setCanvas(webGLCanvas);
        
        renderer = gwtRenderer;
        
        // Init renderer
        gwtRenderer.initialize();
    }
    
    /**
     * execute one iteration of the render loop in the OpenGL thread
     */
    protected void runLoop(){
        if (!created)
            throw new IllegalStateException();

        listener.update();
       
        // All this does is call swap buffers
        // If the canvas is not active, there's no need to waste time
        // doing that ..
        if (renderable) {
//            assert checkGLError();

            // calls swap buffers, etc.
            try {
                if (autoFlush){
//                    Display.update(false);
                }else{
//                    Display.processMessages();
//                    Thread.sleep(50);
                    // add a small wait
                    // to reduce CPU usage
                }
            } catch (Throwable ex){
                listener.handleError("Error while swapping buffers", ex);
            }
        }

//        if (frameRate > 0)
//            Display.sync(frameRate);

        if (renderable){
            if (autoFlush){
                // check input after we synchronize with framerate.
                // this reduces input lag.
//                Display.processMessages();
            }
        }

        // Subclasses just call GLObjectManager clean up objects here
        // it is safe .. for now.
        renderer.onFrame();
    }

    /**
     * De-initialize in the OpenGL thread.
     */
    protected void deinitInThread(){
        destroyContext();

        listener.destroy();
        logger.info("Display destroyed.");
        super.internalDestroy();
    }

    public void run() {
//        logger.log(Level.INFO, "Using LWJGL {0}", Sys.getVersion());
        initInThread();
//        while (true){
//            if (renderable){
////                if (Display.isCloseRequested())
////                    listener.requestClose(false);
//
//                if (wasActive != Display.isActive()) {
//                    if (!wasActive) {
//                        listener.gainFocus();
//                        timer.reset();
//                        wasActive = true;
//                    } else {
//                        listener.loseFocus();
//                        wasActive = false;
//                    }
//                }
//            }
//
//            runLoop();
//
//            if (needClose)
//                break;
//        }
        
        Scheduler.get().scheduleIncremental(new RepeatingCommand() {
            @Override
            public boolean execute() {
                runLoop();
                return !needClose;
            }
        });
        
        
//        deinitInThread();
    }

}
