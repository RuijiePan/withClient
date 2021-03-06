package auto.newsky.coding.util;

import com.sun.imageio.plugins.jpeg.JPEGImageWriter;
import org.apache.log4j.Logger;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;

/**
 * Created by Administrator on 2016/9/22.
 */
public class ImgCompressUtil {

    /**
     * log4j
     */
    private final static Logger logger = Logger.getLogger(ImgCompressUtil.class
            .getName());

    /**
     * 图片压缩测试
     *
     * @param args
     */
    public static void main(String args[]) {
        // 图片url，压缩后的宽和高
        String url = "/upload/c671c57023e6eb83a1fa492babf0779e.jpg";
        int w = 700;
        int h = 500;
        //压缩后的图片路径
        String newName = UUIDUtil.createUUID();
        String newDir = "/upload/";
        String filePath = newDir + newName + "_"
                + w + "_" + h + url.substring(url.indexOf("."));
        //压缩
        ImgCompress(url,filePath,w,h);
    }

    /**
     * 外部调用方法
     * @param url
     * @param w
     * @param h
     */
    public static String ImgCompress(String url, String filePath, int w, int h) {
        // 压缩质量 百分比
        float JPEGcompression = 0.7f;

        // 本地图片存储路径
        url = "/upload" + url;
        String name = url.substring(url.lastIndexOf("/") + 1);

        // 截取url中最后一个“/”之后的字符串为name
        logger.info("url：===========" + url);
        logger.info("name：=========" + name);

        //压缩主方法
        return ImgCompress(filePath, url, name, w, h, JPEGcompression);

    }

