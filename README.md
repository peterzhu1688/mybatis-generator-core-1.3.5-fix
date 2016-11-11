# mybatis-generator-core-1.3.5-fix说明

此版本为mybatis-generator-core-1.3.5定制版，通过自定义CommentGenerator重写生成代码注释的逻辑，具体查看 **org.mybatis.generator.MyCommentGenerator**

- 去掉了 \*Mapper接口的无用注释
- 去掉了 \*Mapper.xml文件的无用注释
- 修改Model类的Field注释为 TABLENAME.COLUMN(COMMENT)


# 使用方法

1. git clone下载到本地后，替换掉pom.xml中的\<distributionManagement\>为内网nexus地址
2. 执行mvn clean deploy命令将生成的mybatis-generator-core-1.3.5-fix.jar上传到内网nexus仓库中
3. 然后git clone下载mybatis-generator-1.3.5, 修改generator.properties配置jdbc相关信息，修改generatorConfig.xml配置生成策略和目标table
4. 执行 mvn mybatis-generator:generate即可。
