import com.itheima.demo02_pojo.Brand;
import com.itheima.demo03_mapper.BrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BrandTest {
    @Test
    public void tsAll() throws IOException {
        String resource = "mybatis-config.xml";//指定核心配置文件名称
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.sAll();
        System.out.println(brands);
        sqlSession.close();
    }
    @Test
    public void tsOne() throws IOException {
        String resource = "mybatis-config.xml";//指定核心配置文件名称
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
       Brand brands = mapper.sOne(3);
        System.out.println(brands);
        sqlSession.close();
    }


    @Test
    public void selectbyCoon() throws IOException {
        String resource = "mybatis-config.xml";//指定核心配置文件名称
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectbyCoon("华", null);
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void insertTset() throws IOException {
        String resource = "mybatis-config.xml";//指定核心配置文件名称
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        Brand brand = new Brand(8,"金银花","云南",88,"去火",5);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int insert = mapper.insert(brand);
        System.out.println(insert);
        sqlSession.commit();
        sqlSession.close();
    }
}
