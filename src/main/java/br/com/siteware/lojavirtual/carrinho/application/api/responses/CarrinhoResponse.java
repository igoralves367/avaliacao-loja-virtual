package br.com.siteware.lojavirtual.carrinho.application.api.responses;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.com.siteware.lojavirtual.carrinho.domain.CarrinhoDeCompras;
import lombok.Getter;
@Getter
public class CarrinhoResponse {
	private UUID idCarrinhoDeCompras;
	private String cpf;
	private List<ItemCarrinhoResponse> itens;
	private LocalDateTime dataHoraAbertura;
	private LocalDateTime dataHoraDaUltimaAlteracao;
	
	public CarrinhoResponse(CarrinhoDeCompras carrinho) {
		this.idCarrinhoDeCompras = carrinho.getIdCarrinhoDeCompras();
		this.itens = ItemCarrinhoResponse.converte(carrinho.getItens());
		this.cpf = carrinho.getCpf();
		this.dataHoraAbertura = carrinho.getDataHoraAbertura();
		this.dataHoraDaUltimaAlteracao = carrinho.getDataHoraDaUltimaAlteracao();
	}
}
