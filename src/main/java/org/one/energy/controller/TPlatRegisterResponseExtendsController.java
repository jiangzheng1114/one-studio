package org.one.energy.controller;

import org.one.energy.service.TPlatRegisterResponseExtendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plat")
public class TPlatRegisterResponseExtendsController {
    @Autowired
    private TPlatRegisterResponseExtendsService tPlatRegisterResponseExtendsService;
}
