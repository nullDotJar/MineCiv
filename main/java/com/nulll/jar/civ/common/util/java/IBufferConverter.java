package com.nulll.jar.civ.common.util.java;

import java.nio.ByteBuffer;

import net.minecraft.nbt.NBTTagCompound;

public interface IBufferConverter<T> extends IConverter<ByteBuffer, T>
{
	public T from(ByteBuffer from);

	public ByteBuffer to(T to);
}
