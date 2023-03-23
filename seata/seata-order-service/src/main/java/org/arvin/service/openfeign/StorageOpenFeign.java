package org.arvin.service.openfeign;

import org.arvin.api.CommonResult;
import org.arvin.pojo.TStorage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "storage-service",path = "/tStorage")
public interface StorageOpenFeign {

    @GetMapping("/{storageId}")
    public CommonResult<TStorage> getStorageById(@PathVariable("storageId")long storageId);

    @GetMapping("/decrease/{storageId}/{count}")
    public CommonResult<TStorage> decrease(@PathVariable("storageId")int storageId,@PathVariable("count")int count);
}
