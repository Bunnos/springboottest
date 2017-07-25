package com.boot.service.imp;

import com.boot.dao.cluster.JsEbookMapper;
import com.boot.dao.cluster.TempMapper;
import com.boot.model.cluster.JsEbook;
import com.boot.model.cluster.JsEbookExample;
import com.boot.model.cluster.Temp;
import com.boot.model.cluster.TempExample;
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
    public TempMapper tempMapper;

    @Override
    public String transferData() {
        TempExample tempExample = new TempExample();
        tempExample.createCriteria().andCategoriescodeIsNotNull();
        List<Temp> temps = tempMapper.selectByExample(tempExample);
        JsEbookExample ebookExample;
        if(temps!=null && temps.size()>0){
            for (Temp temp:temps){
                ebookExample = new JsEbookExample();
                ebookExample.createCriteria().andCategoriescodeLike(temp.getCategoriescode()+"%");
                List<JsEbook> jsEbooks = ebookMapper.selectByExample(ebookExample);
                Long count = temp.getCount();
                for (JsEbook ebook:jsEbooks){
                    ebook.setTotalnum(count);
                    ebookMapper.updateByPrimaryKeySelective(ebook);
                }
            }
        }
        return "success";
    }
}
