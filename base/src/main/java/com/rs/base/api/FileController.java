package com.rs.base.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Oleh Osyka
 * Date: 6/6/2016
 * Time: 6:34 PM
 */
@Controller
public class FileController {

    @RequestMapping(value = "/file")
    public String issue() {
        return "file";
    }

}
