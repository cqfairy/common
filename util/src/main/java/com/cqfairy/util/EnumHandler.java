package com.cqfairy.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * [概 要] 描述类 <br/>
 * [环 境] J2SE 1.7
 *
 * @author 研发部-张光富
 * @version 1.0
 */
public class EnumHandler extends BaseTypeHandler<EnumSupper> {

    private Class<EnumSupper> enumSupperClass ;


    public EnumHandler(Class<EnumSupper> enumSupperClass){
        if(enumSupperClass == null)
            throw new IllegalArgumentException("enumSupperClass cannot be null");
        this.enumSupperClass = enumSupperClass ;
    }

    private EnumSupper convert(int value){
        EnumSupper [] enumSuppers = enumSupperClass.getEnumConstants();
        for (EnumSupper es : enumSuppers){
            if(es.getValue() == value){
                return es ;
            }
        }
        return null ;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, EnumSupper enumSupper, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,enumSupper.getValue());
    }

    @Override
    public EnumSupper getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return convert(resultSet.getInt(s));
    }

    @Override
    public EnumSupper getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return convert(resultSet.getInt(i));
    }

    @Override
    public EnumSupper getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return convert(callableStatement.getInt(i));
    }
}
