package com.guojunjie.springbootblog.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @time： 2019/11/21 20:22
 * @author： guojunjie
 * TODO： 上传图片的工具类，解耦
 */
public class UploadUtil {
    public static String uploadFile(MultipartFile file, String dirName,String name) throws IOException {
        //将MultipartFile转为File
        File f = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = file.getInputStream();
            f = new File(file.getOriginalFilename());
            FileUtil.inputStreamToFile(ins, f);
        }
        //上传File到华为云OBS并返回url
        // todo:这里配置使用的是永久访问密钥，最好修改为临时访问密钥
        String url = HuaWeiCloudOBSUtil.uploadFile(dirName,name, f);
        //删除生成的File文件
        File del = new File(f.toURI());
        del.delete();
        return url;
    }
}
