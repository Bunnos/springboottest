package com.boot.service.imp;

import com.boot.dao.cluster.*;
import com.boot.model.cluster.*;
import com.boot.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */
@Service
@Transactional
public class EbookServiceImpl implements EbookService{
    @Autowired
    public JsEbookMapper ebookMapper;
    @Autowired
    public JsEbookNewMapper ebookNewMapper;
    @Autowired
    public TempMapper tempMapper;
    @Autowired
    public TempEbookMapper tempEbookMapper;
    @Autowired
    public TempTeacherMapper tempTeacherMapper;

    @Override
    public String transferData(int type) {
        if(type==0){
            TempEbookExample bookExample = new TempEbookExample();
            bookExample.createCriteria().andCategoriescodeIsNotNull().andRtypeEqualTo(0);
            List<TempEbook> tempEbooks = tempEbookMapper.selectByExample(bookExample);
            if(tempEbooks!=null && tempEbooks.size()>0){
                for (TempEbook temp:tempEbooks){
                    String code = temp.getCategoriescode();
                    long count = temp.getCount();
                    updateEbook(code,count,type);
                }
            }
        }
        if(type==1){
            TempTeacherExample teacherExample = new TempTeacherExample();
            teacherExample.createCriteria().andCategoriescodeIsNotNull().andRtypeEqualTo(1);
            List<TempTeacher> tempTeachers = tempTeacherMapper.selectByExample(teacherExample);
            if(tempTeachers!=null && tempTeachers.size()>0){
                for (TempTeacher temp:tempTeachers){
                    String code = temp.getCategoriescode();
                    long count = temp.getCount();
                    updateEbook(code,count,type);
                }
            }
        }
        return "success";
    }

    private void updateEbook(String cateCode,long count,int type){
        JsEbookNewExample ebookExample = new JsEbookNewExample();
        ebookExample.createCriteria().andCategoriescodeLike(cateCode+"%").andRtypeEqualTo(type);
        List<JsEbookNew> jsEbooks = ebookNewMapper.selectByExample(ebookExample);
        for (JsEbookNew ebook:jsEbooks){
            ebook.setTotalnum(count);
            ebookNewMapper.updateByPrimaryKeySelective(ebook);
        }
    }
}
