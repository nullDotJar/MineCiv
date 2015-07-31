package com.nulll.jar.civ.common.util;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nulll.jar.civ.common.core.Constants;

/**
 * @author tim4242
 * @author philipas
 * 
 * <br>
 * <br>
 * 
 *         This is a general Logging class. <br>
 *         Is's a static wrapper for the <br>
 *         {@link org.apache.logging.log4j.Logger Logger} for this mod
 */
public final class Log
{

	private static final Logger m_log = LogManager.getLogger(Constants.MOD_NAME);

	/**
	 * A wrapper method for
	 * {@link org.apache.logging.log4j.Logger#info(java.lang.Object)
	 * Logger.info())} <br>
	 * every new Object gets displayed on a new line.
	 * 
	 * @param mes
	 *            The messages to be displayed.
	 */
	public static final void info(Object... mes)
	{
		for(Object s : mes)
			m_log.info(s);
	}

	/**
	 * A wrapper method for
	 * {@link org.apache.logging.log4j.Logger#warn(java.lang.Object)
	 * Logger.info())} <br>
	 * every new Object gets displayed on a new line.
	 * 
	 * @param mes
	 *            The messages to be displayed.
	 */
	public static final void warn(Object... mes)
	{
		for(Object s : mes)
			m_log.warn(s);
	}

	/**
	 * A wrapper method for
	 * {@link org.apache.logging.log4j.Logger#error(java.lang.Object)
	 * Logger.info())} <br>
	 * every new Object gets displayed on a new line.
	 * 
	 * @param mes
	 *            The messages to be displayed.
	 */
	public static final void error(Object... mes)
	{
		for(Object s : mes)
			m_log.error(s);
	}

}
