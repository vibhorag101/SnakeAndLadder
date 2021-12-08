package assets;

import java.net.URISyntaxException;
import java.util.Objects;

public class resourceLoader {
    String returnPath;
    public String getPath(String pathGiven){
        returnPath = Objects.requireNonNull(getClass().getResource(pathGiven)).toString();
        return(returnPath);
    }
}
