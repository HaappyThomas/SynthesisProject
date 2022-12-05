package ca.bdeb.projetsynthese.controller;

import ca.bdeb.projetsynthese.models.Config;
import ca.bdeb.projetsynthese.services.ConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "API for system configuration")
@RestController
@RequestMapping("api/v1/config")
public class ConfigController {
    @Autowired
    private ConfigService service;

    @ApiOperation(value = "get user's Configure")
    @GetMapping("/{useremail}")
    public Config getByEmail(@ApiParam("user's email")
                             @PathVariable("useremail") String email) {
        return service.getByEmail(email);
    }

    @ApiOperation(value = "add or modify user's config")
    @PutMapping("/update")
    public Config update(@RequestBody Config config) {
        return service.update(config);
    }

    @ApiOperation(value = "delete un user's config")
    @PutMapping("/reset")
    public Config reset(@RequestBody Config config) {
        return service.reset(config);
    }

}
