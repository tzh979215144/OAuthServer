package daoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.hoperun.dao.TokenMapper;
import com.hoperun.dao.UserMapper;
import com.hoperun.domain.Token;

import baseTest.SpringTestCase;

public class TokenDaoTest {

	
	@Autowired
	private TokenMapper tokenMapper;
	
	Logger logger = Logger.getLogger(UserDaoTest.class);
	
	@Test
	public void test() {
		
		
		
	}

}
