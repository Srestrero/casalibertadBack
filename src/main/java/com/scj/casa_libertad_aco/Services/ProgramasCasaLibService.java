
package com.scj.casa_libertad_aco.Services;

import com.scj.casa_libertad_aco.Entities.Expectativas;
import com.scj.casa_libertad_aco.Entities.FuncionariosRegistro;
import com.scj.casa_libertad_aco.Entities.MediosConocimiento;
import com.scj.casa_libertad_aco.Entities.ProgramasCasaLib;
import com.scj.casa_libertad_aco.Entities.Usuarios;
import com.scj.casa_libertad_aco.Repositories.ExpectativasRepository;
import com.scj.casa_libertad_aco.Repositories.FuncionariosRegistroRepository;
import com.scj.casa_libertad_aco.Repositories.MediosConocimientoRepository;
import com.scj.casa_libertad_aco.Repositories.ProgramasCasaLibRepository;
import com.scj.casa_libertad_aco.Repositories.UsuariosRepository;
import com.scj.casa_libertad_aco.salidaDTOs.ConsultaProgramasCasaLibDTO;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;


@Service
public class ProgramasCasaLibService {
    
    @Autowired
    private  ProgramasCasaLibRepository programasCasaLibRepository;
    
    @Autowired
    private UsuariosRepository usuariosRepository;
    
    @Autowired
    private MediosConocimientoRepository mediosConocimientoRepository;
    
    @Autowired
    private ExpectativasRepository expectativasRepository;
    
    @Autowired
    private FuncionariosRegistroRepository funcionariosRegistroRepository;
    
    
    /*
    C-Crear
    */
    public ProgramasCasaLib crearProgramasCasaLib(String numeroDocumento,ConsultaProgramasCasaLibDTO consultaProgramasCasaLibDTO){
        Usuarios usuarios = usuariosRepository.findByNumeroDocumento(numeroDocumento);
        //ProgramasCasaLib programas =  programasCasaLibRepository.findByUsuarios(usuarios);
        ProgramasCasaLib programas = new ProgramasCasaLib(); 
        programas.setOtroMedioConoc(consultaProgramasCasaLibDTO.getOtr_medio_conoc());
        programas.setNombresOtroFunc(consultaProgramasCasaLibDTO.getNombres_otro_func());
        MediosConocimiento medios = mediosConocimientoRepository.findByUniqId(consultaProgramasCasaLibDTO.getMedios_conoc_uniqid());
        programas.setMediosConocs(medios);
        Expectativas expectativas = expectativasRepository.findByUniqId(consultaProgramasCasaLibDTO.getExpectativas_uniqid());
        programas.setExpectativas(expectativas);
        FuncionariosRegistro funcionario = funcionariosRegistroRepository.findByUniqId(consultaProgramasCasaLibDTO.getFuncs_registro_uniqid());
        programas.setUsuarios(usuarios);
        
        return programasCasaLibRepository.save(programas);
        
        
        
        
    } 

    /*
    R-Consultar
    */
    public ConsultaProgramasCasaLibDTO consultaProgramas(String numDocumento)throws Exception{
        try{
        Usuarios usuarios = usuariosRepository.findByNumeroDocumento(numDocumento);
        ProgramasCasaLib programas = programasCasaLibRepository.findByUsuarios(usuarios);
        ConsultaProgramasCasaLibDTO consulta = new ConsultaProgramasCasaLibDTO();
        consulta.setOtr_medio_conoc(programas.getOtroMedioConoc());
        consulta.setNombres_otro_func(programas.getNombresOtroFunc());
        consulta.setMedios_conoc_uniqid(programas.getMediosConocs().getUniqId());
        consulta.setExpectativas_uniqid(programas.getExpectativas().getUniqId());
        consulta.setFuncs_registro_uniqid(programas.getFuncionarioRegistros().getUniqId());
        
        return consulta;
        
        }catch(Exception e){
            return null;
        }
    }
    
    /*
    U- Actualizar
    */
    public ProgramasCasaLib actualizaProgramasCasaLib(String numeroDocumento,
            ConsultaProgramasCasaLibDTO consultaProgramasCasaLibDTO)throws Exception{
        try{
        Usuarios usuarios = usuariosRepository.findByNumeroDocumento(numeroDocumento);
        ProgramasCasaLib programas = new ProgramasCasaLib(); 
        programas.setOtroMedioConoc(consultaProgramasCasaLibDTO.getOtr_medio_conoc());
        programas.setNombresOtroFunc(consultaProgramasCasaLibDTO.getNombres_otro_func());
        MediosConocimiento medios = mediosConocimientoRepository.findByUniqId(consultaProgramasCasaLibDTO.getMedios_conoc_uniqid());
        programas.setMediosConocs(medios);
        Expectativas expectativas = expectativasRepository.findByUniqId(consultaProgramasCasaLibDTO.getExpectativas_uniqid());
        programas.setExpectativas(expectativas);
        FuncionariosRegistro funcionario = funcionariosRegistroRepository.findByUniqId(consultaProgramasCasaLibDTO.getFuncs_registro_uniqid());
        programas.setUsuarios(usuarios);
        
        return programasCasaLibRepository.save(programas);
       
        }catch(Exception e){
            return null;
        }
    }
    
    
}
