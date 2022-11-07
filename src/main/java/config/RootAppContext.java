package config;


import domain.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.context.annotation.SessionScope;

// 프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
@ComponentScan(basePackages = "dao")
@ComponentScan(basePackages = "service")
@MapperScan(basePackages = "mapper")
@PropertySource("/WEB-INF/properties/db.properties")
public class RootAppContext {

    @Bean("loginUserBean")
    @SessionScope
    public User loginUserBean() {
        return new User();
    }

    @Value("${db.classname}")
    private String db_classname;// = "oracle.jdbc.OracleDriver";

    @Value("${db.url}")
    private String db_url;// = "jdbc:oracle:thin:@localhost:1521:xe";

    @Value("${db.username}")
    private String db_username;// = "scott";

    @Value("${db.password}")
    private String db_password;// = "tiger";

    // 데이터베이스 접속 정보 관리
    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource source = new BasicDataSource();
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

}