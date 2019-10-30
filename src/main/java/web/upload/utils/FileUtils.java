package web.upload.utils;

import java.io.File;

/**
 * @Author ZhangGJ
 * @Date 2019/10/23
 */
public class FileUtils {

    public static void createDirectories(String pathName){
        File directories = new File(pathName);
        if(directories.exists()){
            System.out.println("文件上传根目录已存在");
        }else{
            if(directories.mkdirs()){
                System.out.println("创建目录成功！");
            }else{
                System.out.println("创建目录失败！");
            }
        }
    }
}
