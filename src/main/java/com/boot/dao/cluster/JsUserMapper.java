package com.boot.dao.cluster;

import com.boot.model.cluster.JsUser;
import com.boot.model.cluster.JsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int countByExample(JsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int deleteByExample(JsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int insert(JsUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int insertSelective(JsUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    List<JsUser> selectByExampleWithBLOBs(JsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    List<JsUser> selectByExample(JsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    JsUser selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int updateByExampleSelective(@Param("record") JsUser record, @Param("example") JsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") JsUser record, @Param("example") JsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int updateByExample(@Param("record") JsUser record, @Param("example") JsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int updateByPrimaryKeySelective(JsUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(JsUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int updateByPrimaryKey(JsUser record);
}