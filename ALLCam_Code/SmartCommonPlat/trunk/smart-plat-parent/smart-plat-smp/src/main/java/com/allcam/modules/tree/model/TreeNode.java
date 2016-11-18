package com.allcam.modules.tree.model;

public class TreeNode
{
    private String id;
    
    private String parentId;
    
    private String text;
    
    private String type;
    
    private State state;
    
    public TreeNode(String id, String parentId, String text, String type, State state)
    {
        this.id = id;
        this.parentId = parentId;
        this.text = text;
        this.type = type;
        this.state = state;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getParentId()
    {
        return parentId;
    }
    
    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }
    
    public String getText()
    {
        return text;
    }
    
    public void setText(String text)
    {
        this.text = text;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public State getState()
    {
        return state;
    }
    
    public void setState(State state)
    {
        this.state = state;
    }
    
}
