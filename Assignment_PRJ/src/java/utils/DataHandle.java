package utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Admin
 */
public class DataHandle {
    public void copyFile(String fileName, Part filePart, String savePath) throws IOException {

        FileOutputStream outputStream = null;
        InputStream fileContent = null;

        try {
            outputStream = new FileOutputStream(new File(savePath + File.separator + fileName));
            // Creating a new file with file path and the file name
            fileContent = filePart.getInputStream();
            // Getting the input stream
            int readBytes = 0;
            byte[] readArray = new byte[1024];
            // Initializing a byte array with size 1024

            while ((readBytes = fileContent.read(readArray)) != -1) {
                outputStream.write(readArray, 0, readBytes);
            } // This loop will write the contents of the byte array unitl the end to the output stream
        } catch (Exception ex) {
            System.out.println("Error Writing File: " + ex);
        } finally {
            if (outputStream != null) {
                outputStream.close();
                // Closing the output stream
            }
            if (fileContent != null) {
                fileContent.close();
                // Closing the input stream
            }
        }
    }

//returns a file with a unique name in case an image with the same name 
//already exist in the folder
    private static File getUniqueFilename(File file) {
        String baseName = FilenameUtils.getBaseName(file.getName());
        String extension = FilenameUtils.getExtension(file.getName());
        int counter = 1;
        while (file.exists()) {
            file = new File(file.getParent(), baseName + "-" + (counter++) + "." + extension);
        }
        return file;
    }
    public String getValue(Part part) throws IOException {
        if(part == null){
            return null;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
        StringBuilder value = new StringBuilder();
        char[] buffer = new char[1024];
        for (int length = 0; (length = reader.read(buffer)) > 0;) {
            value.append(buffer, 0, length);
        }
        return value.toString();
    }
}
