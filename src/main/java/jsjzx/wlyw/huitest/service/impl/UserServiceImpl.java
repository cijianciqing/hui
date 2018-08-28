package jsjzx.wlyw.huitest.service.impl;

import jsjzx.wlyw.huitest.beans.User;
import jsjzx.wlyw.huitest.mapper.UserMapper;
import jsjzx.wlyw.huitest.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CiJian
 * @since 2018-08-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
