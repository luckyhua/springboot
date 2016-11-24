package com.luckyhua.springboot.global.database.mybaits;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * @author luckyhua
 * @date 2016/11/23
 * @description 自定义生成model文档注释
 */
public class CustomCommentGenerator extends DefaultCommentGenerator {

    /**
     * 添加字段注释
     * @param field 字段
     * @param introspectedTable 表
     * @param introspectedColumn 列
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (StringUtils.isNotBlank(introspectedColumn.getRemarks())) {
            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
            addJavadocTag(field, false);
            field.addJavaDocLine(" */");
        }
    }

}
