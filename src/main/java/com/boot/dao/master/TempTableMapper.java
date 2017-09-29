package com.boot.dao.master;

import com.boot.model.master.TempTable;
import com.boot.model.master.TempTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TempTableMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp_table
     *
     * @mbggenerated Thu Sep 14 19:03:53 CST 2017
     */
    int countByExample(TempTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp_table
     *
     * @mbggenerated Thu Sep 14 19:03:53 CST 2017
     */
    int deleteByExample(TempTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp_table
     *
     * @mbggenerated Thu Sep 14 19:03:53 CST 2017
     */
    int insert(TempTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp_table
     *
     * @mbggenerated Thu Sep 14 19:03:53 CST 2017
     */
    int insertSelective(TempTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp_table
     *
     * @mbggenerated Thu Sep 14 19:03:53 CST 2017
     */
    List<TempTable> selectByExampleWithBLOBs(TempTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp_table
     *
     * @mbggenerated Thu Sep 14 19:03:53 CST 2017
     */
    List<TempTable> selectByExample(TempTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp_table
     *
     * @mbggenerated Thu Sep 14 19:03:53 CST 2017
     */
    int updateByExampleSelective(@Param("record") TempTable record, @Param("example") TempTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp_table
     *
     * @mbggenerated Thu Sep 14 19:03:53 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") TempTable record, @Param("example") TempTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp_table
     *
     * @mbggenerated Thu Sep 14 19:03:53 CST 2017
     */
    int updateByExample(@Param("record") TempTable record, @Param("example") TempTableExample example);
}