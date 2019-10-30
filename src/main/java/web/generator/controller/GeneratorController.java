package web.generator.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.generator.domain.TableInfo;
import web.generator.service.IGeneratorService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author ZhangGJ
 * @Date 2019/10/24
 */
@Controller
@RequestMapping("/gen")
public class GeneratorController {

    @Autowired
    private IGeneratorService generatorService;

    /**
     * 查询数据库所有的表信息
     * @param tableInfo
     * @return
     */
    @PostMapping("/list")
    @ResponseBody
    public List<TableInfo> list(@RequestBody TableInfo tableInfo){
        return generatorService.tableInfoList(tableInfo);
    }

    /**
     * 生成代码
     * @param response
     * @param tableName
     */
    @GetMapping("/code/{tableName}")
    public void generatorCode(HttpServletResponse response, @PathVariable("tableName") String tableName) throws IOException {
        byte[] data = generatorService.generatorCode(tableName);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"pactera.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }
}
