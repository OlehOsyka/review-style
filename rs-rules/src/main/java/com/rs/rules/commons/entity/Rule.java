package com.rs.rules.commons.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 5/31/2016
 * Time: 4:42 PM
 */
@Document(collection = "rules")
public class Rule {

    @Id
    private String name;
    private String rule;
    private List<String> files;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }
}
