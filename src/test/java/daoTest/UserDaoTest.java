package daoTest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hoperun.dao.UserMapper;
import com.hoperun.domain.User;

import baseTest.SpringTestCase;

public class UserDaoTest extends SpringTestCase {

	@Autowired
	private UserMapper userMapper;

	Logger logger = Logger.getLogger(UserDaoTest.class);

	@Test
	public void test() {

		// 插入
		User user1 = new User();
		user1.setUname("testInsert");
		user1.setUpassword("testInsert");
		userMapper.insertByUser(user1);

		// 查询
		User user2 = userMapper.selectUserByUname("admin");
		// 查询测试
		System.out.println(user2.getUname());

		// 插入测试
		User user3 = userMapper.selectUserByUname("testInsert");
		System.out.println(user3.getUname() + "：id：" + user3.getUid());

		// 删除
		userMapper.deleteByPrimaryKey(user3.getUid());
		// 删除测试
		User user4 = userMapper.selectUserByUname("testInsert");
		System.out.println("删除后是否查询到：" + user4);
	}

}
