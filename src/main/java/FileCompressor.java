// Bu sizin "kontratınızdır". Uygulamanız sadece bunu bilir.
public interface FileCompressor {
    void compress(String fileName);
    String getExtension(); // .zip, .rar vb.
}
