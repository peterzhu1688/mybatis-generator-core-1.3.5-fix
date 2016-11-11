/**
 *    Copyright ${license.git.copyrightYears} the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
/**
 *  @Author peter.zhu
 *  @Date 2016/11/09
 */
package org.mybatis.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * Created by peter.zhu on 2016/11/9 0009.
 */
public class MyCommentGenerator extends DefaultCommentGenerator {

    /**
     * 数据对象类Field注释
     * @param field
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addFieldComment(Field field,
                                IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        field.addJavaDocLine("/**"); //$NON-NLS-1$

        String tableName = String.valueOf(introspectedTable.getFullyQualifiedTable()).toUpperCase();
        String columnName = String.valueOf(introspectedColumn.getActualColumnName()).toUpperCase();

        StringBuilder sb = new StringBuilder(" * ");
        sb.append(tableName);
        sb.append('.');
        sb.append(columnName);

        String remarks = introspectedColumn.getRemarks(); //字段注释
        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            sb.append(" (").append(remarks).append(")");
        }

        field.addJavaDocLine(sb.toString());

        field.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    /**
     * 数据对象类注释
     * @param topLevelClass
     * @param introspectedTable
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass,
                                     IntrospectedTable introspectedTable) {
        if (suppressAllComments || !addRemarkComments) {
            return;
        }

        topLevelClass.addJavaDocLine("/**"); //$NON-NLS-1$

        String remarks = introspectedTable.getFullyQualifiedTable().getRemark();
        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            topLevelClass.addJavaDocLine(" *");
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));  //$NON-NLS-1$
            for (String remarkLine : remarkLines) {
                topLevelClass.addJavaDocLine(" * " + remarkLine);  //$NON-NLS-1$
            }
        }
        topLevelClass.addJavaDocLine(" *");

        StringBuilder sb = new StringBuilder(" * 表名: ");
        sb.append(String.valueOf(introspectedTable.getFullyQualifiedTable()).toUpperCase());
        topLevelClass.addJavaDocLine(sb.toString());

        topLevelClass.addJavaDocLine(" *");

        topLevelClass.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    /**
     * 数据对象类Getter方法注释
     * @param method
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addGetterComment(Method method,
                                 IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
        //去掉model的get方法注释


    }

    /**
     * 数据对象类Setter方法注释
     * @param method
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addSetterComment(Method method,
                                 IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
        //去掉model的set方法注释


    }

    /**
     * Mapper类方法注释
     * @param method
     * @param introspectedTable
     */
    @Override
    public void addGeneralMethodComment(Method method,
                                        IntrospectedTable introspectedTable) {
        //去掉Mapper方法注释


    }

    /**
     * mapper.xml文件注释
     * @param xmlElement
     */
    @Override
    public void addComment(XmlElement xmlElement) {
        //去掉mapper.xml文件注释


    }



}
