package com.hoperun.dao;

import com.hoperun.domain.Code;
import com.hoperun.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CodeMapper {
	/**
	 * 根据主键删除 参数:主键 返回:删除个数
	 * 
	 * @ibatorgenerated 2017-09-24 22:25:33
	 */
	@Delete({ "delete from code", "where `number` = #{number,jdbcType=INTEGER}" })
	void deleteByNumber(@Param("number") int number);

	/**
	 * 插入，空属性也会插入 参数:pojo对象 返回:删除个数
	 * 
	 * @ibatorgenerated 2017-09-24 22:25:33
	 */
	@Insert({ "insert into code (code, number)", "values (#{code,jdbcType=VARCHAR}, #{number,jdbcType=INTEGER})" })
	void insertByCodeAndNumber(@Param("code") String code, @Param("number") int number);

	/**
	 * 根据主键查询 参数:查询条件,主键值 返回:对象
	 * 
	 * @ibatorgenerated 2017-09-24 22:25:33
	 */
	@Select({ "select", "number", "from code", "where code = #{code,jdbcType=VARCHAR}" })
	int selectNumberByCode(@Param("code") String code);

	/**
	 * 根据主键修改，空值条件会修改成null 参数:1.要修改成的值 返回:成功修改个数
	 * 
	 * @ibatorgenerated 2017-09-24 22:25:33
	 */
	@Update({ "update code", "set code = #{code,jdbcType=VARCHAR},", "'number' = #{number,jdbcType=INTEGER}",
			"where code = #{code,jdbcType=VARCHAR}" })
	void updateByCodeAndNumber(@Param("code") String code, @Param("number") int number);
}