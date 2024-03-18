package com.algaworks.algafood.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	public Cidade salvar(Cidade cidade) {
		Long idEstado = cidade.getEstado().getId();
		Estado estado = estadoRepository.findById(idEstado)
				.orElseThrow(
						() -> new EntidadeNaoEncontradaException(
								String.format("O estado com id %d não foi encontrado", idEstado) ));
		
		cidade.setEstado(estado);	
		return cidadeRepository.save(cidade);
	}
	
	
	public void excluir(Long id) {
		try {
			cidadeRepository.deleteById(id);
			
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Cidade de código %d não encontrada", id));
		}catch(DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("A cidade de código %d. Não pode ser excluida", id));
		}
	}
}
