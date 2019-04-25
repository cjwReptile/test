package spring.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: cjw
 * @Date: 2019/1/2 10:22
 * @Description:
 */
public interface Resource {

    InputStream getResource() throws IOException;

}
