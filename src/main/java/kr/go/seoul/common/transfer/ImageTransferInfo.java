package kr.go.seoul.common.transfer;


import kr.go.seoul.common.model.vo.ImageSize;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;

public class ImageTransferInfo extends FileTransferInfo {
    /// FIELDs
    private HashMap<String, ImageSize> imageSizes;
    private final ImageSize originalSize;
    private final ImageSize maxSize;

    /// CONSTRUCTORs

    /**
     * ImageTransferInfo를 생성하기 위한 생성자
     * @param path 이미지 파일의 폴더
     * @param fileName 이미지 파일 이름(확장자 포함)
     * @author 신현진
     */
    public ImageTransferInfo(String path, String fileName) {
        super(path, fileName);
        this.imageSizes = new HashMap<>();
        this.originalSize = ImageTransferInfo.getImageSize(absolutePath);
        this.maxSize = new ImageSize(0, 0);
    }
    /**
     * ImageTransferInfo를 생성하기 위한 생성자
     * @param path 이미지 파일의 폴더
     * @param fileName 이미지 파일 이름(확장자 포함)
     * @author 신현진
     */
    public ImageTransferInfo(String path, String fileName, ImageSize maxSize) {
        super(path, fileName);
        this.imageSizes = new HashMap<>();
        this.originalSize = ImageTransferInfo.getImageSize(absolutePath);
        this.maxSize = maxSize;
    }

    /**
     * ImageTransferInfo를 생성하기 위한 생성자
     * @param originalFileName 원본 파일명
     * @param fileName 파일명
     * @param absolutePath 파일 전체경로 
     * @param fileSize 파일크기
     * @param imageSizes 관련된 이미지 파일의 크기 정보
     * @author 신현진
     */
    public ImageTransferInfo(String originalFileName,
                             String fileName,
                             String absolutePath,
                             long fileSize,
                             HashMap<String, ImageSize> imageSizes) {
        super(originalFileName, fileName, absolutePath, fileSize);
        this.imageSizes = imageSizes;
        this.originalSize = ImageTransferInfo.getImageSize(absolutePath);
        this.maxSize = new ImageSize(0, 0);
    }

    /// GETTERs
    public HashMap<String, ImageSize> getImageSizes() { return imageSizes; }
    public ImageSize getOriginalSize() { return this.originalSize; }

    /// SETTERs
    public void setImageSizes(HashMap<String, ImageSize> imageSizes) { this.imageSizes = imageSizes; }

    /// METHODs
    public static ImageSize getImageSize(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) return null;

        BufferedImage img = null;
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
            return null;
        }
        return new ImageSize(img.getWidth(), img.getHeight());
    }

    /**
     * 이미지를 특정 크기로 변경하여 복사하는 메서드
     * @param targetDir 이동할 디렉토리
     * @param filename 변경할 파일명. 확장자는 그대로 유지
     * @param imageSize 변경할 크기
     * @return 변경된 파일 정보
     * @throws IOException
     * @author 신현진
     */
    public ImageTransferInfo resizeCopyTo(String targetDir, String filename, ImageSize imageSize) throws IOException {
        File file = new File(absolutePath);
        if (!file.exists()) throw new FileNotFoundException(absolutePath);

        String ext = file.getName().substring(file.getName().lastIndexOf('.') + 1);                                     // 파일 확장자
        BufferedImage img = ImageIO.read(file);                                                                         // 이미지 읽기
        int originalWidth = img.getWidth();
        int originalHeight = img.getHeight();

        int newHeight = (originalHeight * imageSize.getWidth()) / originalWidth;                                        // 기존 비율 유지
        newHeight = imageSize.getHeight() == 0 ? newHeight : imageSize.getHeight();                                     // 설정된 크기가 0일 경우 원본 비율 유지
        
        // 스케일 변경
        Image scaleImg = img.getScaledInstance(imageSize.getWidth(), newHeight, Image.SCALE_DEFAULT);
        BufferedImage newImage = new BufferedImage(imageSize.getWidth(), newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = newImage.getGraphics();
        graphics.drawImage(scaleImg, 0, 0, null);
        graphics.dispose();

        // 경로 생성
        File folder = new File(targetDir);
        if (!folder.exists()) folder.mkdirs();

        // 저장
        this.fileName = filename + '.' + ext;
        File newFile = new File(targetDir + '\\' + this.fileName);
        if (newFile.exists()) throw new FileAlreadyExistsException(newFile.getAbsolutePath());                          // 중복 파일 존재할 경우 예외

        ImageIO.write(newImage, ext.toLowerCase(), newFile);                                                            // 이미지 저장
//        this.absolutePath = newFile.getAbsolutePath();
        return this;
    }

    /**
     * 파일을 이동하는 메서드
     * @param targetDir 이동할 디렉토리
     * @param filename 변경할 파일명 - 확장자 포함
     * @return 이동된 현재 파일(Channing)
     * @throws IOException
     * @author 신현진
     */
    @Override
    public ImageTransferInfo moveTo(String targetDir, String filename) throws IOException {
        File originFile = new File(absolutePath);
        if (!originFile.exists()) throw new FileNotFoundException(absolutePath);                                        // 기존 파일이 없을 경우 예외

        String ext = originFile.getName().substring(originFile.getName().lastIndexOf('.') + 1);                         // 파일 확장자
        File newFile = new File(targetDir + '\\' + filename + '.' + ext);
        if (newFile.exists()) throw new FileAlreadyExistsException(newFile.getPath());                                  // 중복 파일이 존재할 경우 예외

        File dir = new File(targetDir);
        if (!dir.exists()) dir.mkdirs();                                                                                // 디렉토리가 없을 경우 디렉토리 생성

        originFile.renameTo(newFile);
        this.fileName = filename;
        this.absolutePath = newFile.getAbsolutePath();
        return this;
    }

    /**
     * 이미지를 지정된 모든 크기로 변경하여 복사하는 메서드
     * @param targetDir 이동할 디렉토리
     * @param filename 변경할 파일명(filename_key). 확장자는 그대로 유지
     * @return 변경된 파일정보
     * @throws IOException
     * @author 신현진
     */
    public ImageTransferInfo resizeMoveToAll(String targetDir, String filename) throws IOException {
        // size list
        for (String key : imageSizes.keySet())
        {
            resizeCopyTo(targetDir, filename + '_' + key, imageSizes.get(key));
        }
        // original - max
        if (originalSize.getWidth() > maxSize.getWidth() ||
            originalSize.getHeight() > maxSize.getHeight()) {
            resizeCopyTo(targetDir, filename + "_max", maxSize);
        }

        // TODO: DEBUG
        System.err.println(this);

        return this.moveTo(targetDir, filename);
    }

    ///


    @Override
    public String toString() {
        return "ImageTransferInfo{" +
                "원본 파일명='" + originalFileName + '\'' +
                ", 파일이름='" + fileName + '\'' +
                ", 파일전체경로='" + absolutePath + '\'' +
                ", 파일크기=" + fileSize +
                ", 이미지크기=" + imageSizes +
                ", 원본 이미지 크기=" + originalSize +
                ", 최대 크기=" + maxSize +
                '}';
    }
}
