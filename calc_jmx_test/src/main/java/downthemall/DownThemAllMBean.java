package downthemall;

import java.io.IOException;

/**
 * Created by sam on 11/16/16.
 */
public interface DownThemAllMBean {
    String getUrl();

    void setUrl(String url);

    String getFilename();

    void setFilename(String filename);

    void getFile(String url, String filename) throws IOException;
}
