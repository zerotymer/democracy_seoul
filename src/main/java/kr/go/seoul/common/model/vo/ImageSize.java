package kr.go.seoul.common.model.vo;

public class ImageSize {
    /// FIELDs
    private int width = 0;
    private int height = 0;

    /// CONSTRUCTORs

    public ImageSize() {}
    public ImageSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public ImageSize(String size) {
        String[] sizes = size.split("x");
        this.width = Integer.parseInt(sizes[0]);
        this.height = Integer.parseInt(sizes[1]);
    }

    /// GETTERs
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    /// SETTERs
    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }

    /// METHODs

    @Override
    public String toString() { return String.format("%dx%d", width, height); }

    public ImageSize copyTo() { return new ImageSize(width, height); }
}
