package mapper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {

    private static SqlSessionFactory sqlSessionFactory = null;

    //私有构造方法，使该类不可创建新对象
    private SqlSessionFactoryUtils(){}

    /**
     * @return sql session 工厂
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory != null){
        	return sqlSessionFactory;
        }
            //获取资源文件流
        String resource = "mybatis-config.xml";
        
        try {	            
        	InputStream inputstream = Resources.getResourceAsStream(resource);	            
        	sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);	        
        } catch (IOException e) {	            
        	e.printStackTrace();	            
        	return null; 
        }
        return sqlSessionFactory;
    }
    public static SqlSession openSqlSession(){
    	if(sqlSessionFactory == null){
    		getSqlSessionFactory();
    	}
		return sqlSessionFactory.openSession();
    	
    }
}
