package mavenTestNGHomework;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class MavenTest {

    public static void main(String[] args) throws IOException {
        String asciiArt = FigletFont.convertOneLine("Alīna Platonova");
        System.out.println(asciiArt);
    }

}
