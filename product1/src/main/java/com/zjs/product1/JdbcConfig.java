package com.zjs.product1;

import com.alibaba.druid.filter.Filter;
import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author zjs
 * @description 功能描述
 * @create 2023/3/22 9:53
 */
@Configuration
@ComponentScan({
        "com.zjs.product1.**.controller",
        "com.zjs.product1.**.service"
})
@MapperScan({"com.zjs.product1.dao.*","com.zjs.product1.dao.*.ext"}) //dao层类所在包
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
public class JdbcConfig {
    /**自动注入数据库配置类*/
    @Autowired
    private DBProperties db;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(db.getDriverClassName());
        dataSource.setUrl(db.getUrl());
        dataSource.setUsername(db.getUsername());
        dataSource.setPassword(db.getPassword());
        // 配置初始化大小、最小、最大
        dataSource.setInitialSize(Integer.valueOf(db.getInitialSize()));
        dataSource.setMinIdle(Integer.valueOf(db.getMinIdle()));
        dataSource.setMaxActive(Integer.valueOf(db.getMaxActive()));
        // 配置获取连接等待超时的时间
        dataSource.setMaxWait(Long.valueOf(db.getMaxWait()));
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        //配置一个连接在池中最小生存的时间，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis(300000);

        //打开PSCache，并且指定每个连接上PSCache的大小
        //dataSource.setPoolPreparedStatements(true);
        //dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        //禁用对于长时间不使用的连接强制关闭的功能
        dataSource.setRemoveAbandoned(false);

        try {
            WallConfig wc=new WallConfig();
            wc.setMultiStatementAllow(true);
            WallFilter wf=new WallFilter();
            wf.setConfig(wc);
            List<Filter> filters = new ArrayList<>();
            filters.add(wf);
            dataSource.setFilters("stat,wall");
            dataSource.setProxyFilters(filters);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(){
        SqlSessionFactory factory = null;
        try {
            MybatisSqlSessionFactoryBean  sessionFactoryBean = new MybatisSqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(dataSource());

            //读取mybatis各个类的 *mapper.xml文件,这个地方的locationPattern一定要写对，不然会找不到输出到target\classes\mybatis\*目录下的mapper.xml文件
            String locationPattern = "classpath*:/mybatis/*/*.xml";
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources(locationPattern);
            List<Resource> filterResourceList = new ArrayList<Resource>();
            List<String> fileNameList = new ArrayList<String>();
            for (int i=0; i<resources.length; i++){
                Resource resource = resources[i];
                if(!fileNameList.contains(resource.getFilename())){
                    filterResourceList.add(resource);
                    fileNameList.add(resource.getFilename());
                }
            }

            Resource[] result = new Resource[filterResourceList.size()];
            sessionFactoryBean.setMapperLocations(filterResourceList.toArray(result));

            factory = (SqlSessionFactory) sessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  factory;
    }

    @Bean
    public AsyncConfigurerSupport configurerSupport(){
        return new AsyncConfigurerSupport(){
            @Override
            public Executor getAsyncExecutor() {
                ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
                executor.setCorePoolSize(10);
                executor.setMaxPoolSize(20);
                executor.setQueueCapacity(50000);
                executor.setThreadNamePrefix("DocThreadPool");
                executor.initialize();
                return executor;

            }

            @Override
            public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
                return super.getAsyncUncaughtExceptionHandler();
            }
        };
    }
}
