package cn.itcas.feign.Config;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderConfig {
    /**
     * 发送http请求
     *
     * @return {@link RestTemplate}
     */
    @LoadBalanced //负载均衡
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
  
    /**
     * 随机规则
     *  全局有效
     * @return {@link IRule}
     */
    @Bean
    public IRule randomRule(){
        return new RandomRule();
    }
}
