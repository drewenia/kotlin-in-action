public class RarCompressor implements FileCompressor{
    @Override
    public void compress(String fileName) {
        System.out.println(fileName + " RAR compressed");
    }

    @Override
    public String getExtension() {
        return "rar";
    }
}
