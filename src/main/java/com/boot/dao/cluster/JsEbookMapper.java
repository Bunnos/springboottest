package com.boot.dao.cluster;

import com.boot.model.cluster.JsEbook;
import com.boot.model.cluster.JsEbookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsEbookMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook
     *
     * @mbggenerated Sun Jul 16 13:33:50 CST 2017
     */
    int countByExample(JsEbookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook
     *
     * @mbggenerated Sun Jul 16 13:33:50 CST 2017
     */
    int deleteByExample(JsEbookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook
     *
     * @mbggenerated Sun Jul 16 13:33:50 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook
     *
     * @mbggenerated Sun Jul 16 13:33:50 CST 2017
     */
    int insert(JsEbook record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook
     *
     * @mbggenerated Sun Jul 16 13:33:50 CST 2017
     */
    int insertSelective(JsEbook record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook
     *
     * @mbggenerated Sun Jul 16 13:33:50 CST 2017
     */
    List<JsEbook> selectByExample(JsEbookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook
     *
     * @mbggenerated Sun Jul 16 13:33:50 CST 2017
     */
    JsEbook selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook
     *
     * @mbggenerated Sun Jul 16 13:33:50 CST 2017
     */
    int updateByExampleSelective(@Param("record") JsEbook record, @Param("example") JsEbookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook
     *
     * @mbggenerated Sun Jul 16 13:33:50 CST 2017
     */
    int updateByExample(@Param("record") JsEbook record, @Param("example") JsEbookExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook
     *
     * @mbggenerated Sun Jul 16 13:33:50 CST 2017
     */
    int updateByPrimaryKeySelective(JsEbook record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_ebook
     *
     * @mbggenerated Sun Jul 16 13:33:50 CST 2017
     */
    int updateByPrimaryKey(JsEbook record);
}