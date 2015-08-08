package com.nulll.jar.civ.common.tactical.node;

import com.nulll.jar.civ.common.tactical.CivWorld;

public interface ICivNode
{

	public int getX();

	public int getY();

	public void setX(int x);

	public void setY(int y);

	public CivWorld getWorld();

	public void init(CivWorld w, int x, int y);

	public int getID();

	public class CivNode implements ICivNode
	{
		protected int m_id;

		protected int m_x;
		protected int m_y;

		protected CivWorld m_world;

		public CivNode(int id)
		{
			m_id = id;
		}

		@Override
		public int getX()
		{
			return m_x;
		}

		@Override
		public int getY()
		{
			return m_y;
		}

		@Override
		public void setX(int x)
		{
			m_x = x;
		}

		@Override
		public void setY(int y)
		{
			m_y = y;
		}

		@Override
		public CivWorld getWorld()
		{
			return m_world;
		}

		@Override
		public void init(CivWorld w, int x, int y)
		{
			m_x = x;
			m_y = y;

			m_world = w;
		}

		@Override
		public int getID()
		{
			return m_id;
		}

	}
}
