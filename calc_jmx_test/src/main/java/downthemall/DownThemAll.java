package downthemall;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by sam on 11/16/16.
 */
public class DownThemAll implements DownThemAllMBean {
    private String url;
    private String filename;

    public DownThemAll(String url, String filename) {
        this.url = url;
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void getFile(String url, String filename) throws IOException {
        ReadableByteChannel byteChannel = Channels.newChannel(new URL(url).openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        fileOutputStream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
    }
}
