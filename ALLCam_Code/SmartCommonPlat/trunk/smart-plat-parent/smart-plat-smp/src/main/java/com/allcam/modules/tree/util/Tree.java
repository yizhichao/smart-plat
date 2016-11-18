package com.allcam.modules.tree.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.allcam.modules.tree.model.State;
import com.allcam.modules.tree.model.TreeNode;
import com.allcam.utils.JSonUtils;

public class Tree
{
    // 一个关于父亲节点和所有孩子们的键值对
    private HashMap<String, Stack<TreeNode>> parentChildrenMap = new HashMap<String, Stack<TreeNode>>();
    
    // 一个关于节点id和节点对象的键值对
    private HashMap<String, TreeNode> nodeMap = new HashMap<String, TreeNode>();
    
    private Set<String> parentIdSet = new HashSet<String>();
    
    public void addNode(TreeNode node)
    {
        parentIdSet.add(node.getParentId());
        nodeMap.put(node.getId(), node);
        addParentChildrenMap(node.getParentId(), node);
    }
    
    // 组装成一个节点与父亲id的map
    private void addParentChildrenMap(String parentId, TreeNode node)
    {
        if (!parentChildrenMap.containsKey(parentId))
        {
            Stack<TreeNode> children = new Stack<TreeNode>();
            children.push(node);
            parentChildrenMap.put(parentId, children);
        }
        else
        {
            Stack<TreeNode> children = parentChildrenMap.get(parentId);
            children.push(node);
        }
    }
    
    // 设置第一层节点。主要把那些找不到父亲的节点主动的放在根节点下面。
    private void setFistFloor(TreeNode root)
    {
        String rootId = root.getId();
        for (String parentId : parentIdSet)
        {
            // 下面找到所有的不存在的父亲节点，放在list里面。
            if (null == nodeMap.get(parentId) && !parentId.equals(rootId))
            {
                Stack<TreeNode> children = parentChildrenMap.get(parentId);
                for (TreeNode treeNode : children.getAll())
                {
                    treeNode.setParentId(rootId);
                    addParentChildrenMap(rootId, treeNode);
                }
                parentChildrenMap.remove(parentId);
                // parentIdSet.remove(parentId);
            }
        }
        // 默认选中第一个root下子节点
        /*if (!parentChildrenMap.get(rootId).isEmpty())
        {
            parentChildrenMap.get(rootId).top().setState(new State(0, 1, 0));
        }*/
    }
    
    public String getTreeJson(Tree tree, TreeNode root)
    {
        tree.setFistFloor(root);
        StringBuilder ans = new StringBuilder();
        ans.append("[");
        ans.append(JSonUtils.toJSon(root));
        ans.deleteCharAt(ans.lastIndexOf("}"));
        ans.append(",\"children\":[");
        Stack<TreeNode> parents = new Stack<TreeNode>();
        parents.push(root);
        // 设置一个堆栈标志位
        int treeDeepth = 0;
        while (!parents.isEmpty())
        {
            TreeNode parent = parents.top();
            // 得到该父亲的孩子节点们
            Stack<TreeNode> children = tree.parentChildrenMap.get(parent.getId());
            if (null == children || children.isEmpty())
            {
                parents.pop();
            }
            else
            {
                // 如果孩子节点循环未结束或者堆栈没有改变，就进行循环孩子节点的操作！
                while (!children.isEmpty())
                {
                    // 得到孩子节点
                    TreeNode child = children.pop();
                    // 如果是非树枝节点就打印一部分字符串，同时入堆栈进行下次的循环
                    if (parentIdSet.contains(child.getId()))
                    {
                        ans.append(JSonUtils.toJSon(child));
                        ans.deleteCharAt(ans.lastIndexOf("}"));
                        ans.append(",\"children\":[");
                        // 将该节点推入堆栈
                        parents.push(child);
                        // 设置堆栈被修改了。将退出当次的while循环。
                        treeDeepth++;
                        break;
                    }
                    // 如果是树枝节点 ，就直接转换成为json字符串
                    else
                    {
                        ans.append(JSonUtils.toJSon(child) + ",");
                        if (children.isEmpty())
                        {
                            if (treeDeepth > 0)
                            {
                                ans.deleteCharAt(ans.lastIndexOf(","));
                                ans.append("]},");
                                treeDeepth--;
                            }
                            // 将打印完的父亲节点从堆栈中扔掉。
                            parents.pop();
                        }
                    }
                }
            }
        }
        if (ans.length()-1 == ans.lastIndexOf(","))
        {
            ans.deleteCharAt(ans.lastIndexOf(","));
        }
//        do{
//        	if(treeDeepth%2==1||treeDeepth==0)
        		ans.append("]}]");
//        	else
//        		ans.append("}]}");
//        	treeDeepth--;
//        }while(treeDeepth>0);
        return ans.toString();
    }
}
