package com.spring.redis.springredis.services;

import com.spring.redis.springredis.enums.KeyRegion;
import com.spring.redis.springredis.enums.Region;

public interface CashService {

    void removeKeyFromCashById(Long id, Region region, Object key);
}
