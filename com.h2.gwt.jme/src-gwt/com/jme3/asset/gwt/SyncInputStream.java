package com.jme3.asset.gwt;

import java.io.InputStream;

public class SyncInputStream extends InputStream {
    
    private String input = null;

    private Integer index = -1;
    
    
    ////
    ////
    
    public int read() {
        while (input == null) {
            //do nothing
        }
        
        if (index >= input.length()) {
            return -1;
        }
        int result = input.charAt(index);
        index++;
        return result;
    }
    
    public String getInput() {
        return input;
    }


    public void setInput(String input) {
        this.input = input;
    }


    public Integer getIndex() {
        return index;
    }


    public void setIndex(Integer index) {
        this.index = index;
    }

}
