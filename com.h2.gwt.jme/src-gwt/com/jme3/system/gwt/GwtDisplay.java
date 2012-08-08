package com.jme3.system.gwt;

import com.jme3.input.JoyInput;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.TouchInput;
import com.jme3.system.AppSettings;

public class GwtDisplay extends GwtAbstractDisplay {

    @Override
    public Type getType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MouseInput getMouseInput() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public KeyInput getKeyInput() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JoyInput getJoyInput() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TouchInput getTouchInput() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTitle(String title) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setAutoFlushFrames(boolean enabled) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void create(boolean waitFor) {
        run();
    }

    @Override
    public void restart() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void destroy(boolean waitFor) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void createContext(AppSettings settings) {
//        DisplayMode displayMode = null;
//        if (settings.getWidth() <= 0 || settings.getHeight() <= 0){
//            displayMode = Display.getDesktopDisplayMode();
//            settings.setResolution(displayMode.getWidth(), displayMode.getHeight());
//        }else if (settings.isFullscreen()){
//            displayMode = getFullscreenDisplayMode(settings.getWidth(), settings.getHeight(),
//                                                   settings.getBitsPerPixel(), settings.getFrequency());
//            if (displayMode == null)
//                throw new RuntimeException("Unable to find fullscreen display mode matching settings");
//        }else{
//            displayMode = new DisplayMode(settings.getWidth(), settings.getHeight());
//        }
//
//       int samples = 0;
//        if (settings.getSamples() > 1){
//            samples = settings.getSamples();
//        }
//        PixelFormat pf = new PixelFormat(settings.getBitsPerPixel(),
//                                         0,
//                                         settings.getDepthBits(),
//                                         settings.getStencilBits(),
//                                         samples);

        frameRate = settings.getFrameRate();
//        logger.log(Level.INFO, "Selected display mode: {0}", displayMode);

//        boolean pixelFormatChanged = false;
//        if (created.get() && (pixelFormat.getBitsPerPixel() != pf.getBitsPerPixel()
//                            ||pixelFormat.getDepthBits() != pf.getDepthBits()
//                            ||pixelFormat.getStencilBits() != pf.getStencilBits()
//                            ||pixelFormat.getSamples() != pf.getSamples())){
//            renderer.resetGLObjects();
//            Display.destroy();
//            pixelFormatChanged = true;
//        }
//        pixelFormat = pf;
//        
//        Display.setTitle(settings.getTitle());
//        if (displayMode != null){
//            if (settings.isFullscreen()){
//                Display.setDisplayModeAndFullscreen(displayMode);
//            }else{
//                Display.setFullscreen(false);
//                Display.setDisplayMode(displayMode);
//            }
//        }else{
//            Display.setFullscreen(settings.isFullscreen());
//        }
//
//        if (settings.getIcons() != null) {
//            Display.setIcon(imagesToByteBuffers(settings.getIcons()));
//        }
//        
//        Display.setVSyncEnabled(settings.isVSync());
//        
//        if (created.get() && !pixelFormatChanged){
//            Display.releaseContext();
//            Display.makeCurrent();
//            Display.update();
//        }
//
//        if (!created.get() || pixelFormatChanged){
//            ContextAttribs attr = createContextAttribs();
//            if (attr != null){
//                Display.create(pixelFormat, attr);
//            }else{
//                Display.create(pixelFormat);
//            }
//            renderable.set(true);
//            
//            if (pixelFormatChanged && pixelFormat.getSamples() > 1
//             && GLContext.getCapabilities().GL_ARB_multisample){
//                GL11.glEnable(ARBMultisample.GL_MULTISAMPLE_ARB);
//            }
//        }
        renderable = true;
    }

    @Override
    protected void destroyContext() {
        // TODO Auto-generated method stub
        
    }

}
