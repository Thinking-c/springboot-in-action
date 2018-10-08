package com.thinking.springbootincation.common.exception.file;

import org.apache.commons.fileupload.FileUploadException;

/**
 * @Author：caoj
 * @Description： 文件超长 异常
 * @Date：Created in 2018/7/25
 */
public class FileNameLengthLimitExceededException extends FileUploadException {

    private static final long serialVersionUID = 1L;
    private int length;
    private int maxLength;
    private String filename;

    public FileNameLengthLimitExceededException(String filename, int length, int maxLength) {
        super("file name : [" + filename + "], length : [" + length + "], max length : [" + maxLength + "]");
        this.length = length;
        this.maxLength = maxLength;
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public int getLength() {
        return length;
    }

    public int getMaxLength() {
        return maxLength;
    }

}
