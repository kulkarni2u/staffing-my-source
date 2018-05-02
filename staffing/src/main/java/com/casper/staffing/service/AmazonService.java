package com.casper.staffing.service;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.casper.staffing.exception.BaseServiceException;

import java.io.InputStream;

public interface AmazonService {

    S3Object getS3Object(final String bucketName, final String key) throws BaseServiceException;

    boolean transferObject(final InputStream inputStream, final ObjectMetadata metadata, final String bucketName, final String key) throws BaseServiceException;

    String transferWithEncryption(final InputStream inputStream, final ObjectMetadata metadata, final String bucketName, final String key) throws BaseServiceException;
}

