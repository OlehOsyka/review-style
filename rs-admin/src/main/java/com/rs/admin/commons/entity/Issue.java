package com.rs.admin.commons.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Author: Oleh Osyka
 * Date: 5/20/2016
 * Time: 3:51 PM
 */
@Entity
@Table(name = "issues")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Issue {

    private Long id;
    private Boolean isReviewed;
    private User assigned;
    private Integer lineFrom;
    private Integer lineTo;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getReviwed() {
        return isReviewed;
    }

    public void setReviwed(Boolean reviwed) {
        isReviewed = reviwed;
    }

    @ManyToOne
    @JoinColumn(name = "assigned",
            referencedColumnName = "email",
            nullable = false)
    @NotNull(message = "Assigning is required! ")
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
