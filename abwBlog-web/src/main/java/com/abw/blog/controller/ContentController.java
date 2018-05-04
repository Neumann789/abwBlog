package com.abw.blog.controller;

import com.abw.blog.common.BaseRsp;
import com.abw.blog.common.constants.RspCodeEnum;
import com.abw.blog.common.exception.AbwException;
import com.abw.blog.common.utils.SeqUtils;
import com.abw.blog.service.ContentService;
import com.abw.blog.service.req.ContentInfo;
import com.abw.blog.service.req.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by fanghuabao on 2018/4/25 0025.
 */
@RestController
@RequestMapping("/abwBlog")
public class ContentController {
    private static final Logger logger = LoggerFactory.getLogger(ContentController.class);

    @Value("${abw.upload.dir}")
    private String abwUploadDir;

    @Value("${abw.http.file.server}")
    private String abwHttpFileServer;
    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/registContent",method= RequestMethod.POST)
    public BaseRsp registContent(@RequestBody ContentInfo req){
        return contentService.registContent(req);
    }

    @RequestMapping(value = "/uploadFile",method= RequestMethod.POST)
    public BaseRsp uploadFile(HttpServletResponse rsp,HttpServletRequest req) throws IOException {
        logger.info("uploadFile");
        StandardMultipartHttpServletRequest smhs = (StandardMultipartHttpServletRequest)req;
        smhs.getMultiFileMap().get("file");
       // MultipartFile mulFile = smhs.getMultiFileMap().get("file");
        MultipartFile mulFile = smhs.getMultiFileMap().get("file").get(0);
                FileOutputStream outputStream = null;
        String newUploadFileUrl = null;
        if (!mulFile.isEmpty()) {
            String mulFileName = mulFile.getOriginalFilename();
            try {
                File file = new File(abwUploadDir, SeqUtils.getUUIDPreWithTime()+"_"+mulFileName);
                file.createNewFile();
                outputStream = new FileOutputStream(file);
                outputStream.write(mulFile.getBytes());
                newUploadFileUrl = abwHttpFileServer+file.getName();
                logger.info("File load success.");
            } catch (Exception e) {
                logger.error("upload file error:"+e.getMessage(),e);
                return BaseRsp.returnRsp(RspCodeEnum.CONTENT_UPLOAD_FAIL.getRspCode()
                        ,RspCodeEnum.CONTENT_UPLOAD_FAIL.getRspMsg(e.getMessage()));

            } finally {
                try {
                    if(outputStream!=null){
                        outputStream.close();
                    }
                }catch (Exception e){
                    logger.error(e.getMessage(),e);
                }

            }
        }
        return BaseRsp.returnSuccss(newUploadFileUrl);

    }

    @RequestMapping(value = "/searchContentList",method= RequestMethod.POST)
    public BaseRsp searchContentList(@RequestBody ContentInfo contentInfo) {
        return contentService.searchContentList(contentInfo);
    }

    @RequestMapping(value = "/searchSingleContent",method= RequestMethod.POST)
    public BaseRsp searchSingleContent(@RequestBody ContentInfo contentInfo) {
        return contentService.searchSingleContent(contentInfo);
    }







}
