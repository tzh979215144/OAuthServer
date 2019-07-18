package daoTest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;





import com.hg.dao.UserMapper;
import com.hg.domain.User;

import baseTest.SpringTestCase;

public class UserDaoTest extends SpringTestCase {

	@Autowired
	private UserMapper userMapper;
	
	Logger logger = Logger.getLogger(UserDaoTest.class);
	
	@Test
	public void test() {
		User user = userMapper.selectByUname("");
		System.out.println(user.getUname());
	}
	
}
