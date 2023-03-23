package org.arvin.service.impl;

import org.arvin.pojo.TAccount;
import org.arvin.mapper.TAccountMapper;
import org.arvin.service.ITAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements ITAccountService {

}
