package com.xiaojianma.config.member;


import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = {"com.xiaojianma.member.mapper"}, sqlSessionTemplateRef = "memberSqlSessionTemplate")
public class MemberDataSourceConfig {

    @Bean("memberDataSource")
    public DataSource memberDataSource(MemberConfig memberConfig) throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(memberConfig.getUrl());
        mysqlXADataSource.setUser(memberConfig.getUsername());
        mysqlXADataSource.setPassword(memberConfig.getPassword());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSourceBean = new AtomikosDataSourceBean();
        xaDataSourceBean.setXaDataSource(mysqlXADataSource);
        xaDataSourceBean.setUniqueResourceName(memberConfig.getUniqueResourceName());
        xaDataSourceBean.setMaxPoolSize(memberConfig.getMaxPoolSize());
        xaDataSourceBean.setMinPoolSize(memberConfig.getMinPoolSize());
        xaDataSourceBean.setMaxLifetime(memberConfig.getMaxLiftTime());
        xaDataSourceBean.setBorrowConnectionTimeout(memberConfig.getBorrowConnectionTimeout());
        xaDataSourceBean.setLoginTimeout(memberConfig.getLoginTimeout());
        xaDataSourceBean.setMaintenanceInterval(memberConfig.getMaintenanceInterval());
        xaDataSourceBean.setMaxIdleTime(memberConfig.getMaxIdleTime());
        xaDataSourceBean.setTestQuery(memberConfig.getTestQuery());
        return xaDataSourceBean;
    }

    @Bean("memberSqlSessionFactory")
    public SqlSessionFactory memberSqlSessionFactory(@Qualifier("memberDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }
//
//    @Bean(name = "memberTransactionManager")
//    public DataSourceTransactionManager memberTransactionManager(@Qualifier("memberDataSource") DataSource dataSource) throws Exception {
//        return new DataSourceTransactionManager(dataSource);
//    }

    @Bean("memberSqlSessionTemplate")
    public SqlSessionTemplate memberSqlSessionTemplate(@Qualifier("memberSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

