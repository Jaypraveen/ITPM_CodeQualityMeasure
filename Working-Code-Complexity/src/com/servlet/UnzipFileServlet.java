package com.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UnzipFileServlet
 */
@WebServlet("/UnzipFileServlet")
public class UnzipFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnzipFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String unzip = request.getParameter("unzip");

		//MimetypesFileTypeMap fileTypeMap = new MimetypesFileTypeMap();
		//String typeMap = fileTypeMap.getContentType(path);
/*
		
		if (unzip.contains(".zip")) {
			System.out.println("zip");
			System.out.println(type);
			
		} else if (unzip.contains(".rar")) {
			System.out.println("rar");
			System.out.println(typeMap);
			System.out.println(type);

		} else {
			System.out.println("unzipped");
			System.out.println(typeMap);
			System.out.println(type);
		}
		*/
		if (unzip.contains(".zip")) {
			System.out.println("zip");

			String fileZip = unzip;
			File destDir = new File("C:\\\\Users\\\\User\\\\Desktop\\\\");
			byte[] buffer = new byte[1024];
			ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
			ZipEntry zipEntry = zis.getNextEntry();
			while (zipEntry != null) {
				File newFile = newFile(destDir, zipEntry);
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				zipEntry = zis.getNextEntry();
			}
			zis.closeEntry();
			zis.close();

			PrintWriter printWriter = response.getWriter();
			printWriter.println("File successfully unziped. Please Choose the unzipped file from your desktop.");

		} else if (unzip.contains(".rar")) {
			System.out.println("rar");

		} else {
			System.out.println("unzipped");
		}
	}
	
	public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
		File destFile = new File(destinationDir, zipEntry.getName());

		String destDirPath = destinationDir.getCanonicalPath();
		String destFilePath = destFile.getCanonicalPath();

		if (!destFilePath.startsWith(destDirPath + File.separator)) {
			throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
		}

		return destFile;

	}


}
