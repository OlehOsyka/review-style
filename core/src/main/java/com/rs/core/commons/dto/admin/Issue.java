package com.rs.core.commons.dto.admin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rs.core.commons.dto.auth.User;

/**
 * Author: Oleh Osyka
 * Date: 5/20/2016
 * Time: 3:51 PM
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {

    private Long id;
    private Boolean isReviewed;
    private User assigned;
    private Integer lineFrom;
    private Integer lineTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getReviewed() {
        return isReviewed;
    }

    public void setReviewed(Boolean reviewed) {
        isReviewed = reviewed;
    }

    public User getAssigned() {
        return assigned;
    }

    public void setAssigned(User assigned) {
        this.assigned = assigned;
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
