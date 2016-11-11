# mybatis-generator-core-1.3.5-fix说明

此版本为mybatis-generator-core-1.3.5定制版，通过自定义CommentGenerator重写生成代码注释的逻辑，具体查看 **org.mybatis.generator.MyCommentGenerator**

- 去掉了 \*Mapper接口的无用注释
- 去掉了 \*Mapper.xml文件的无用注释
- 修改Model类的Field注释为 TABLENAME.COLUMN(COMMENT)




# 使用方法

1. 下载到本地
    
    git clone https://github.com/peterzhu1688/mybatis-generator-core-1.3.5-fix.git

2. 替换掉pom.xml中的\<distributionManagement\>为内网nexus地址
     
         <distributionManagement>
          <snapshotRepository>
            <id>snapshots</id>
            <url>http://xxxxx/nexus/content/repositories/snapshots</url>
          </snapshotRepository>
          <repository>
            <id>releases</id>
            <url>http://xxxxxx/nexus/content/repositories/releases</url>
          </repository>
        </distributionManagement>
  
2. 将mybatis-generator-core-1.3.5-fix.jar上传到内网nexus仓库中

          mvn clean deploy


3. 下载mybatis-generator-1.3.5

          //TODO 

4. 修改generator.properties配置jdbc相关信息


5. 修改generatorConfig.xml配置生成策略和目标table
  
6. 执行 mvn mybatis-generator:generate即可。


# 效果

    /**
     *
     * 入库明细表
     *
     * 表名: MMS_INCOME_DETAIL
     *
     */
    public class IncomeDetailDO {
        /**
         * MMS_INCOME_DETAIL.ID
         */
        private Long id;

        /**
         * MMS_INCOME_DETAIL.ARTICLE_ID (物品ID)
         */
        private String articleId;

        /**
         * MMS_INCOME_DETAIL.EVENT_ID (入库事件ID)
         */
        private String eventId;

        /**
         * MMS_INCOME_DETAIL.MAT_ID (物资编码)
         */
        private String matId;

        /**
         * MMS_INCOME_DETAIL.WHS_ID (仓库编码)
         */
        private String whsId;

        /**
         * MMS_INCOME_DETAIL.UNIT_FEE (单价)
         */
        private BigDecimal unitFee;

        /**
         * MMS_INCOME_DETAIL.CREATE_TIME (创建时间)
         */
        private Date createTime;

        /**
         * MMS_INCOME_DETAIL.UPDATE_TIME (更新时间)
         */
        private Date updateTime;

    }

