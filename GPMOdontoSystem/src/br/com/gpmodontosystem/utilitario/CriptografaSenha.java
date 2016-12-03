package br.com.gpmodontosystem.utilitario;

import org.jcommon.encryption.SimpleMD5;

import br.com.gpmodontosystem.model.Usuario;

public class CriptografaSenha {
	
	public void criptografarSenha(Usuario u){
		SimpleMD5 md5 = new SimpleMD5(u.getSenha(), "!@#$%&*()");
		u.setSenha(md5.toHexString());
	}

}
