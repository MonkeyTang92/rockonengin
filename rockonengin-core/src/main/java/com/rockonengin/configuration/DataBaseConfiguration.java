package com.rockonengin.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by tangfan on 2017/12/03.
 */
@Configuration
@DependsOn({"springContextUtil"})
public class DataBaseConfiguration {

    public static DruidDataSource createDefaultDruidDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setMaxWait(60000);
        druidDataSource.setMaxActive(20);
        druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(0);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setConnectionProperties("druid.stat.slowSqlMillis=3000");
        druidDataSource.setValidationQuery("SELECT 'x'");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setFilters("stat,wall");

        return druidDataSource;
    }

    public static SqlSessionFactory createDefaultSqlSessionFactory(DataSource dataSource, String configLocation, String mapperLocation) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setConfigLocation(resolver.getResource(configLocation));
        factory.setMapperLocations(resolver.getResources(mapperLocation));

        return factory.getObject();
    }

    /**
     * 配置数据源
     */
    @Bean(name = "rockonenginDataSource")
    @ConfigurationProperties(prefix = "spring.dataSource")
    public DataSource getRockonenginDataSource() throws SQLException {
        return createDefaultDruidDataSource();
    }

    /**
     * 配置SqlSessionFactory
     */
    @Bean(name = "rockonenginSqlSessionFactory")
    public SqlSessionFactory getRockonenginSqlSessionFactory(@Qualifier("rockonenginDataSource") DataSource dataSource) throws Exception {
        String configLocation = "classpath:/mybatis/configuration.xml";
        String mapperLocation = "classpath*:/mybatis/mapper/com.rockonengin/*.xml";
        SqlSessionFactory sqlSessionFactory = createDefaultSqlSessionFactory(dataSource, configLocation, mapperLocation);
        return sqlSessionFactory;
    }

    /**
     * mybatis扫描Mapper
     */
    @Bean(name = "rockonenginMapperScannerConfigurer")
    public MapperScannerConfigurer getRockonenginMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("rockonenginSqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.rockonengin.dao.rockonengin");
        return mapperScannerConfigurer;
    }


    /**
     * 配置事务管理器
     */
//    @Bean
//    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
