package assets;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class resourceLoader {
    String returnPath;

    public String getPath(String pathGiven) {
        returnPath = Objects.requireNonNull(getClass().getResource(pathGiven)).toString();
        return (returnPath);
    }

    public URL getURL(String pathGiven) throws URISyntaxException, MalformedURLException {
        return (Objects.requireNonNull(getClass().getResource(pathGiven)).toURI().toURL());
    }
}
