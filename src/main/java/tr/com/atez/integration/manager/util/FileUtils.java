package tr.com.atez.integration.manager.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Slf4j
public abstract class FileUtils {

    public static InputStream convert(String classPathFileName){
        InputStream inputStream = null;
        try {
            ClassPathResource classPathResource = new ClassPathResource(classPathFileName);
            inputStream = classPathResource.getInputStream();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    public static File readFileFromFS(String filePath){
        FileSystemResource resource = new FileSystemResource(filePath);
        File file = resource.getFile();
        return file;
    }


    public static InputStream fileToInputStream(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        return new FileInputStream(file);
    }

    public static String fileToString(String filePath){
        Path path = Paths.get(filePath);
        String content = null;
        try {
            content = Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static InputStream file2InputStream(String filePath) {

        FileInputStream fis = null;
        try {
            File file = new File(filePath);
            fis = new FileInputStream(file);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fis;
    }

    public static byte[] file2Byte(String filePath) {
        byte[] fileBytes = null;
        FileInputStream fis = null;
        try {
            File file = new File(filePath);
            fis = new FileInputStream(file);
            fileBytes = new byte[(int) file.length()];
            fis.read(fileBytes);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileBytes;
    }

    public static File createFile(String savePath){
        File file = null;
        try {
            if(null == savePath){
                String fileType = "xlsx";
                String tempFileName = UUID.randomUUID().toString().replace("-", "").toLowerCase();
                    file =  File.createTempFile(tempFileName, "." + fileType);

                savePath = file.getPath();
            }else{
                file = new File(savePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }


    public static void writeFileToFs(File file, String fileStr){
        try {
            byte[] bytes = Base64.getDecoder().decode(fileStr.getBytes());
            Files.write(file.toPath(), bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static InputStream base64ToInputStream(String base64) {
        byte[] bytes = Base64.getDecoder().decode(base64.getBytes());
        ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
        return stream;
    }

    public static File convert(MultipartFile file) throws IOException {
        File convertFile = new File(file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convertFile);
        fos.write(file.getBytes());
        fos.close();
        return convertFile;
    }

    //  @Transactional(propagation = Propagation.REQUIRES_NEW)
    public static File saveFS(InputStream inputStream, String savePath, String fileName) throws IOException {
        /*
            String path = businessConfig.getSavePath().isEmpty()? null: businessConfig.getSavePath();
            File file = FileUtils.createFile(path);
            FileUtils.writeFileToFs(file, fileStr);
         */

        log.info("save file to file systems called...");
        OutputStream outputStream = null;
        File file = null;
        try {
            if(null == savePath){
                String format = ".xlsx";
                if(fileName != null){
                    String[] fileNameSplitted = fileName.split("\\.");
                    fileName = fileNameSplitted[0] + "_";
                    format = "." + fileNameSplitted[1];
                }
                file =  File.createTempFile(fileName, format);
                savePath = file.getPath();
            }else{
                file = new File(savePath);
            }
            outputStream = new FileOutputStream(file);
            int read;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            log.info("convert InputStream to file done, savePath is : {}", savePath);
            inputStream.reset();
        } catch (IOException e) {
            throw new IOException(e);
        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        log.info("file saved to file system: {}", file.getName());
        return file;
    }


}
