import java.util.ServiceLoader;

public class Derived {
    public static void main(String[] args) {
        ServiceLoader<FileCompressor> loader = ServiceLoader.load(FileCompressor.class);

        String desiredExtension = "rar";

        FileCompressor selectedProcessor = null;
        for (FileCompressor cp : loader) {
            if (cp.getExtension().equalsIgnoreCase(desiredExtension)) {
                selectedProcessor = cp;
                break;
            }
        }
        if (selectedProcessor != null) {
            selectedProcessor.compress("document.pdf");
        } else {
            System.out.println("Hata: " + desiredExtension + " için bir compressor bulunamadı!");
        }
    }
}
