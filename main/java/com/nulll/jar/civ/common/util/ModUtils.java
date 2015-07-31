package com.nulll.jar.civ.common.util;

import java.lang.reflect.Field;
import java.util.Arrays;

import sun.misc.Unsafe;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.FMLModContainer;
import net.minecraftforge.fml.common.ModContainer;

import com.nulll.jar.civ.common.util.java.ReflectionHelper;

public class ModUtils
{
	/**
	 * Utility method that sets the disableability of a modcontainer.<br>
	 * <br>
	 * 
	 * TODO:<br>
	 * Currently only works with
	 * {@link net.minecraftforge.fml.common.FMLModContainer FMLModContainer}.
	 * 
	 * @param c
	 *            The modcontainer to set the disableability of.
	 * @param d
	 *            The disableability to set to.
	 * @return If it succeeded.
	 */
	public static boolean setDisableablility(ModContainer c, ModContainer.Disableable d)
	{
		if(c instanceof FMLModContainer)
		{
			try
			{
				ReflectionHelper.getFieldAccesseble(FMLModContainer.class, "disableability").set(c, ModContainer.Disableable.NEVER);
				return true;
			} catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	public static void setBiomeArrayLength(int newLen)
	{
		try
		{
			Field bListF = BiomeGenBase.class.getDeclaredField("biomeList");

			bListF.setAccessible(true);

			BiomeGenBase[] lastArray = (BiomeGenBase[]) bListF.get(null);

			BiomeGenBase[] resArray = Arrays.copyOfRange(lastArray, 0, newLen);

			Unsafe UNSAFE = getUnsafeSafe();

			UNSAFE.putObjectVolatile(UNSAFE.staticFieldBase(bListF), UNSAFE.staticFieldOffset(bListF), resArray);

		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static Unsafe getUnsafeSafe()
	{
		try
		{

			Field singleoneInstanceField = Unsafe.class.getDeclaredField("theUnsafe");
			singleoneInstanceField.setAccessible(true);
			return (Unsafe) singleoneInstanceField.get(null);

		} catch(Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public static String getBiomeArrString(BiomeGenBase[] arr)
	{
		StringBuilder build = new StringBuilder();

		build.append("{");

		for(BiomeGenBase base : arr)
		{
			if(base == null)
				break;

			build.append(base.biomeName + ", ");
		}

		build.append("Length: " + arr.length);

		build.append("}\n");

		return build.toString();
	}

}
