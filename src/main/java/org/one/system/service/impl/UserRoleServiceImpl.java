package org.one.system.service.impl;

import org.one.system.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleService userRoleService;

}
