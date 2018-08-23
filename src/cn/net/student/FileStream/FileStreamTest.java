package cn.net.student.FileStream;

import java.io.IOException;

public class FileStreamTest {

	public static void main(String[] args) throws IOException {
		String data = "Hello file output stream ,If the failure please forgive me for the first test!";
		/*
		 * 写入
		 */
		//通过文件输出流FileOutputStream向文件里写入数据
		FileOutputStreamTest.writData(data);
		/*
		 * 读取
		 */
		//通过文件字节输入流FileInputStream读取文件里的数据
		System.out.println("\n字节读取结果：\n" + FileInputStreamTest.readFileByByte());
		//通过文件字符输入流InputStreamReader读取文件里的数据
		System.out.println("\n字符读取结果：\n" + FileInputStreamTest.readFileByChar());
		//通过文件缓冲输入流BufferedReader读取文件里的数据
		System.out.println("\n行读取结果：\n" + FileInputStreamTest.readFileByLines());
	}

}
