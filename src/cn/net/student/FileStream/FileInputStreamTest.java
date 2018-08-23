package cn.net.student.FileStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileInputStreamTest {
	private static String result = "";
	
	/**
	 * 以字节的形式读取文件,常用于读二进制文件，如图片、声音、影像等文件。 
	 * @return
	 */
	public static String readFileByByte(){
		//1、创建File文件对象，指向要操作的文件位置
		File file = new File(FilePath.WRITE_PATH + FilePath.WRITE_FILE);
		
		//2、声明文件输入流FileInputStream对象
		FileInputStream input = null;
		
		try {
			//3、将File文件当做形参传给文件输入流FileInputStream
			input = new FileInputStream(file);
			//4、创建临时字节数组存文件输入流读取到的数据
			byte tempByte[] = new byte[input.available()];
			//4、创建临时数
			int tempNumber;
			//5、通过文件流开始读取数据，并将读取到的字节数传给临时数，直到读取不到为止
			while((tempNumber = input.read(tempByte)) != -1){
				System.out.write(tempByte, 0, tempNumber);//第一个参数为数组，第二个参数为开始为止，第三个参数为长度
			}
			result = new String(tempByte,"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//6、关闭文件输入流
			if(input != null){
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	/**
	 * 以字符为单位读取文件，尝试用与文本、数字等类型的文件
	 * @return
	 */
	public static String readFileByChar(){
		//创建文件对象
		File file = new File(FilePath.WRITE_PATH + FilePath.WRITE_FILE);
		//创建字符读取流
		Reader reader = null;
		//将文件输入流做形参传给字符输入流InputStreamReader
		try {
			reader = new InputStreamReader(new FileInputStream(file));
			//创建临时字符数组存字符输入流读取的内容
			char tempChar[] = new char[1024];
			//创建临时数存取字符输入流一次读取到的字符数，直至读取完为止
			int tempNumber = 0;
			while((tempNumber = reader.read(tempChar)) != -1){
				//屏蔽掉\r不显示，因为和\n和相冲，都会导致换行，不屏蔽会有很多空行
				if((tempNumber == tempChar.length) && tempChar[tempChar.length - 1] != '\r'){
					System.out.println("读取字符1：" + tempChar);
				}else{
					for(int i = 0;i < tempNumber;i++){
						if(tempChar[i] == '\r'){
							continue;
						}else{
							System.out.println("读取字符2：" + tempChar);
						}
					}
				}
			}
			
			result = String.valueOf(tempChar);
			//result = new String(tempChar,0,tempChar.length);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭字符输入流
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	/**
	 * 以行为读取单位，常用于读面向行的格式化文件
	 * @return
	 */
	public static String readFileByLines(){
		//创建文件对象
		File file = new File(FilePath.WRITE_PATH + FilePath.WRITE_FILE);
		//创建缓冲输入流
		BufferedReader reader = null;
		try {
			//将节点流输入流FileRead作为形参赋给缓冲输入流
			reader = new BufferedReader(new FileReader(file));
			//创建临时字符串存缓冲输入流读取的行数
			String tempLine = "";
			//创建临时整数，存取读取的第几行
			int tempLineNum = 1;
			//一次读入一行，直至读完为止
			while((tempLine = reader.readLine()) != null){
				//显示行号
				System.out.println("line:::"+tempLineNum+": "+tempLine);
				result += tempLine + "\n";
				tempLineNum++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭输入流
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	

}
