import java.util.Hashtable;

public class FileTypeHashtable {
    private final Hashtable<String, String> fileTypeDescriptions;
    private final Hashtable<String, String> fileTypeVulnerabilities;

    public FileTypeHashtable() {
        fileTypeDescriptions = new Hashtable<>();
        fileTypeVulnerabilities = new Hashtable<>();

        // Populate the Hashtable with file types and descriptions
        fileTypeDescriptions.put("txt", "Text File");
        fileTypeDescriptions.put("jpg", "JPEG Image");
        fileTypeDescriptions.put("pdf", "PDF Document");
        fileTypeDescriptions.put("doc", "Microsoft Word Document");
        fileTypeDescriptions.put("xls", "Microsoft Excel Spreadsheet");
        fileTypeDescriptions.put("java", "Java Source Code");
        fileTypeDescriptions.put("html", "HTML Document");
        fileTypeDescriptions.put("png", "PNG Image");
        fileTypeDescriptions.put("mp3", "MP3 Audio File");
        fileTypeDescriptions.put("ppt", "Microsoft PowerPoint Presentation");
        fileTypeDescriptions.put("csv", "Comma-Separated Values File");
        fileTypeDescriptions.put("json", "JSON Data File");
        fileTypeDescriptions.put("gif", "GIF Image");
        fileTypeDescriptions.put("zip", "ZIP Archive");
        fileTypeDescriptions.put("xml", "XML Document");
        fileTypeDescriptions.put("mp4", "MP4 Video File");
        fileTypeDescriptions.put("py", "Python Source Code");

        // Populate the Hashtable with file types and vulnerabilities
        fileTypeVulnerabilities.put("txt", "Can be used as a carrier for malware or execute malicious scripts in specific applications.");
        fileTypeVulnerabilities.put("jpg", "Susceptible to 'malware camouflaging' where malicious code can be embedded in image files.");
        fileTypeVulnerabilities.put("pdf", "May contain various vulnerabilities like malicious code execution, embedded malware, and data exfiltration.");
        fileTypeVulnerabilities.put("doc", "Can carry macro viruses and scripting vulnerabilities.");
        fileTypeVulnerabilities.put("xls", "Similar to Word documents, Excel files can carry macro viruses and scripting vulnerabilities.");
        fileTypeVulnerabilities.put("java", "Contains potential security vulnerabilities like code injection and insecure dependencies.");
        fileTypeVulnerabilities.put("html", "Vulnerable to Cross-Site Scripting (XSS) and SQL injection.");
        fileTypeVulnerabilities.put("png", "While generally considered safe, they could be used to hide malicious data within the image.");
        fileTypeVulnerabilities.put("mp3", "Can potentially carry malware in the form of hidden executable code or embedded malware.");
        fileTypeVulnerabilities.put("ppt", "Can carry macro viruses, scripting vulnerabilities, and potential data manipulation.");
        fileTypeVulnerabilities.put("csv", "Prone to CSV injection attacks, especially when interpreted and processed without proper input validation.");
        fileTypeVulnerabilities.put("json", "Susceptible to JSON injection attacks and data tampering.");
        fileTypeVulnerabilities.put("gif", "Similar to other image formats, GIFs can carry malware or be used for hiding malicious scripts through steganography.");
        fileTypeVulnerabilities.put("zip", "May contain threats like 'zip bomb', malware delivery, or password cracking.");
        fileTypeVulnerabilities.put("xml", "Vulnerable to XML Injection, XXE attacks, and other web-related security issues.");
        fileTypeVulnerabilities.put("mp4", "Susceptible to malware embedded within the file, enabling potential code execution upon opening.");
        fileTypeVulnerabilities.put("py", "Contains security vulnerabilities like code injection and insecure dependencies if not managed securely.");

    }

    public String getFileDescription(String fileType) {
        return fileTypeDescriptions.get(fileType);
    }

    public String getFileVulnerabilities(String fileType) {
        return fileTypeVulnerabilities.get(fileType);
    }

    public void printFileTypeDescription(String fileType) {
        String description = getFileDescription(fileType);
        String vulnerabilities = getFileVulnerabilities(fileType);

        if (description != null) {
            System.out.println("File Type: " + fileType);
            System.out.println("Description: " + description);
            System.out.println("Vulnerabilities: " + vulnerabilities);
        } else {
            System.out.println("File type not found in the Hashtable.");
        }
    }

    // File type hashtable driver for testing
    public static void main(String[] args) {
        FileTypeHashtable fileTypeHashtable = new FileTypeHashtable();

        // Get and print the description and vulnerabilities for a specific file type
        String fileType = "pdf";
        fileTypeHashtable.printFileTypeDescription(fileType);
    }
}
