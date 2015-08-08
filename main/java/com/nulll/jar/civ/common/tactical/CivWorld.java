package com.nulll.jar.civ.common.tactical;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;

import com.nulll.jar.civ.common.tactical.node.ICivNode;
import com.nulll.jar.civ.common.tactical.node.INodeFactory;
import com.nulll.jar.civ.common.tactical.node.IUpdatingNode;
import com.nulll.jar.civ.common.util.INBTSaveHandler;

public class CivWorld implements INBTSaveHandler
{

	public final int WIDTH;

	private ICivNode[] m_nodes;

	private INodeFactory m_factory;

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

	@Override
	public void save(NBTTagCompound nbt)
	{
		NBTTagCompound comp = new NBTTagCompound();

		NBTTagList list = new NBTTagList();

		for(int i = 0; i < m_nodes.length; i++)
		{
			NBTTagCompound tmp = new NBTTagCompound();

			if(m_nodes[i] == null)
			{
				tmp.setInteger("id", -1);

				m_nodes[i].save(null);
			} else
			{
				tmp.setInteger("id", m_nodes[i].getID());

				NBTTagCompound c = new NBTTagCompound();

				m_nodes[i].save(c);

				tmp.setTag("data", c);
			}

			list.appendTag(tmp);
		}

		comp.setTag("nodes", list);

		nbt.setTag("world", comp);
	}

	@Override
	public void load(NBTTagCompound nbt)
	{
		NBTTagCompound comp = nbt.getCompoundTag("world");

		m_nodes = new ICivNode[WIDTH * WIDTH];

		NBTTagList list = (NBTTagList) comp.getTag("nodes");

		for(int i = 0; i < m_nodes.length; i++)
		{
			int id = ((NBTTagCompound) list.get(i)).getInteger("id");

			if(id == -1 || !m_factory.canCreate(id))
			{
				m_nodes[i] = null;
				continue;
			}

			ICivNode n = m_factory.create(id);

			n.load(((NBTTagCompound) list.get(i)).getCompoundTag("data"));

			m_nodes[i] = n;
		}
	}
}
