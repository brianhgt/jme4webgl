package com.jme3.input;

import com.jme3.input.controls.InputListener;
import com.jme3.input.controls.Trigger;
import com.jme3.input.event.JoyAxisEvent;
import com.jme3.input.event.JoyButtonEvent;
import com.jme3.input.event.KeyInputEvent;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.input.event.MouseMotionEvent;
import com.jme3.input.event.TouchEvent;

public interface IInputManager extends RawInputListener {
    
    public void beginInput();

    public void endInput();

    @Override
    public void onJoyAxisEvent(JoyAxisEvent evt);

    @Override
    public void onJoyButtonEvent(JoyButtonEvent evt);

    @Override
    public void onMouseMotionEvent(MouseMotionEvent evt);

    @Override
    public void onMouseButtonEvent(MouseButtonEvent evt);

    @Override
    public void onKeyEvent(KeyInputEvent evt);

    @Override
    public void onTouchEvent(TouchEvent evt);

    public void reset();

    public void addListener(InputListener listener,
            String... mappingNames);

    public void addMapping(String inputMappingExit, Trigger... triggers);

    public void update(float timePerFrame);

    public boolean hasMapping(String inputMappingCameraPos);

    public void deleteMapping(String inputMappingCameraPos);

    public void removeListener(InputListener keyListener);

    public void setCursorVisible(boolean b);

    public Joystick[] getJoysticks();

}
