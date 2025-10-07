package com.ShopSphere.ShopSphere.service;  // Defines the package location of this service class

import org.springframework.stereotype.Service;  // Imports Service annotation to mark this class as a Spring service
import org.springframework.web.multipart.MultipartFile;  // Imports MultipartFile to handle uploaded files

import java.io.File;  // Imports File class for file handling
import java.io.IOException;  // Imports IOException to handle file transfer errors

@Service  // Marks this class as a Spring-managed service component
public class FileStorageService {

    private final String UPLOAD_DIR = "uploads/";  // Folder where uploaded files will be stored

    /**
     * Constructor that ensures the upload directory exists.
     * If it does not exist, it creates it.
     */
    public FileStorageService() {
        File uploadDir = new File(UPLOAD_DIR);  // Creates a File object pointing to the uploads folder
        if (!uploadDir.exists()) {  // Checks if the folder doesn't exist
            uploadDir.mkdirs();  // Creates the uploads folder
        }
    }

    /**
     * Saves the given file to the uploads directory.
     *
     * @param file the uploaded file to be saved
     * @return the relative file path of the saved file
     * @throws RuntimeException if the file is empty or saving fails
     */
    public String saveFile(MultipartFile file) {
        if (file.isEmpty()) {  // Checks if the uploaded file is empty
            throw new RuntimeException("File is empty!");  // Throws error if file is empty
        }
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();  // Creates a unique file name using current time
        File destination = new File(UPLOAD_DIR + fileName);  // Creates file object for saving the file
        try {
            file.transferTo(destination);  // Transfers uploaded file to destination
        } catch (IOException e) {  // Handles IO exception
            throw new RuntimeException(e);  // Throws runtime exception if transfer fails
        }
        return "/" + UPLOAD_DIR + fileName;  // Returns path of saved file
    }

    /**
     * Deletes a file from the uploads directory.
     *
     * @param filePath the path of the file to delete
     * @return true if the file was successfully deleted, false otherwise
     */
    public boolean deleteFile(String filePath) {
        if (filePath == null || filePath.isEmpty())  // Checks if path is invalid
            return false;  // Returns false if no valid path

        File file = new File(filePath.replace("/", ""));  // Creates File object after removing slashes
        return file.exists() && file.delete();  // Deletes file if it exists and returns true if successful
    }

    /**
     * Gets the path of the uploads directory.
     *
     * @return the upload directory path
     */
    public String getUploadDir() {
        return UPLOAD_DIR;  // Returns upload folder path
    }

}
