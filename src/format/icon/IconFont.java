package format.icon;

import java.io.InputStream;

public interface IconFont {
    String getFontFamily();

    InputStream getFontInputStream();
}
