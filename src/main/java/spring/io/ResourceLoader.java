package spring.io;

import java.net.URL;

/**
 * @Auther: cjw
 * @Date: 2019/1/2 10:29
 * @Description:
 */
public class ResourceLoader {



    /**
     *
     * 功能描述: 返回url resource
     * @param:
     * @return:
     * @auther: cjw
     * @date: 2019/1/2 10:33
     */
    public Resource getUrlResource(String location){
        URL url = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(url);
    }

}
