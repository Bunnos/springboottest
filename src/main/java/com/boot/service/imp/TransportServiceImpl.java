package com.boot.service.imp;

import com.boot.dao.cluster.JsCategoriesDictMapper;
import com.boot.dao.cluster.JsCategoriesMapper;
import com.boot.dao.cluster.JsCategoriesRelationMapper;
import com.boot.dao.master.BokaEduresourceclassMapper;
import com.boot.model.cluster.*;
import com.boot.model.master.BokaEduresourceclass;
import com.boot.model.master.BokaEduresourceclassExample;
import com.boot.service.TransportService;
import com.boot.utils.BaseUtils;
import com.boot.utils.NumberUtils;
import com.boot.utils.PinYinUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */
@Service
@Transactional
public class TransportServiceImpl implements TransportService {

    @Autowired
    private JsCategoriesDictMapper jsCategoriesDictMapperMapper;
    @Autowired
    private BokaEduresourceclassMapper bokaEduresourceclassMapper;
    @Autowired
    private JsCategoriesRelationMapper jsCategoriesRelationMapper;
    @Autowired
    private JsCategoriesMapper jsCategoriesMapper;

    @Override
    public String transCategoriesDict() {
        BokaEduresourceclassExample bokaEduresourceclassExample = new BokaEduresourceclassExample();
        bokaEduresourceclassExample.createCriteria().andParentidEqualTo(0);
        // 一级
        List<BokaEduresourceclass> firstC = bokaEduresourceclassMapper.selectByExample(bokaEduresourceclassExample);
        // 二级
        List<BokaEduresourceclass> secondC = new ArrayList<>();
        // 三级
        List<BokaEduresourceclass> thirdC = new ArrayList<>();
        // categoryList
        List<JsCategoriesDict> categoriesDictList = new ArrayList<>();
        // 前三级的id集合
        List<Integer> excludeId = new ArrayList<>();
        // 二级list
        getSourceByParentId(firstC, secondC, excludeId, categoriesDictList, 0);
        // 三级list
        getSourceByParentId(secondC, thirdC, excludeId, categoriesDictList, 0);
        // 四级list
        getSourceByParentId(thirdC, null, excludeId, categoriesDictList, 1);
        // save 1-4级
        try {
            saveCategoryDict(categoriesDictList);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @Override
    public String transCategoriesRelation() {
        BokaEduresourceclassExample bokaEduresourceclassExample = new BokaEduresourceclassExample();
        bokaEduresourceclassExample.createCriteria().andParentidEqualTo(0);
        // 一级
        List<BokaEduresourceclass> firstC = bokaEduresourceclassMapper.selectByExample(bokaEduresourceclassExample);
        // 二级
        List<BokaEduresourceclass> secondC;
        // 三级
        List<BokaEduresourceclass> fourC;

        JsCategoriesRelation jsCategoriesRelation;
        for (BokaEduresourceclass one : firstC) {
            jsCategoriesRelation = new JsCategoriesRelation();
            StringBuilder builderOne = new StringBuilder(PinYinUtils.convertLower(one.getName()));
            jsCategoriesRelation.setLevel1(builderOne.toString());
            bokaEduresourceclassExample.clear();
            bokaEduresourceclassExample.createCriteria().andParentidEqualTo(one.getId());
            secondC = bokaEduresourceclassMapper.selectByExample(bokaEduresourceclassExample);
            for (BokaEduresourceclass two : secondC) {
                StringBuilder builderTwo = new StringBuilder(builderOne).append("-").append(PinYinUtils.convertLower(two.getName()));
                jsCategoriesRelation.setLevel2(builderTwo.toString());
                bokaEduresourceclassExample.clear();
                bokaEduresourceclassExample.createCriteria().andParentidEqualTo(two.getId());
                fourC = bokaEduresourceclassMapper.selectByExample(bokaEduresourceclassExample);
                for (BokaEduresourceclass four : fourC) {
                    StringBuilder builderThree = new StringBuilder(builderTwo).append("-beishidaban");
                    jsCategoriesRelation.setLevel3(builderThree.toString());
                    StringBuilder builderFour = new StringBuilder(builderThree).append("-").append(PinYinUtils.convertLower(four.getName()));
                    jsCategoriesRelation.setLevel4(builderFour.toString());
                    bokaEduresourceclassExample.clear();
                    bokaEduresourceclassExample.createCriteria().andParentidEqualTo(four.getId());
                    String code = NumberUtils.generateUniqueId(getCategoriesRelationId());
                    jsCategoriesRelation.setCode(code);
                    jsCategoriesRelationMapper.insert(jsCategoriesRelation);
                }
            }
        }
        return "success";
    }

    @Override
    public String transCategories() {
        BokaEduresourceclassExample bokaEduresourceclassExample = new BokaEduresourceclassExample();
        bokaEduresourceclassExample.createCriteria().andParentidEqualTo(0);
        bokaEduresourceclassExample.setOrderByClause("ordersby");
        // 一级
        List<BokaEduresourceclass> firstC = bokaEduresourceclassMapper.selectByExample(bokaEduresourceclassExample);
        // 二级
        List<BokaEduresourceclass> secondC;
        // 三级
        List<BokaEduresourceclass> fourC;
        // 四级
        List<BokaEduresourceclass> fiveC;
        List<BokaEduresourceclass> sixC;
        List<BokaEduresourceclass> sevenC;
        List<BokaEduresourceclass> eightC;
        List<BokaEduresourceclass> nineC;
        for (BokaEduresourceclass one : firstC) {
            StringBuilder builderOne = new StringBuilder(PinYinUtils.convertLower(one.getName()));
            bokaEduresourceclassExample.clear();
            bokaEduresourceclassExample.createCriteria().andParentidEqualTo(one.getId());
            bokaEduresourceclassExample.setOrderByClause("ordersby");
            secondC = bokaEduresourceclassMapper.selectByExample(bokaEduresourceclassExample);
            for (BokaEduresourceclass two : secondC) {
                StringBuilder builderTwo = new StringBuilder(builderOne).append("-").append(PinYinUtils.convertLower(two.getName()));
                bokaEduresourceclassExample.clear();
                bokaEduresourceclassExample.createCriteria().andParentidEqualTo(two.getId());
                bokaEduresourceclassExample.setOrderByClause("ordersby");
                fourC = bokaEduresourceclassMapper.selectByExample(bokaEduresourceclassExample);
                for (BokaEduresourceclass four : fourC) {
                    StringBuilder builderThree = new StringBuilder(builderTwo).append("-beishidaban");
                    StringBuilder builderFour = new StringBuilder(builderThree).append("-").append(PinYinUtils.convertLower(four.getName()));
                    bokaEduresourceclassExample.clear();
                    bokaEduresourceclassExample.createCriteria().andParentidEqualTo(four.getId());
                    bokaEduresourceclassExample.setOrderByClause("ordersby");
                    JsCategoriesRelationExample jsCategoriesRelationExample = new JsCategoriesRelationExample();
                    jsCategoriesRelationExample.createCriteria().andLevel4EqualTo(builderFour.toString());
                    List<JsCategoriesRelation> jsCategoriesRelations = jsCategoriesRelationMapper.selectByExample(jsCategoriesRelationExample);
                    String code = null;
                    if (jsCategoriesRelations != null && jsCategoriesRelations.size() > 0) {
                        for (JsCategoriesRelation entity : jsCategoriesRelations) {
                            code = entity.getCode();
                        }
                    }
                    fiveC = bokaEduresourceclassMapper.selectByExample(bokaEduresourceclassExample);
                    for (BokaEduresourceclass five : fiveC) {

                        JsCategories jsCategorieFive = new JsCategories();
                        jsCategorieFive.setDeep(String.valueOf(5));
                        jsCategorieFive.setName(five.getName());
                        jsCategorieFive.setParentid(code);
                        jsCategorieFive.setLevel4Code(builderFour.toString());
                        jsCategorieFive.setId(NumberUtils.generateUniqueId(getCategoriesId()));
                        jsCategoriesMapper.insert(jsCategorieFive);
                        bokaEduresourceclassExample.clear();
                        bokaEduresourceclassExample.createCriteria().andParentidEqualTo(five.getId());
                        bokaEduresourceclassExample.setOrderByClause("ordersby");
                        sixC = bokaEduresourceclassMapper.selectByExample(bokaEduresourceclassExample);
                        for (BokaEduresourceclass six : sixC) {
                            JsCategories jsCategorieSix = new JsCategories();
                            jsCategorieSix.setId(NumberUtils.generateUniqueId(getCategoriesId()));
                            jsCategorieSix.setDeep(String.valueOf(6));
                            jsCategorieSix.setName(six.getName());
                            jsCategorieSix.setParentid(jsCategorieFive.getId());
                            jsCategorieSix.setLevel4Code(builderFour.toString());
                            jsCategoriesMapper.insert(jsCategorieSix);
                            bokaEduresourceclassExample.clear();
                            bokaEduresourceclassExample.createCriteria().andParentidEqualTo(six.getId());
                            bokaEduresourceclassExample.setOrderByClause("ordersby");
                            sevenC = bokaEduresourceclassMapper.selectByExample(bokaEduresourceclassExample);
                            for (BokaEduresourceclass seven : sevenC) {
                                JsCategories jsCategorieSeven = new JsCategories();
                                jsCategorieSeven.setId(NumberUtils.generateUniqueId(getCategoriesId()));
                                jsCategorieSeven.setDeep(String.valueOf(7));
                                jsCategorieSeven.setName(seven.getName());
                                jsCategorieSeven.setParentid(jsCategorieSix.getId());
                                jsCategorieSeven.setLevel4Code(builderFour.toString());
                                jsCategoriesMapper.insert(jsCategorieSeven);
                                bokaEduresourceclassExample.clear();
                                bokaEduresourceclassExample.createCriteria().andParentidEqualTo(seven.getId());
                                bokaEduresourceclassExample.setOrderByClause("ordersby");
                                eightC = bokaEduresourceclassMapper.selectByExample(bokaEduresourceclassExample);
                                for (BokaEduresourceclass eight : eightC) {
                                    JsCategories jsCategorieEight = new JsCategories();
                                    jsCategorieEight.setId(NumberUtils.generateUniqueId(getCategoriesId()));
                                    jsCategorieEight.setDeep(String.valueOf(8));
                                    jsCategorieEight.setName(eight.getName());
                                    jsCategorieEight.setParentid(jsCategorieSeven.getId());
                                    jsCategorieEight.setLevel4Code(builderFour.toString());
                                    jsCategoriesMapper.insert(jsCategorieEight);
                                    bokaEduresourceclassExample.clear();
                                    bokaEduresourceclassExample.createCriteria().andParentidEqualTo(eight.getId());
                                    bokaEduresourceclassExample.setOrderByClause("ordersby");
                                }
                            }
                        }
                    }
                }
            }
        }
        return "success";
    }

    @Override
    public String categoriesRelationSort() {
        JsCategoriesRelationExample example = new JsCategoriesRelationExample();
        example.createCriteria().andIdIsNotNull();
        List<JsCategoriesRelation> jsCategoriesRelations = jsCategoriesRelationMapper.selectByExample(example);
        if (jsCategoriesRelations != null && jsCategoriesRelations.size() > 0) {
            int i = 0;
            for (JsCategoriesRelation entity : jsCategoriesRelations) {
                String s = NumberUtils.transToThreePositionNum(i);
                entity.setLevel1sort("A"+s);
                entity.setLevel2sort("B"+s);
                entity.setLevel3sort("C"+s);
                entity.setLevel4sort("D"+s);
                i = i+1;
                jsCategoriesRelationMapper.updateByPrimaryKeySelective(entity);
            }
        }
        return "SUCCESS";
    }

    private void saveCategoryDict(List<JsCategoriesDict> categoriesDictList) {
        if (categoriesDictList != null && categoriesDictList.size() > 0) {
            for (JsCategoriesDict entity : categoriesDictList) {
                jsCategoriesDictMapperMapper.insert(entity);
            }
        }
    }

    private List<BokaEduresourceclass> getSourceByParentId(List<BokaEduresourceclass> source,
                                                           List<BokaEduresourceclass> target,
                                                           List<Integer> excludeId, List<JsCategoriesDict> categoriesDictList,
                                                           int type) {
        BokaEduresourceclassExample bokaEduresourceclassExample = new BokaEduresourceclassExample();
        if (source != null && source.size() > 0) {
            for (BokaEduresourceclass entity : source) {
                if (type != 1) {
                    bokaEduresourceclassExample.clear();
                    bokaEduresourceclassExample.createCriteria().andParentidEqualTo(entity.getId());
                    List<BokaEduresourceclass> temp = bokaEduresourceclassMapper.selectByExample(bokaEduresourceclassExample);
                    target.addAll(temp);
                }
                // 转化新实体类 start
                JsCategoriesDict jsCategoriesDict = new JsCategoriesDict();
                String code = PinYinUtils.convertLower(entity.getName());
                jsCategoriesDict.setCode(code);
                jsCategoriesDict.setName(entity.getName());
                categoriesDictList.add(jsCategoriesDict);
                // end
                excludeId.add(entity.getId());
            }
        }
        return target;
    }

    private String getCategoriesId() {
        JsCategoriesExample jsCategoriesExample = new JsCategoriesExample();
        String date = BaseUtils.formatDate(new Date(), "yyyyMMddHHmmss");
        jsCategoriesExample.createCriteria().andIdLike("1" + date + "%");
        jsCategoriesExample.setOrderByClause("id DESC");
        List<JsCategories> jsCategories = jsCategoriesMapper.selectByExample(jsCategoriesExample);
        String zj = null;
        if (jsCategories != null && jsCategories.size() > 0) {
            zj = jsCategories.get(0).getId();
        }
        return zj;
    }

    private String getCategoriesRelationId() {
        JsCategoriesRelationExample example = new JsCategoriesRelationExample();
        String date = BaseUtils.formatDate(new Date(), "yyyyMMddHHmmss");
        example.createCriteria().andCodeLike("1" + date + "%");
        example.setOrderByClause("code DESC");
        List<JsCategoriesRelation> jsCategories = jsCategoriesRelationMapper.selectByExample(example);
        String zj = null;
        if (jsCategories != null && jsCategories.size() > 0) {
            zj = jsCategories.get(0).getCode();
        }
        return zj;
    }
}
