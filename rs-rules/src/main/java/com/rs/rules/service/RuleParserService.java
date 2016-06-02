package com.rs.rules.service;

import com.rs.rules.commons.bean.FoundIssue;
import com.rs.rules.commons.bean.TokenAttributes;
import com.rs.rules.commons.bean.TokenTypes;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: Oleh Osyka
 * Date: 5/31/2016
 * Time: 4:48 PM
 */
@Service
public class RuleParserService {

    public FoundIssue analyzeFile(File file, String rule) throws FileNotFoundException {
        JavaClassSource javaClass = Roaster.parse(JavaClassSource.class, file);
        StringTokenizer st = new StringTokenizer(rule);
        if (st.hasMoreTokens()) {
            TokenTypes tt = TokenTypes.valueOf(st.nextToken());
            switch (tt) {
                case CLASS:
                    return analyzeClass(javaClass, st);
                case METHOD:
                    MethodSource<JavaClassSource> method = javaClass.getMethod(st.nextToken());
                    return analyzeMethod(method, st);
                case CLASS_ATTRIBUTE:
                    FieldSource<JavaClassSource> field = javaClass.getField(st.nextToken());
                    return analyzeField(field, st);
            }
        }
        return FoundIssue.newIssue().empty();
    }

    private FoundIssue analyzeField(FieldSource<JavaClassSource> field, StringTokenizer st) {
        if (st.hasMoreTokens()) {
            TokenAttributes tt = TokenAttributes.valueOf(st.nextToken());
            switch (tt) {
                case NAME:
                    return checkGeneral(st, field.getName(), field.getStartPosition(), field.getEndPosition());
            }
        }
        return FoundIssue.newIssue().empty();
    }

    private FoundIssue analyzeMethod(MethodSource<JavaClassSource> method, StringTokenizer st) {
        if (st.hasMoreTokens()) {
            TokenAttributes tt = TokenAttributes.valueOf(st.nextToken());
            switch (tt) {
                case NAME:
                    return checkGeneral(st, method.getName(), method.getStartPosition(), method.getEndPosition());
                case PARAMETERS:
                    return checkParameters(st, method.getParameters(), method.getStartPosition(), method.getStartPosition());
                case VARIABLE:
                    return checkVariable(st, method.getTypeVariables(), method.getStartPosition(), method.getStartPosition());
            }
        }
        return FoundIssue.newIssue().empty();
    }

    private FoundIssue checkVariable(StringTokenizer st, List<TypeVariableSource<JavaClassSource>> typeVariables, int startPosition, int position) {
        if (st.hasMoreTokens()) {
            TokenAttributes tt = TokenAttributes.valueOf(st.nextToken());
            switch (tt) {
                case NAME:
                    for (TypeVariableSource<JavaClassSource> p : typeVariables) {
                        FoundIssue foundIssue = checkGeneral(st, p.getName(), startPosition, position);
                        if (!foundIssue.isEmpty()) {
                            return foundIssue;
                        }
                    }
            }
        }
        return FoundIssue.newIssue().empty();
    }

    private FoundIssue checkParameters(StringTokenizer st, List<ParameterSource<JavaClassSource>> parameters, int startPosition, int position) {
        if (st.hasMoreTokens()) {
            TokenAttributes tt = TokenAttributes.valueOf(st.nextToken());
            switch (tt) {
                case NAME:
                    for (ParameterSource<JavaClassSource> p : parameters) {
                        FoundIssue foundIssue = checkGeneral(st, p.getName(), startPosition, position);
                        if (!foundIssue.isEmpty()) {
                            return foundIssue;
                        }
                    }
            }
        }
        return FoundIssue.newIssue().empty();
    }

    private FoundIssue analyzeClass(JavaClassSource file, StringTokenizer st) {
        if (st.hasMoreTokens()) {
            TokenAttributes tt = TokenAttributes.valueOf(st.nextToken());
            switch (tt) {
                case NAME:
                    return checkGeneral(st, file.getName(), -1, -1);
            }
        }
        return FoundIssue.newIssue().empty();
    }

    private FoundIssue checkGeneral(StringTokenizer st, String name, int startPosition, int endPosition) {
        if (st.hasMoreTokens()) {
            String regexp = st.nextToken();
            Pattern p = Pattern.compile(regexp);
            Matcher m = p.matcher(name);
            if (m.find()) {
                return FoundIssue.newIssue().in(startPosition, endPosition).priority(st.nextToken());
            }
        }
        return FoundIssue.newIssue().empty();
    }
}
