package cn.itcas.feign.clients;


import cn.itcas.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * 用户客户端   用于发送http请求  已经实现负载均衡
 *
 * @author 当当
 * @date 2022/11/25
 */
@FeignClient("userservice")
public interface UserClient {

    /**
     * 在order服务的user Id查询user服务
     *
     * @param id id
     * @return {@link User}
     */
    @GetMapping("/user/{id}")
    User getById(@PathVariable("id")Long id);


}
