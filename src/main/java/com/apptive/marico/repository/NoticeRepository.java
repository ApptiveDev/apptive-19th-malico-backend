package com.apptive.marico.repository;

import com.apptive.marico.entity.Notice;
import com.apptive.marico.entity.NoticeReadStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
