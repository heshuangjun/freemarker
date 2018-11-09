package cn.itcast.demo;

import cn.itcast.domain.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author heshuangjun
 * @date 2018-11-09 14:00
 */
public class FreemarkerTest {

    public static void main(String[] args) throws IOException, TemplateException {

        //第一步:创建一个Configuration对象.构造方法的参数就是freemarker的版本号
        Configuration configuration = new Configuration(Configuration.getVersion());

        //第二步:设置模板文件的路径
        configuration.setDirectoryForTemplateLoading(new File("/Users/heshuangjun/IDEA_workspace01/freeMarker_Demo/src/main/resources"));

        //第三步:设置字符集编码utf-8
        configuration.setDefaultEncoding("utf-8");

        //第四步:加载一个模板,创建一个模板对象
        Template template = configuration.getTemplate("test.ftl");

        //第五步:组装数据,用Map组装
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Tino大帅哥");
        map.put("age", 19);

        List<User> userList = new ArrayList<User>();
        for (int i = 1; i <= 5; i++) {
            User user = new User();
            user.setId(i);
            user.setName("款式,型号: " + i);
            userList.add(user);
        }
        map.put("userList", userList);

        //第六步:组装一个输出流,达到结果是为了生成一个html页面
        Writer out = new FileWriter("/Users/heshuangjun/IDEA_workspace01/freeMarker_Demo/src/main/resources/test1.html");

        //第七步:调用模板对象,输出文件
        template.process(map, out);

        //第八步:关闭流
        out.close();

        /**
         * 这是关于freemarker入门小demo的测试
         */
    }
}
