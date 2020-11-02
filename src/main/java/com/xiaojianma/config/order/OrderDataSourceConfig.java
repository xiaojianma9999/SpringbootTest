package com.xiaojianma.config.order;

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
@MapperScan(basePackages = "com.xiaojianma.order.mapper", sqlSessionTemplateRef = "orderSqlSessionTemplate")
public class OrderDataSourceConfig {

    @Bean(name = "orderDataSource")
    public DataSource orderDataSource(OrderConfig orderConfig) throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(orderConfig.getUrl());
        mysqlXADataSource.setUser(orderConfig.getUsername());
        mysqlXADataSource.setPassword(orderConfig.getPassword());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSourceBean = new AtomikosDataSourceBean();
        xaDataSourceBean.setXaDataSource(mysqlXADataSource);
        xaDataSourceBean.setUniqueResourceName(orderConfig.getUniqueResourceName());
        xaDataSourceBean.setMaxPoolSize(orderConfig.getMaxPoolSize());
        xaDataSourceBean.setMinPoolSize(orderConfig.getMinPoolSize());
        xaDataSourceBean.setMaxLifetime(orderConfig.getMaxLiftTime());
        xaDataSourceBean.setBorrowConnectionTimeout(orderConfig.getBorrowConnectionTimeout());
        xaDataSourceBean.setLoginTimeout(orderConfig.getLoginTimeout());
        xaDataSourceBean.setMaintenanceInterval(orderConfig.getMaintenanceInterval());
        xaDataSourceBean.setMaxIdleTime(orderConfig.getMaxIdleTime());
        xaDataSourceBean.setTestQuery(orderConfig.getTestQuery());
        return xaDataSourceBean;
    }

    @Bean(name = "orderSqlSessionFactory")
    public SqlSessionFactory orderSqlSessionFactory(@Qualifier("orderDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

//    @Bean(name = "orderTransactionManager")
//    public DataSourceTransactionManager orderTransactionManager(@Qualifier("orderDataSource") DataSource dataSource) throws Exception {
//        return new DataSourceTransactionManager(dataSource);
//    }

    @Bean(name = "orderSqlSessionTemplate")
    public SqlSessionTemplate orderSqlSessionTemplate(@Qualifier("orderSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

