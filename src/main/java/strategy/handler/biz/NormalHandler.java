package strategy.handler.biz;

import org.springframework.stereotype.Component;
import strategy.handler.AbstractHandler;
import strategy.handler.HandlerType;
import strategy.model.OrderDTO;

/**
 * @Author: CipherCui
 * @Description: 普通订单处理器
 * @Date: Created in 10:17 2019/2/2
 */
@Component
@HandlerType("1")
public class NormalHandler extends AbstractHandler {

    @Override
    public String handle(OrderDTO dto) {
        return "处理普通订单";
    }

}
