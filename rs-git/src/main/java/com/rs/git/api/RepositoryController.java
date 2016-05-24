package com.rs.git.api;

import com.rs.core.commons.dto.JsonApiResponse;
import com.rs.git.service.IGitRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

/**
 * Author: Oleh Osyka
 * Date: 5/24/2016
 * Time: 1:48 PM
 */
@RestController
@RequestMapping(value = "/api/repo")
public class RepositoryController {

    @Autowired
    private IGitRepositoryService gitRepositoryService;

    @ResponseStatus(OK)
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public JsonApiResponse projectAdd(@RequestParam(value = "address") String address) {
        gitRepositoryService.downloadRepo(address);
        return JsonApiResponse.newResponse()
                .successfull()
                .statusCode(OK.value())
                .data(null);
    }

}
