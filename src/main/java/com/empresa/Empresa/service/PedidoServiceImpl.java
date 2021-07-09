package com.empresa.Empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.Empresa.module.Pedido;
import com.empresa.Empresa.repository.IBaseRepository;
import com.empresa.Empresa.repository.IPedidoRepository;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Integer> implements IPedidoService
{
	@Autowired
	private IPedidoRepository iPedidoRepository;
	public PedidoServiceImpl(IBaseRepository<Pedido, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}
