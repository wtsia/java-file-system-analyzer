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
        fileTypeVulnerabilities.put("pdf", "Malicious code execution, embedded malware, data exfiltration");
        fileTypeVulnerabilities.put("html", "Cross-Site Scripting (XSS), SQL injection");
        fileTypeVulnerabilities.put("java", "Security vulnerabilities in code, code injection");
        fileTypeVulnerabilities.put("json", "JSON Injection, data tampering");
        fileTypeVulnerabilities.put("zip", "Zip bomb, malware delivery");
        fileTypeVulnerabilities.put("xml", "XML Injection, XXE (XML External Entity) Attack");
        fileTypeVulnerabilities.put("py", "Code injection, insecure dependencies");
        fileTypeVulnerabilities.put("csv", "CSV Injection");

        // Add more file types and vulnerabilities as needed
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
