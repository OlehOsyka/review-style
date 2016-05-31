package com.rs.rules.service;

import com.rs.rules.commons.bean.FoundIssue;
import com.rs.rules.commons.bean.TokenTypes;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.source.MethodSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

import static com.rs.rules.commons.bean.TokenTypes.CLASS;

/**
 * Author: Oleh Osyka
 * Date: 5/31/2016
 * Time: 4:48 PM
 */
public class RuleParserService {

    public FoundIssue analyzeFile(File file, String rule) throws FileNotFoundException {
        JavaClassSource javaClass = Roaster.parse(JavaClassSource.class, file);
        StringTokenizer st = new StringTokenizer(rule);
        if (st.hasMoreTokens()) {
            TokenTypes tt = TokenTypes.valueOf(st.nextToken());
            switch (tt) {
                case CLASS:
                    analyzeClass(javaClass, st);
                    break;
                case METHOD:
                    MethodSource<JavaClassSource> method = javaClass.getMethod(st.nextToken());
                    analyzeMethod(method, st);
            }
        }
        javaClass.addMethod()
                .setPublic()
                .setStatic(true)
                .setName("main")
                .setReturnTypeVoid()
                .setBody("System.out.println(\"Hello World\");")
                .addParameter("java.lang.String[]", "args");
        System.out.println(javaClass);
    }

    private void analyzeMethod(MethodSource<JavaClassSource> method, StringTokenizer st) {

    }

    private void analyzeClass(JavaClassSource file, StringTokenizer st) {

    }
}
