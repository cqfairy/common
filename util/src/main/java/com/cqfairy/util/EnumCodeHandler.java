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
public class EnumCodeHandler extends BaseTypeHandler<EnumCodeSupper> {

    private Class<EnumCodeSupper> enumCodeSupperClass ;


    public EnumCodeHandler(Class<EnumCodeSupper> enumSupperClass){
        if(enumSupperClass == null)
            throw new IllegalArgumentException("enumSupperClass cannot be null");
        this.enumCodeSupperClass = enumSupperClass ;
    }

    private EnumCodeSupper convert(String code){
        EnumCodeSupper [] enumSuppers = enumCodeSupperClass.getEnumConstants();
        for (EnumCodeSupper ecs : enumSuppers){
            if(ecs.getCode().equals(code)){
                return ecs ;
            }
        }
        return null ;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, EnumCodeSupper enumCodeSupper, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,enumCodeSupper.getCode());
    }

    @Override
    public EnumCodeSupper getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return convert(resultSet.getString(s));
    }

    @Override
    public EnumCodeSupper getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return convert(resultSet.getString(i));
    }

    @Override
    public EnumCodeSupper getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return convert(callableStatement.getString(i));
    }
}
