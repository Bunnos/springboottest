package com.boot.service.imp;

import com.alibaba.druid.util.StringUtils;
import com.boot.constants.CommonConst;
import com.boot.constants.ResourceTypeOneLevelConst;
import com.boot.constants.ResourceTypeTwoLevelConst;
import com.boot.dao.cluster.*;
import com.boot.dao.master.BokaNewsMapper;
import com.boot.dao.master.BokaNewsclassMapper;
import com.boot.dao.master.BokaNewscontentMapper;
import com.boot.model.cluster.*;
import com.boot.model.cluster.bo.ResourceTypeTwoLvBo;
import com.boot.model.master.*;
import com.boot.service.AsynResourceService;
import com.boot.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Administrator on 2017/7/12.
 */
@Service
@Transactional
public class AsynResourceServiceImpl implements AsynResourceService {
    /*
    主库
     */
    @Autowired
    private BokaNewsclassMapper newsclassMapper;
    @Autowired
    private BokaNewsMapper newsMapper;
    @Autowired
    private BokaNewscontentMapper newscontentMapper;
    /*
    从库
     */
    @Autowired
    private JsResourceMapper resourceMapper;
    @Autowired
    private JsDictMapper dictMapper;
    @Autowired
    private JsCategoriesDictMapper categoriesDictMapper;
    @Autowired
    private JsCategoriesMapper categoriesMapper;
    @Autowired
    private JsCategoriesRelationMapper relationMapper;

    @Override
    public String transferAsynByResourceName(String rName) throws Exception {
        List<BokaNewsclass> newsclassList = getNewsListByName(rName);
        JsResourceWithBLOBs jsResource;
        if (newsclassList != null && newsclassList.size() > 0) {
            for (BokaNewsclass newsclass : newsclassList) {
                short parenId = newsclass.getParentid();
                Map<String, String> result = getPhaseSubjectInfo(parenId);
                String phaseId = result.get("phaseId");
                String phase = result.get("phase");
                String subjectId = result.get("subjectId");
                String subject = result.get("subject");
                String categoriesCode = result.get("categoriesCode");
                System.out.println(categoriesCode);
                Short id = newsclass.getId();
                BokaNewsExample newsExample = new BokaNewsExample();
                newsExample.createCriteria().andClassidEqualTo(Integer.valueOf(id));
                List<BokaNews> bokaNewsList = newsMapper.selectByExample(newsExample);
                if (bokaNewsList != null && bokaNewsList.size() > 0) {
                    for (BokaNews entity : bokaNewsList) {
//                        System.out.println("newsId:" + entity.getId());
                        jsResource = new JsResourceWithBLOBs();
                        putBasicInfo(entity, jsResource);
                        putPhaseSubject(jsResource, phaseId, phase, subjectId, subject, categoriesCode);
                        putLevelResourceType(jsResource, rName);
                        putFileResourceType(entity, jsResource);
                        putContent(entity,jsResource);
                        resourceMapper.insert(jsResource);
                    }
                }
            }
        }

        return "success";
    }

    private void putContent(BokaNews entity, JsResourceWithBLOBs jsResource) {
        BokaNewscontentWithBLOBs bokaNewscontentWithBLOBs = newscontentMapper.selectByPrimaryKey(entity.getId());
        String content = "";
        String content_old = bokaNewscontentWithBLOBs.getContent();
        if(bokaNewscontentWithBLOBs!=null && !StringUtils.isEmpty(content_old)){
            content = content_old;
        }
        jsResource.setContent(content);

    }

    private void putFileResourceType(BokaNews entity, JsResourceWithBLOBs jsResource) {
        String news12 = entity.getNews12();
        String news14 = entity.getNews14();
        String news16 = entity.getNews16();
        String news17 = entity.getNews17();
        if (!StringUtils.isEmpty(news12)) {
            putPdfOrSwfPath(jsResource, news12);
        }
        if (!StringUtils.isEmpty(news14)) {
            String path14 = UnserializePhpCodeUtils.unSerializePhpCode(entity,news14);
            putPdfOrSwfPath(jsResource, path14);
        }
        if (!StringUtils.isEmpty(news16)) {
            String path16 = UnserializePhpCodeUtils.unSerializePhpCode(entity,news16);
            putPdfOrSwfPath(jsResource, path16);
        }
        if (!StringUtils.isEmpty(news17)) {
            String path17 = UnserializePhpCodeUtils.unSerializePhpCode(entity,news17);
            putPdfOrSwfPath(jsResource, path17);
        }

    }

    private void putPdfOrSwfPath(JsResourceWithBLOBs jsResource, String news) {
        if (ResourceTypeTransfeUtils.isEndWith(news, CommonConst.SWF)) {
            jsResource.setSwfpath(news);
        }
        if (ResourceTypeTransfeUtils.isEndWith(news, CommonConst.PDF)) {
            jsResource.setPdfpath(news);
        }
        Map<String, String> fileType = ResourceTypeTransfeUtils.getFileType(news);
        jsResource.setFilepath(news);
        jsResource.setResourceformatid(fileType.get("formatId"));
        jsResource.setResourceformatvalue(fileType.get("formatValue"));
    }

