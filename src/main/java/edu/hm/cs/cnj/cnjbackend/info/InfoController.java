package edu.hm.cs.cnj.cnjbackend.info;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hanway on 17.10.2017.
 */
@RestController
@RequestMapping("/v1/info")
@Api
public class InfoController {

    @Autowired
    private InfoProperties infoProperties;

    @GetMapping
    @ApiOperation(value = "Show server information", response = Info.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Server reachable")
    })
    public Info greeting() {
        Info result = new Info();
        result.setMessage(infoProperties.getMessage());
        return result;
    }

}