package com.boot.utils;

import com.boot.dao.cluster.JsDictMapper;
import com.boot.model.cluster.JsDict;
import com.boot.model.cluster.JsDictExample;
import com.boot.model.cluster.bo.ResourceTypeTwoLvBo;
import com.boot.service.ResourceService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/9.
 */
@Component
public class CacheUtils implements BeanPostProcessor {
    @Autowired
    private JsDictMapper jsDictMapper;

    private static Map<String, Object> jsDictCache = new HashMap<>();

    public static Map<String, Object> getJsClsTwoCache() {
        return jsDictCache;
    }

    public static ResourceTypeTwoLvBo getValueByKey(String key) {
        ResourceTypeTwoLvBo value = null;
        if (jsDictCache.containsKey(key)) {
            value = (ResourceTypeTwoLvBo) jsDictCache.get(key);
        }
        return value;
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
        return arg0;
    }

    @Override
    public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
        if (arg0 instanceof ResourceService) { //判断Object是否是该类的bean
            JsDictExample example = new JsDictExample();
            example.createCriteria().andTypeEqualTo("classTwo");
            List<JsDict> jsDicts = jsDictMapper.selectByExample(example);
            System.out.println(arg0 + "初始化后=====================>" + jsDicts.get(0).getDesc());
            // --这里就可以进行缓存操作了
            putIntoJsDictCache(jsDicts);
        }
        return arg0;
    }

    private void putIntoJsDictCache(List<JsDict> jsDicts) {
        if (jsDicts != null && jsDicts.size() > 0) {
            ResourceTypeTwoLvBo bo;
            for (JsDict jsDict : jsDicts) {
                bo = new ResourceTypeTwoLvBo();
                bo.setLevelId(jsDict.getCode());
                bo.setLevelValue(jsDict.getValue());
                jsDictCache.put(bo.getLevelId(), bo);
            }
        }
    }
}
