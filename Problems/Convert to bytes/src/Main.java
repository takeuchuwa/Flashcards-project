import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        int read = inputStream.read();
        while (read != -1) {
            System.out.print(read);
            read = inputStream.read();
        }
    }
}