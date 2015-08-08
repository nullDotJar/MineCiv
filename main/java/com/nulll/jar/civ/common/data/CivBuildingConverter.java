package com.nulll.jar.civ.common.data;

import java.nio.ByteBuffer;

import com.nulll.jar.civ.common.util.java.IBufferConverter;

public class CivBuildingConverter implements IBufferConverter<CivBuilding>
{

	@Override
	public CivBuilding from(ByteBuffer from)
	{
		int width = from.getInt();
		int height = from.getInt();
		int depth = from.getInt();
		int length = from.getInt();

		CivBuilding res = new CivBuilding(width, height, depth, new BlockData[width][height][depth]);

		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				for(int z = 0; z < depth; z++)
				{
					res.m_data[x][y][z] = new BlockData(from.getInt(), from.getShort());
				}
			}
		}

		return res;
	}

	@Override
	public ByteBuffer to(CivBuilding to)
	{
		ByteBuffer b = ByteBuffer.allocate(4 * Integer.BYTES + to.m_width * to.m_height * to.m_depth * Integer.BYTES + Short.BYTES);

		b.putInt(to.m_width);
		b.putInt(to.m_height);
		b.putInt(to.m_depth);
		b.putInt(to.m_width * to.m_height * to.m_depth);

		for(int x = 0; x < to.m_width; x++)
		{
			for(int y = 0; y < to.m_height; y++)
			{
				for(int z = 0; z < to.m_depth; z++)
				{
					b.putInt(to.m_data[x][y][z].m_id);
					b.putShort(to.m_data[x][y][z].m_meta);
				}
			}
		}

		return b;
	}

}
