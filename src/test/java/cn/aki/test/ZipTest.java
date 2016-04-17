package cn.aki.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.junit.Test;
/**
 * 文件压缩
 * @author aki
 * 2016年4月14日 下午3:26:19
 */
public class ZipTest {
	@Test
	public void test(){
		File dir=new File("D:/Download");
		String zipFile="D:/Download/1.zip";
		InputStream is=null;
		ZipOutputStream zos=null;
		try{
			zos=new ZipOutputStream(new FileOutputStream(zipFile));
			if(dir.isDirectory()){
				File[] files=dir.listFiles();
				for(File file:files){
					if(file.isFile()&&file.getName().endsWith(".doc")){
						is=new FileInputStream(file);
						zos.putNextEntry(new ZipEntry(file.getName()));
						byte[] buff=new byte[1024];
						int length=-1;
						while((length=is.read(buff))!=-1){
							zos.write(buff, 0, length);
						}
						is.close();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(zos!=null){
				try {
					zos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
