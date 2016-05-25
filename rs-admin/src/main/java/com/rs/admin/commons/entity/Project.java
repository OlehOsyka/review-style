package com.rs.admin.commons.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Author: Oleh Osyka
 * Date: 5/20/2016
 * Time: 3:31 PM
 */
@Entity
@Table(name = "projects")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Project {

    private Long id;
    private String name;
    private String description;
    private User owner;
    private String vcsAddress;
    private Set<User> participants = Sets.newHashSet();
    private List<Issue> issues = Lists.newArrayList();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    @NotBlank(message = "Project name is required! ")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Project name is required! ")
    public String getVcsAddress() {
        return vcsAddress;
    }

    public void setVcsAddress(String vcsAddress) {
        this.vcsAddress = vcsAddress;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id",
            referencedColumnName = "id",
            nullable = false)
    @NotNull(message = "Owner is required! ")
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @ManyToMany
    @JoinTable(name = "participants",
            joinColumns = {@JoinColumn(name = "projects_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "users_id", nullable = false)})
    @Size(min = 1, message = "At least one participant is required! ")
    public Set<User> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<User> participants) {
        this.participants = participants;
    }

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return new EqualsBuilder()
                .append(id, project.id)
                .append(name, project.name)
                .append(description, project.description)
                .append(owner, project.owner)
                .append(vcsAddress, project.vcsAddress)
                .append(participants, project.participants)
                .append(issues, project.issues)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(description)
                .append(owner)
                .append(vcsAddress)
                .toHashCode();
    }
}
