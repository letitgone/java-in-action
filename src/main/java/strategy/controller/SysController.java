package strategy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import strategy.model.OrderDTO;
import strategy.service.IOrderService;

/**
 * @Author ZhangGJ
 * @Date 2019/04/28
 */
@RestController
public class SysController {

    @Autowired private IOrderService orderService;

    @PostMapping("/system")
    public String system() {
        OrderDTO dto = new OrderDTO();
        dto.setType("2");
        orderService.handle(dto);
        return "Success!!!";
    }
}
