package com.certant.vtv.seeders;


import com.certant.vtv.model.Costumer;
import com.certant.vtv.model.Inspector;
import com.certant.vtv.repository.CostumerRepository;
import com.certant.vtv.repository.InspectorRepository;
import com.certant.vtv.utils.CostumerType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@AllArgsConstructor
@Component
public class PersonSeeder {

    private CostumerRepository costumerRepository;
    private InspectorRepository inspectorRepository;

    public void saveCostumer(){
        if(costumerRepository.count() == 0){
            Costumer pedro = new Costumer(CostumerType.EXEMPT,new ArrayList<>());
            pedro.setName("pedro");
            pedro.setEmail("pedro@gmail.com");
            pedro.setLastName("picapiedra");
            pedro.setDni("12345678");
            pedro.setPhoneNumber("3777-123456");
            costumerRepository.save(pedro);

            Costumer santi = new Costumer(CostumerType.NORMAL,new ArrayList<>());
            santi.setName("Santi");
            santi.setEmail("santi@gmail.com");
            santi.setDni("22345678");
            santi.setLastName("simon");
            santi.setPhoneNumber("3777-654321");
            costumerRepository.save(santi);
        }
    }

    public void saveInspector(){
        if(inspectorRepository.count() == 0){
            Inspector inspector = new Inspector();
            inspector.setPhoneNumber("3777-123456");
            inspector.setEmail("fabri@gmail.com");
            inspector.setName("Fabricio");
            inspector.setLastName("Perfetti");
            inspectorRepository.save(inspector);

            Inspector inspector1 = new Inspector();
            inspector1.setPhoneNumber("3777-987654");
            inspector1.setEmail("sergio@gmail.com");
            inspector1.setName("Sergio");
            inspector1.setLastName("Ramos");
            inspectorRepository.save(inspector1);
        }
    }
}
