package org.one.energy.controller;

import org.one.energy.service.SStandardCollectConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/standard")
public class SStandardCollectConfigController {

    @Autowired
    private SStandardCollectConfigService sStandardCollectConfigService;
}
