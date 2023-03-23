package org.arvin.service.openfeign;

import org.arvin.api.CommonResult;
import org.arvin.pojo.TAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "account-service",path = "/tAccount")
public interface AccountOpenFeign {

    @GetMapping("/{accountId}")
    CommonResult<TAccount> getAccountById(@PathVariable("accountId")long accountId);

    @GetMapping("/decrease/{accountId}/{money}")
    public CommonResult<TAccount> decrease(@PathVariable("accountId") int accountId,@PathVariable int money);


}
