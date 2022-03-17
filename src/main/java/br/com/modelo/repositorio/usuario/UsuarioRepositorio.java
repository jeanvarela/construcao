package br.com.modelo.repositorio.usuario;

import br.com.modelo.entidade.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório para acessar a tabela de usuário
 *
 * @author Jean Varela
 * data    11/08/2021
 */
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
}
