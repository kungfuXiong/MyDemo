package com.qinglan.fileoperate;

import com.qinglan.fileoperate.Interceptor.NeedInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
@ResponseBody
public class FileUpload {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUpload.class);

    @NeedInterceptor
    @PostMapping("/uploadOne")
    public R uoloadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //判断文件是否为空
        if (file.isEmpty()) {
            return R.error("上传文件为空");
        } else {
            //获取文件名
            String originalName = file.getOriginalFilename().split("\\.")[1];
            String uuid = UUID.randomUUID().toString().replace("-", "");
            //避免同名文件上传冲突
            String fileName = uuid + "." + originalName;
            //设置目标存储文件夹
            String uploadsPath = request.getSession().getServletContext().getRealPath("uploads");
            File dir = new File(uploadsPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //设置目标文件夹及文件名
            File dst = new File(dir, fileName);
            LOGGER.info(dst.toString());
            try {
                //存储文件至目标文件夹并重命名
                file.transferTo(dst);
            } catch (IOException e) {
                return R.error("存储文件出错");
            } finally {
                dst.deleteOnExit();
                return R.ok();
            }
        }
    }
}
