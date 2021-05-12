package web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.spring.service.IMultiServiceService;
import web.spring.service.impl.MultiService2ServiceImpl;

import javax.annotation.Resource;

/**
 * @Author ZhangGJ
 * @Date 2021/05/12 15:04
 */
@RestController
@RequestMapping("test")
public class MultiServiceController {

    private final IMultiServiceService multiServiceService1;

    @Autowired
    public MultiServiceController(@Qualifier("multiService1ServiceImpl")
                    IMultiServiceService multiServiceService1) {
        this.multiServiceService1 = multiServiceService1;
    }

    @Resource(type = MultiService2ServiceImpl.class)
    private IMultiServiceService multiServiceService2;

    @Resource(name = "multiService3ServiceImpl")
    private IMultiServiceService multiServiceService3;

    @GetMapping("test")
    public void test() {
        multiServiceService1.test();
        multiServiceService2.test();
        multiServiceService3.test();
    }
}
