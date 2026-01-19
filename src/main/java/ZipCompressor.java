public class ZipCompressor implements FileCompressor{
    @Override
    public void compress(String fileName) {
        System.out.println(fileName + " ZIP compressed");
    }

    @Override
    public String getExtension() {
        return "zip";
    }
}
