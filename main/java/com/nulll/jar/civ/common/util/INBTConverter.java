package com.nulll.jar.civ.common.util;

import com.nulll.jar.civ.common.util.java.IConverter;

import net.minecraft.nbt.NBTTagCompound;

public interface INBTConverter<T> extends IConverter<NBTTagCompound, T>
{

	public T from(NBTTagCompound nbt);
	
	public NBTTagCompound to(T nbt);
		
}
