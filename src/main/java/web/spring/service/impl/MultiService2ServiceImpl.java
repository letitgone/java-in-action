package web.spring.service.impl;

import org.springframework.stereotype.Service;
import web.spring.service.IMultiServiceService;

/**
 * @Author ZhangGJ
 * @Date 2021/05/12 15:05
 */
@Service
public class MultiService2ServiceImpl implements IMultiServiceService {

    @Override
    public void test() {
        System.out.println("MultiService2");
    }
}
