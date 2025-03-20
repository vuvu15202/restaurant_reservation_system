package com.hcr.swd392g3.project.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcr.swd392g3.project.entity.Waitlist;

@Repository
public interface WaitlistRepository extends JpaRepository<Waitlist, Integer> {
    List<Waitlist> getAllByPerson_PersonIDOrderByBookingHourDesc(int personID);

    List<Waitlist> getAllByTable_TableIDOrderByBookingHourDesc(int tableID);

    List<Waitlist> findAll();

    Waitlist getByPerson_PersonIDAndTable_TableID(int personID, int tableID);

    Waitlist getByBookingHour(Date date);
    void removeWaitlistByPerson_PersonIDAndTable_TableID(int personID,int tableID);
}
