package com.nulll.jar.civ.common.util;

import net.minecraft.nbt.NBTTagCompound;

public interface INBTConverter<T>
{

	public T load(NBTTagCompound nbt);
	
	public NBTTagCompound save(T nbt);
		
}
