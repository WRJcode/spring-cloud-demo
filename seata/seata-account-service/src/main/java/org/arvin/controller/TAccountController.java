package org.arvin.controller;

import org.arvin.api.CommonResult;
import org.arvin.pojo.TAccount;
import org.arvin.service.ITAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author arvin
 * @since 2023-03-21
 */
@RestController
@RequestMapping("/tAccount")
public class TAccountController {

    @Autowired
    ITAccountService accountService;

    @GetMapping("test")
    public String test(){
        return "test";
    }

    @GetMapping("/{id}")
    public CommonResult<TAccount> accountById(@PathVariable("id") long id){
        System.out.println(id);
        TAccount account = accountService.getById(id);
        CommonResult result = CommonResult.success(account);
        System.out.println(account);
        System.out.println(result);
        return result;
    }

    @GetMapping("/decrease/{accountId}/{money}")
    public CommonResult<TAccount> decrease(@PathVariable("accountId") int accountId,@PathVariable int money){

        // 模拟超时
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TAccount account = accountService.getById(accountId);
        account.setUsed(account.getUsed() + money);
        account.setResidue(account.getTotal() - account.getUsed());
        accountService.updateById(account);

        return CommonResult.success(account);
    }




}
