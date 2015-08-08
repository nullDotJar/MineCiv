package com.nulll.jar.civ.common.util;

import net.minecraft.nbt.NBTTagCompound;

public interface INBTSaveHandler
{
	
	public void save(NBTTagCompound nbt);
	
	public void load(NBTTagCompound nbt);
	
}
