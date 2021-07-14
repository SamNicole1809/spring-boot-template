package cn.sam.template.commons;

import cn.sam.template.execption.MyFormatException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

public class MyOss {

    private final String endpoint;
    private final String accessKey;
    private final String accessSecret;
    private final String bucket;

    public MyOss(String endpoint, String accessKey, String accessSecret, String bucket) {
        this.endpoint = endpoint;
        this.accessKey = accessKey;
        this.accessSecret = accessSecret;
        this.bucket = bucket;
    }

    /**
     * upload file to oss
     * @param inputStream file stream
     * @param fileUrl file url in oss, such as path/filename.png
     */
    public void uploadStream(InputStream inputStream, String fileUrl) {
        OSS oss = new OSSClientBuilder().build(endpoint, accessKey, accessSecret);
        PutObjectRequest request = new PutObjectRequest(bucket, fileUrl, inputStream);
        oss.putObject(request);
        oss.shutdown();
    }

    /**
     * use this method will return a authorized url of file
     * can only be used in one hour
     * @param fileUrl file url in oss
     * @return authorized fileUrl
     */
    public String generateOneHourUrl(String fileUrl) {
        OSS oss = new OSSClientBuilder().build(endpoint, accessKey, accessSecret);
        return oss.generatePresignedUrl(this.bucket, fileUrl, MyDate.getOneHourLater()).toString();
    }

    /**
     * you can upload file to a document in oss
     * String.format("[document path]/%s.%s", UUID.randomUUID().toString(), fileSplitArr[1]);
     */
    public String createFileUrl(MultipartFile file) throws MyFormatException {
        String fileName = file.getOriginalFilename();
        if (fileName == null) {
            throw new MyFormatException();
        }
        String[] fileSplitArr = fileName.split("\\.");
        if (fileSplitArr.length != 2) {
            throw new MyFormatException();
        }
        return String.format("%s.%s", UUID.randomUUID().toString(), fileSplitArr[1]);
    }

}
