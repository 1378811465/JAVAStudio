package cn.net.student.FileStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	//向文件写入数据
	public static void writData(String data) throws IOException{
		//1、创建一个文件对象，表明要操作的文件位置
		File dir = new File(FilePath.WRITE_PATH);
		//2、如果没有此文件夹，则创建一个
		if(!dir.exists()){
			dir.mkdirs();
		}
		//在要操作的文件位置，如果电脑没有此文件位置，并且是多级，必须用mkdirs() 如果只是一级mkdir() 
		//但这只是创建了目录，所以还需要单独创建文件的操作
		//如果电脑有此文件位置，则只需要1.1和1.2即可
		//1.1、创建文件对象，表明要操作的文件位置
		File file = new File(FilePath.WRITE_PATH+FilePath.WRITE_FILE);
		//1.2如果没有此文件，则创建一个
		if(!file.exists()){
			file.createNewFile();
		}
		//3、创建文件输出流FileOutputStream对象
		FileOutputStream output = null;
		try {
			//4、将file文件为形参传给文件输出流FileOutputStream
			output = new FileOutputStream(file);
			//5、写入的操作
			output.write(data.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//6、关闭输出流
			if(output != null){
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
