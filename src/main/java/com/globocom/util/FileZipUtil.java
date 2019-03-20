package com.globocom.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class FileZipUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileZipUtil.class);
	/**
	 * Unzip it
	 * 
	 * @param zipFile
	 *            input zip file
	 * @param output
	 *            zip file output folder
	 */
	public void unZipIt(String zipFile, String outputFolder) {

		byte[] buffer = new byte[20480];

		LOGGER.info("FileZipUtil :zipFile :" + zipFile + "outputFolder:" + outputFolder);

		try {
			// get the zip file content
			ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
			// get the zipped file list entry
			ZipEntry ze = zis.getNextEntry();

			while (ze != null) {

				String fileName = ze.getName();
				File newFile = new File(outputFolder + File.separator + fileName);

				LOGGER.info("file unzip : " + newFile.getAbsoluteFile());

				LOGGER.info("FileZipUtil :file unzip  :" + newFile.getAbsoluteFile());

				// create all non exists folders
				// else you will hit FileNotFoundException for compressed folder
				new File(newFile.getParent()).mkdirs();

				FileOutputStream fos = new FileOutputStream(newFile);

				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}

				fos.close();
				ze = zis.getNextEntry();
			}

			zis.closeEntry();
			zis.close();
			if(zipFile.contains(".zip") || zipFile.contains(".rar") ){
				File file = new File(zipFile);
				boolean deleted = file.delete();
			}
//
//			System.out.println("Zip File Deleted Successfully :deleted :" + deleted);
			LOGGER.info("Done");

			LOGGER.info("FileZipUtil :UnZip completed successfully ");

		} catch (IOException ex) {
			ex.printStackTrace();
			LOGGER.info("FileZipUtil :UnZip completed unsuccessfully :zipFile :" + zipFile + "outputFolder:" + outputFolder + "Exception :" + ex);
		}
	}

			
}
