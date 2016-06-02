package com.rs.rules.commons.bean;

/**
 * Author: Oleh Osyka
 * Date: 5/31/2016
 * Time: 4:52 PM
 */
public class FoundIssue {

    private boolean empty;
    private String priority;
    private Integer lineFrom;
    private Integer lineTo;

    public static FoundIssue newIssue() {
        return new FoundIssue();
    }

    public FoundIssue empty() {
        this.empty = true;
        return this;
    }

    public FoundIssue in(int from, int to) {
        this.lineFrom = from;
        this.lineTo = to;
        return this;
    }

    public FoundIssue priority(String priority) {
        this.priority = priority;
        return this;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Integer getLineFrom() {
        return lineFrom;
    }

    public void setLineFrom(Integer lineFrom) {
        this.lineFrom = lineFrom;
    }

    public Integer getLineTo() {
        return lineTo;
    }

    public void setLineTo(Integer lineTo) {
        this.lineTo = lineTo;
    }
}
