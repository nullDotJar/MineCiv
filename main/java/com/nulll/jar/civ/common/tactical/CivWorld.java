package com.nulll.jar.civ.common.tactical;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

import com.nulll.jar.civ.common.tactical.node.ICivNode;
import com.nulll.jar.civ.common.tactical.node.IUpdatingNode;

public class CivWorld
{

	public final int WIDTH;

	private ICivNode[] m_nodes;

	public ICivNode getNode(int x, int y)
	{
		int i = y * WIDTH + x;

		if(i < WIDTH * WIDTH)
			return m_nodes[i];

		return null;
	}

	public void setNode(int x, int y, ICivNode n)
	{
		int i = y * WIDTH + x;

		if(i < WIDTH * WIDTH)
			m_nodes[i] = n;
	}

	private CivWorld()
	{
		WIDTH = MinecraftServer.getServer().getMaxWorldSize() / 16;

		m_nodes = new ICivNode[WIDTH * WIDTH];
	}

	public void update()
	{
		for(int i = 0; i < m_nodes.length; i++)
		{
			ICivNode n = m_nodes[i];
			
			if(n != null)
			{
				if(n instanceof IUpdatingNode)
					((IUpdatingNode) n).update();
			}
		}
	}

}
