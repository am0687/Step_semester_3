public class FileValidator {

    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
    }

    /**
     * Validates if a filename ends with an accepted extension (pdf, docx, zip).
     */
    public static String validateFileExtension(String filename) {
        // Guard clause for null or files with no extension
        if (filename == null || filename.lastIndexOf('.') == -1) {
            return "Rejected — invalid file type";
        }

        // Find the index of the last dot
        int lastDotIndex = filename.lastIndexOf('.');
        
        // Extract the extension (everything after the last dot)
        String extension = filename.substring(lastDotIndex + 1);

        // Compare case-insensitively against accepted extensions
        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }
}