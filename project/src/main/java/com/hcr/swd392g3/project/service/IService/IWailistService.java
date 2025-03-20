package com.hcr.swd392g3.project.service.IService;

import com.hcr.swd392g3.project.dto.WaitlistDTO;
import com.hcr.swd392g3.project.entity.Waitlist;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IWailistService {

    List<WaitlistDTO> getAllByPersonID();

    List<WaitlistDTO> getAllByTableID(int tableID);

    List<WaitlistDTO> getAll();
    WaitlistDTO addWaitlist(WaitlistDTO waitlistDTO);

    void cancelWaitlist(WaitlistDTO waitlistDTO);
}
