package com.nulll.jar.civ.common.data;

public class CivBuilding
{	
	public int m_width;
	public int m_height;
	public int m_depth;
	
	public BlockData[][][] m_data;
	
	public CivBuilding(int w, int h, int d, BlockData[][][] data)
	{
		m_width = w;
		m_height = h;
		m_depth = d;
		
		m_data = data;
	}

}
