package daoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.hoperun.dao.TokenMapper;
import com.hoperun.domain.Token;

import baseTest.SpringTestCase;

/**
 * 测试Mapper层的操作 三个方法：选择，插入，删除 先测试选择 再测试插入 最后测试删除
 * 
 * @author tanpang
 *
 */
public class TokenDaoTest extends SpringTestCase {

	@Autowired
	private TokenMapper tokenMapper;

	Logger logger = Logger.getLogger(TokenDaoTest.class);

	@Test
	public void test() {

		// 选择
		String token = tokenMapper.selectTokenByToken("fd59bf2f17c5d23a555e97def7b256af");
		System.out.println("testSelect token::" + token);

		// 插入
		// 注意有外键约束
		tokenMapper.insertByTokenAndCode("testTokentestTokentestTokentestToken", "WBeUoyHhyn2K23mkELv1Me41p6LPfY");
		String token1 = tokenMapper.selectTokenByToken("testTokentestTokentestTokentestToken");
		System.out.println("testInsert token::" + token1);

		// 删除
		tokenMapper.deleteByCode("testCodetestCodetestCodetestCode");
		String token2 = tokenMapper.selectTokenByToken("testTokentestTokentestTokentestToken");
		System.out.println("testDeleted token::" + token2);

	}

}
