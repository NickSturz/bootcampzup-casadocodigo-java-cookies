package com.casaDoCodigo.Nicolle.Validadores;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.casaDoCodigo.Nicolle.Cliente.ClienteForm;
import com.casaDoCodigo.Nicolle.Estado.Estado;
import com.casaDoCodigo.Nicolle.Pais.Pais;

@Component
public class ValidarEstadoPertencePais implements Validator {
	
    @Autowired
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteForm.class.isAssignableFrom(clazz);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
    
    ClienteForm request = (ClienteForm) target;
    
    Pais pais = manager.find(Pais.class, request.getPaisNome());
    System.out.println(pais);
    System.out.println("OW esse é o pais");
    if (pais == null) {
    	errors.rejectValue("pais", null, "Pais não cadastrado");
    	return;
    }
    
    Estado estado = manager.find(Estado.class, request.getEstadoNome());
    if ( estado.getPais().getId().equals(pais.getId())) {
		System.out.println("ta certo");
	}else {
		System.out.println("Ta errado");
		errors.rejectValue("estado", null, "O estado não pertence a esse país");
	}
    }}
    /*
    List<Estado> listaEstados = manager.createQuery("SELECT e from Estado e WHERE pais =  :pais", Estado.class)
    		.setParameter("pais", pais).getResultList();
    if (listaEstados.size() > 0 ) {
    	if (estado == null) {
    		errors.rejectValue("estado", null, "Estado obrigatório");
    	} else if (!(estado.getPais().equals(pais))) {
    		errors.rejectValue("estado", null, "O estado não pertence a esse país");
    	} 
    	
    } else if (estado != null) {
    	errors.rejectValue("estado", null, "Esse país não possui estados cadastrados");
    }
  }*/
	
/*
            ClienteForm request = (ClienteForm) target;

        Pais pais = manager.find(Pais.class, request.getPaisNome());
        if (pais == null) {
            errors.rejectValue("cliente.paisId", null,
                    "Compra não pode ser efetuada. Pais não existe.");
            return;
        }

        Estado estado = manager.find(Estado.class, request.getEstadoNome());

        List<Estado> estadosList = manager
                .createQuery("SELECT e from Estado e WHERE pais = :pais", Estado.class)
                .setParameter("pais", pais)
                .getResultList();


        if (estadosList.size() > 0) {
            if (estado == null) {
                errors.rejectValue("cliente.estadoNome", null,
                        "Campo 'estado' obrigatório.");

            } else if (!(estado.getPais()).equals(pais)) {
                errors.rejectValue("cliente.estadoNome", null,"Cadastro não pode ser efetuado. Este estado não pertence ao país selecionado.");
            }

        } else if (estado != null) {
            errors.rejectValue("cliente.estadoNome", null,
                    "adastroCompra não pode ser efetuado. Este país não possui estados.");
        }
    }*/

