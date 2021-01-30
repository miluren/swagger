package com.z.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

// ApiModel 配置类的注释
// ApiModelProperty 配置实体类属性的注释，如果为public，才可以在Swagger中显示
@ApiModel("用户实体类")
public class User {

	@ApiModelProperty("用户名")
	public String name;
	@ApiModelProperty("密码")
	public String password;
}
