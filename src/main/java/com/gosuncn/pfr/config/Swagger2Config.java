package com.gosuncn.pfr.config;
//swagger2的配置文件，在项目的启动类的同级文件建立

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2的配置文件
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${swagger.show:false}")
    private boolean swaggerShow;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(swaggerShow)
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.gosuncn.pfr.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /***
     * 构建 api文档的详细信息函数
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("项目管理平台")
                //创建人
                //.contact(new Contact("hwj", "http://www.baidu.com", ""))
                //版本号
                .version("1.0")
                //描述
                .description("上海旅店管理服务"
                )
                .build();
    }
 
 
}