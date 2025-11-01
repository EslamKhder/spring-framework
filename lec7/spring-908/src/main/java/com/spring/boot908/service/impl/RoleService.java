package com.spring.boot908.service.impl;

import com.spring.boot908.dto.RoleDto;
import jakarta.transaction.SystemException;

public interface RoleService {

    RoleDto findByCode(String code) throws SystemException;
}
