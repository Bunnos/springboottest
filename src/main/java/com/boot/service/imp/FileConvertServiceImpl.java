package com.boot.service.imp;

import com.boot.dao.cluster.JsResourceMapper;
import com.boot.model.cluster.JsResourceExample;
import com.boot.model.cluster.JsResourceWithBLOBs;
import com.boot.service.FileConvertService;
import com.boot.utils.HttpHelper;
import com.boot.vo.FileConvertVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/18.
 */
@Service
@Transactional
public class FileConvertServiceImpl implements FileConvertService {
    @Autowired
    private JsResourceMapper mapper;
    @Value("${fileHost}")
    private String fileHost;
    @Value("${fileConvertServer}")
    private String fileConvertServer;
    @Value("${fileConvertCallBackServer}")
    private String fileConvertCallBackServer;

    @Override
    public String convertFile() throws Exception {
        FileConvertVo fileConvertVo = new FileConvertVo();
        JsResourceExample jsResourceExample = new JsResourceExample();
        jsResourceExample.createCriteria().andFilepathIsNotNull().andPdfpathIsNull().andSwfpathIsNull().andOriginEqualTo("OD");
        List<JsResourceWithBLOBs> list = mapper.selectByExampleWithBLOBs(jsResourceExample);
        int i = 0;
        if (list != null && list.size() > 0) {
            for (JsResourceWithBLOBs entity : list) {
                if (i == 150) {
                    break;
                }
                String filePath = entity.getFilepath();
                String fileType; // 文件后缀名
                fileType = StringUtils.substring(filePath, StringUtils.lastIndexOf(filePath, ".") + 1);
                String targetType = returnTargetType(fileType);
                if (StringUtils.isEmpty(targetType)) { // 如果转换服务器不支持转换文件则直接返回
                    return null;
                }
                fileConvertVo.setBusiId(entity.getId());
                Map<String, Object> paramData = new HashMap<>();
                paramData.put("source", fileHost + filePath);
                paramData.put("targetType", targetType);
                paramData.put("callback", fileConvertCallBackServer + "?busiId=" + fileConvertVo.getBusiId());
                HttpHelper.post(fileConvertServer, paramData); // 发送转换文件请求

                fileConvertVo.setConertDate(new Date());
                fileConvertVo.setConertState("1"); // 文件转换中
                i = i + 1;
            }
        }

//                updateBusiInfo(fileConvertVo);
        return null;
    }

    @Override
    public String convertFileCallBack(HttpServletResponse response, FileConvertVo fileConvertVo) throws Exception {
        if (fileConvertVo != null) {
            String id = fileConvertVo.getBusiId();
            updateResourceInfo(fileConvertVo, id);
            return "success";
        }
        return "fail";
    }

    private void updateResourceInfo(FileConvertVo fileConvertVo, String id) {
        JsResourceWithBLOBs jsResourceWithBLOBs = mapper.selectByPrimaryKey(id);
        String pdfPath = fileConvertVo.getConv_url_middle();
        String swfPath = fileConvertVo.getConv_url_result();
        if (!StringUtils.isEmpty(pdfPath) && !StringUtils.isEmpty(swfPath)) {
            jsResourceWithBLOBs.setPdfpath(pdfPath);
            jsResourceWithBLOBs.setSwfpath(swfPath);
        }
        if (StringUtils.isEmpty(pdfPath) && !StringUtils.isEmpty(swfPath)) {
            jsResourceWithBLOBs.setFilepath(swfPath);
        }
        mapper.updateByPrimaryKeySelective(jsResourceWithBLOBs);
    }

    /**
     * 根据文件格式返回targetType
     *
     * @param fileType
     * @return
     */
    private String returnTargetType(String fileType) {
        String targetType = null;
        switch (fileType) {
            case "doc":
                ;
            case "docx":
                ;
            case "xlsx":
                ;
            case "xls":
                ;
            case "ppt":
                ;
            case "pptx":
                targetType = "SWF";
                break;
            case "flv":
                targetType = "MP4";
                break;
        }

        return targetType;
    }
}
