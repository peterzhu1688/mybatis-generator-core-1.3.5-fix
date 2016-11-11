# mybatis-generator-core-1.3.5-fix说明
此版本为mybatis-generator-core-1.3.5定制版，主要重写了自动生成注释的逻辑，具体@See org.mybatis.generator.MyCommentGenerator

- 去掉了 \*Mapper接口的无用注释
- 去掉了 \*Mapper.xml文件的无用注释
- 修改Model类的Field注释为 TABLENAME.COLUMN(COMMENT)


