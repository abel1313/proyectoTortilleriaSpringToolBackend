package com.empresa.Empresa.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.Empresa.module.Cliente;
import com.empresa.Empresa.module.DetalleVenta;
import com.empresa.Empresa.module.EstatusPedido;
import com.empresa.Empresa.module.Pedido;
import com.empresa.Empresa.module.Producto;
import com.empresa.Empresa.module.Usuario;
import com.empresa.Empresa.module.Venta;
import com.empresa.Empresa.service.IDetalleService;
import com.empresa.Empresa.service.IEstatusPedidoService;
import com.empresa.Empresa.service.IPedidoService;
import com.empresa.Empresa.service.IProductoService;
import com.empresa.Empresa.service.IVentaService;
import com.empresa.Empresa.service.PedidoServiceImpl;
import com.empresa.Empresa.service.IClienteService;
import com.empresa.Empresa.service.IUsuarioService;

@RestController
@RequestMapping(path = "/empresa/sistema/pedido")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{

	@Autowired
	private IPedidoService iPedidoService;
	@Autowired
	private IProductoService iProductoService;
	@Autowired
	private IVentaService iVentaService;
	@Autowired
	private IDetalleService iDetalleService;
	
	@Autowired 
	private IClienteService IClienteService;
	@Autowired 
	private IUsuarioService IUsuarioService;
	@Autowired 
	private IEstatusPedidoService iEstatusPedidoService;
	
	@GetMapping("/nuevoPedido/{idProducto}/{cantidadPedido}/{tipoPedido}")
	public ResponseEntity<?> nueevoPedido
	(  @PathVariable("idProducto") int idProducto,
			@PathVariable("cantidadPedido") double cantidad,
			@PathVariable("tipoPedido") String tipoPedido) {
		try {

			
			if( idProducto != 0 && cantidad != 0 && !tipoPedido.isEmpty()  )
			{	
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				
			Producto producto = iProductoService.findById(idProducto);
			
			Venta nuevaVenta = new Venta();
			nuevaVenta.setFechaVenta( dtf.format(LocalDateTime.now()) );
			nuevaVenta.setTotal( cantidad * producto.getPrecioProducto() );
			Cliente c = IClienteService.findById(1);
			nuevaVenta.setCliente( c );
			
			Venta v = iVentaService.save( nuevaVenta );
			
			DetalleVenta detalleVenta = new DetalleVenta();
			detalleVenta.setKilosDetalleVenta( cantidad );
			detalleVenta.setPrecioDetalleVenta( producto.getPrecioProducto() );
			detalleVenta.setSubtotalDetalleVenta( cantidad * producto.getPrecioProducto() );
			detalleVenta.setProducto(producto);
			detalleVenta.setVenta(v);

			iDetalleService.save(detalleVenta);
			
			Usuario u = IUsuarioService.findById(1);	
			
			EstatusPedido estatusPedido = iEstatusPedidoService.findById( tipoPedido.equals("pedido") ? 1 : 2 );
			

			Pedido pedido = new Pedido();
			pedido.setVenta(v);
			pedido.setUsuario(u);
			pedido.setEstatusPedido(estatusPedido);
			
			Pedido pe = iPedidoService.save(pedido);
			
			

				return ResponseEntity.status(HttpStatus.OK).body( null );
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde '}");
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
}
