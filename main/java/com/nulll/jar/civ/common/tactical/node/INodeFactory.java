package com.nulll.jar.civ.common.tactical.node;

public interface INodeFactory
{

	public boolean canCreate(int id);
	
	public ICivNode create(int id);
	
}
