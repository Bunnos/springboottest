package com.boot.service.imp;

import com.alibaba.druid.util.StringUtils;
import com.boot.constants.CommonConst;
import com.boot.constants.NewResourceTypeConst;
import com.boot.constants.ResourceTypeOneLevelConst;
import com.boot.constants.ResourceTypeTwoLevelConst;
import com.boot.dao.cluster.*;
import com.boot.dao.master.BokaEduresourceMapper;
import com.boot.dao.master.BokaEduresourceclassMapper;
import com.boot.dao.master.BokaNewsMapper;
import com.boot.dao.master.BokaNewsclassMapper;
import com.boot.model.cluster.*;
import com.boot.model.cluster.bo.ResourceTypeTwoLvBo;
import com.boot.model.master.BokaEduresourceExample;
import com.boot.model.master.BokaEduresourceWithBLOBs;
import com.boot.model.master.BokaEduresourceclass;
import com.boot.model.master.BokaEduresourceclassExample;
import com.boot.service.ResourceService;
import com.boot.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/7/7.
 */
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {
    /*
    主库
     */
    @Autowired
    private BokaEduresourceMapper eduresourceMapper;
    @Autowired
    private BokaEduresourceclassMapper eduresourceclassMapper;
    @Autowired
    private BokaNewsclassMapper newsclassMapper;
    @Autowired
    private BokaNewsMapper newsMapper;
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
    @Autowired
    private JsEbookMapper ebookMapper;

    @Override
    public String transferSynByResourceClassType(int classType) {
        List<BokaEduresourceWithBLOBs> sourceList = getSourceListByType(classType);
        JsResourceWithBLOBs jsResource;
        try {
            if (sourceList != null && sourceList.size() > 0) {
//                int i =0;
                for (BokaEduresourceWithBLOBs entity : sourceList) {
                    jsResource = new JsResourceWithBLOBs();
                    /*if(i==150){
                        break;
                    }*/
                    if (classType != 1 || (classType == 1 && !StringUtils.isEmpty(entity.getTitle()) && entity.getTitle().indexOf("coverpage") > -1)) {
                        // 设置基本信息
                        putBasicInfo(entity, jsResource);
                        // 设置一级资源类目
                        putOneLevelResourceType(jsResource);
                        // 设置资源格式
                        putResourceFormat(entity, jsResource);
                        // 设置二级资源类目
                        putTwoLevelResourceType(entity, jsResource);
                        // 设置资源目录
                        putResourcePath(entity, jsResource);
                        // 设置学段学科
                        putPhaseSubjectInfo(entity, jsResource);
//                        System.out.println("");
                        resourceMapper.insert(jsResource);
                    } else {
                        // E-BOOK
                        JsEbook ebook;
                        putPhaseSubjectInfo(entity, jsResource);
                        String categoriesCode = jsResource.getCategoriescode();
                        String phtoto = entity.getPhoto();
                        List<String> list = UnserializePhpCodeUtils.unEbookSerializePhpCode(phtoto);
                        if (list != null && list.size() > 0) {
                            for (String photoPath : list) {
                                if (!StringUtils.isEmpty(photoPath) && !photoPath.startsWith("month")) {
                                    Map<String, String> map = NumberUtils.transferEbookPhotoPath(photoPath);
                                    ebook = new JsEbook();
                                    if (map != null && map.size() > 0) {
                                        String num = map.get("num");
                                        String preffix = map.get("preffix");
                                        if (!StringUtils.isEmpty(preffix)) {
                                            ebook.setPrefixpath(preffix);
                                        }
                                        if (!StringUtils.isEmpty(num)) {
                                            ebook.setIndexnum(num);
                                        }
                                        ebook.setCategoriescode(categoriesCode);
                                        ebook.setId(UUID.randomUUID().toString());
                                    }
                                    ebookMapper.insert(ebook);
                                }
                                System.out.println("");
                            }
                        }
                    }
//                    i=i+1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @Override
    public void setResourceCode() {
        JsResourceExample example = new JsResourceExample();
        example.createCriteria().andIdIsNotNull();
        List<JsResourceWithBLOBs> jsResources = resourceMapper.selectByExampleWithBLOBs(example);
        if (jsResources != null && jsResources.size() > 0){
            int i = 1;
            StringBuilder stringBuilder ;
            for (JsResourceWithBLOBs entity:jsResources){
                stringBuilder = new StringBuilder("ZY");
                Date date1 = new Date();
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
                String str1 = sdf1.format(date1);
                stringBuilder.append(str1);
                String num=String.format("%05d",i);
                stringBuilder.append(num);
                entity.setResourcecode(stringBuilder.toString());
                resourceMapper.updateByPrimaryKeyWithBLOBs(entity);
                i=i+1;
            }
        }
    }


    private void putResourcePath(BokaEduresourceWithBLOBs entity, JsResourceWithBLOBs jsResource) {
        String source11 = entity.getEduresource11();
        String source6 = entity.getEduresource6();
        String source13 = entity.getEduresource13();
        String photo = null;
        if (entity.getResourcetype() == 1) {
            photo = entity.getPhoto();
        }
        if (!StringUtils.isEmpty(photo)) {
            String photoPath = UnserializePhpCodeUtils.unSerializePhpCode(null, photo);
            jsResource.setCoverpath(photoPath);
        }
        if (!StringUtils.isEmpty(source11)) {
            jsResource.setFilepath(entity.getEduresource11());
        }
        if (!StringUtils.isEmpty(source6)) {
            String path6 = UnserializePhpCodeUtils.unSerializePhpCode(null, source6);
            // swf格式
            if (ResourceTypeTransfeUtils.isEndWith(path6, CommonConst.SWF)) {
                jsResource.setSwfpath(path6);
            } else {
                jsResource.setFilepath(path6);
            }
        }
        if (!StringUtils.isEmpty(source13)) {
            String path13 = UnserializePhpCodeUtils.unSerializePhpCode(null, source13);
            jsResource.setFilepath(path13);
        }
    }

    /**
     * 设置基本信息
     *
     * @param entity
     * @param jsResource
     */
    private void putBasicInfo(BokaEduresourceWithBLOBs entity, JsResourceWithBLOBs jsResource) {
        jsResource.setId(UUID.randomUUID().toString());
        jsResource.setTitle(entity.getTitle()); // 标题
        jsResource.setContent(entity.getContent()); // 内容
        jsResource.setDownclick(String.valueOf(entity.getDownloads())); // 下载数
        jsResource.setViews(String.valueOf(entity.getViews())); // 查看数
        jsResource.setIsfree(CommonConst.FREE); // 是否收费
        jsResource.setOrigin(CommonConst.OLD); // 来源是老数据
        jsResource.setState("3");
        jsResource.setUserid("1");
        jsResource.setUsername("基教分社");
        jsResource.setCreatedate(DateUtils.timeStampToDate(entity.getDateline())); // 创建时间
    }

    /**
     * 设置学段学科
     *
     * @param entity
     * @param jsResource
     */
    private boolean putPhaseSubjectInfo(BokaEduresourceWithBLOBs entity, JsResource jsResource) throws Exception {
        String classId = entity.getClassid();
        if (!StringUtils.isEmpty(classId)) {
            List<String> sortList = new ArrayList();
            BokaEduresourceclassExample example = new BokaEduresourceclassExample();
            example.createCriteria().andIdEqualTo(Integer.valueOf(classId));
            List<BokaEduresourceclass> bokaEduresourceclasses = eduresourceclassMapper.selectByExample(example);
            BokaEduresourceclass bo;
            if (bokaEduresourceclasses != null && bokaEduresourceclasses.size() > 0) {
                bo = bokaEduresourceclasses.get(0);
                sortList.add(bo.getName());
                dieDaiTest(bo.getParentid(), sortList);
            }
            Collections.reverse(sortList);
            int count = 1;
            String phaseId = null;
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
                    jsResource.setPhaseid(phaseId);
                    jsResource.setPhase(param);
                    sbOne = new StringBuilder(phaseId);
                    if (count == size) {
                        categoriesCode.append(sbOne);
                    } else {
                        categoriesCode.append(sbOne).append(",");
                    }
                }
                if (count == 2 && !StringUtils.isEmpty(param)) { // 学科
                    subjectId = PinYinUtils.convertLower(param);
                    if (!StringUtils.isEmpty(phaseId)) {
                        StringBuilder newSubjectId = new StringBuilder(phaseId).append("-").append(subjectId);
                        jsResource.setSubjectid(newSubjectId.toString());
                        jsResource.setSubject(param);
                        sbTwo = new StringBuilder(sbOne).append("-").append(subjectId);
                        categoriesCode.append(sbTwo).append(",");
                        sbThree = new StringBuilder(sbTwo).append("-").append(CommonConst.BEISHIDABAN);
                        // todo 待测试
                        if (size == 2) {
                            categoriesCode.append(sbThree);
                        } else {
                            categoriesCode.append(sbThree).append(",");
                        }
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
            jsResource.setCategoriescode(categoriesCode.toString());
        }
        return true;
    }

    private void dieDaiTest(int classId, List sortList) {
        if (classId == 0) {
            return;
        } else {
            BokaEduresourceclassExample example = new BokaEduresourceclassExample();
            example.createCriteria().andIdEqualTo(classId);
            List<BokaEduresourceclass> list = eduresourceclassMapper.selectByExample(example);
            if (list != null && list.size() > 0) {
                BokaEduresourceclass bo = list.get(0);
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

    /**
     * 设置二级资源类目
     *
     * @param entity
     * @param jsResource
     */
    private void putTwoLevelResourceType(BokaEduresourceWithBLOBs entity, JsResource jsResource) {
        int resourcetype = entity.getResourcetype();
        ResourceTypeTwoLvBo bo = getTypeTwoBo(resourcetype);
        jsResource.setResourcetypetwolevelid(bo.getLevelId());
        jsResource.setResourcetypetwolevelvalue(bo.getLevelValue());
    }

    /**
     * 二级资源类目设置逻辑
     *
     * @param resourcetype
     * @return
     */
    private ResourceTypeTwoLvBo getTypeTwoBo(int resourcetype) {
        ResourceTypeTwoLvBo bo = null;
        // 电子课本
        if (resourcetype == 1) {
            // 教师用书
            bo = CacheUtils.getValueByKey(ResourceTypeTwoLevelConst.E_TEXTBOOK);
        }
        // 教师用书
        if (resourcetype == 3) {
            // 教师用书
            bo = CacheUtils.getValueByKey(ResourceTypeTwoLevelConst.TEACHER_BOOK);
        }
        // 课件资源
        if (resourcetype == 2) {
            // 教学课件
            bo = CacheUtils.getValueByKey(ResourceTypeTwoLevelConst.COURSEWARE);
        }
        // 教学设计 教学指导
        if (resourcetype == 4 || resourcetype == 19) {
            // 教学设计
            bo = CacheUtils.getValueByKey(ResourceTypeTwoLevelConst.INSTRUCTION_DESIGN);
        }
        // 视频资源
        if (resourcetype == 5) {
            // 教学设计
            bo = CacheUtils.getValueByKey(ResourceTypeTwoLevelConst.MICRO_CLASS);
        }
        // 图片素材 录音资源 教学图库
        if (resourcetype == 6 || resourcetype == 20 || resourcetype == 31) {
            // 备课资源
            bo = CacheUtils.getValueByKey(ResourceTypeTwoLevelConst.MATERIAL_FOR_PREPARE);
        }
        // 评价试题 优秀作业 同步练习 测试评价 专题复习
        if (resourcetype == 7 || resourcetype == 13
                || resourcetype == 14 || resourcetype == 35
                || resourcetype == 30) {
            // 同步练习
            bo = CacheUtils.getValueByKey(ResourceTypeTwoLevelConst.SYNC_EXERCISE);
        }
        // 物理大观 时事热点 心理研究 心理辅导
        if (resourcetype == 22 || resourcetype == 29
                || resourcetype == 33 || resourcetype == 34) {
            // 拓展资源
            bo = CacheUtils.getValueByKey(ResourceTypeTwoLevelConst.EXPAND_RES);
        }
        return bo;
    }

    /**
     * 设置资源格式
     *
     * @param entity
     * @param jsResource
     */
    private void putResourceFormat(BokaEduresourceWithBLOBs entity, JsResource jsResource) {
        String fileType = entity.getFiletype();
        if (!StringUtils.isEmpty(fileType)) {
            NewResourceTypeConst resFormat = ResourceTypeTransfeUtils.transerferResouceType(fileType);
            if (resFormat.equals(NewResourceTypeConst.UNSURE)) {
                resFormat = ResourceTypeTransfeUtils.transferFileType(entity.getContent());
            }
            jsResource.setResourceformatid(resFormat.getName());
            jsResource.setResourceformatvalue(resFormat.getDesc());
        }
    }

    /**
     * 设置一级资源类目
     *
     * @param jsResource
     */
    private void putOneLevelResourceType(JsResource jsResource) {
        jsResource.setResourcetypeonelevelid(ResourceTypeOneLevelConst.SYNC_RESOURCE);
        jsResource.setResourcetypeonelevelvalue(ResourceTypeOneLevelConst.SYNC_RESOURCE_VALUE);
        jsResource.setResourcetype(ResourceTypeOneLevelConst.SYN);
    }

    /**
     * 获取列表
     *
     * @param classType
     * @return
     */
    private List<BokaEduresourceWithBLOBs> getSourceListByType(int classType) {
        BokaEduresourceExample example = new BokaEduresourceExample();
        example.createCriteria().andResourcetypeEqualTo((byte) classType);
        List<BokaEduresourceWithBLOBs> bokaEduresourceWithBLOBs = eduresourceMapper.selectByExampleWithBLOBs(example);
        return bokaEduresourceWithBLOBs;
    }

}
