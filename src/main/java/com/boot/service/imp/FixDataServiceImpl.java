package com.boot.service.imp;

import com.boot.dao.cluster.JsResourceMapper;
import com.boot.dao.master.BokaEduresourceMapper;
import com.boot.dao.master.BokaNewsMapper;
import com.boot.model.cluster.JsResourceExample;
import com.boot.model.cluster.JsResourceWithBLOBs;
import com.boot.model.master.BokaEduresourceExample;
import com.boot.model.master.BokaEduresourceWithBLOBs;
import com.boot.model.master.BokaNews;
import com.boot.model.master.BokaNewsExample;
import com.boot.service.FixDataService;
import com.boot.utils.UnserializePhpCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FixDataServiceImpl implements FixDataService {
    @Autowired
    private BokaNewsMapper newsMapper;

    @Autowired
    private BokaEduresourceMapper eduresourceMapper;

    @Autowired
    private JsResourceMapper resourceMapper;

    @Override
    public void fixWuli() throws Exception {
        JsResourceExample jsResourceExample = new JsResourceExample();
//        jsResourceExample.createCriteria().andPhaseidEqualTo("wuli");
        jsResourceExample.createCriteria().andPhaseidIsNull().andResourcetypeNotEqualTo("SYN");
        List<JsResourceWithBLOBs> jsResources = resourceMapper.selectByExampleWithBLOBs(jsResourceExample);
        if (jsResources != null && jsResources.size() > 0) {
            for (JsResourceWithBLOBs jsResource : jsResources) {
                String title = jsResource.getTitle();
                BokaNewsExample newsExample = new BokaNewsExample();
                newsExample.createCriteria().andTitleEqualTo(title);
                List<BokaNews> bokaNews = newsMapper.selectByExample(newsExample);
                for (BokaNews bokaNew : bokaNews) {
                    if (checkQuanguoBan(bokaNew.getClassid())) {
                        jsResource.setPhaseid("chuzhong");
                        jsResource.setPhase("初中");
                        jsResource.setSubjectid("chuzhong-wuliquanguoban");
                        jsResource.setSubject("物理-全国版");
                        jsResource.setCategoriescode("chuzhong,chuzhong-wuliquanguoban,chuzhong-wuliquanguoban-beishidaban");
                        System.out.println(bokaNew.getTitle() + " 全国版");
                    }
                    if (checkBeijingBan(bokaNew.getClassid())) {
                        jsResource.setPhaseid("chuzhong");
                        jsResource.setPhase("初中");
                        jsResource.setSubjectid("chuzhong-wulibeijingban");
                        jsResource.setSubject("物理-北京版");
                        jsResource.setCategoriescode("chuzhong,chuzhong-wulibeijingban,chuzhong-wulibeijingban-beishidaban");
                        System.out.println(bokaNew.getTitle() + " 北京版");
                    }
                    jsResource.getTitle();
//                    System.out.println();
                    resourceMapper.updateByPrimaryKeySelective(jsResource);
                }
            }
        }
    }

    @Override
    public void fixPhoto() throws Exception {
        JsResourceExample jsResourceExample = new JsResourceExample();
        jsResourceExample.createCriteria().andResourceformatidEqualTo("Image").andResourcetypetwolevelidNotEqualTo("TeacherBook").andResourcetypetwolevelidNotEqualTo("E-textbook");
        List<JsResourceWithBLOBs> jsResourceWithBLOBs = resourceMapper.selectByExampleWithBLOBs(jsResourceExample);
        if(jsResourceWithBLOBs!=null && jsResourceWithBLOBs.size()>0){
            for(JsResourceWithBLOBs entity: jsResourceWithBLOBs){
                Date createdate = entity.getCreatedate();
                Long timeStamp = createdate.getTime()/1000;
                String title = entity.getTitle();
                BokaEduresourceExample bokaEduresourceExample = new BokaEduresourceExample();
                bokaEduresourceExample.createCriteria().andTitleEqualTo(title).andDatelineEqualTo(timeStamp).andPhotoIsNotNull();
                List<BokaEduresourceWithBLOBs> bokaEduresourceWithBLOBsList = eduresourceMapper.selectByExampleWithBLOBs(bokaEduresourceExample);
                if(bokaEduresourceWithBLOBsList !=null && bokaEduresourceWithBLOBsList.size()>0){
                    BokaEduresourceWithBLOBs boka = bokaEduresourceWithBLOBsList.get(0);
                    String photo = boka.getPhoto();
                    String newPhotoPath = UnserializePhpCodeUtils.getNewPhotoPath(photo);
                    entity.setContent(newPhotoPath);
//                    System.out.println();
                    resourceMapper.updateByPrimaryKeyWithBLOBs(entity);
                }
            }
        }
    }

    private boolean checkBeijingBan(Integer classId) {
        if (classId == 445 || classId == 446 || classId == 447 || classId == 448 || classId == 449 || classId == 450 || classId == 451) {
            return true;
        }
        return false;
    }

    private boolean checkQuanguoBan(Integer classId) {
        if (classId == 385 || classId == 121 || classId == 122 || classId == 275 || classId == 337 || classId == 358 || classId == 363) {
            return true;
        }
        return false;
    }
}
