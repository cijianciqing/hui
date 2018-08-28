package jsjzx.wlyw.huitest;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import jdk.nashorn.internal.runtime.regexp.joni.WarnCallback;
import jsjzx.wlyw.huitest.beans.User;
import jsjzx.wlyw.huitest.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HuiTestApplicationTests {


	@Autowired
	UserServiceImpl userService;

	@Test
	public void contextLoads() {
		User user = new User();
		user.setName("whoAmI");
		userService.insert(user);

	}


	@Test
	public void fuzzySearch(){
		Page<User> page = new Page<>(1,2);
		EntityWrapper<User> wrapper = new EntityWrapper<>();
		wrapper.like("name","s");
		Page<User> page1 = userService.selectPage(page,wrapper);

	}
}
