package com.boot.dao.cluster;

import com.boot.model.cluster.JsDict;
import com.boot.model.cluster.JsDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsDictMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_dict
     *
     * @mbggenerated Sun Jul 09 14:14:08 CST 2017
     */
    int countByExample(JsDictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_dict
     *
     * @mbggenerated Sun Jul 09 14:14:08 CST 2017
     */
    int deleteByExample(JsDictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_dict
     *
     * @mbggenerated Sun Jul 09 14:14:08 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_dict
     *
     * @mbggenerated Sun Jul 09 14:14:08 CST 2017
     */
    int insert(JsDict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_dict
     *
     * @mbggenerated Sun Jul 09 14:14:08 CST 2017
     */
    int insertSelective(JsDict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_dict
     *
     * @mbggenerated Sun Jul 09 14:14:08 CST 2017
     */
    List<JsDict> selectByExample(JsDictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_dict
     *
     * @mbggenerated Sun Jul 09 14:14:08 CST 2017
     */
    JsDict selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_dict
     *
     * @mbggenerated Sun Jul 09 14:14:08 CST 2017
     */
    int updateByExampleSelective(@Param("record") JsDict record, @Param("example") JsDictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_dict
     *
     * @mbggenerated Sun Jul 09 14:14:08 CST 2017
     */
    int updateByExample(@Param("record") JsDict record, @Param("example") JsDictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_dict
     *
     * @mbggenerated Sun Jul 09 14:14:08 CST 2017
     */
    int updateByPrimaryKeySelective(JsDict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_dict
     *
     * @mbggenerated Sun Jul 09 14:14:08 CST 2017
     */
    int updateByPrimaryKey(JsDict record);
}