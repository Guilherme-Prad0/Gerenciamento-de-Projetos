package com.zera.projetos.services;

import com.zera.projetos.models.ProjetoModel;
import com.zera.projetos.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    ProjetoRepository projetoRepository;

    public ProjetoModel criarProjeto(ProjetoModel projetoModel ){
        return projetoRepository.save(projetoModel);
    }

    public List<ProjetoModel> buscarTodosProjetos(){
        return projetoRepository.findAll();
    }

    public ProjetoModel buscarPorId(Long id){
        return projetoRepository.findById(id).get();
    }

    public void deletar(Long id){
        projetoRepository.deleteById(id);
    }

    public ProjetoModel atualizar(Long id, ProjetoModel projetoModel){
        ProjetoModel newProjeto = projetoRepository.findById(id).get();
        newProjeto.setNome(projetoModel.getNome());
        newProjeto.setDataInicio(projetoModel.getDataInicio());
        newProjeto.setDataFim(projetoModel.getDataFim());
        return projetoRepository.save(newProjeto);
    }


}