    private void putBasicInfo(BokaNews entity, JsResourceWithBLOBs jsResource) {
        jsResource.setId(UUID.randomUUID().toString());
        jsResource.setState("3");
        jsResource.setTitle(entity.getTitle());
        jsResource.setAuthor(entity.getAuthor());
        jsResource.setOrigin(CommonConst.OLD); // 来源是老数据
        jsResource.setViews(String.valueOf(entity.getViews())); // 查看数
        jsResource.setDownclick(String.valueOf(entity.getDownloads())); // 下载数
        jsResource.setCreatedate(DateUtils.timeStampToDate(entity.getDateline()));
    }

    private void putPhaseSubject(JsResourceWithBLOBs jsResource, String phaseId, String phase, String subjectId, String subject, String categoriesCode) {
        if (!StringUtils.isEmpty(phaseId)) {
            jsResource.setPhaseid(phaseId);
            jsResource.setPhase(phase);
            if (!StringUtils.isEmpty(subjectId)) {
                StringBuilder newSubjectId = new StringBuilder(phaseId).append("-").append(subjectId);
                jsResource.setSubjectid(newSubjectId.toString());
                jsResource.setSubject(subject);
            }
        }
        jsResource.setCategoriescode(categoriesCode);
    }

    /**
     * 设置一级资源类目
     *
     * @param jsResource
     */
    private void putLevelResourceType(JsResource jsResource, String rName) {
        if (rName.equals("教材介绍") || rName.equals("产品目录")) {
            jsResource.setResourcetypeonelevelid(ResourceTypeOneLevelConst.TEXTBOOK_INRO);
            jsResource.setResourcetypeonelevelvalue(ResourceTypeOneLevelConst.TEXTBOOK_INRO_VALUE);
            jsResource.setResourcetype(ResourceTypeOneLevelConst.TINT);
        }
        if (rName.equals("作者介绍")) {
            jsResource.setResourcetypeonelevelid(ResourceTypeOneLevelConst.AUTHOR_INTRO);
            jsResource.setResourcetypeonelevelvalue(ResourceTypeOneLevelConst.AUTHOR_INTRO_VALUE);
            jsResource.setResourcetype(ResourceTypeOneLevelConst.AUT);
        }
        if (rName.equals("教材培训") || rName.equals("课程培训")) {
            jsResource.setResourcetypeonelevelid(ResourceTypeOneLevelConst.SUBJECT_RESEARCH);
            jsResource.setResourcetypeonelevelvalue(ResourceTypeOneLevelConst.SUBJECT_RESEARCH_VALUE);
            jsResource.setResourcetype(ResourceTypeOneLevelConst.SUB);
            ResourceTypeTwoLvBo valueByKey = CacheUtils.getValueByKey(ResourceTypeTwoLevelConst.TEACHING_TRAIN);
            jsResource.setResourcetypetwolevelid(valueByKey.getLevelId());
            jsResource.setResourcetypetwolevelvalue(valueByKey.getLevelValue());
        }
        if (rName.equals("教学研究")) {
            jsResource.setResourcetypeonelevelid(ResourceTypeOneLevelConst.SUBJECT_RESEARCH);
            jsResource.setResourcetypeonelevelvalue(ResourceTypeOneLevelConst.SUBJECT_RESEARCH_VALUE);
            jsResource.setResourcetype(ResourceTypeOneLevelConst.SUB);
            ResourceTypeTwoLvBo valueByKey = CacheUtils.getValueByKey(ResourceTypeTwoLevelConst.TEACHING_RESEARCH);
            jsResource.setResourcetypetwolevelid(valueByKey.getLevelId());
            jsResource.setResourcetypetwolevelvalue(valueByKey.getLevelValue());
        }
        if (rName.equals("课程纲要")) {
            jsResource.setResourcetypeonelevelid(ResourceTypeOneLevelConst.SUBJECT_RESEARCH);
            jsResource.setResourcetypeonelevelvalue(ResourceTypeOneLevelConst.SUBJECT_RESEARCH_VALUE);
            jsResource.setResourcetype(ResourceTypeOneLevelConst.SUB);
            ResourceTypeTwoLvBo valueByKey = CacheUtils.getValueByKey(ResourceTypeTwoLevelConst.CURRICULUM_IDEA);
            jsResource.setResourcetypetwolevelid(valueByKey.getLevelId());
            jsResource.setResourcetypetwolevelvalue(valueByKey.getLevelValue());
        }
        if (rName.equals("中考专栏") || rName.equals("中学生数理化") || rName.equals("高考专栏") || rName.equals("时事热点") || rName.equals("文献资料")) {
            jsResource.setResourcetypeonelevelid(ResourceTypeOneLevelConst.SUBJECT_RESEARCH);
            jsResource.setResourcetypeonelevelvalue(ResourceTypeOneLevelConst.SUBJECT_RESEARCH_VALUE);
            jsResource.setResourcetype(ResourceTypeOneLevelConst.SUB);
            ResourceTypeTwoLvBo valueByKey = CacheUtils.getValueByKey(ResourceTypeTwoLevelConst.EXAM_COLUMN);
            jsResource.setResourcetypetwolevelid(valueByKey.getLevelId());
            jsResource.setResourcetypetwolevelvalue(valueByKey.getLevelValue());
        }
    }

