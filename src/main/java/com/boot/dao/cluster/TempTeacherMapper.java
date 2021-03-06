package com.boot.dao.cluster;

import com.boot.model.cluster.TempTeacher;
import com.boot.model.cluster.TempTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TempTeacherMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp_teacher
     *
     * @mbggenerated Wed Aug 02 14:58:49 CST 2017
     */
    int countByExample(TempTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp_teacher
     *
     * @mbggenerated Wed Aug 02 14:58:49 CST 2017
     */
    int deleteByExample(TempTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp_teacher
     *
     * @mbggenerated Wed Aug 02 14:58:49 CST 2017
     */
    int insert(TempTeacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp_teacher
     *
     * @mbggenerated Wed Aug 02 14:58:49 CST 2017
     */
    int insertSelective(TempTeacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp_teacher
     *
     * @mbggenerated Wed Aug 02 14:58:49 CST 2017
     */
    List<TempTeacher> selectByExample(TempTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp_teacher
     *
     * @mbggenerated Wed Aug 02 14:58:49 CST 2017
     */
    int updateByExampleSelective(@Param("record") TempTeacher record, @Param("example") TempTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table temp_teacher
     *
     * @mbggenerated Wed Aug 02 14:58:49 CST 2017
     */
    int updateByExample(@Param("record") TempTeacher record, @Param("example") TempTeacherExample example);
}