package com.residentialresources.model;

import lombok.Data;

@Data
public class Imovel {
	private String id;
	private int idImovel;
	private String idImobzi;
	private String imobziCode;
	private String status;
	private String tipoImovel;
	private String subTipoImovel;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String areaUtil;
	private int dormitorios;
	private int banheiros;
	private int suites;
	private int vagas;
	private String valorLocacao;
	private String valorIptuMensal;
	private String valorLocacaoTotal;
	private boolean exclusivo;
	private String valorCondominio;
	private boolean mobiliado;
	private boolean temPiscina;
	private String tipoAnuncio;
	private String aluguelPartirDe;	
}
