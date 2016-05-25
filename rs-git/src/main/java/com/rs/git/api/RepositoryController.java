package com.rs.git.api;

import com.rs.core.commons.dto.JsonApiResponse;
import com.rs.core.commons.dto.git.Tree;
import com.rs.core.exception.RestException;
import com.rs.git.service.IGitRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rs.core.api.ApiErrorCodes.EMPTY_TREE;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
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
    public JsonApiResponse projectAdd(@RequestParam(value = "address") String address,
                                      @RequestParam(value = "projectName") String projectName) {
        gitRepositoryService.downloadRepo(address, projectName);
        return JsonApiResponse.newResponse()
                .successfull()
                .statusCode(OK.value())
                .data(null);
    }

    @ResponseStatus(OK)
    @RequestMapping(value = "/{projectName}/tree", method = RequestMethod.GET)
    public JsonApiResponse projectTree(@PathVariable(value = "projectName") String projectName) {
        List<Tree> projectTree = gitRepositoryService.getProjectTree(projectName);
        if (CollectionUtils.isEmpty(projectTree)) {
            throw new RestException("Can't get tree for project " + projectName, INTERNAL_SERVER_ERROR.value(), EMPTY_TREE);
        }
        return JsonApiResponse.newResponse()
                .successfull()
                .statusCode(OK.value())
                .data(projectTree);
    }
}
