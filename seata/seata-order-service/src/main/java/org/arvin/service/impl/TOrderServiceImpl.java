package org.arvin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.arvin.mapper.TOrderMapper;
import org.arvin.pojo.TOrder;
import org.arvin.service.ITOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author arvin
 * @since 2023-03-21
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

}
