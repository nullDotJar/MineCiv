package com.nulll.jar.civ.common.util.java;

import net.minecraft.nbt.NBTTagCompound;

public interface IConverter<F, T>
{
	public T from(F from);

	public F to(T to);
}
