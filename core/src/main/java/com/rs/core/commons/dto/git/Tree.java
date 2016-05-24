package com.rs.core.commons.dto.git;

import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 5/24/2016
 * Time: 6:30 PM
 */
public class Tree {

    private String title;
    private String key;
    private boolean folder;
    private boolean expanded = false;
    private boolean unselectable = true;
    private List<Tree> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isFolder() {
        return folder;
    }

    public void setFolder(boolean folder) {
        this.folder = folder;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }
}
