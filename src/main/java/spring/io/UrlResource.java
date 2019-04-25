package spring.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Auther: cjw
 * @Date: 2019/1/2 10:24
 * @Description:
 */
public class UrlResource implements Resource{



    private URL url;

    UrlResource(URL url){
        this.url = url;
    }

    @Override
    public InputStream getResource() throws IOException {
        URLConnection urlConnection = url.openConnection();
        return urlConnection.getInputStream();
    }
}
