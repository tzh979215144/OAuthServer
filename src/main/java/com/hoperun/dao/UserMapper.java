package com.hoperun.dao;

import com.hoperun.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
	/**
	 * 根据主键删除 参数:主键 返回:删除个数
	 * 
	 * @ibatorgenerated 2017-09-24 22:25:33
	 */
	@Delete({ "delete from user", "where `uid` = #{uid,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer uid);

	/**
	 * 插入，空属性也会插入 参数:pojo对象 返回:删除个数
	 * 
	 * @ibatorgenerated 2017-09-24 22:25:33
	 */
	@Insert({ "insert into user (uname, upassword)",
			"values (#{uname,jdbcType=VARCHAR}, #{upassword,jdbcType=VARCHAR})" })
	int insertByUser(User record);

	/**
	 * 插入，空属性不会插入 参数:pojo对象 返回:删除个数
	 * 
	 * @ibatorgenerated 2017-09-24 22:25:33
	 */
	int insertSelective(User record);

	/**
	 * 根据主键查询 参数:查询条件,主键值 返回:对象
	 * 
	 * @ibatorgenerated 2017-09-24 22:25:33
	 */
	@Select({ "select", "uid,uname, upassword, code", "from user", "where uname = #{uname,jdbcType=VARCHAR}" })
	@ResultMap("BaseResultMap")
	User selectUserByUname(String uname);

	/**
	 * 根据主键查询 参数:查询条件,主键值 返回:对象
	 * 
	 * @ibatorgenerated 2017-09-24 22:25:33
	 */
	@Select({ "select", "upassword", "from user", "where code = #{code,jdbcType=VARCHAR}" })
	String selectUpasswordByCode(@Param("code") String code);

	/**
	 * 根据主键修改，空值条件不会修改成null 参数:1.要修改成的值 返回:成功修改个数
	 * 
	 * @ibatorgenerated 2017-09-24 22:25:33
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * 根据主键修改，空值条件会修改成null 参数:1.要修改成的值 返回:成功修改个数
	 * 
	 * @ibatorgenerated 2017-09-24 22:25:33
	 */
	@Update({ "update user", "set uname = #{uname,jdbcType=VARCHAR},", "upassword = #{upassword,jdbcType=VARCHAR},",
			"code = #{code,jdbcType=VARCHAR}", "where `uid` = #{uid,jdbcType=INTEGER}" })
	int updateByUser(User record);

	/**
	 * 绑定CODE码
	 */
	@Update({ "update user", "set code = #{code,jdbcType=VARCHAR}", "where uid = #{uid,jdbcType=INTEGER}" })
	int updateCodeByUser(User record);

}