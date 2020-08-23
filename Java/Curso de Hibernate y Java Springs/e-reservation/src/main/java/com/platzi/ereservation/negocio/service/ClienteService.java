/**
 * 
 */
package com.platzi.ereservation.negocio.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.ereservation.modelo.Cliente;
import com.platzi.ereservation.negocio.repository.ClienteRepository;

/**
 * Clase para definir los servicios del cliente
 * @author gilbe
 *
 */

@Service
@Transactional(readOnly = true)
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {

		this.clienteRepository = clienteRepository;

	}

	/** 
	 * Metodo para realizar la operación de guardar un cliente
	 * @param cliente
	 * @author gilbe
	 * */
	@Transactional
	public Cliente create(Cliente cliente) {

		return this.clienteRepository.save(cliente);

	}

	/**
	 * Método para realizar la operación de actualizar un cliente
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente update(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	/**
	 * Método para realizar la operción de eliminación de un cliente
	 * @param cliente
	 */
	@Transactional
	public void delete(Cliente cliente) {

		this.clienteRepository.delete(cliente);

	}

	/**
	 * Método para consultar un cliente por su identificación
	 * @param identificacionCli
	 * @return
	 */
	public Cliente findByIdentificacion(String identificacionCli) {

		return this.clienteRepository.findByIdentificacion(identificacionCli);

	}

	public List<Cliente> findAll() {
		
		return this.clienteRepository.findAll();
		
	}
	
}