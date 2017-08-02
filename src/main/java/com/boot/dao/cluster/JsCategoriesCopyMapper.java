package com.boot.dao.cluster;

import com.boot.model.cluster.JsCategoriesCopy;
import com.boot.model.cluster.JsCategoriesCopyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsCategoriesCopyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_categories_copy
     *
     * @mbggenerated Fri Jul 28 14:44:26 CST 2017
     */
    int countByExample(JsCategoriesCopyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_categories_copy
     *
     * @mbggenerated Fri Jul 28 14:44:26 CST 2017
     */
    int deleteByExample(JsCategoriesCopyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_categories_copy
     *
     * @mbggenerated Fri Jul 28 14:44:26 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_categories_copy
     *
     * @mbggenerated Fri Jul 28 14:44:26 CST 2017
     */
    int insert(JsCategoriesCopy record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_categories_copy
     *
     * @mbggenerated Fri Jul 28 14:44:26 CST 2017
     */
    int insertSelective(JsCategoriesCopy record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_categories_copy
     *
     * @mbggenerated Fri Jul 28 14:44:26 CST 2017
     */
    List<JsCategoriesCopy> selectByExample(JsCategoriesCopyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_categories_copy
     *
     * @mbggenerated Fri Jul 28 14:44:26 CST 2017
     */
    JsCategoriesCopy selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_categories_copy
     *
     * @mbggenerated Fri Jul 28 14:44:26 CST 2017
     */
    int updateByExampleSelective(@Param("record") JsCategoriesCopy record, @Param("example") JsCategoriesCopyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_categories_copy
     *
     * @mbggenerated Fri Jul 28 14:44:26 CST 2017
     */
    int updateByExample(@Param("record") JsCategoriesCopy record, @Param("example") JsCategoriesCopyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_categories_copy
     *
     * @mbggenerated Fri Jul 28 14:44:26 CST 2017
     */
    int updateByPrimaryKeySelective(JsCategoriesCopy record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_categories_copy
     *
     * @mbggenerated Fri Jul 28 14:44:26 CST 2017
     */
    int updateByPrimaryKey(JsCategoriesCopy record);
}