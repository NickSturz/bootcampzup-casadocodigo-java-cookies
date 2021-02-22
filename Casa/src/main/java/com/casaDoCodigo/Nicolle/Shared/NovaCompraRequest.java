//package br.com.zup.cdc.nicolle.request;
//
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.PastOrPresent;
//
//import br.com.zup.cdc.nicolle.model.Compra;
//import br.com.zup.cdc.nicolle.model.Cupom;
//import br.com.zup.cdc.nicolle.model.Livro;
//
//public class NovaCompraRequest {
//
//	@NotEmpty
//	private ClienteRequest cliente;
//
//	@NotEmpty
//	private CarrinhoRequest carrinho;
//
//	@PastOrPresent
//	private LocalDateTime createdAt = LocalDateTime.now();
//
//	public Compra Comprar(EntityManager em) throws Exception {
//		List<Livro> livros = new ArrayList<>();
//		BigDecimal total = BigDecimal.ZERO;
//
//		for (ItemRequest item : carrinho.getItems()) {
//			Livro livro = em.find(Livro.class, item.getLivroId());
//			if (livro == null)
//				throw new Exception("Livro não cadastrado");
//
//			BigDecimal quantidade = BigDecimal.valueOf(item.getQuantidade());
//			total = total.add(livro.getPreco().multiply(quantidade));
//			livros.add(livro);
//		}
//		
//		if (!total.equals(carrinho.getTotal()))
//			throw new Exception("Valores não condizentes");
//		Cupom cupom = manager.find(Cupom.class, cliente.getCupomId());
//        validaCupom(cupom);
//
//        BigDecimal porcentagem = (cupom.getPorcentagem()).divide(BigDecimal.valueOf(100), RoundingMode.UP);
//        BigDecimal totalComDesconto = total.subtract(total.multiply(porcentagem));
//
//        return new Compra(cliente.toModel(manager), livros, total, totalComDesconto);
//	}
//
//}
