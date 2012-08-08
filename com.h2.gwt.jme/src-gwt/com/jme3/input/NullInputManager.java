package com.jme3.input;

import com.jme3.input.controls.InputListener;
import com.jme3.input.controls.Trigger;
import com.jme3.input.event.JoyAxisEvent;
import com.jme3.input.event.JoyButtonEvent;
import com.jme3.input.event.KeyInputEvent;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.input.event.MouseMotionEvent;
import com.jme3.input.event.TouchEvent;

public class NullInputManager implements IInputManager {
    
    public NullInputManager(MouseInput mouse, KeyInput keys, JoyInput joystick,
            TouchInput touch) {
        
    }

    @Override
    public void beginInput() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void endInput() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onJoyAxisEvent(JoyAxisEvent evt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onJoyButtonEvent(JoyButtonEvent evt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onMouseMotionEvent(MouseMotionEvent evt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onMouseButtonEvent(MouseButtonEvent evt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onKeyEvent(KeyInputEvent evt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onTouchEvent(TouchEvent evt) {
        // TODO Auto-generated method stub
        
    }

    public void reset() {
        // TODO Auto-generated method stub
        
    }

//    public void addListener(AppActionListener actionListener,
//            String inputMappingExit) {
//        // TODO Auto-generated method stub
//        
//    }

    public void addMapping(String inputMappingExit, Trigger... triggers) {
        // TODO Auto-generated method stub
        
    }

    public void update(float timePerFrame) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addListener(InputListener listener, String... mappingNames) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean hasMapping(String inputMappingCameraPos) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void deleteMapping(String inputMappingCameraPos) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeListener(InputListener keyListener) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setCursorVisible(boolean b) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Joystick[] getJoysticks() {
        // TODO Auto-generated method stub
        return null;
    }

}
