package com.irv.media.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description minio配置
 * @author zqs
 * @date 2022/9/12 19:32
 * @version 1.0
 */
 @Configuration
public class MinioConfig {

//从nacos配置中心读取信息
 @Value("${minio.endpoint}")
 private String endpoint;
 @Value("${minio.accessKey}")
 private String accessKey;
 @Value("${minio.secretKey}")
 private String secretKey;

 @Bean
 public MinioClient minioClient() {

  MinioClient minioClient =
          MinioClient.builder()
                  .endpoint(endpoint) // ip加端口
                  .credentials(accessKey, secretKey) // 用户名， 密码
                  .build();
  return minioClient;
 }
}
