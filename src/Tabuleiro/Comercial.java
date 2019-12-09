package Tabuleiro;

import jogadores.Jogador;
import jogadores.SemSaldoException;

public interface Comercial {

	public void compra(Jogador j)throws SemSaldoException;
	public int getPreco();
	public Jogador getProprietario();
	public void  pagaAluguel(Jogador recebe, Jogador paga) throws SemSaldoException;
}
