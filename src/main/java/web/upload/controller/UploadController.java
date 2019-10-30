package web.upload.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.upload.utils.FileUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author ZhangGJ
 * @Date 2019/10/23
 */
@Controller
@RequestMapping("/system")
public class UploadController {

    private static final Logger log = LoggerFactory.getLogger(UploadController.class);

    @Value("${file.upload.root.dir.windows}")
    private String fileUploadRootDirWindows;

    @Value("${file.upload.root.dir.mac}")
    private String fileUploadRootDirMac;

    @Value("${file.upload.root.dir.linux}")
    private String fileUploadRootDirLinux;

    private static String fileUploadRootDir = null;

//    @PostConstruct
    private void init(){
        String system = System.getProperty("os.name");
        if(system.startsWith("Mac OS")){
            fileUploadRootDir = fileUploadRootDirMac;
        }else if(system.startsWith("Windows")){
            fileUploadRootDir = fileUploadRootDirWindows;
        }else{
            fileUploadRootDir = fileUploadRootDirLinux;
        }

        FileUtils.createDirectories(fileUploadRootDir);
    }

    @PostMapping("/upload")
    @ResponseBody
    public JSONObject fileUpload(@RequestParam("file") MultipartFile file){
        init();
        File convertFile = new File(fileUploadRootDir + file.getOriginalFilename());
        FileOutputStream fileOutputStream = null;
        JSONObject result = new JSONObject();
        try {
            try {
                fileOutputStream = new FileOutputStream(convertFile);
                fileOutputStream.write(file.getBytes());
            } finally {
                fileOutputStream.close();
            }
        } catch (FileNotFoundException e) {
            log.info("找不到此文件！");
            e.printStackTrace();
        } catch (IOException e) {
            log.info("文件读取失败！");
            e.printStackTrace();
        }
        result.put("fileName", file.getOriginalFilename());
        result.put("filePatjh",fileUploadRootDir + file.getOriginalFilename());
        result.put("uploadTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        result.put("uploadUser", "admin");
        result.put("message","Upload Success");
        result.put("code", "200");
        log.info("上传文件：" + file.getOriginalFilename() + ",成功");
        return result;
    }

    @GetMapping("/download/{fileName}")
    @ResponseBody
    public ResponseEntity<Object> downloadFile(@PathVariable("fileName") String fileName){
        File file = new File(fileUploadRootDir + fileName);
        InputStreamResource resource = null;
        try {
            resource = new InputStreamResource(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            log.info("找不到此文件！");
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add ( "Content-Disposition",String.format("attachment;filename=\"%s",fileName));
        headers.add ( "Cache-Control","no-cache,no-store,must-revalidate" );
        headers.add ( "Pragma","no-cache" );
        headers.add ( "Expires","0" );

        ResponseEntity<Object> responseEntity = ResponseEntity.ok()
            .headers ( headers )
            .contentLength ( file.length ())
            .contentType(MediaType.parseMediaType ( "application/txt" ))
            .body(resource);

        return responseEntity;
    }
}
