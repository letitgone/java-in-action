import java.io.*;public class ABCAppearsTest {    private static final String regex = "";    public static void main(String[] args) {        File file = new File("F:\\development_environment\\IdeaProjects\\java-in-action\\src\\main\\resources\\Article");        InputStream in = null;        int i;        String article = "";        try {             in = new FileInputStream(file);             while(((i = in.read()) != -1)){                 String s = String.valueOf((char)i);                 article += s;             }        } catch (FileNotFoundException e) {            e.printStackTrace();        } catch (IOException e) {            e.printStackTrace();        }        System.out.println(article);    }}