    public static String ImgCompress(String filePath, File file,
                                     int w, int h, float JPEGcompression) {
        filePath = "/upload/"+filePath;
        if (!(file.exists() && file.canRead())) {
            filePath = "/upload/404.jpg";
        }else{
            try {
                BufferedImage bufferedImage =  ImageIO.read(file);

                int new_w = w;
                int new_h = h;

                BufferedImage image_to_save = new BufferedImage(new_w, new_h,
                        bufferedImage.getType());
                image_to_save.getGraphics().drawImage(
                        bufferedImage.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0,
                        0, null);
                FileOutputStream fos = new FileOutputStream(filePath); // 输出到文件流

                // 新的方法
                int dpi = 300;//分辨率
                saveAsJPEG(dpi, image_to_save, JPEGcompression, fos);
                //关闭输出流
                fos.close();
                //返回压缩后的图片地址
            } catch (IOException ex) {
                //logger.log(Level.SEVERE, null, ex);
                filePath = "/upload/404.jpg";
            }
        }

        System.out.print(filePath+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return filePath;

    }

    /**
     * 图片压缩主方法
     *
     * @param filePath
     *            图片所在的文件夹路径
     * @param url
     *            图片路径
     * @param name
     *            图片名
     * @param w
     *            目标宽
     * @param h
     *            目标高
     * @param JPEGcompression
     *            压缩质量/百分比
     * @author zhouqz
     */
    public static String ImgCompress(String filePath, String url, String name,
                                     int w, int h, float JPEGcompression) {
        File file = new File(url);
        if (!(file.exists() && file.canRead())) {
            filePath = "/upload/404.jpg";
        }else{
            try {
                BufferedImage bufferedImage =  ImageIO.read(file);

                //注释掉的部分是将压缩后的图像调整为方形
//				int old_w = bufferedImage.getWidth(null); // 得到源图宽
//				int old_h = bufferedImage.getHeight(null);//得到源图高
//				int new_w = 0;
//				int new_h = 0;
//				double w2 = (old_w * 1.00) / (w * 1.00);
//				double h2 = (old_h * 1.00) / (h * 1.00);
//				// 图片跟据长宽留白，成一个正方形图。
//				BufferedImage oldpic;
//				if (old_w > old_h) {
//					oldpic = new BufferedImage(old_w, old_w,
//							BufferedImage.TYPE_INT_RGB);
//				} else {
//					if (old_w < old_h) {
//						oldpic = new BufferedImage(old_h, old_h,
//								BufferedImage.TYPE_INT_RGB);
//					} else {
//						oldpic = new BufferedImage(old_w, old_h,
//								BufferedImage.TYPE_INT_RGB);
//					}
//				}
//				Graphics2D g = oldpic.createGraphics();
//				g.setColor(Color.white);
//				if (old_w > old_h) {
//					g.fillRect(0, 0, old_w, old_w);
//					g.drawImage(src, 0, (old_w - old_h) / 2, old_w, old_h,
//							Color.white, null);
//				} else {
//					if (old_w < old_h) {
//						g.fillRect(0, 0, old_h, old_h);
//						g.drawImage(src, (old_h - old_w) / 2, 0, old_w, old_h,
//								Color.white, null);
//					} else {
//						// g.fillRect(0,0,old_h,old_h);
//						g.drawImage(src.getScaledInstance(old_w, old_h,
//								Image.SCALE_SMOOTH), 0, 0, null);
//					}
//				}
//				g.dispose();
//				src = oldpic;
                // 图片调整为方形结束
//				if (old_w > w)
//					new_w = (int) Math.round(old_w / w2);
//				else
//					new_w = old_w;
//				if (old_h > h)
//					new_h = (int) Math.round(old_h / h2);// 计算新图长宽
//				else
//					new_h = old_h;

                int new_w = w;
                int new_h = h;

                BufferedImage image_to_save = new BufferedImage(new_w, new_h,
                        bufferedImage.getType());
                image_to_save.getGraphics().drawImage(
                        bufferedImage.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0,
                        0, null);
                FileOutputStream fos = new FileOutputStream(filePath); // 输出到文件流

                // 旧的使用 jpeg classes进行处理的方法
                // JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fos);
                // JPEGEncodeParam jep =
                // JPEGCodec.getDefaultJPEGEncodeParam(image_to_save);
				/* 压缩质量 */
                // jep.setQuality(per, true);
                // encoder.encode(image_to_save, jep);

                // 新的方法
                int dpi = 300;//分辨率
                saveAsJPEG(dpi, image_to_save, JPEGcompression, fos);
                //关闭输出流
                fos.close();
                //返回压缩后的图片地址
            } catch (IOException ex) {
                //logger.log(Level.SEVERE, null, ex);
                filePath = "/upload/404.jpg";
            }
        }

        return filePath;

    }

    /**
     * 以JPEG编码保存图片
     *
     * @param dpi
     *            分辨率
     * @param image_to_save
     *            要处理的图像图片
     * @param JPEGcompression
     *            压缩比
     * @param fos
     *            文件输出流
     * @throws IOException
     */
    public static void saveAsJPEG(Integer dpi, BufferedImage image_to_save,
                                  float JPEGcompression, FileOutputStream fos) throws IOException {

        // useful documentation at
        // http://docs.oracle.com/javase/7/docs/api/javax/imageio/metadata/doc-files/jpeg_metadata.html
        // useful example program at
        // http://johnbokma.com/java/obtaining-image-metadata.html to output
        // JPEG data

        // old jpeg class
        // com.sun.image.codec.jpeg.JPEGImageEncoder jpegEncoder =
        // com.sun.image.codec.jpeg.JPEGCodec.createJPEGEncoder(fos);
        // com.sun.image.codec.jpeg.JPEGEncodeParam jpegEncodeParam =
        // jpegEncoder.getDefaultJPEGEncodeParam(image_to_save);

        // Image writer
        JPEGImageWriter imageWriter = (JPEGImageWriter) ImageIO
                .getImageWritersBySuffix("jpg").next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(fos);
        imageWriter.setOutput(ios);
        // and metadata
        IIOMetadata imageMetaData = imageWriter.getDefaultImageMetadata(
                new ImageTypeSpecifier(image_to_save), null);

        // if(dpi != null && !dpi.equals("")){
        //
        // //old metadata
        // //jpegEncodeParam.setDensityUnit(com.sun.image.codec.jpeg.JPEGEncodeParam.DENSITY_UNIT_DOTS_INCH);
        // //jpegEncodeParam.setXDensity(dpi);
        // //jpegEncodeParam.setYDensity(dpi);
        //
        // //new metadata
        // Element tree = (Element)
        // imageMetaData.getAsTree("javax_imageio_jpeg_image_1.0");
        // Element jfif =
        // (Element)tree.getElementsByTagName("app0JFIF").item(0);
        // jfif.setAttribute("Xdensity", Integer.toString(dpi) );
        // jfif.setAttribute("Ydensity", Integer.toString(dpi));
        //
        // }

        if (JPEGcompression >= 0 && JPEGcompression <= 1f) {

            // old compression
            // jpegEncodeParam.setQuality(JPEGcompression,false);

            // new Compression
            JPEGImageWriteParam jpegParams = (JPEGImageWriteParam) imageWriter
                    .getDefaultWriteParam();
            jpegParams.setCompressionMode(JPEGImageWriteParam.MODE_EXPLICIT);
            jpegParams.setCompressionQuality(JPEGcompression);

        }

        // old write and clean
        // jpegEncoder.encode(image_to_save, jpegEncodeParam);

        // new Write and clean up
        imageWriter.write(imageMetaData,
                new IIOImage(image_to_save, null, null), null);
        ios.close();
        imageWriter.dispose();

    }

}
