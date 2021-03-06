package com.boot.dao.cluster;

import com.boot.model.cluster.JsKnowledge;
import com.boot.model.cluster.JsKnowledgeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsKnowledgeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_knowledge
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int countByExample(JsKnowledgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_knowledge
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int deleteByExample(JsKnowledgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_knowledge
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_knowledge
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int insert(JsKnowledge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_knowledge
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int insertSelective(JsKnowledge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_knowledge
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    List<JsKnowledge> selectByExample(JsKnowledgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_knowledge
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    JsKnowledge selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_knowledge
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int updateByExampleSelective(@Param("record") JsKnowledge record, @Param("example") JsKnowledgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_knowledge
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int updateByExample(@Param("record") JsKnowledge record, @Param("example") JsKnowledgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_knowledge
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int updateByPrimaryKeySelective(JsKnowledge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_knowledge
     *
     * @mbggenerated Mon Jul 03 10:05:32 CST 2017
     */
    int updateByPrimaryKey(JsKnowledge record);
}