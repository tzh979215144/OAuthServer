package com.hoperun.dao;

import com.hoperun.domain.Code;
import com.hoperun.domain.Token;
import com.hoperun.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TokenMapper {
	/**
	 * 根据主键删除 参数:主键 返回:删除个数
	 * 
	 * @ibatorgenerated 2017-09-24 22:25:33
	 */
	@Delete({ "delete from token", "where code = #{code,jdbcType=VARCHAR}" })
	void deleteByCode(@Param("code") String code);

	/**
	 * 插入，空属性也会插入 参数:pojo对象 返回:删除个数
	 * 
	 * @ibatorgenerated 2017-09-24 22:25:33
	 */
	@Insert({ "insert into token (token, code)", "values (#{token,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR})" })
	void insertByTokenAndCode(@Param("token") String token, @Param("code") String code);

	/**
	 * 根据主键查询 参数:查询条件,主键值 返回:对象
	 * 
	 * @ibatorgenerated 2017-09-24 22:25:33
	 */
	@Select({ "select", "token", "from token", "where token = #{token,jdbcType=VARCHAR}" })
	String selectTokenByToken(@Param("token") String token);
}