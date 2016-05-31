package com.rs.rules.service;

import com.rs.rules.commons.bean.FoundIssue;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

/**
 * Author: Oleh Osyka
 * Date: 5/31/2016
 * Time: 4:48 PM
 */
public class RuleParserService {

    public FoundIssue analyzeFile(File file, String rule) throws FileNotFoundException {
        JavaClassSource javaClass = Roaster.parse(JavaClassSource.class, file);
        StringTokenizer st = new StringTokenizer(rule);
        while(st.hasMoreTokens()){
            String token = st.nextToken();
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
}
