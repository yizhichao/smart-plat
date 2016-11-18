package com.allcam.modules.tree.model;

public class State
{
    private int opened;
    
    private int selected;
    
    private int disabled;
    
    public State(int opened, int selected, int disabled)
    {
        this.opened = opened;
        this.selected = selected;
        this.disabled = disabled;
    }
    
    public int getOpened()
    {
        return opened;
    }
    
    public void setOpened(int opened)
    {
        this.opened = opened;
    }
    
    public int getSelected()
    {
        return selected;
    }
    
    public void setSelected(int selected)
    {
        this.selected = selected;
    }
    
    public int getDisabled()
    {
        return disabled;
    }
    
    public void setDisabled(int disabled)
    {
        this.disabled = disabled;
    }
    
}
