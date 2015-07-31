package com.nulll.jar.civ.common.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface ICivProxy
{

	/**
	 * Gets triggered at the end of the pre initialization of the mod.
	 * 
	 * @param event
	 *            The
	 *            {@link net.minecraftforge.fml.common.event.FMLPreInitializationEvent
	 *            FMLPreInitializationEvent} of the life cycle event handler.
	 */
	public void preInit(FMLPreInitializationEvent event);

	/**
	 * Gets triggered at the end of the initialization of the mod.
	 * 
	 * @param event
	 *            The
	 *            {@link net.minecraftforge.fml.common.event.FMLInitializationEvent
	 *            FMLInitializationEvent} of the life cycle event handler.
	 */
	public void init(FMLInitializationEvent event);

	/**
	 * Gets triggered at the end of the post initialization of the mod.
	 * 
	 * @param event
	 *            The
	 *            {@link net.minecraftforge.fml.common.event.FMLPostInitializationEvent
	 *            FMLPostInitializationEvent} of the life cycle event handler.
	 */
	public void postInit(FMLPostInitializationEvent event);

}
