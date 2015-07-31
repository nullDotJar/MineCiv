/**
 * 
 */
package com.nulll.jar.civ.common.util.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import com.nulll.jar.civ.common.util.java.FilenameFilters.AllFilter;

/**
 * @author tim4242
 * 
 * 
 *
 */
public class ZipUtil
{

	private static URLClassLoader m_sysloader = null;
	private static Method m_addURL = null;

	public static boolean unzip(File zip, File out, FilenameFilter filter)
	{
		byte[] buffer = new byte[1024];

		try
		{

			if(!out.exists())
			{
				out.mkdir();
			}

			ZipInputStream zis = new ZipInputStream(new FileInputStream(zip));
			ZipEntry ze;

			while ((ze = zis.getNextEntry()) != null)
			{

				if(!filter.accept(zip, ze.getName()))
					continue;

				String fileName = ze.getName();
				File newFile = new File(out + File.separator + fileName);

				new File(newFile.getParent()).mkdirs();

				if(fileName.endsWith("/"))
					continue;

				FileOutputStream fos = new FileOutputStream(newFile);

				int len;

				while ((len = zis.read(buffer)) > 0)
				{
					fos.write(buffer, 0, len);
				}

				fos.close();
			}

			zis.closeEntry();
			zis.close();

			return true;

		} catch(IOException ex)
		{
			ex.printStackTrace();
			return false;
		}

	}

	public static boolean unzipAll(File in, File out)
	{
		return unzip(in, out, new AllFilter());
	}

	public static boolean unzipSingleFile(File zip, File out, String resFileName) throws Exception
	{
		byte[] buffer = new byte[1024];

		try
		{

			if(!out.exists())
			{
				out.mkdir();
			}

			ZipInputStream zis = new ZipInputStream(new FileInputStream(zip));
			ZipEntry ze;

			while ((ze = zis.getNextEntry()) != null)
			{

				String fileName = ze.getName();

				if(fileName.contains("/"))
				{
					if(!(fileName.endsWith("/")))
					{
						fileName = ze.getName().split("/")[ze.getName().split("/").length - 1];
					}
				}

				if(!(resFileName.equals(fileName)))
					continue;

				File newFile = new File(new File(out.getName() + File.separator + fileName).toString());

				out.mkdirs();

				FileOutputStream fos = new FileOutputStream(newFile);

				int len;

				while ((len = zis.read(buffer)) > 0)
				{
					fos.write(buffer, 0, len);
				}

				fos.close();
			}

			zis.closeEntry();
			zis.close();

			return true;

		} catch(IOException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * This method zips the directory
	 * 
	 * @param dir
	 * @param zipDirName
	 */
	public static void zipDir(File dir, String zipDirName)
	{
		try
		{
			List<String> filesInDir = new ArrayList<String>();

			populateFilesList(filesInDir, dir);
			FileOutputStream fos = new FileOutputStream(zipDirName);
			ZipOutputStream zos = new ZipOutputStream(fos);
			for(String filePath : filesInDir)
			{
				ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length() + 1, filePath.length()));
				zos.putNextEntry(ze);
				FileInputStream fis = new FileInputStream(filePath);
				byte[] buffer = new byte[1024];
				int len;
				while ((len = fis.read(buffer)) > 0)
				{
					zos.write(buffer, 0, len);
				}
				zos.closeEntry();
				fis.close();
			}
			zos.close();
			fos.close();
		} catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * This method populates all the files in a directory to a List
	 * 
	 * @param dir
	 * @throws IOException
	 */
	public static void populateFilesList(List<String> l, File dir) throws IOException
	{
		File[] files = dir.listFiles();
		for(File file : files)
		{
			if(file.isFile())
				l.add(file.getAbsolutePath());
			else
				populateFilesList(l, file);
		}
	}

}
