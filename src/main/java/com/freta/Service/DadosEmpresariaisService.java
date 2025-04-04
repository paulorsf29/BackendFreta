package com.freta.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freta.Entity.DadosEmpresariaisEntity;
import com.freta.Repository.DadosEmpresariaisRepository;

@Service
public class DadosEmpresariaisService {
    
    @Autowired
    private DadosEmpresariaisRepository dadosEmpresariaisRepository;

    public DadosEmpresariaisEntity salvar(DadosEmpresariaisEntity dadosEmpresariaisEntity){
        if (dadosEmpresariaisEntity.getCliente() == null) {
            throw new RuntimeException("cliente é obrigaatorio");
        }
        return dadosEmpresariaisRepository.save(dadosEmpresariaisEntity);
    }
    public List<DadosEmpresariaisEntity> listarDadosEmpresariais(){
        return dadosEmpresariaisRepository.findAll();
    }
    public Optional<DadosEmpresariaisEntity> buscarPorId(Long id){
        return dadosEmpresariaisRepository.findById(id);
    }
    
    public DadosEmpresariaisEntity atualizarDadosEmpresariais(Long id, DadosEmpresariaisEntity dadosEmpresariaisEntity){
        return dadosEmpresariaisRepository.findById(id).map(dados -> {
            dados.setCnpj(dadosEmpresariaisEntity.getCnpj());
            dados.setRazaoSocial(dadosEmpresariaisEntity.getRazaoSocial());
            dados.setNomeFantasia(dadosEmpresariaisEntity.getNomeFantasia());
            dados.setEndereco(dadosEmpresariaisEntity.getEndereco());
            dados.setInscricaoEstadual(dadosEmpresariaisEntity.getInscricaoEstadual());
            dados.setCodigoDeArea(dadosEmpresariaisEntity.getCodigoDeArea());
            dados.setTelefone(dadosEmpresariaisEntity.getTelefone());
            dados.setCidade(dadosEmpresariaisEntity.getCidade());
            dados.setEstado(dadosEmpresariaisEntity.getEstado());
            dados.setCep(dadosEmpresariaisEntity.getCep());
            dados.setCliente(dadosEmpresariaisEntity.getCliente());
            return dadosEmpresariaisRepository.save(dados);
        }).orElseThrow(() -> new RuntimeException("dados empresariais nao encontrado"));
    }
    public void eletarDadosEmpresariais(Long id){
        dadosEmpresariaisRepository.deleteById(id);
    }
}
