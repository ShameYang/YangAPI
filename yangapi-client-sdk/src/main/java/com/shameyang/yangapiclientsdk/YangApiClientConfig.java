package com.shameyang.yangapiclientsdk;

import com.shameyang.yangapiclientsdk.client.YangApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ShameYang
 * @date 2024/8/31 18:44
 * @description
 */
@Configuration
@ConfigurationProperties("yangapi.client")
@Data
@ComponentScan
public class YangApiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public YangApiClient yangApiClient() {
        return new YangApiClient(accessKey, secretKey);
    }
}