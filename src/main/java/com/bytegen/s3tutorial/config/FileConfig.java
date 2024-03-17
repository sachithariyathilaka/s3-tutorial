package com.bytegen.s3tutorial.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @class FileConfig
 * @description This class is used to set up basic configurations for AmazonS3
 *
 * @author Sachith Ariyathilaka
 * @version 1.0.0
 * @date 2024/03/17
 */
@Configuration
public class FileConfig {

    @Value("${aws.s3.access.key}")
    private String accessKey;

    @Value("${aws.s3.secret.key}")
    private String secretKey;

    @Value("${aws.s3.region.name}")
    private String regionName;

    /**
     * @method amazonS3
     * @description This method used to initiate bean for AmazonS3
     *
     * @return AmazonS3
     */
    @Bean
    public AmazonS3 amazonS3() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(awsCredentials);
        return AmazonS3ClientBuilder.standard().withCredentials(awsStaticCredentialsProvider).withRegion(regionName).build();
    }
}