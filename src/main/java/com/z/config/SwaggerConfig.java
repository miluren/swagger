package com.z.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *  @EnableSwagger2 开启Swagger2
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket docket1(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("b");
	}

	@Bean
	public Docket docket2(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("c");
	}

	// 配置了Swagger 的Docket 的bean示例
	@Bean
	public Docket docket(Environment environment){

		// 设置要显示的Swagger环境
		Profiles profiles = Profiles.of("dev","test");

		// 通过environment.acceptsProfiles判断是否处在自己设定的环境当中
		boolean flag = environment.acceptsProfiles(profiles);


		// 方法重载
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.groupName("a")
				// enable 是否启用Swagger, 如果为false，则Swagger不能在浏览器中访问
				.enable(flag)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.z.controller"))
				.build(); // build
	}

	// 配置swagger信息 = apiinfo
	private ApiInfo apiInfo(){
		// 配置swagger作者信息
		Contact contact = new Contact("miluren",
				"https://www.baidu.com",
				"2807853618@qq.com");


		ApiInfo apiInfo = new ApiInfo("麋鹿人的swagger",
				"麋鹿人迷路了",
				"1.0",
				"https://www.baidu.com",
				contact, "Apache 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0",
				new ArrayList());
		return apiInfo;
	}
}
