package config;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.*;

// Spring MVC 프로젝트에 관련된 설정을 하는 클래스
@Configuration
// Controller 어노테이션이 셋팅되어 있는 클래스를 Controller로 등록한다.
@EnableWebMvc
//스캔할 패키지를 지정한다.
//@ComponentScan(basePackages = "kr.co.ezenac.dao")
//@ComponentScan(basePackages = "kr.co.ezenac.service")
//@ComponentScan(basePackages = "kr.co.ezenac.beans")
@ComponentScan(basePackages = "controller")
@PropertySource("/WEB-INF/propeties/db.properties")
public class ServletAppContext implements WebMvcConfigurer {

    @Value("${db.classname}")
    private String db_classname;// = "oracle.jdbc.OracleDriver";

    @Value("${db.url}")
    private String db_url;// = "jdbc:oracle:thin:@localhost:1521:xe";

    @Value("${db.username}")
    private String db_username;// = "scott";

    @Value("${db.password}")
    private String db_password;// = "tiger";

    // Controller의 메서드가 반환하는 jsp의 이름 앞뒤에 확장자를 붙여주도록 한다.
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        WebMvcConfigurer.super.configureViewResolvers(registry);
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    // 정적 파일의 경로를 매핑한다.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }

    // 데이터베이스 접속 정보 관리
    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource source = new BasicDataSource();
        System.out.println(db_classname);
        System.out.println(db_url);
        System.out.println(db_username);
        System.out.println(db_password);
        source.setDriverClassName(db_classname);
        source.setUrl(db_url);
        source.setUsername(db_username);
        source.setPassword(db_password);

        return source;
    }

    // 쿼리문과 접속 관리하는 객체
    @Bean
    public SqlSessionFactory factory(BasicDataSource source) throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(source);
        SqlSessionFactory factory = factoryBean.getObject();
        return factory;
    }

/*
    // 쿼리문 실행을 위한 객체
    @Bean
    public MapperFactoryBean<TopMenuMapper> getTopMenuMapper(SqlSessionFactory factory) throws Exception{
        MapperFactoryBean<TopMenuMapper> factoryBean = new MapperFactoryBean<>(TopMenuMapper.class);
        factoryBean.setSqlSessionFactory(factory);
        return factoryBean;
    }
*/
/*

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        WebMvcConfigurer.super.addInterceptors(registry);

        TopMenuInterceptor topMenuInterceptor = new TopMenuInterceptor(topMenuService);

        InterceptorRegistration reg1 = registry.addInterceptor(topMenuInterceptor);
        reg1.addPathPatterns("/**");

    }
*/
/*

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
        res.setBasenames("/WEB-INF/properties/error_message");
        return res;
    }
*/

    //@PropertySource 를 붙여 프로퍼티 파일을 로드하려면 정의해야 하는 @Bean
    //특이점은 스프링 버전 5.0.5.RELEASE에서 이 Bean을 설정하지 않아도 정상적으로 동작
    //ReloadableResourceBundleMessageSource을 등록했을시 @Value가 properties 값을 제대로 불러오지 못했고, 이 빈을 등록한 후 정상 동작
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}