    /**
     * 获取列表
     *
     * @param rName
     * @return
     */
    private List<BokaNewsclass> getNewsListByName(String rName) {
        BokaNewsclassExample example = new BokaNewsclassExample();
        example.createCriteria().andNameEqualTo(rName);
        List<BokaNewsclass> bokaNewsclasses = newsclassMapper.selectByExample(example);
        return bokaNewsclasses;
    }

    /**
     * 设置学段学科
     *
     * @param parenId
     */
    private Map<String, String> getPhaseSubjectInfo(short parenId) throws Exception {
        List<String> sortList = new ArrayList();
        Map<String, String> map = new HashMap<>();
        dieDaiTest(parenId, sortList);
        Collections.reverse(sortList);
        int count = 1;
        String phaseId;
        String subjectId;
        StringBuilder categoriesCode = new StringBuilder();
        StringBuilder sbOne = null;
        StringBuilder sbTwo = null;
        StringBuilder sbThree = null;
        StringBuilder sbFour = null;
        int size = sortList.size();
        for (String param : sortList) {
            if (count == 1) { // 学段
                phaseId = PinYinUtils.convertLower(param);
                map.put("phaseId", phaseId);
                map.put("phase", param);
                sbOne = new StringBuilder(phaseId);
                if (count == size) {
                    categoriesCode.append(sbOne);
                } else {
                    categoriesCode.append(sbOne).append(",");
                }
            }
            if (count == 2) { // 学科
                subjectId = PinYinUtils.convertLower(param);
                map.put("subjectId", subjectId);
                map.put("subject", param);
                sbTwo = new StringBuilder(sbOne).append("-").append(subjectId);
                categoriesCode.append(sbTwo).append(",");
                sbThree = new StringBuilder(sbTwo).append("-").append(CommonConst.BEISHIDABAN);
                if(size==2){
                    categoriesCode.append(sbThree);
                }else {
                    categoriesCode.append(sbThree).append(",");
                }
            }
            if (count == 3) {
                sbFour = new StringBuilder(sbThree)
                        .append("-").append(PinYinUtils.convertLower(param));
                if (size > 3) {
                    categoriesCode.append(sbFour).append(",");
                } else {
                    categoriesCode.append(sbFour);
                }
            }
            if (size > 3 && count > 3) {
                JsCategoriesExample dictExample = new JsCategoriesExample();
                dictExample.createCriteria().andNameEqualTo(param).andLevel4CodeEqualTo(sbFour.toString());
                List<JsCategories> jsCategoriesList = categoriesMapper.selectByExample(dictExample);
                if (jsCategoriesList != null && jsCategoriesList.size() > 0) {
                    JsCategories jsCategories = jsCategoriesList.get(0);
                    String id = jsCategories.getId();
                    if (count == size) {
                        categoriesCode.append(id);
                    } else {
                        categoriesCode.append(id).append(",");
                    }
                }
            }
            count = count + 1;
        }
        map.put("categoriesCode", categoriesCode.toString());
        return map;
    }

    private void dieDaiTest(Short parentid, List<String> sortList) {
        if (parentid == 0) {
            return;
        } else {
            BokaNewsclassExample example = new BokaNewsclassExample();
            example.createCriteria().andIdEqualTo(parentid);
            List<BokaNewsclass> list = newsclassMapper.selectByExample(example);
            if (list != null && list.size() > 0) {
                BokaNewsclass bo = list.get(0);
                JsCategoriesExample jsCategoriesExample = new JsCategoriesExample();
                jsCategoriesExample.createCriteria().andNameEqualTo(bo.getName());
                List<JsCategories> jsCategoriesList = categoriesMapper.selectByExample(jsCategoriesExample);
                if (jsCategoriesList != null && jsCategoriesList.size() > 0) {
                    JsCategories jsCategories = jsCategoriesList.get(0);
                    sortList.add(jsCategories.getName());
                } else {
                    JsCategoriesDictExample dictExample = new JsCategoriesDictExample();
                    dictExample.createCriteria().andNameEqualTo(bo.getName());
                    List<JsCategoriesDict> categoriesDictList = categoriesDictMapper.selectByExample(dictExample);
                    if (categoriesDictList != null && categoriesDictList.size() > 0) {
                        JsCategoriesDict jsCategoriesDict = categoriesDictList.get(0);
                        sortList.add(jsCategoriesDict.getName());
                    }
                }
                dieDaiTest(bo.getParentid(), sortList);
            }
        }
    }
}
