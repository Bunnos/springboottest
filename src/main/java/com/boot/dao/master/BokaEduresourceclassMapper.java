package com.boot.dao.master;

import com.boot.model.master.BokaEduresourceclass;
import com.boot.model.master.BokaEduresourceclassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BokaEduresourceclassMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table boka_eduresourceclass
     *
     * @mbggenerated Mon Jul 03 17:57:41 CST 2017
     */
    int countByExample(BokaEduresourceclassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table boka_eduresourceclass
     *
     * @mbggenerated Mon Jul 03 17:57:41 CST 2017
     */
    int deleteByExample(BokaEduresourceclassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table boka_eduresourceclass
     *
     * @mbggenerated Mon Jul 03 17:57:41 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table boka_eduresourceclass
     *
     * @mbggenerated Mon Jul 03 17:57:41 CST 2017
     */
    int insert(BokaEduresourceclass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table boka_eduresourceclass
     *
     * @mbggenerated Mon Jul 03 17:57:41 CST 2017
     */
    int insertSelective(BokaEduresourceclass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table boka_eduresourceclass
     *
     * @mbggenerated Mon Jul 03 17:57:41 CST 2017
     */
    List<BokaEduresourceclass> selectByExample(BokaEduresourceclassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table boka_eduresourceclass
     *
     * @mbggenerated Mon Jul 03 17:57:41 CST 2017
     */
    BokaEduresourceclass selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table boka_eduresourceclass
     *
     * @mbggenerated Mon Jul 03 17:57:41 CST 2017
     */
    int updateByExampleSelective(@Param("record") BokaEduresourceclass record, @Param("example") BokaEduresourceclassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table boka_eduresourceclass
     *
     * @mbggenerated Mon Jul 03 17:57:41 CST 2017
     */
    int updateByExample(@Param("record") BokaEduresourceclass record, @Param("example") BokaEduresourceclassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table boka_eduresourceclass
     *
     * @mbggenerated Mon Jul 03 17:57:41 CST 2017
     */
    int updateByPrimaryKeySelective(BokaEduresourceclass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table boka_eduresourceclass
     *
     * @mbggenerated Mon Jul 03 17:57:41 CST 2017
     */
    int updateByPrimaryKey(BokaEduresourceclass record);
}