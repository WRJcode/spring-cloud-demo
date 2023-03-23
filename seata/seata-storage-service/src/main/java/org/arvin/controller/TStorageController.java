package org.arvin.controller;

import org.arvin.api.CommonResult;
import org.arvin.pojo.TStorage;
import org.arvin.service.ITStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author arvin
 * @since 2023-03-21
 */
@RestController
@RequestMapping("/tStorage")
public class TStorageController {

    @Autowired
    ITStorageService storageService;

    @GetMapping("/{id}")
    public CommonResult<TStorage> getStorageById(@PathVariable("id") long id){
        return CommonResult.success(storageService.getById(id));
    }

    @GetMapping("/decrease/{storageId}/{count}")
    public CommonResult<TStorage> decrease(@PathVariable("storageId")int storageId,@PathVariable("count")int count){

        TStorage storage = storageService.getById(storageId);
        storage.setUsed(storage.getUsed() + count);
        storage.setResidue(storage.getTotal() - storage.getUsed());
        storageService.updateById(storage);
        return CommonResult.success(storage);

    }
}
