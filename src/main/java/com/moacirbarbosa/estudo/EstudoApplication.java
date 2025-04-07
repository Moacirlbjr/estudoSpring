package com.moacirbarbosa.estudo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.moacirbarbosa.estudo.domain.Categoria;
import com.moacirbarbosa.estudo.domain.Cidade;
import com.moacirbarbosa.estudo.domain.Cliente;
import com.moacirbarbosa.estudo.domain.Endereco;
import com.moacirbarbosa.estudo.domain.Estado;
import com.moacirbarbosa.estudo.domain.ItemPedido;
import com.moacirbarbosa.estudo.domain.Pagamento;
import com.moacirbarbosa.estudo.domain.PagamentoComBoleto;
import com.moacirbarbosa.estudo.domain.PagamentoComCartao;
import com.moacirbarbosa.estudo.domain.Pedido;
import com.moacirbarbosa.estudo.domain.Produto;
import com.moacirbarbosa.estudo.domain.enuns.EstadoPagamento;
import com.moacirbarbosa.estudo.domain.enuns.TipoCliente;
import com.moacirbarbosa.estudo.repositories.CategoriaRepository;
import com.moacirbarbosa.estudo.repositories.CidadeRepository;
import com.moacirbarbosa.estudo.repositories.ClienteRepository;
import com.moacirbarbosa.estudo.repositories.EnderecoRepository;
import com.moacirbarbosa.estudo.repositories.EstadoRepository;
import com.moacirbarbosa.estudo.repositories.ItemPedidoRepository;
import com.moacirbarbosa.estudo.repositories.PagamentoRepository;
import com.moacirbarbosa.estudo.repositories.PedidoRepository;
import com.moacirbarbosa.estudo.repositories.ProdutoRepository;
import com.moacirbarbosa.estudo.resources.CategoriaResource;

@SpringBootApplication
public class EstudoApplication implements CommandLineRunner{

    private final CategoriaResource categoriaResource;

	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private ProdutoRepository produtoRepository;	
	@Autowired
	private CidadeRepository cidadeRepository;	
	@Autowired
	private EstadoRepository estadoRepository;	
	@Autowired
	private EnderecoRepository enderecoRepository;	
	@Autowired
	private ClienteRepository clienteRepository;	
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
    EstudoApplication(CategoriaResource categoriaResource) {
        this.categoriaResource = categoriaResource;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(EstudoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia",est1);
		Cidade c2 = new Cidade(null, "São Paulo",est2);
		Cidade c3 = new Cidade(null, "Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3)); 
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","34948294834",TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("83481345","34533234"));
		
		Endereco e1 = new Endereco(null,"Rua Flores","300","apt 303","Jardim","38223804",cli1,c1);
		Endereco e2 = new Endereco(null,"Av Matos","105","Sala 800","Centro","38777012",cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));		
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"),cli1,e1);
		Pedido ped2 = new Pedido(null,sdf.parse("10/10/2017 19:35"),cli1,e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped1,6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2017 00:00"),null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
	}

}
