package com.hcr.swd392g3.project.service;

import com.hcr.swd392g3.project.OtherMethod;
import com.hcr.swd392g3.project.converter.WaitlistConverter;
import com.hcr.swd392g3.project.dto.WaitlistDTO;
import com.hcr.swd392g3.project.entity.Person;
import com.hcr.swd392g3.project.entity.Waitlist;
import com.hcr.swd392g3.project.repository.PersonRepository;
import com.hcr.swd392g3.project.repository.WaitlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import com.hcr.swd392g3.project.service.IService.IWailistService;

import java.util.ArrayList;
import java.util.List;

@Service
public class WaitlistServiceImpl implements IWailistService {
    @Autowired
    WaitlistRepository waitlistRepository;
    @Autowired
    WaitlistConverter waitlistConverter;
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<WaitlistDTO> getAllByPersonID() {
        OtherMethod otherMethod=new OtherMethod();
        Person person = personRepository.findByUserName(otherMethod.getAuthorizationName());
        List<Waitlist> list= waitlistRepository.getAllByPerson_PersonIDOrderByBookingHourDesc(person.getPersonID());
        List<WaitlistDTO> waitlistDTOS=new ArrayList<>();
        for (Waitlist waitlist : list){

            waitlistDTOS.add(waitlistConverter.toDTO(waitlist));
        }
        return waitlistDTOS;
    }

    @Override
    public List<WaitlistDTO> getAllByTableID(int tableID) {
        List<Waitlist> list = waitlistRepository.getAllByTable_TableIDOrderByBookingHourDesc(tableID);
        List<WaitlistDTO> waitlistDTOS = new ArrayList<>();
        for (Waitlist waitlist : list) {
            waitlistDTOS.add(waitlistConverter.toDTO(waitlist));
        }
        return waitlistDTOS;
    }

    @Override
    public List<WaitlistDTO> getAll() {
        System.out.println("ok");
        List<Waitlist> list= waitlistRepository.findAll();
        List<WaitlistDTO> waitlistDTOS=new ArrayList<>();
        for (Waitlist waitlist : list){

            waitlistDTOS.add(waitlistConverter.toDTO(waitlist));
        }
        return waitlistDTOS;
    }

    @Override
    public WaitlistDTO addWaitlist(WaitlistDTO waitlistDTO) {
        Waitlist waitlist= waitlistConverter.toEntity(waitlistDTO);
        OtherMethod otherMethod = new OtherMethod();
        Person person= new Person();
        person.setPassword("1111");
        person.setRole(3);
        person.setFirstName(waitlistDTO.getFirstName());
        person.setLastName(waitlistDTO.getLastName());
        person.setPhoneNumber(waitlistDTO.getPhoneNumber());
        if(otherMethod.getAuthorizationName()!= null){
            person = personRepository.getPersonByUserName(otherMethod.getAuthorizationName());
            //waitlist.setPerson(person);
            
        }
        else{
            personRepository.save(person);
            waitlist.setPerson(personRepository.findAll().get(personRepository.findAll().size()));

        }
        waitlistRepository.save(waitlist);
        return waitlistDTO;
    }

    @Override
    public void cancelWaitlist(WaitlistDTO waitlistDTO) {
        waitlistRepository.removeWaitlistByPerson_PersonIDAndTable_TableID(waitlistDTO.getPerson().getPersonID(),
        waitlistDTO.getTable().getTableID());

    }
}
