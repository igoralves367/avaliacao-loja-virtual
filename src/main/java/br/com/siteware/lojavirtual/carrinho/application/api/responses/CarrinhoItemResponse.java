package br.com.siteware.lojavirtual.carrinho.application.api.responses;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.siteware.lojavirtual.produto.domain.PromocaoEnum;
import lombok.Value;
@Value
public class CarrinhoItemResponse {
	private UUID idItemCarrinho;
    private UUID idProduto;
    private String nomeProduto;
    private Double quantidade;
    private BigDecimal precoUnitario;
    private PromocaoEnum promocao;
    private BigDecimal precoTotalBruto;
    private BigDecimal precoTotalLiquido;
    private BigDecimal desconto;

    public CarrinhoItemResponse(UUID idItemCarrinho, UUID idProduto, String nomeProduto, Double quantidade, BigDecimal precoUnitario, PromocaoEnum promocao, BigDecimal precoTotalBruto, BigDecimal precoTotalLiquido, BigDecimal desconto) {
        this.idItemCarrinho = idItemCarrinho;
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.promocao = promocao;
        this.precoTotalBruto = precoTotalBruto;
        this.precoTotalLiquido = precoTotalLiquido;
        this.desconto = desconto;
    }

    public static List<CarrinhoItemResponse> converte(List<CarrinhoItemResponse> itemCarrinho) {
        return itemCarrinho.stream()
                .map(item -> new CarrinhoItemResponse(
                        item.getIdItemCarrinho(),
                        item.getIdProduto(),
                        item.getNomeProduto(),
                        item.getQuantidade(),
                        item.getPrecoUnitario(),
                        item.getPromocao(),
                        item.getPrecoTotalBruto(),
                        item.getPrecoTotalLiquido(),
                        item.getDesconto()
                ))
                .collect(Collectors.toList());
    }
}
