package cn.zbq.springcloud.contentcenter.controller.content;

import cn.zbq.springcloud.contentcenter.auth.LoginCheck;
import cn.zbq.springcloud.contentcenter.domain.dto.content.ShareDTO;
import cn.zbq.springcloud.contentcenter.service.content.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分享控制器
 *
 * @author Zbq
 * @since 2019/9/8 18:33
 */
@RestController
@RequestMapping("/shares")
public class ShareController {
    @Autowired
    private ShareService shareService;

    @LoginCheck
    @RequestMapping("/{id}")
    public ShareDTO findById(@PathVariable Integer id, @RequestHeader("X-Token") String token) {
        // @RequestHeader("X-Token") String token 接收一个名为X-Token的Header，将其赋值给名为token的参数
        return this.shareService.findById(id,token);
    }
}
