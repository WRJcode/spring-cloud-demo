package org.arvin.controller;

import io.seata.spring.annotation.GlobalTransactional;
import org.arvin.api.CommonResult;
import org.arvin.pojo.TAccount;
import org.arvin.pojo.TOrder;
import org.arvin.pojo.TStorage;
import org.arvin.service.ITOrderService;
import org.arvin.service.openfeign.AccountOpenFeign;
import org.arvin.service.openfeign.StorageOpenFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author arvin
 * @since 2023-03-21
 */
@Controller
@RequestMapping("/tOrder")
public class TOrderController {

    @Autowired
    ITOrderService orderService;

    @Autowired
    AccountOpenFeign accountOpenFeign;

    @Autowired
    StorageOpenFeign storageOpenFeign;

    @PostMapping("")
    public CommonResult<TOrder> put(TOrder order){
        orderService.save(order);
        return CommonResult.success(order);
    }

    @GetMapping("/test/feign/{accountId}/{storageId}")
    public void feignTest(@PathVariable("accountId")long accountId,@PathVariable("storageId")long storageId){
        CommonResult<TAccount> accountCommonResult = accountOpenFeign.getAccountById(accountId);
        CommonResult<TStorage> storageCommonResult = storageOpenFeign.getStorageById(storageId);

        System.out.println(accountCommonResult);
        System.out.println(storageCommonResult);
    }

    @GlobalTransactional(name = "scorpios-create-order",rollbackFor = Exception.class)
    @GetMapping("/business/{accountId}/{storageId}/{count}/{money}")
    public void business(@PathVariable("accountId")int accountId,@PathVariable("storageId")int storageId,@PathVariable("count")int count,
                          @PathVariable("money")int money){
        System.out.println("先生成订单");
        TOrder order = new TOrder();
        order.setId(2);
        order.setUserId(1);
        order.setProductId(1);
        order.setCount(count);
        order.setMoney(money);
        order.setStatus((byte) 0);

        orderService.save(order);

        System.out.println("减库存");
        storageOpenFeign.decrease(storageId,count);

        System.out.println("口余额");
        accountOpenFeign.decrease(accountId,money);

        System.out.println("修改订单状态，订单交易完毕");
        order.setStatus((byte) 1);
        orderService.updateById(order);
    }
}
