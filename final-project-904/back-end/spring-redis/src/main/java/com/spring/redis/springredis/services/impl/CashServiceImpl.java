package com.spring.redis.springredis.services.impl;

import com.spring.redis.springredis.enums.KeyRegion;
import com.spring.redis.springredis.enums.Region;
import com.spring.redis.springredis.models.Product;
import com.spring.redis.springredis.services.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CashServiceImpl implements CashService {

    @Autowired
    private CacheManager cacheManager;

    // TASK
    @Override
    public void removeKeyFromCashById(Long id, Region region, Object key) {
        Cache cache = cacheManager.getCache(region.name());
        if (Objects.nonNull(cache)) {
            List<Product> cachedList = cache.get(key, List.class);
            if (Objects.nonNull(cachedList)) {
                List<Product> updatedList = cachedList.stream()
                        .filter(p -> !p.getId().equals(id))
                        .toList();
                cache.put(key, updatedList);
            }
        }
    }
}
